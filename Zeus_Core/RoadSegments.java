/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class RoadSegments
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected RoadSegments prev;
/*   9:    */   protected RoadSegments next;
/*  10:    */   protected int index;
/*  11:    */   protected float demand;
/*  12:    */   protected double fromLat;
/*  13:    */   protected double fromLong;
/*  14:    */   protected double toLat;
/*  15:    */   protected double toLong;
/*  16:    */   protected boolean isAssigned;
/*  17:    */   protected boolean isSelected;
/*  18:    */   protected String roadSegName;
/*  19:    */   protected String roadSegNo;
/*  20:    */   protected String fromNodes;
/*  21:    */   protected String toNodes;
/*  22:    */   protected boolean directionOfTravel;
/*  23:    */   
/*  24:    */   public RoadSegments()
/*  25:    */   {
/*  26: 35 */     this.roadSegNo = "No number";
/*  27: 36 */     this.prev = null;
/*  28: 37 */     this.next = null;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public boolean isAssigned()
/*  32:    */   {
/*  33: 45 */     return this.isAssigned;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public boolean getSelected()
/*  37:    */   {
/*  38: 53 */     return this.isSelected;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setSelected(boolean is)
/*  42:    */   {
/*  43: 61 */     this.isSelected = is;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setAssigned(boolean is)
/*  47:    */   {
/*  48: 69 */     this.isAssigned = is;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public RoadSegments getPrev()
/*  52:    */   {
/*  53: 77 */     return this.prev;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public RoadSegments getNext()
/*  57:    */   {
/*  58: 85 */     return this.next;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setPrev(RoadSegments s)
/*  62:    */   {
/*  63: 93 */     this.prev = s;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setNext(RoadSegments s)
/*  67:    */   {
/*  68:101 */     this.next = s;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public int getIndex()
/*  72:    */   {
/*  73:109 */     return this.index;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public double getToLatCoord()
/*  77:    */   {
/*  78:117 */     return this.toLat;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public double getToLongCoord()
/*  82:    */   {
/*  83:125 */     return this.toLong;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public double getFromLatCoord()
/*  87:    */   {
/*  88:133 */     return this.fromLat;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public double getFromLongCoord()
/*  92:    */   {
/*  93:141 */     return this.fromLong;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getFromNodes()
/*  97:    */   {
/*  98:149 */     return this.fromNodes;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getToNodes()
/* 102:    */   {
/* 103:157 */     return this.toNodes;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public int getDemand()
/* 107:    */   {
/* 108:167 */     return (int)this.demand;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setDemand(int d)
/* 112:    */   {
/* 113:175 */     this.demand = d;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setRoadSegmentName(String roadSegN)
/* 117:    */   {
/* 118:183 */     this.roadSegName = roadSegN;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getRoadSegmentName()
/* 122:    */   {
/* 123:191 */     return this.roadSegName;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setRoadSegmentNo(String roadSegNum)
/* 127:    */   {
/* 128:199 */     this.roadSegNo = roadSegNum;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String getRoadSegmentNo()
/* 132:    */   {
/* 133:207 */     return this.roadSegNo;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public Object clone()
/* 137:    */   {
/* 138:222 */     RoadSegments clonedShipment = new RoadSegments();
/* 139:    */     
/* 140:224 */     clonedShipment.demand = this.demand;
/* 141:225 */     clonedShipment.index = this.index;
/* 142:226 */     clonedShipment.isAssigned = this.isAssigned;
/* 143:    */     
/* 144:    */ 
/* 145:229 */     clonedShipment.toLat = this.toLat;
/* 146:230 */     clonedShipment.toLong = this.toLong;
/* 147:231 */     clonedShipment.fromLat = this.fromLat;
/* 148:232 */     clonedShipment.fromLong = this.fromLong;
/* 149:    */     
/* 150:234 */     return clonedShipment;
/* 151:    */   }
/* 152:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.RoadSegments
 * JD-Core Version:    0.7.0.1
 */