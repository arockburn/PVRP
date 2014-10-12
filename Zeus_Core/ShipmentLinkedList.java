/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ 
/*   5:    */ public class ShipmentLinkedList
/*   6:    */ {
/*   7:    */   private Shipment head;
/*   8:    */   private Shipment tail;
/*   9:    */   private int numShipments;
/*  10:    */   private int totalDemand;
/*  11:    */   
/*  12:    */   public void linkHeadTail()
/*  13:    */   {
/*  14: 40 */     this.head.setNext(this.tail);
/*  15: 41 */     this.tail.setPrev(this.head);
/*  16: 42 */     this.head.setPrev(null);
/*  17: 43 */     this.tail.setNext(null);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public Shipment getHead()
/*  21:    */   {
/*  22: 51 */     return this.head;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Shipment getTail()
/*  26:    */   {
/*  27: 59 */     return this.tail;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setHead(Shipment head)
/*  31:    */   {
/*  32: 63 */     this.head = head;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setTail(Shipment tail)
/*  36:    */   {
/*  37: 67 */     this.tail = tail;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public int getNumShipments()
/*  41:    */   {
/*  42: 75 */     return this.numShipments;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public int getTotalDemand()
/*  46:    */   {
/*  47: 79 */     return this.totalDemand;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setTotalDemand(int totalDemand)
/*  51:    */   {
/*  52: 83 */     this.totalDemand = totalDemand;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setNumShipments(int numShipments)
/*  56:    */   {
/*  57: 87 */     this.numShipments = numShipments;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public boolean insertLast(Shipment shipment)
/*  61:    */   {
/*  62: 98 */     if (this.head.getNext() == this.tail)
/*  63:    */     {
/*  64: 99 */       this.head.setNext(shipment);
/*  65:100 */       this.tail.setPrev(shipment);
/*  66:101 */       shipment.setPrev(this.head);
/*  67:102 */       shipment.setNext(this.tail);
/*  68:    */     }
/*  69:    */     else
/*  70:    */     {
/*  71:106 */       shipment.setNext(this.tail);
/*  72:107 */       shipment.setPrev(this.tail.getPrev());
/*  73:108 */       this.tail.getPrev().setNext(shipment);
/*  74:109 */       this.tail.setPrev(shipment);
/*  75:    */     }
/*  76:111 */     this.numShipments += 1;
/*  77:112 */     this.totalDemand += shipment.getDemand();
/*  78:113 */     return true;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public Shipment find(int key)
/*  82:    */   {
/*  83:122 */     boolean isDiagnostic = false;
/*  84:123 */     Shipment current = this.head.getNext();
/*  85:125 */     while (current.getNext() != this.tail)
/*  86:    */     {
/*  87:126 */       if (current.getIndex() == key) {
/*  88:    */         break;
/*  89:    */       }
/*  90:130 */       current = current.getNext();
/*  91:    */     }
/*  92:133 */     if (isDiagnostic) {
/*  93:134 */       System.out.println("found " + current.getIndex());
/*  94:    */     }
/*  95:137 */     return current;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public boolean clearAllSelected()
/*  99:    */   {
/* 100:146 */     Shipment ship = this.head.getNext();
/* 101:148 */     while (ship != this.tail)
/* 102:    */     {
/* 103:149 */       ship.setIsSelected(false);
/* 104:150 */       ship = ship.getNext();
/* 105:    */     }
/* 106:152 */     return true;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public boolean isAllShipsSelected()
/* 110:    */   {
/* 111:160 */     Shipment ship = this.head.getNext();
/* 112:162 */     while (ship != this.tail)
/* 113:    */     {
/* 114:163 */       if (!ship.getIsSelected()) {
/* 115:164 */         return false;
/* 116:    */       }
/* 117:167 */       ship = ship.getNext();
/* 118:    */     }
/* 119:170 */     return true;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean isAllShipsAssigned()
/* 123:    */   {
/* 124:178 */     Shipment ship = this.head.getNext();
/* 125:180 */     while (ship != this.tail)
/* 126:    */     {
/* 127:181 */       if (!ship.getIsAssigned()) {
/* 128:182 */         return false;
/* 129:    */       }
/* 130:185 */       ship = ship.getNext();
/* 131:    */     }
/* 132:188 */     return true;
/* 133:    */   }
/* 134:    */   
/* 135:    */   protected double calcPolarAngle(double x1, double y1, double x, double y)
/* 136:    */   {
/* 137:201 */     double radian = 57.295780000000001D;
/* 138:202 */     double slope = 0.0D;
/* 139:    */     
/* 140:    */ 
/* 141:    */ 
/* 142:    */ 
/* 143:207 */     double xrun = x - x1;
/* 144:208 */     double yrise = y - y1;
/* 145:    */     double angle;
/* 146:    */     double angle;
/* 147:210 */     if (xrun > 0.0D)
/* 148:    */     {
/* 149:211 */       slope = yrise / xrun;
/* 150:    */       double angle;
/* 151:213 */       if (yrise >= 0.0D) {
/* 152:214 */         angle = Math.atan(slope) * radian;
/* 153:    */       } else {
/* 154:217 */         angle = 360.0D + Math.atan(slope) * radian;
/* 155:    */       }
/* 156:    */     }
/* 157:    */     else
/* 158:    */     {
/* 159:    */       double angle;
/* 160:220 */       if (xrun == 0.0D)
/* 161:    */       {
/* 162:    */         double angle;
/* 163:221 */         if (yrise >= 0.0D) {
/* 164:222 */           angle = 90.0D;
/* 165:    */         } else {
/* 166:225 */           angle = 270.0D;
/* 167:    */         }
/* 168:    */       }
/* 169:    */       else
/* 170:    */       {
/* 171:229 */         slope = yrise / xrun;
/* 172:230 */         angle = 180.0D + Math.atan(slope) * radian;
/* 173:    */       }
/* 174:    */     }
/* 175:233 */     return angle;
/* 176:    */   }
/* 177:    */   
/* 178:    */   protected double calcDist(double x1, double x2, double y1, double y2)
/* 179:    */   {
/* 180:245 */     double d = 0.0D;
/* 181:    */     try
/* 182:    */     {
/* 183:248 */       d = Math.sqrt((x2 - x1) * (x2 - x1) + 
/* 184:249 */         (y2 - y1) * (y2 - y1));
/* 185:    */     }
/* 186:    */     catch (ArithmeticException e)
/* 187:    */     {
/* 188:252 */       System.out.println(
/* 189:253 */         "Arithmetic Exception in calculating distance in ShipmentLinkedList " + 
/* 190:254 */         e);
/* 191:    */     }
/* 192:256 */     return d;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void writeShipments(PrintStream out)
/* 196:    */   {
/* 197:264 */     out.println(this.numShipments);
/* 198:    */     
/* 199:266 */     Shipment ship = this.head.getNext();
/* 200:267 */     while (ship != this.tail)
/* 201:    */     {
/* 202:268 */       out.println(ship.getIndex() + " " + ship.getTruckTypeNeeded() + " " + 
/* 203:269 */         ship.getDemand() + " " + ship.getXCoord() + " " + 
/* 204:    */         
/* 205:271 */         ship.getYCoord());
/* 206:272 */       ship = ship.getNext();
/* 207:    */     }
/* 208:    */   }
/* 209:    */   
/* 210:    */   public int[] getCurrentComb(int[] combList, int combIndex, int t)
/* 211:    */   {
/* 212:287 */     int[] decodedComb = new int[t];
/* 213:    */     
/* 214:    */ 
/* 215:290 */     int combCode = combList[combIndex];
/* 216:291 */     decodedComb = decodeTheComb(combCode, t);
/* 217:292 */     return decodedComb;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public int[] decodeTheComb(int code, int t)
/* 221:    */   {
/* 222:306 */     int num = code;
/* 223:307 */     int quot = -1;
/* 224:    */     
/* 225:    */ 
/* 226:310 */     int[] tempArray = new int[t];
/* 227:311 */     int[] decode = new int[t];
/* 228:312 */     int count = 0;
/* 229:313 */     int numDays = t;
/* 230:314 */     while (quot != 0)
/* 231:    */     {
/* 232:315 */       quot = num / 2;
/* 233:316 */       int rem = num % 2;
/* 234:    */       
/* 235:    */ 
/* 236:319 */       tempArray[count] = rem;
/* 237:320 */       count++;
/* 238:321 */       num = quot;
/* 239:    */     }
/* 240:324 */     for (int b = 0; b < t; b++) {
/* 241:325 */       decode[b] = tempArray[(--numDays)];
/* 242:    */     }
/* 243:331 */     return decode;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public void displayBackwardList()
/* 247:    */   {
/* 248:412 */     System.out.print("List (last to first): ");
/* 249:413 */     Shipment current = this.tail;
/* 250:414 */     while (current != this.head.getNext()) {
/* 251:416 */       current = current.getPrev();
/* 252:    */     }
/* 253:419 */     System.out.println("");
/* 254:    */   }
/* 255:    */   
/* 256:    */   public boolean isEmpty()
/* 257:    */   {
/* 258:427 */     return this.head.getNext() == null;
/* 259:    */   }
/* 260:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.ShipmentLinkedList
 * JD-Core Version:    0.7.0.1
 */