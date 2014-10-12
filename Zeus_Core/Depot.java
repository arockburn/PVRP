/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Depot
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   private Depot next;
/*   9:    */   private Depot prev;
/*  10:    */   private TruckLinkedList mainTrucks;
/*  11:    */   private int depotNum;
/*  12:    */   private double xCoord;
/*  13:    */   private double yCoord;
/*  14:    */   private Attributes attributes;
/*  15:    */   private String startLoc;
/*  16:    */   private double startX;
/*  17:    */   private double startY;
/*  18:    */   private String endLoc;
/*  19:    */   private double endX;
/*  20:    */   private double endY;
/*  21:    */   
/*  22:    */   public Depot()
/*  23:    */   {
/*  24: 41 */     this.prev = null;
/*  25: 42 */     this.next = null;
/*  26: 43 */     this.depotNum = -1;
/*  27: 44 */     this.xCoord = -1.0D;
/*  28: 45 */     this.yCoord = -1.0D;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public Depot(int d, float x, float y)
/*  32:    */   {
/*  33: 57 */     this.depotNum = d;
/*  34: 58 */     this.xCoord = x;
/*  35: 59 */     this.yCoord = y;
/*  36: 60 */     this.attributes = new Attributes();
/*  37: 61 */     this.mainTrucks = new TruckLinkedList();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public Depot getPrev()
/*  41:    */   {
/*  42: 69 */     return this.prev;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Depot getNext()
/*  46:    */   {
/*  47: 77 */     return this.next;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setPrev(Depot d)
/*  51:    */   {
/*  52: 85 */     this.prev = d;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setNext(Depot d)
/*  56:    */   {
/*  57: 93 */     this.next = d;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public TruckLinkedList getMainTrucks()
/*  61:    */   {
/*  62:101 */     return this.mainTrucks;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setMainTrucks(TruckLinkedList tll)
/*  66:    */   {
/*  67:109 */     this.mainTrucks = tll;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public double getXCoord()
/*  71:    */   {
/*  72:117 */     return this.xCoord;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setXCoord(double Xc)
/*  76:    */   {
/*  77:124 */     this.xCoord = Xc;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public double getYCoord()
/*  81:    */   {
/*  82:132 */     return this.yCoord;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setYCoord(double Yc)
/*  86:    */   {
/*  87:139 */     this.yCoord = Yc;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public int getDepotNum()
/*  91:    */   {
/*  92:147 */     return this.depotNum;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setDepotNum(int dNum)
/*  96:    */   {
/*  97:154 */     this.depotNum = dNum;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getStartLoc()
/* 101:    */   {
/* 102:162 */     return this.startLoc;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setStartLoc(String sLoc)
/* 106:    */   {
/* 107:169 */     this.startLoc = sLoc;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public double getStartY()
/* 111:    */   {
/* 112:177 */     return this.startY;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setStartY(float sLocLong)
/* 116:    */   {
/* 117:184 */     this.startY = sLocLong;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public double getStartX()
/* 121:    */   {
/* 122:192 */     return this.startX;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setStartX(float sLocLat)
/* 126:    */   {
/* 127:199 */     this.startX = sLocLat;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getEndLoc()
/* 131:    */   {
/* 132:207 */     return this.endLoc;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setEndLoc(String eLoc)
/* 136:    */   {
/* 137:214 */     this.endLoc = eLoc;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public double getEndY()
/* 141:    */   {
/* 142:222 */     return this.endY;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setEndY(float eLocLong)
/* 146:    */   {
/* 147:229 */     this.endY = eLocLong;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public double getEndX()
/* 151:    */   {
/* 152:237 */     return this.endX;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setEndXt(float eLocLat)
/* 156:    */   {
/* 157:244 */     this.endX = eLocLat;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public double getxCoord()
/* 161:    */   {
/* 162:248 */     return this.xCoord;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setxCoord(double xCoord)
/* 166:    */   {
/* 167:252 */     this.xCoord = xCoord;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public double getyCoord()
/* 171:    */   {
/* 172:256 */     return this.yCoord;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setyCoord(double yCoord)
/* 176:    */   {
/* 177:260 */     this.yCoord = yCoord;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public Attributes getAttributes()
/* 181:    */   {
/* 182:264 */     return this.attributes;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setAttributes(Attributes attributes)
/* 186:    */   {
/* 187:268 */     this.attributes = attributes;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setStartX(double startX)
/* 191:    */   {
/* 192:272 */     this.startX = startX;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setStartY(double startY)
/* 196:    */   {
/* 197:276 */     this.startY = startY;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setEndX(double endX)
/* 201:    */   {
/* 202:280 */     this.endX = endX;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setEndY(double endY)
/* 206:    */   {
/* 207:284 */     this.endY = endY;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String toString()
/* 211:    */   {
/* 212:292 */     return 
/* 213:293 */       "#" + this.depotNum + " (" + this.xCoord + ", " + this.yCoord + ")" + this.attributes;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public Object clone()
/* 217:    */   {
/* 218:305 */     Depot clonedDepot = new Depot();
/* 219:    */     
/* 220:307 */     clonedDepot.depotNum = this.depotNum;
/* 221:308 */     clonedDepot.xCoord = this.xCoord;
/* 222:309 */     clonedDepot.yCoord = this.yCoord;
/* 223:310 */     clonedDepot.attributes = ((Attributes)this.attributes.clone());
/* 224:311 */     clonedDepot.mainTrucks = ((TruckLinkedList)this.mainTrucks.clone());
/* 225:    */     
/* 226:313 */     return clonedDepot;
/* 227:    */   }
/* 228:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Depot
 * JD-Core Version:    0.7.0.1
 */