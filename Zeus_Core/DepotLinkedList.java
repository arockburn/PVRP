/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public class DepotLinkedList
/*   7:    */   implements Serializable, Cloneable
/*   8:    */ {
/*   9:    */   private Depot head;
/*  10:    */   private Depot tail;
/*  11:    */   private Attributes attributes;
/*  12:    */   
/*  13:    */   public DepotLinkedList()
/*  14:    */   {
/*  15: 35 */     this.head = new Depot();
/*  16: 36 */     this.tail = new Depot();
/*  17: 37 */     this.head.setNext(this.tail);
/*  18: 38 */     this.tail.setPrev(this.head);
/*  19: 39 */     this.attributes = new Attributes();
/*  20:    */   }
/*  21:    */   
/*  22:    */   public Depot getHead()
/*  23:    */   {
/*  24: 50 */     return this.head;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public Depot getTail()
/*  28:    */   {
/*  29: 58 */     return this.tail;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public void setHead(Depot head)
/*  33:    */   {
/*  34: 88 */     this.head = head;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setTail(Depot tail)
/*  38:    */   {
/*  39: 94 */     this.tail = tail;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void linkHeadTail()
/*  43:    */   {
/*  44: 98 */     this.head.setNext(this.tail);
/*  45: 99 */     this.tail.setPrev(this.head);
/*  46:100 */     this.head.setPrev(null);
/*  47:101 */     this.tail.setNext(null);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public boolean insertDepotLast(Depot depot)
/*  51:    */   {
/*  52:113 */     if (this.head.getNext() == this.tail)
/*  53:    */     {
/*  54:114 */       this.head.setNext(depot);
/*  55:115 */       this.tail.setPrev(depot);
/*  56:116 */       depot.setPrev(this.head);
/*  57:117 */       depot.setNext(this.tail);
/*  58:    */     }
/*  59:    */     else
/*  60:    */     {
/*  61:122 */       depot.setNext(this.tail);
/*  62:123 */       depot.setPrev(this.tail.getPrev());
/*  63:124 */       this.tail.getPrev().setNext(depot);
/*  64:125 */       this.tail.setPrev(depot);
/*  65:    */     }
/*  66:128 */     return true;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Attributes getAttributes()
/*  70:    */   {
/*  71:132 */     return this.attributes;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setAttributes(Attributes attributes)
/*  75:    */   {
/*  76:138 */     this.attributes = attributes;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void removeEmptyTrucks()
/*  80:    */   {
/*  81:247 */     Depot depot = getHead().getNext();
/*  82:248 */     while (depot != this.tail)
/*  83:    */     {
/*  84:249 */       depot.getMainTrucks().removeEmptyTrucks();
/*  85:250 */       depot = depot.getNext();
/*  86:    */     }
/*  87:    */   }
/*  88:    */   
/*  89:    */   protected Depot find(int key)
/*  90:    */   {
/*  91:262 */     Depot current = this.head.getNext();
/*  92:264 */     while ((current.getDepotNum() != key) && (current != this.tail))
/*  93:    */     {
/*  94:265 */       if (current.getNext() == null) {
/*  95:266 */         return null;
/*  96:    */       }
/*  97:269 */       current = current.getNext();
/*  98:    */     }
/*  99:273 */     if (current == this.tail) {
/* 100:275 */       current = null;
/* 101:    */     }
/* 102:278 */     return current;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public int getTotalNumTrucksUsed()
/* 106:    */   {
/* 107:286 */     Depot currentDepot = this.head.getNext();
/* 108:    */     
/* 109:288 */     int numBusesUsed = 0;
/* 110:291 */     while (currentDepot != this.tail)
/* 111:    */     {
/* 112:292 */       Truck currentTruck = currentDepot.getMainTrucks().getHead();
/* 113:293 */       Truck currentTruckTail = currentDepot.getMainTrucks().getTail();
/* 114:296 */       while (currentTruck != currentTruckTail)
/* 115:    */       {
/* 116:298 */         if (!currentTruck.isEmptyMainNodes()) {
/* 117:299 */           numBusesUsed++;
/* 118:    */         }
/* 119:302 */         currentTruck = currentTruck.getNext();
/* 120:    */       }
/* 121:305 */       currentDepot = currentDepot.getNext();
/* 122:    */     }
/* 123:308 */     return numBusesUsed;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public int getNumTrucksUsed()
/* 127:    */   {
/* 128:359 */     int numT = 0;
/* 129:    */     
/* 130:361 */     Depot depot = this.head.getNext();
/* 131:363 */     while (depot != this.tail)
/* 132:    */     {
/* 133:364 */       Truck truck = depot.getMainTrucks().getHead().getNext();
/* 134:365 */       Truck truckTail = depot.getMainTrucks().getTail();
/* 135:367 */       while (truck != truckTail)
/* 136:    */       {
/* 137:368 */         numT++;
/* 138:369 */         truck = truck.getNext();
/* 139:    */       }
/* 140:372 */       depot = depot.getNext();
/* 141:    */     }
/* 142:375 */     return numT;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String getSolutionString()
/* 146:    */   {
/* 147:384 */     return 
/* 148:385 */       "Trucks Used = " + getTotalNumTrucksUsed() + " | " + this.attributes.toDetailedString();
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void printDepotLinkedList(PrintStream out)
/* 152:    */   {
/* 153:396 */     out.println(ProblemInfo.numDepots);
/* 154:    */     
/* 155:398 */     Depot depot = getHead().getNext();
/* 156:    */     try
/* 157:    */     {
/* 158:401 */       while (depot != getTail())
/* 159:    */       {
/* 160:402 */         out.println(depot.getDepotNum() + " " + depot.getXCoord() + " " + 
/* 161:403 */           depot.getYCoord() + " " + depot.getAttributes().getTotalDemand() + 
/* 162:404 */           " " + 
/* 163:405 */           depot.getAttributes().getTotalDistance() + " " + 
/* 164:406 */           depot.getMainTrucks().getSize());
/* 165:    */         
/* 166:408 */         Truck truck = depot.getMainTrucks().getHead().getNext();
/* 167:409 */         Truck truckTail = depot.getMainTrucks().getTail();
/* 168:411 */         while (truck != truckTail)
/* 169:    */         {
/* 170:412 */           out.println(truck.getTruckNum() + " " + 
/* 171:413 */             truck.getTruckType().getServiceType() + " " + 
/* 172:414 */             truck.getAttributes().getTotalDemand() + " " + 
/* 173:415 */             truck.getAttributes().getTotalDistance() + " " + 
/* 174:416 */             truck.getTruckType().getMaxCapacity() + " " + 
/* 175:417 */             truck.getTruckType().getMaxDuration() + " " + 
/* 176:418 */             truck.getMainNodes().getSize());
/* 177:    */           
/* 178:420 */           Nodes cell = truck.getMainNodes().getHead().getNext();
/* 179:421 */           Nodes cellTail = truck.getMainNodes().getTail();
/* 180:423 */           while (cell != cellTail)
/* 181:    */           {
/* 182:424 */             out.println(cell.getIndex() + " " + cell.getDemand() + " " + 
/* 183:425 */               cell.getShipment().getXCoord() + " " + 
/* 184:426 */               cell.getShipment().getYCoord() + " " + 
/* 185:427 */               cell.getShipment().getTruckTypeNeeded());
/* 186:428 */             cell = cell.getNext();
/* 187:    */           }
/* 188:431 */           truck = truck.getNext();
/* 189:    */         }
/* 190:434 */         depot = depot.getNext();
/* 191:    */       }
/* 192:    */     }
/* 193:    */     catch (Exception e)
/* 194:    */     {
/* 195:438 */       System.out.println("Error in printDepotLinkedList" + e);
/* 196:439 */       e.printStackTrace();
/* 197:    */     }
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void writeDepotLinkedListXML(String xmlFileName)
/* 201:    */   {
/* 202:452 */     String topHeading = "MDVRP";
/* 203:453 */     Depot depot = this.head;
/* 204:    */     
/* 205:455 */     XMLFileWriter.writeToXML(xmlFileName, topHeading, depot, ProblemInfo.numDepots);
/* 206:    */   }
/* 207:    */   
/* 208:    */   public Object clone()
/* 209:    */   {
/* 210:507 */     DepotLinkedList clonedDepotLinkedList = new DepotLinkedList();
/* 211:    */     
/* 212:509 */     clonedDepotLinkedList.setAttributes((Attributes)getAttributes().clone());
/* 213:510 */     clonedDepotLinkedList.head = ((Depot)this.head.clone());
/* 214:    */     
/* 215:    */ 
/* 216:513 */     clonedDepotLinkedList.head.setPrev(null);
/* 217:515 */     if (this.head != this.tail)
/* 218:    */     {
/* 219:516 */       Depot currentDepot = clonedDepotLinkedList.head;
/* 220:517 */       Depot nextDepot = getHead().getNext();
/* 221:519 */       while (nextDepot != null)
/* 222:    */       {
/* 223:520 */         currentDepot.setNext((Depot)nextDepot.clone());
/* 224:521 */         currentDepot.getNext().setPrev(currentDepot);
/* 225:522 */         currentDepot = currentDepot.getNext();
/* 226:523 */         nextDepot = nextDepot.getNext();
/* 227:526 */         if (nextDepot == null)
/* 228:    */         {
/* 229:527 */           clonedDepotLinkedList.tail = currentDepot;
/* 230:528 */           currentDepot.setNext(null);
/* 231:    */         }
/* 232:    */       }
/* 233:    */     }
/* 234:    */     else
/* 235:    */     {
/* 236:534 */       clonedDepotLinkedList.tail = clonedDepotLinkedList.head;
/* 237:    */     }
/* 238:537 */     return clonedDepotLinkedList;
/* 239:    */   }
/* 240:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.DepotLinkedList
 * JD-Core Version:    0.7.0.1
 */