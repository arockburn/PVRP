/*  1:   */ package edu.sru.thangiah.zeus.core;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class Settings
/*  8:   */ {
/*  9:16 */   public static boolean lockTrucks = false;
/* 10:18 */   public static PrintStream debugStream = System.out;
/* 11:21 */   public static int debugLevel = 3;
/* 12:   */   public static final int OFF = 0;
/* 13:   */   public static final int ERROR = 1;
/* 14:   */   public static final int WARNING = 2;
/* 15:   */   public static final int COMMENT = 3;
/* 16:26 */   private static final String[] dbg = {
/* 17:27 */     "OFF", "ERROR", "WARNING", "COMMENT" };
/* 18:   */   
/* 19:   */   public static void printDebug(int level, String msg)
/* 20:   */   {
/* 21:30 */     if (level <= debugLevel) {
/* 22:31 */       debugStream.println(dbg[level] + " \"" + msg + "\" " + 
/* 23:32 */         new Timestamp(new Date().getTime()));
/* 24:   */     }
/* 25:   */   }
/* 26:   */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Settings
 * JD-Core Version:    0.7.0.1
 */