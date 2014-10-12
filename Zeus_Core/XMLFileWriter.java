/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import javax.swing.JOptionPane;
/*   5:    */ import javax.xml.parsers.DocumentBuilder;
/*   6:    */ import javax.xml.parsers.DocumentBuilderFactory;
/*   7:    */ import javax.xml.parsers.ParserConfigurationException;
/*   8:    */ import javax.xml.transform.Transformer;
/*   9:    */ import javax.xml.transform.TransformerException;
/*  10:    */ import javax.xml.transform.TransformerFactory;
/*  11:    */ import javax.xml.transform.dom.DOMSource;
/*  12:    */ import javax.xml.transform.stream.StreamResult;
/*  13:    */ import org.w3c.dom.Attr;
/*  14:    */ import org.w3c.dom.Document;
/*  15:    */ import org.w3c.dom.Element;
/*  16:    */ import org.w3c.dom.NamedNodeMap;
/*  17:    */ import org.w3c.dom.Node;
/*  18:    */ import org.w3c.dom.NodeList;
/*  19:    */ import org.w3c.dom.Text;
/*  20:    */ 
/*  21:    */ public class XMLFileWriter
/*  22:    */ {
/*  23:    */   private static String XmlFileName;
/*  24:    */   private static String schoolName;
/*  25:    */   private static String popName;
/*  26:    */   private static String pPercent;
/*  27:    */   private static String points;
/*  28:    */   private static boolean save;
/*  29:    */   private static boolean isPopBlock;
/*  30:    */   
/*  31:    */   public XMLFileWriter(String XmlFileName, String schoolName, boolean saving, boolean isPopBlock)
/*  32:    */   {
/*  33: 58 */     XmlFileName = XmlFileName;
/*  34: 59 */     schoolName = schoolName;
/*  35: 60 */     save = saving;
/*  36: 61 */     isPopBlock = isPopBlock;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public XMLFileWriter(String XmlFileName, String popName, String pPercent, String points, boolean saving, boolean isPopBlock)
/*  40:    */   {
/*  41: 73 */     XmlFileName = XmlFileName;
/*  42: 74 */     popName = popName;
/*  43: 75 */     pPercent = pPercent;
/*  44: 76 */     points = points;
/*  45: 77 */     save = saving;
/*  46: 78 */     isPopBlock = isPopBlock;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public XMLFileWriter(String createXml)
/*  50:    */   {
/*  51: 86 */     XmlFileName = createXml;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void createXML(String xmlFileName, String xmlnsHeading)
/*  55:    */   {
/*  56:    */     try
/*  57:    */     {
/*  58: 95 */       String file = XmlFileName;
/*  59:    */       
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:100 */       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
/*  64:101 */       DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
/*  65:    */       
/*  66:    */ 
/*  67:104 */       Document doc = docBuilder.newDocument();
/*  68:105 */       Element rootElement = doc.createElement("Routes");
/*  69:106 */       rootElement.setAttribute("xmlns", xmlnsHeading);
/*  70:107 */       doc.appendChild(rootElement);
/*  71:    */       
/*  72:    */ 
/*  73:    */ 
/*  74:    */ 
/*  75:112 */       TransformerFactory transformerFactory = TransformerFactory.newInstance();
/*  76:113 */       Transformer transformer = transformerFactory.newTransformer();
/*  77:114 */       DOMSource source = new DOMSource(doc);
/*  78:115 */       StreamResult result = new StreamResult(new File(file));
/*  79:116 */       transformer.transform(source, result);
/*  80:    */     }
/*  81:    */     catch (TransformerException tfe)
/*  82:    */     {
/*  83:120 */       JOptionPane.showMessageDialog(null, "TransformerException error", "Error", 0);
/*  84:    */     }
/*  85:    */     catch (ParserConfigurationException pce)
/*  86:    */     {
/*  87:123 */       JOptionPane.showMessageDialog(null, "ParserConfig error", "Error", 0);
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   public static boolean writeToXML(String filePath, String xmlnsHeading, Depot depot, int numDepots)
/*  92:    */   {
/*  93:    */     try
/*  94:    */     {
/*  95:132 */       String file = XmlFileName;
/*  96:    */       
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:137 */       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
/* 101:138 */       DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
/* 102:    */       
/* 103:    */ 
/* 104:141 */       Document doc = docBuilder.newDocument();
/* 105:142 */       Element rootElement = doc.createElement("Routes");
/* 106:143 */       rootElement.setAttribute("xmlns", xmlnsHeading);
/* 107:144 */       doc.appendChild(rootElement);
/* 108:153 */       for (int i = 0; i < 2; i++)
/* 109:    */       {
/* 110:155 */         Element staff = doc.createElement("Staff");
/* 111:156 */         rootElement.appendChild(staff);
/* 112:    */         
/* 113:    */ 
/* 114:159 */         Attr attr = doc.createAttribute("id");
/* 115:    */         
/* 116:161 */         attr.setValue(Integer.toString(i));
/* 117:162 */         staff.setAttributeNode(attr);
/* 118:    */         
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:168 */         Element firstname = doc.createElement("firstname");
/* 124:169 */         firstname.appendChild(doc.createTextNode("yong"));
/* 125:170 */         staff.appendChild(firstname);
/* 126:    */         
/* 127:    */ 
/* 128:173 */         Element lastname = doc.createElement("lastname");
/* 129:174 */         lastname.appendChild(doc.createTextNode("mook kim"));
/* 130:175 */         staff.appendChild(lastname);
/* 131:    */         
/* 132:    */ 
/* 133:178 */         Element nickname = doc.createElement("nickname");
/* 134:179 */         nickname.appendChild(doc.createTextNode("mkyong"));
/* 135:180 */         staff.appendChild(nickname);
/* 136:    */         
/* 137:    */ 
/* 138:183 */         Element salary = doc.createElement("salary");
/* 139:184 */         salary.appendChild(doc.createTextNode("100000"));
/* 140:185 */         staff.appendChild(salary);
/* 141:    */       }
/* 142:310 */       TransformerFactory transformerFactory = TransformerFactory.newInstance();
/* 143:311 */       Transformer transformer = transformerFactory.newTransformer();
/* 144:312 */       DOMSource source = new DOMSource(doc);
/* 145:313 */       StreamResult result = new StreamResult(new File(filePath));
/* 146:314 */       transformer.transform(source, result);
/* 147:    */     }
/* 148:    */     catch (ParserConfigurationException pce)
/* 149:    */     {
/* 150:316 */       JOptionPane.showMessageDialog(null, "ParserConfig error", "Error", 0);
/* 151:317 */       return false;
/* 152:    */     }
/* 153:    */     catch (TransformerException tfe)
/* 154:    */     {
/* 155:319 */       JOptionPane.showMessageDialog(null, "TransformerException error", "Error", 0);
/* 156:320 */       return false;
/* 157:    */     }
/* 158:328 */     return true;
/* 159:    */   }
/* 160:    */   
/* 161:    */   protected Node getNode(String tagName, NodeList nodes)
/* 162:    */   {
/* 163:334 */     for (int x = 0; x < nodes.getLength(); x++)
/* 164:    */     {
/* 165:335 */       Node node = nodes.item(x);
/* 166:336 */       if (node.getNodeName().equalsIgnoreCase(tagName)) {
/* 167:337 */         return node;
/* 168:    */       }
/* 169:    */     }
/* 170:341 */     return null;
/* 171:    */   }
/* 172:    */   
/* 173:    */   protected String getNodeValue(Node node)
/* 174:    */   {
/* 175:345 */     NodeList childNodes = node.getChildNodes();
/* 176:346 */     for (int x = 0; x < childNodes.getLength(); x++)
/* 177:    */     {
/* 178:347 */       Node data = childNodes.item(x);
/* 179:348 */       if (data.getNodeType() == 3) {
/* 180:349 */         return data.getNodeValue();
/* 181:    */       }
/* 182:    */     }
/* 183:351 */     return "";
/* 184:    */   }
/* 185:    */   
/* 186:    */   protected String getNodeValue(String tagName, NodeList nodes)
/* 187:    */   {
/* 188:355 */     for (int x = 0; x < nodes.getLength(); x++)
/* 189:    */     {
/* 190:356 */       Node node = nodes.item(x);
/* 191:357 */       if (node.getNodeName().equalsIgnoreCase(tagName))
/* 192:    */       {
/* 193:358 */         NodeList childNodes = node.getChildNodes();
/* 194:359 */         for (int y = 0; y < childNodes.getLength(); y++)
/* 195:    */         {
/* 196:360 */           Node data = childNodes.item(y);
/* 197:361 */           if (data.getNodeType() == 3) {
/* 198:362 */             return data.getNodeValue();
/* 199:    */           }
/* 200:    */         }
/* 201:    */       }
/* 202:    */     }
/* 203:366 */     return "";
/* 204:    */   }
/* 205:    */   
/* 206:    */   protected String getNodeAttr(String attrName, Node node)
/* 207:    */   {
/* 208:370 */     NamedNodeMap attrs = node.getAttributes();
/* 209:371 */     for (int y = 0; y < attrs.getLength(); y++)
/* 210:    */     {
/* 211:372 */       Node attr = attrs.item(y);
/* 212:373 */       if (attr.getNodeName().equalsIgnoreCase(attrName)) {
/* 213:374 */         return attr.getNodeValue();
/* 214:    */       }
/* 215:    */     }
/* 216:377 */     return "";
/* 217:    */   }
/* 218:    */   
/* 219:    */   protected String getNodeAttr(String tagName, String attrName, NodeList nodes)
/* 220:    */   {
/* 221:381 */     for (int x = 0; x < nodes.getLength(); x++)
/* 222:    */     {
/* 223:382 */       Node node = nodes.item(x);
/* 224:383 */       if (node.getNodeName().equalsIgnoreCase(tagName))
/* 225:    */       {
/* 226:384 */         NodeList childNodes = node.getChildNodes();
/* 227:385 */         for (int y = 0; y < childNodes.getLength(); y++)
/* 228:    */         {
/* 229:386 */           Node data = childNodes.item(y);
/* 230:387 */           if ((data.getNodeType() == 2) && 
/* 231:388 */             (data.getNodeName().equalsIgnoreCase(attrName))) {
/* 232:389 */             return data.getNodeValue();
/* 233:    */           }
/* 234:    */         }
/* 235:    */       }
/* 236:    */     }
/* 237:395 */     return "";
/* 238:    */   }
/* 239:    */   
/* 240:    */   protected void setNodeValue(String tagName, String value, NodeList nodes)
/* 241:    */   {
/* 242:404 */     Node node = getNode(tagName, nodes);
/* 243:405 */     if (node == null) {
/* 244:406 */       return;
/* 245:    */     }
/* 246:409 */     NodeList childNodes = node.getChildNodes();
/* 247:410 */     for (int y = 0; y < childNodes.getLength(); y++)
/* 248:    */     {
/* 249:411 */       Node data = childNodes.item(y);
/* 250:412 */       if (data.getNodeType() == 3)
/* 251:    */       {
/* 252:413 */         data.setNodeValue(value);
/* 253:414 */         return;
/* 254:    */       }
/* 255:    */     }
/* 256:    */   }
/* 257:    */   
/* 258:    */   protected void addNode(String tagName, String value, Node parent)
/* 259:    */   {
/* 260:423 */     Document dom = parent.getOwnerDocument();
/* 261:    */     
/* 262:    */ 
/* 263:426 */     Node node = dom.createElement(tagName);
/* 264:    */     
/* 265:    */ 
/* 266:429 */     Text nodeVal = dom.createTextNode(value);
/* 267:430 */     Node c = node.appendChild(nodeVal);
/* 268:    */     
/* 269:    */ 
/* 270:433 */     parent.appendChild(node);
/* 271:    */   }
/* 272:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.XMLFileWriter
 * JD-Core Version:    0.7.0.1
 */