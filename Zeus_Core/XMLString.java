/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.util.Collection;
/*   5:    */ import java.util.Iterator;
/*   6:    */ import java.util.StringTokenizer;
/*   7:    */ import java.util.jar.Attributes;
/*   8:    */ 
/*   9:    */ public class XMLString
/*  10:    */ {
/*  11:    */   private boolean isRoot;
/*  12:    */   private String tag;
/*  13:    */   private XMLString sibling;
/*  14:    */   private XMLString child;
/*  15:    */   private Attributes attributes;
/*  16:    */   
/*  17:    */   public XMLString(String name, boolean isRoot)
/*  18:    */   {
/*  19: 31 */     this.tag = name;
/*  20: 32 */     this.sibling = null;
/*  21: 33 */     this.child = null;
/*  22: 34 */     this.attributes = new Attributes();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public XMLString(String xml)
/*  26:    */   {
/*  27: 44 */     this.sibling = null;
/*  28: 45 */     this.child = null;
/*  29: 46 */     this.attributes = new Attributes();
/*  30:    */     
/*  31:    */ 
/*  32: 49 */     String headerTag = xml.substring(0, xml.indexOf(">"));
/*  33: 52 */     if (headerTag.indexOf("=") == -1)
/*  34:    */     {
/*  35: 54 */       this.tag = headerTag.substring(1).trim();
/*  36:    */     }
/*  37:    */     else
/*  38:    */     {
/*  39: 58 */       StringTokenizer st = new StringTokenizer(headerTag);
/*  40: 59 */       this.tag = st.nextToken().substring(1);
/*  41: 62 */       while (st.hasMoreTokens())
/*  42:    */       {
/*  43: 63 */         String att = st.nextToken();
/*  44: 64 */         this.attributes.putValue(att.substring(0, att.indexOf("=")), att);
/*  45:    */       }
/*  46:    */     }
/*  47: 69 */     String insideTag = xml.substring(xml.indexOf(">") + 1, 
/*  48: 70 */       xml.indexOf("</" + this.tag + ">"));
/*  49: 72 */     if (!insideTag.equals("")) {
/*  50: 73 */       this.child = new XMLString(insideTag);
/*  51:    */     }
/*  52: 77 */     String outsideTag = xml.substring(xml.indexOf("</" + this.tag + ">") + 
/*  53: 78 */       ("</" + this.tag + ">").length());
/*  54: 80 */     if (!outsideTag.equals("")) {
/*  55: 81 */       this.sibling = new XMLString(outsideTag);
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void addSibling(XMLString sib)
/*  60:    */   {
/*  61: 90 */     if (this.sibling == null) {
/*  62: 91 */       this.sibling = sib;
/*  63:    */     } else {
/*  64: 94 */       this.sibling.addSibling(sib);
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void addChild(XMLString ch)
/*  69:    */   {
/*  70:103 */     if (this.child == null) {
/*  71:104 */       this.child = ch;
/*  72:    */     } else {
/*  73:107 */       this.child.addSibling(ch);
/*  74:    */     }
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void insertAttribute(String name, String value)
/*  78:    */   {
/*  79:118 */     this.attributes.putValue(name, name + "=\"" + value + "\"");
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getAttribute(String name)
/*  83:    */   {
/*  84:127 */     String value = this.attributes.getValue(name);
/*  85:129 */     if (value.equals("")) {
/*  86:130 */       return "";
/*  87:    */     }
/*  88:133 */     return value.substring(value.indexOf("=") + 2, value.length() - 1).trim();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public XMLString getChild()
/*  92:    */   {
/*  93:137 */     return this.child;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public XMLString getSibling()
/*  97:    */   {
/*  98:141 */     return this.sibling;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getTag()
/* 102:    */   {
/* 103:145 */     return this.tag;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String toString()
/* 107:    */   {
/* 108:153 */     String xml = "";
/* 109:    */     
/* 110:    */ 
/* 111:156 */     xml = xml + "<" + this.tag;
/* 112:    */     
/* 113:    */ 
/* 114:159 */     Iterator iter = this.attributes.values().iterator();
/* 115:161 */     while (iter.hasNext())
/* 116:    */     {
/* 117:162 */       String value = (String)iter.next();
/* 118:163 */       xml = xml + " " + value;
/* 119:    */     }
/* 120:167 */     xml = xml + ">";
/* 121:170 */     if (this.child != null) {
/* 122:171 */       xml = xml + this.child.toString();
/* 123:    */     }
/* 124:175 */     xml = xml + "</" + this.tag + ">";
/* 125:178 */     if (this.sibling != null) {
/* 126:179 */       xml = xml + this.sibling.toString();
/* 127:    */     }
/* 128:182 */     return xml;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public static void main(String[] args)
/* 132:    */   {
/* 133:190 */     XMLString xmlString = new XMLString("zeus", true);
/* 134:191 */     xmlString.insertAttribute("hello", "fetus");
/* 135:192 */     xmlString.insertAttribute("goober", "booger");
/* 136:    */     
/* 137:194 */     XMLString ch2 = new XMLString("child1", false);
/* 138:195 */     ch2.insertAttribute("hello", "fetus");
/* 139:    */     
/* 140:197 */     XMLString ch1 = new XMLString("child2", false);
/* 141:198 */     ch1.insertAttribute("hello", "fetus");
/* 142:    */     
/* 143:200 */     ch2.addChild(ch1);
/* 144:201 */     xmlString.addSibling(ch2);
/* 145:    */     
/* 146:203 */     String xml = xmlString.toString();
/* 147:204 */     System.out.println(xml);
/* 148:    */     
/* 149:206 */     XMLString root = new XMLString(xml);
/* 150:207 */     System.out.println(root.toString());
/* 151:208 */     System.out.println(root.getAttribute("goober"));
/* 152:    */   }
/* 153:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.XMLString
 * JD-Core Version:    0.7.0.1
 */