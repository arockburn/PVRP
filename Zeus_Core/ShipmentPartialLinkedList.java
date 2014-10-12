/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ 
/*   5:    */ public class ShipmentPartialLinkedList
/*   6:    */ {
/*   7:    */   protected ShipmentPartial head;
/*   8:    */   protected ShipmentPartial tail;
/*   9:    */   protected int numShipments;
/*  10:    */   protected int totalDemand;
/*  11:    */   
/*  12:    */   public ShipmentPartialLinkedList()
/*  13:    */   {
/*  14: 25 */     this.head = new ShipmentPartial();
/*  15: 26 */     this.tail = new ShipmentPartial();
/*  16: 27 */     this.numShipments = 0;
/*  17:    */   }
/*  18:    */   
/*  19:    */   public ShipmentPartial getHead()
/*  20:    */   {
/*  21: 35 */     return this.head;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public ShipmentPartial getTail()
/*  25:    */   {
/*  26: 43 */     return this.tail;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public int getNumPartialShipments()
/*  30:    */   {
/*  31: 51 */     return this.numShipments;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public boolean insertLast(ShipmentPartial shipment)
/*  35:    */   {
/*  36: 61 */     if (this.head.getNext() == this.tail)
/*  37:    */     {
/*  38: 62 */       this.head.setNext(shipment);
/*  39: 63 */       this.tail.setPrev(shipment);
/*  40: 64 */       shipment.setPrev(shipment);
/*  41: 65 */       shipment.setNext(shipment);
/*  42:    */     }
/*  43:    */     else
/*  44:    */     {
/*  45: 69 */       shipment.setNext(this.tail);
/*  46: 70 */       shipment.setPrev(this.tail.getPrev());
/*  47: 71 */       this.tail.getPrev().setNext(shipment);
/*  48: 72 */       this.tail.setPrev(shipment);
/*  49:    */     }
/*  50: 75 */     this.numShipments += 1;
/*  51: 76 */     return true;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public ShipmentPartial find(int key)
/*  55:    */   {
/*  56: 86 */     boolean isDiagnostic = false;
/*  57: 87 */     ShipmentPartial current = this.head;
/*  58: 89 */     while (current.getNext() != null)
/*  59:    */     {
/*  60: 90 */       if (current.getIndex() == key) {
/*  61:    */         break;
/*  62:    */       }
/*  63: 94 */       current = current.getNext();
/*  64:    */     }
/*  65: 97 */     if (isDiagnostic) {
/*  66: 98 */       System.out.println("found " + current.getIndex());
/*  67:    */     }
/*  68:101 */     return current;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public boolean clearAllSelected()
/*  72:    */   {
/*  73:110 */     ShipmentPartial ship = this.head;
/*  74:112 */     while (ship != null)
/*  75:    */     {
/*  76:113 */       ship.isSelected = false;
/*  77:114 */       ship = ship.getNext();
/*  78:    */     }
/*  79:116 */     return true;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public boolean isAllShipsSelected()
/*  83:    */   {
/*  84:124 */     ShipmentPartial ship = this.head;
/*  85:126 */     while (ship != null)
/*  86:    */     {
/*  87:127 */       if (!ship.getSelected()) {
/*  88:128 */         return false;
/*  89:    */       }
/*  90:131 */       ship = ship.getNext();
/*  91:    */     }
/*  92:134 */     return true;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public boolean isAllShipsAssigned()
/*  96:    */   {
/*  97:142 */     ShipmentPartial ship = this.head;
/*  98:144 */     while (ship != null)
/*  99:    */     {
/* 100:145 */       if (!ship.isAssigned()) {
/* 101:146 */         return false;
/* 102:    */       }
/* 103:149 */       ship = ship.getNext();
/* 104:    */     }
/* 105:152 */     return true;
/* 106:    */   }
/* 107:    */   
/* 108:    */   protected double calcPolarAngle(double x1, double y1, double x, double y)
/* 109:    */   {
/* 110:165 */     double radian = 57.295780000000001D;
/* 111:166 */     double slope = 0.0D;
/* 112:    */     
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:171 */     double xrun = x - x1;
/* 117:172 */     double yrise = y - y1;
/* 118:    */     double angle;
/* 119:    */     double angle;
/* 120:174 */     if (xrun > 0.0D)
/* 121:    */     {
/* 122:175 */       slope = yrise / xrun;
/* 123:    */       double angle;
/* 124:177 */       if (yrise >= 0.0D) {
/* 125:178 */         angle = Math.atan(slope) * radian;
/* 126:    */       } else {
/* 127:181 */         angle = 360.0D + Math.atan(slope) * radian;
/* 128:    */       }
/* 129:    */     }
/* 130:    */     else
/* 131:    */     {
/* 132:    */       double angle;
/* 133:184 */       if (xrun == 0.0D)
/* 134:    */       {
/* 135:    */         double angle;
/* 136:185 */         if (yrise >= 0.0D) {
/* 137:186 */           angle = 90.0D;
/* 138:    */         } else {
/* 139:189 */           angle = 270.0D;
/* 140:    */         }
/* 141:    */       }
/* 142:    */       else
/* 143:    */       {
/* 144:193 */         slope = yrise / xrun;
/* 145:194 */         angle = 180.0D + Math.atan(slope) * radian;
/* 146:    */       }
/* 147:    */     }
/* 148:197 */     return angle;
/* 149:    */   }
/* 150:    */   
/* 151:    */   protected double calcDist(double x1, double x2, double y1, double y2)
/* 152:    */   {
/* 153:209 */     double d = 0.0D;
/* 154:    */     try
/* 155:    */     {
/* 156:212 */       d = Math.sqrt((x2 - x1) * (x2 - x1) + 
/* 157:213 */         (y2 - y1) * (y2 - y1));
/* 158:    */     }
/* 159:    */     catch (ArithmeticException e)
/* 160:    */     {
/* 161:216 */       System.out.println(
/* 162:217 */         "Arithmetic Exception in calculating distance in ShipmentPartialLinkedList " + 
/* 163:218 */         e);
/* 164:    */     }
/* 165:220 */     return d;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void writeShipmentPartials(PrintStream out)
/* 169:    */   {
/* 170:228 */     out.println(this.numShipments);
/* 171:    */     
/* 172:230 */     ShipmentPartial ship = this.head;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public int[] getCurrentComb(int[] combList, int combIndex, int t)
/* 176:    */   {
/* 177:251 */     int[] decodedComb = new int[t];
/* 178:    */     
/* 179:    */ 
/* 180:254 */     int combCode = combList[combIndex];
/* 181:255 */     decodedComb = decodeTheComb(combCode, t);
/* 182:256 */     return decodedComb;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public int[] decodeTheComb(int code, int t)
/* 186:    */   {
/* 187:270 */     int num = code;
/* 188:271 */     int quot = -1;
/* 189:    */     
/* 190:    */ 
/* 191:274 */     int[] tempArray = new int[t];
/* 192:275 */     int[] decode = new int[t];
/* 193:276 */     int count = 0;
/* 194:277 */     int numDays = t;
/* 195:278 */     while (quot != 0)
/* 196:    */     {
/* 197:279 */       quot = num / 2;
/* 198:280 */       int rem = num % 2;
/* 199:    */       
/* 200:    */ 
/* 201:283 */       tempArray[count] = rem;
/* 202:284 */       count++;
/* 203:285 */       num = quot;
/* 204:    */     }
/* 205:288 */     for (int b = 0; b < t; b++) {
/* 206:289 */       decode[b] = tempArray[(--numDays)];
/* 207:    */     }
/* 208:295 */     return decode;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void displayBackwardList()
/* 212:    */   {
/* 213:304 */     System.out.print("List (last to first): ");
/* 214:305 */     ShipmentPartial current = this.tail;
/* 215:306 */     while (current != null) {
/* 216:308 */       current = current.getPrev();
/* 217:    */     }
/* 218:311 */     System.out.println("");
/* 219:    */   }
/* 220:    */   
/* 221:    */   public boolean isEmpty()
/* 222:    */   {
/* 223:319 */     return this.head == null;
/* 224:    */   }
/* 225:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.ShipmentPartialLinkedList
 * JD-Core Version:    0.7.0.1
 */