/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.ByteArrayInputStream;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.InputStream;
/*   7:    */ import java.io.InputStreamReader;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.net.HttpURLConnection;
/*  10:    */ import java.net.URL;
/*  11:    */ import java.nio.channels.ReadableByteChannel;
/*  12:    */ import javax.xml.parsers.DocumentBuilder;
/*  13:    */ import javax.xml.parsers.DocumentBuilderFactory;
/*  14:    */ import org.w3c.dom.Document;
/*  15:    */ import org.w3c.dom.Element;
/*  16:    */ import org.w3c.dom.Node;
/*  17:    */ import org.w3c.dom.NodeList;
/*  18:    */ 
/*  19:    */ public class GoogleLongLat
/*  20:    */ {
/*  21: 29 */   private static String _gapiUrlPart = "http://maps.googleapis.com/maps/api/geocode/xml?";
/*  22: 35 */   private static HttpURLConnection _httpConnection = null;
/*  23: 42 */   private static String _address = "&address=AIRDRIE+AB+T4B3G5";
/*  24:    */   
/*  25:    */   public static String getLongLat(String address)
/*  26:    */     throws IOException
/*  27:    */   {
/*  28: 53 */     ReadableByteChannel inChannel = null;
/*  29:    */     String latLong;
/*  30:    */     try
/*  31:    */     {
/*  32: 58 */       _address = "address=" + address;
/*  33: 59 */       URL urlRequest = new URL(_gapiUrlPart + _address);
/*  34: 60 */       _httpConnection = 
/*  35: 61 */         (HttpURLConnection)urlRequest.openConnection();
/*  36: 62 */       InputStream stream = _httpConnection.getInputStream();
/*  37: 63 */       BufferedReader bufReader = new BufferedReader(
/*  38: 64 */         new InputStreamReader(stream));
/*  39: 65 */       StringBuilder recDataSB = new StringBuilder();
/*  40:    */       String recData;
/*  41: 67 */       while ((recData = bufReader.readLine()) != null)
/*  42:    */       {
/*  43:    */         String recData;
/*  44: 69 */         recDataSB.append(recData);
/*  45:    */       }
/*  46: 71 */       System.out.println(recDataSB.toString());
/*  47:    */       
/*  48: 73 */       latLong = parseLongLat(recDataSB.toString());
/*  49:    */     }
/*  50:    */     catch (IOException e)
/*  51:    */     {
/*  52:    */       String latLong;
/*  53: 77 */       e.printStackTrace();
/*  54: 78 */       throw e;
/*  55:    */     }
/*  56:    */     finally
/*  57:    */     {
/*  58: 82 */       if (inChannel != null) {
/*  59: 83 */         inChannel.close();
/*  60:    */       }
/*  61:    */     }
/*  62: 85 */     return latLong;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public static String parseLongLat(String xmlString)
/*  66:    */   {
/*  67: 92 */     float distance = 0.0F;
/*  68:    */     
/*  69: 94 */     String latitude = "";
/*  70: 95 */     String longitude = "";
/*  71:    */     try
/*  72:    */     {
/*  73:114 */       DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
/*  74:115 */       DocumentBuilder b = f.newDocumentBuilder();
/*  75:116 */       Document doc = b.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
/*  76:    */       
/*  77:118 */       NodeList books = doc.getElementsByTagName("geometry");
/*  78:119 */       for (int i = 0; i < books.getLength(); i++)
/*  79:    */       {
/*  80:120 */         Element book = (Element)books.item(i);
/*  81:121 */         Node title = book.getElementsByTagName("lat").item(0);
/*  82:122 */         latitude = title.getTextContent();
/*  83:    */         
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89:129 */         System.out.println("Latitude " + latitude);
/*  90:    */       }
/*  91:133 */       books = doc.getElementsByTagName("geometry");
/*  92:134 */       for (int i = 0; i < books.getLength(); i++)
/*  93:    */       {
/*  94:135 */         Element book = (Element)books.item(i);
/*  95:136 */         Node title = book.getElementsByTagName("lng").item(0);
/*  96:137 */         longitude = title.getTextContent();
/*  97:    */         
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:144 */         System.out.println("Longitude " + longitude);
/* 104:    */       }
/* 105:    */     }
/* 106:    */     catch (Exception localException) {}
/* 107:172 */     if ((latitude.equals("")) || (longitude.equals(""))) {
/* 108:174 */       return "0.0;0.0";
/* 109:    */     }
/* 110:178 */     return latitude + ";" + longitude;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public static void main(String[] args)
/* 114:    */   {
/* 115:    */     try
/* 116:    */     {
/* 117:187 */       getLongLat("AIRDRIE+AB+T4B3G5");
/* 118:    */     }
/* 119:    */     catch (Exception localException) {}
/* 120:    */   }
/* 121:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.GoogleLongLat
 * JD-Core Version:    0.7.0.1
 */