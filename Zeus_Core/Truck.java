/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import edu.sru.thangiah.zeus.geoClust.Shape;
/*   4:    */ import edu.sru.thangiah.zeus.geoClust.Vertex;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public class Truck
/*   8:    */   implements Serializable, Cloneable
/*   9:    */ {
/*  10:    */   private Truck prev;
/*  11:    */   private Truck next;
/*  12:    */   private int truckNum;
/*  13:    */   private TruckType truckType;
/*  14:    */   private double depotX;
/*  15:    */   private double depotY;
/*  16:    */   private NodesLinkedList mainNodes;
/*  17:    */   private DaysLinkedList mainDays;
/*  18:    */   private RoadSegmentsLinkedList mainRoadSegments;
/*  19:    */   private Attributes attributes;
/*  20:    */   private Shape shape;
/*  21:    */   
/*  22:    */   public Truck()
/*  23:    */   {
/*  24: 37 */     this.prev = null;
/*  25: 38 */     this.next = null;
/*  26: 39 */     this.truckNum = -1;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public Truck(TruckType tt, float depX, float depY)
/*  30:    */   {
/*  31: 50 */     this.attributes = new Attributes();
/*  32: 51 */     this.depotX = depX;
/*  33: 52 */     this.depotY = depY;
/*  34:    */     
/*  35: 54 */     this.truckType = tt;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Truck getPrev()
/*  39:    */   {
/*  40: 63 */     return this.prev;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Truck getNext()
/*  44:    */   {
/*  45: 71 */     return this.next;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setNext(Truck t)
/*  49:    */   {
/*  50: 79 */     this.next = t;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setPrev(Truck t)
/*  54:    */   {
/*  55: 87 */     this.prev = t;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void truck(Truck t)
/*  59:    */   {
/*  60: 95 */     this.next = t;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public NodesLinkedList getMainNodes()
/*  64:    */   {
/*  65:103 */     return this.mainNodes;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setMainNodes(NodesLinkedList nll)
/*  69:    */   {
/*  70:111 */     this.mainNodes = nll;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public DaysLinkedList getMainDays()
/*  74:    */   {
/*  75:115 */     return this.mainDays;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setMainDays(DaysLinkedList mainDays)
/*  79:    */   {
/*  80:119 */     this.mainDays = mainDays;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public RoadSegmentsLinkedList getMainRoadSegments()
/*  84:    */   {
/*  85:127 */     return this.mainRoadSegments;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setMainRoadSegments(RoadSegmentsLinkedList rsll)
/*  89:    */   {
/*  90:135 */     this.mainRoadSegments = rsll;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public int getTruckNum()
/*  94:    */   {
/*  95:144 */     return this.truckNum;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public TruckType getTruckType()
/*  99:    */   {
/* 100:152 */     return this.truckType;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public boolean equals(Truck otherTruck)
/* 104:    */   {
/* 105:163 */     return otherTruck.getTruckType().getServiceType().equals(getTruckType()
/* 106:164 */       .getServiceType());
/* 107:    */   }
/* 108:    */   
/* 109:    */   public boolean compatableWith(Shipment aShip)
/* 110:    */   {
/* 111:173 */     return aShip.getTruckTypeNeeded().equals(this.truckType.getServiceType());
/* 112:    */   }
/* 113:    */   
/* 114:    */   public boolean isEmptyMainNodes()
/* 115:    */   {
/* 116:182 */     if ((this.mainNodes.getHead() == this.mainNodes.getTail()) || (this.mainNodes.getSize() <= 2)) {
/* 117:183 */       return true;
/* 118:    */     }
/* 119:186 */     return false;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean isEmptyMainDays()
/* 123:    */   {
/* 124:196 */     if ((this.mainDays.getHead() == this.mainDays.getTail()) || (this.mainDays.getSize() <= 2)) {
/* 125:197 */       return true;
/* 126:    */     }
/* 127:200 */     return false;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String toString()
/* 131:    */   {
/* 132:211 */     String s = "#" + this.truckNum + " " + 
/* 133:212 */       " Max Q=" + this.truckType.getMaxCapacity() + " Max Dist =" + this.truckType.getMaxDistance();
/* 134:    */     
/* 135:    */ 
/* 136:    */ 
/* 137:    */ 
/* 138:    */ 
/* 139:    */ 
/* 140:    */ 
/* 141:    */ 
/* 142:    */ 
/* 143:    */ 
/* 144:    */ 
/* 145:    */ 
/* 146:    */ 
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:    */ 
/* 151:    */ 
/* 152:231 */     return s;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public Attributes getAttributes()
/* 156:    */   {
/* 157:235 */     return this.attributes;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setAttributes(Attributes attributes)
/* 161:    */   {
/* 162:239 */     this.attributes = attributes;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setTruckNum(int truckNum)
/* 166:    */   {
/* 167:243 */     this.truckNum = truckNum;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setTruckType(TruckType truckType)
/* 171:    */   {
/* 172:247 */     this.truckType = truckType;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setShape(Shape shape)
/* 176:    */   {
/* 177:251 */     this.shape = shape;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public Object clone()
/* 181:    */   {
/* 182:260 */     Truck clonedTruck = new Truck();
/* 183:    */     
/* 184:262 */     clonedTruck.attributes = ((Attributes)this.attributes.clone());
/* 185:263 */     clonedTruck.depotX = this.depotX;
/* 186:264 */     clonedTruck.depotY = this.depotY;
/* 187:265 */     clonedTruck.mainNodes = ((NodesLinkedList)this.mainNodes.clone());
/* 188:266 */     clonedTruck.truckNum = this.truckNum;
/* 189:267 */     clonedTruck.truckType = ((TruckType)this.truckType.clone());
/* 190:    */     
/* 191:269 */     return clonedTruck;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public Shape newShape()
/* 195:    */   {
/* 196:278 */     this.shape = new Shape();
/* 197:279 */     return this.shape;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public Shape newShape(int n, double r, float x_o, float y_o, int deg)
/* 201:    */   {
/* 202:296 */     this.shape = new Shape(n, r, x_o, y_o, deg);
/* 203:297 */     return this.shape;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public Shape newShape(int n)
/* 207:    */   {
/* 208:308 */     this.shape = new Shape(n);
/* 209:309 */     return this.shape;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public Shape newShape(int n, double r, Vertex c)
/* 213:    */   {
/* 214:323 */     this.shape = new Shape(n, r, c);
/* 215:324 */     return this.shape;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public Shape getShape()
/* 219:    */   {
/* 220:334 */     return this.shape;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setDepotX(double depotXVal)
/* 224:    */   {
/* 225:342 */     this.depotX = depotXVal;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public double getDepotX()
/* 229:    */   {
/* 230:350 */     return this.depotX;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public void setDepotY(double depotYVal)
/* 234:    */   {
/* 235:358 */     this.depotY = depotYVal;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public double getDepotY()
/* 239:    */   {
/* 240:366 */     return this.depotY;
/* 241:    */   }
/* 242:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Truck
 * JD-Core Version:    0.7.0.1
 */