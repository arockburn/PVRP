/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.text.DecimalFormat;
/*   5:    */ 
/*   6:    */ public class Attributes
/*   7:    */   implements Serializable, Cloneable
/*   8:    */ {
/*   9: 17 */   private double totalDemand = 0.0D;
/*  10: 18 */   private double totalDistance = 0.0D;
/*  11: 19 */   private double totalCost = 0.0D;
/*  12: 23 */   private double totalTravelTime = 0.0D;
/*  13: 24 */   private double maxTravelTime = 0.0D;
/*  14: 25 */   private double avgTravelTime = 0.0D;
/*  15:    */   
/*  16:    */   public String toString()
/*  17:    */   {
/*  18: 38 */     DecimalFormat df = new DecimalFormat("0.00");
/*  19:    */     
/*  20: 40 */     return " totQ=" + df.format(this.totalDemand) + " totD=" + 
/*  21: 41 */       df.format(this.totalDistance) + " $" + df.format(this.totalCost);
/*  22:    */   }
/*  23:    */   
/*  24:    */   public double getTotalDemand()
/*  25:    */   {
/*  26: 45 */     return this.totalDemand;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setTotalDemand(double totalDemand)
/*  30:    */   {
/*  31: 49 */     this.totalDemand = totalDemand;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public double getTotalDistance()
/*  35:    */   {
/*  36: 53 */     return this.totalDistance;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setTotalDistance(double totalDistance)
/*  40:    */   {
/*  41: 57 */     this.totalDistance = totalDistance;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public double getTotalCost()
/*  45:    */   {
/*  46: 61 */     return this.totalCost;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setTotalCost(double totalCost)
/*  50:    */   {
/*  51: 65 */     this.totalCost = totalCost;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public double getTotalTravelTime()
/*  55:    */   {
/*  56: 69 */     return this.totalTravelTime;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setTotalTravelTime(double totalTravelTime)
/*  60:    */   {
/*  61: 73 */     this.totalTravelTime = totalTravelTime;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public double getMaxTravelTime()
/*  65:    */   {
/*  66: 77 */     return this.maxTravelTime;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setMaxTravelTime(double maxTravelTime)
/*  70:    */   {
/*  71: 81 */     this.maxTravelTime = maxTravelTime;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public double getAvgTravelTime()
/*  75:    */   {
/*  76: 85 */     return this.avgTravelTime;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setAvgTravelTime(double avgTravelTime)
/*  80:    */   {
/*  81: 89 */     this.avgTravelTime = avgTravelTime;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String toDetailedString()
/*  85:    */   {
/*  86: 98 */     DecimalFormat df = new DecimalFormat("0.00");
/*  87:    */     
/*  88:100 */     return "Total Demand = " + df.format(this.totalDemand) + 
/*  89:101 */       "| Total Distance = " + df.format(this.totalDistance) + 
/*  90:102 */       "| Total Travel Time = " + df.format(this.totalTravelTime) + 
/*  91:103 */       "| Total Cost = $" + df.format(this.totalCost) + "|";
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Object clone()
/*  95:    */   {
/*  96:111 */     Attributes clonedAttributes = new Attributes();
/*  97:    */     
/*  98:113 */     clonedAttributes.avgTravelTime = this.avgTravelTime;
/*  99:114 */     clonedAttributes.maxTravelTime = this.maxTravelTime;
/* 100:    */     
/* 101:116 */     clonedAttributes.totalCost = this.totalCost;
/* 102:    */     
/* 103:118 */     clonedAttributes.totalDemand = this.totalDemand;
/* 104:119 */     clonedAttributes.totalDistance = this.totalDistance;
/* 105:120 */     clonedAttributes.totalTravelTime = this.totalTravelTime;
/* 106:    */     
/* 107:    */ 
/* 108:    */ 
/* 109:124 */     return clonedAttributes;
/* 110:    */   }
/* 111:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Attributes
 * JD-Core Version:    0.7.0.1
 */