/*  1:   */ package edu.sru.thangiah.zeus.core;
/*  2:   */ 
/*  3:   */ public class HaversineFormula
/*  4:   */ {
/*  5:   */   public static float getDistance(float lat1, float long1, float lat2, float long2)
/*  6:   */   {
/*  7:10 */     float distance = 0.0F;
/*  8:11 */     double theta = long1 - long2;
/*  9:   */     
/* 10:13 */     int R = 6371;
/* 11:14 */     double dLat = degToRad(lat2 - lat1);
/* 12:15 */     double dLon = degToRad(long2 - long1);
/* 13:16 */     double a = Math.sin(dLat / 2.0D) * Math.sin(dLat / 2.0D) + 
/* 14:17 */       Math.cos(degToRad(lat1)) * Math.cos(degToRad(lat2)) * 
/* 15:18 */       Math.sin(dLon / 2.0D) * Math.sin(dLon / 2.0D);
/* 16:19 */     double c = 2.0D * Math.atan2(Math.sqrt(a), Math.sqrt(1.0D - a));
/* 17:20 */     double d = R * c;
/* 18:   */     
/* 19:22 */     distance = (float)d;
/* 20:   */     
/* 21:24 */     return distance;
/* 22:   */   }
/* 23:   */   
/* 24:   */   private static double degToRad(float deg)
/* 25:   */   {
/* 26:32 */     return deg * 3.141592653589793D / 180.0D;
/* 27:   */   }
/* 28:   */   
/* 29:   */   private static double radToDeg(float rad)
/* 30:   */   {
/* 31:39 */     return rad * 180.0F / 3.141592653589793D;
/* 32:   */   }
/* 33:   */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.HaversineFormula
 * JD-Core Version:    0.7.0.1
 */