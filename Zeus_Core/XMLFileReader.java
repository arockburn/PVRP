/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import javax.swing.JOptionPane;
/*   6:    */ import javax.xml.parsers.ParserConfigurationException;
/*   7:    */ import javax.xml.parsers.SAXParser;
/*   8:    */ import javax.xml.parsers.SAXParserFactory;
/*   9:    */ import org.xml.sax.Attributes;
/*  10:    */ import org.xml.sax.SAXException;
/*  11:    */ import org.xml.sax.helpers.DefaultHandler;
/*  12:    */ 
/*  13:    */ public class XMLFileReader
/*  14:    */   extends DefaultHandler
/*  15:    */ {
/*  16: 25 */   private boolean school = false;
/*  17: 27 */   private boolean popBlock = false;
/*  18:    */   private String popName;
/*  19:    */   private String points;
/*  20:    */   private String XmlFileName;
/*  21:    */   private String Name;
/*  22:    */   private String tmpValue;
/*  23: 36 */   private ArrayList<String> list = new ArrayList();
/*  24:    */   
/*  25:    */   public XMLFileReader(String XmlFileName, String Name)
/*  26:    */   {
/*  27: 47 */     this.XmlFileName = XmlFileName;
/*  28: 48 */     this.Name = Name;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public XMLFileReader(String XmlFileName, String Name, String points)
/*  32:    */   {
/*  33: 60 */     this.XmlFileName = XmlFileName;
/*  34: 61 */     this.Name = Name;
/*  35: 62 */     this.points = points;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public XMLFileReader(String XmlFileName, ArrayList<String> list)
/*  39:    */   {
/*  40: 71 */     this.XmlFileName = XmlFileName;
/*  41: 72 */     this.list = list;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void readFile()
/*  45:    */   {
/*  46: 79 */     SAXParserFactory factory = SAXParserFactory.newInstance();
/*  47:    */     try
/*  48:    */     {
/*  49: 81 */       SAXParser saxParser = factory.newSAXParser();
/*  50: 82 */       saxParser.parse(this.XmlFileName, this);
/*  51:    */     }
/*  52:    */     catch (ParserConfigurationException e)
/*  53:    */     {
/*  54: 84 */       JOptionPane.showMessageDialog(null, "ParserConfig error", "Error", 0);
/*  55:    */     }
/*  56:    */     catch (SAXException e)
/*  57:    */     {
/*  58: 86 */       JOptionPane.showMessageDialog(null, "SAXException: XML File Not Properly Made", "Error", 0);
/*  59:    */     }
/*  60:    */     catch (IOException e)
/*  61:    */     {
/*  62: 89 */       XMLFileWriter localXMLFileWriter = new XMLFileWriter(this.XmlFileName);
/*  63:    */     }
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void startElement(String uri, String localName, String elementName, Attributes atts)
/*  67:    */     throws SAXException
/*  68:    */   {
/*  69:107 */     if (elementName.equalsIgnoreCase("school"))
/*  70:    */     {
/*  71:108 */       this.list.add(atts.getValue("school"));
/*  72:110 */       if (atts.getValue("school").equals(this.Name)) {
/*  73:112 */         this.school = true;
/*  74:    */       }
/*  75:    */     }
/*  76:116 */     if (elementName.equalsIgnoreCase("popblock"))
/*  77:    */     {
/*  78:117 */       this.popName = atts.getValue("name");
/*  79:119 */       if (atts.getValue("name").equals(this.Name)) {
/*  80:120 */         this.popBlock = true;
/*  81:    */       }
/*  82:    */     }
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void endElement(String uri, String localName, String elementName)
/*  86:    */     throws SAXException
/*  87:    */   {
/*  88:135 */     if ((elementName.equalsIgnoreCase("schooltype")) && (this.school))
/*  89:    */     {
/*  90:    */       String str;
/*  91:137 */       switch ((str = this.tmpValue).hashCode())
/*  92:    */       {
/*  93:    */       case -2021012075: 
/*  94:137 */         if (str.equals("MIDDLE")) {
/*  95:    */           break;
/*  96:    */         }
/*  97:    */         break;
/*  98:    */       case 2217378: 
/*  99:137 */         if (str.equals("HIGH")) {}
/* 100:    */       case 1061033452: 
/* 101:137 */         if ((goto 126) && (str.equals("ELEMENTARY")))
/* 102:    */         {
/* 103:138 */           this.tmpValue = "0";
/* 104:    */           break label132;
/* 105:139 */           this.tmpValue = "1";
/* 106:    */           break label132;
/* 107:140 */           this.tmpValue = "2";
/* 108:    */         }
/* 109:    */         break;
/* 110:    */       }
/* 111:141 */       this.tmpValue = "0";
/* 112:    */     }
/* 113:    */     label132:
/* 114:145 */     if ((!elementName.equalsIgnoreCase("population")) || (
/* 115:    */     
/* 116:    */ 
/* 117:148 */       (!elementName.equalsIgnoreCase("walkpercent")) || (
/* 118:    */       
/* 119:    */ 
/* 120:151 */       (!elementName.equalsIgnoreCase("enablewalk")) || (
/* 121:    */       
/* 122:    */ 
/* 123:154 */       (!elementName.equalsIgnoreCase("latitude")) || (
/* 124:    */       
/* 125:    */ 
/* 126:157 */       (!elementName.equalsIgnoreCase("longitude")) || (
/* 127:    */       
/* 128:    */ 
/* 129:160 */       (!elementName.equalsIgnoreCase("servicerange")) || (
/* 130:    */       
/* 131:    */ 
/* 132:163 */       (!elementName.equalsIgnoreCase("maxwalk")) || (
/* 133:    */       
/* 134:    */ 
/* 135:166 */       (!elementName.equalsIgnoreCase("schoolsize")) || (
/* 136:    */       
/* 137:    */ 
/* 138:169 */       (!elementName.equalsIgnoreCase("minimumpopulation")) || (
/* 139:    */       
/* 140:    */ 
/* 141:172 */       (!elementName.equalsIgnoreCase("maximumpopulation")) || (
/* 142:    */       
/* 143:    */ 
/* 144:175 */       (!elementName.equalsIgnoreCase("minimumdistance")) || (
/* 145:    */       
/* 146:    */ 
/* 147:178 */       (!elementName.equalsIgnoreCase("maximummerge")) || (
/* 148:    */       
/* 149:    */ 
/* 150:181 */       (elementName.equalsIgnoreCase("school")) && (this.school)))))))))))))) {
/* 151:182 */       this.school = false;
/* 152:    */     }
/* 153:184 */     if (elementName.equalsIgnoreCase("percent")) {
/* 154:185 */       this.list.add(this.popName + "," + this.tmpValue);
/* 155:    */     }
/* 156:187 */     if ((elementName.equalsIgnoreCase("points")) && (this.popBlock)) {
/* 157:188 */       this.points = this.tmpValue;
/* 158:    */     }
/* 159:190 */     if ((elementName.equalsIgnoreCase("popblock")) && (this.popBlock)) {
/* 160:191 */       this.popBlock = false;
/* 161:    */     }
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void characters(char[] ch, int start, int length)
/* 165:    */     throws SAXException
/* 166:    */   {
/* 167:204 */     this.tmpValue = new String(ch, start, length);
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getPoints()
/* 171:    */   {
/* 172:213 */     return this.points;
/* 173:    */   }
/* 174:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.XMLFileReader
 * JD-Core Version:    0.7.0.1
 */