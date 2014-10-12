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
/*  19:    */ public class GoogleDist
/*  20:    */ {
/*  21: 30 */   private static String _gapiUrlPart = "http://maps.googleapis.com/maps/api/distancematrix/xml?";
/*  22: 36 */   private static HttpURLConnection _httpConnection = null;
/*  23: 42 */   private static String _toAddress = "&destinations=16057";
/*  24: 48 */   private static String _fromAddress = "origins=16058";
/*  25:    */   
/*  26:    */   public static float getDistance(String orig, String dest)
/*  27:    */     throws IOException
/*  28:    */   {
/*  29: 57 */     ReadableByteChannel inChannel = null;
/*  30: 58 */     float distance = 0.0F;
/*  31:    */     try
/*  32:    */     {
/*  33: 62 */       _fromAddress = "origins=" + orig;
/*  34: 63 */       _toAddress = "&destinations=" + dest;
/*  35: 64 */       URL urlRequest = new URL(_gapiUrlPart + 
/*  36: 65 */         _fromAddress + 
/*  37: 66 */         _toAddress + 
/*  38: 67 */         "&mode=driving&units=imperial");
/*  39: 68 */       _httpConnection = 
/*  40: 69 */         (HttpURLConnection)urlRequest.openConnection();
/*  41: 70 */       InputStream stream = _httpConnection.getInputStream();
/*  42: 71 */       BufferedReader bufReader = new BufferedReader(
/*  43: 72 */         new InputStreamReader(stream));
/*  44: 73 */       StringBuilder recDataSB = new StringBuilder();
/*  45:    */       String recData;
/*  46: 75 */       while ((recData = bufReader.readLine()) != null)
/*  47:    */       {
/*  48:    */         String recData;
/*  49: 77 */         recDataSB.append(recData);
/*  50:    */       }
/*  51: 79 */       System.out.println(recDataSB.toString());
/*  52: 80 */       distance = parseDistance(recDataSB.toString());
/*  53:    */     }
/*  54:    */     catch (IOException e)
/*  55:    */     {
/*  56: 84 */       throw e;
/*  57:    */     }
/*  58:    */     finally
/*  59:    */     {
/*  60: 88 */       if (inChannel != null) {
/*  61: 89 */         inChannel.close();
/*  62:    */       }
/*  63:    */     }
/*  64: 91 */     return distance;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public static float parseDistance(String xmlString)
/*  68:    */   {
/*  69: 98 */     float distance = 0.0F;
/*  70:    */     try
/*  71:    */     {
/*  72:108 */       DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
/*  73:109 */       DocumentBuilder b = f.newDocumentBuilder();
/*  74:110 */       Document doc = b.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
/*  75:111 */       NodeList books = doc.getElementsByTagName("distance");
/*  76:112 */       for (int i = 0; i < books.getLength(); i++)
/*  77:    */       {
/*  78:113 */         Element book = (Element)books.item(i);
/*  79:114 */         Node title = book.getElementsByTagName("text").item(0);
/*  80:115 */         String strMileage = title.getTextContent();
/*  81:116 */         strMileage = strMileage.trim();
/*  82:    */         
/*  83:118 */         strMileage = strMileage.replace("mi", "");
/*  84:119 */         strMileage = strMileage.trim();
/*  85:    */         
/*  86:121 */         distance = Float.valueOf(strMileage).floatValue();
/*  87:122 */         System.out.println(distance);
/*  88:    */       }
/*  89:    */     }
/*  90:    */     catch (Exception localException) {}
/*  91:150 */     return distance;
/*  92:    */   }
/*  93:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.GoogleDist
 * JD-Core Version:    0.7.0.1
 */