/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public class NodesLinkedList
/*   7:    */   implements Serializable, Cloneable
/*   8:    */ {
/*   9:    */   private Nodes head;
/*  10:    */   private Nodes tail;
/*  11:    */   private int truckNum;
/*  12:    */   private TruckType truckType;
/*  13: 24 */   private boolean collapsed = false;
/*  14:    */   private Attributes attributes;
/*  15:    */   private Feasibility feasibility;
/*  16:    */   
/*  17:    */   public Feasibility getFeasibility()
/*  18:    */   {
/*  19: 64 */     return this.feasibility;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public Nodes getHead()
/*  23:    */   {
/*  24: 72 */     return this.head;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public Nodes getTail()
/*  28:    */   {
/*  29: 81 */     return this.tail;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public double getCost()
/*  33:    */   {
/*  34: 90 */     return this.attributes.getTotalCost();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setHead(Nodes headVal)
/*  38:    */   {
/*  39: 98 */     this.head = headVal;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setHeadNext(Nodes headVal)
/*  43:    */   {
/*  44:106 */     this.head.next = headVal;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setTail(Nodes tailVal)
/*  48:    */   {
/*  49:114 */     this.tail = tailVal;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void linkHeadTail()
/*  53:    */   {
/*  54:118 */     this.head.setNext(this.tail);
/*  55:119 */     this.tail.setPrev(this.head);
/*  56:120 */     this.head.setPrev(null);
/*  57:121 */     this.tail.setNext(null);
/*  58:    */   }
/*  59:    */   
/*  60:    */   public Attributes getAttributes()
/*  61:    */   {
/*  62:125 */     return this.attributes;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setAttributes(Attributes attributes)
/*  66:    */   {
/*  67:129 */     this.attributes = attributes;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public TruckType getTruckType()
/*  71:    */   {
/*  72:137 */     return this.truckType;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public int getSize()
/*  76:    */   {
/*  77:153 */     int size = 0;
/*  78:154 */     Nodes cell = getHead().getNext();
/*  79:156 */     while (cell != getTail())
/*  80:    */     {
/*  81:157 */       size++;
/*  82:158 */       cell = cell.getNext();
/*  83:    */     }
/*  84:161 */     return size;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void emptyList()
/*  88:    */   {
/*  89:168 */     this.head.setNext(this.tail);
/*  90:169 */     this.tail.setPrev(this.head);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public int getCollapsedSize()
/*  94:    */   {
/*  95:178 */     Nodes tempCell = this.head.getNext();
/*  96:179 */     int count = 0;
/*  97:181 */     while (tempCell != this.tail)
/*  98:    */     {
/*  99:182 */       if ((tempCell != this.head) && (tempCell != this.tail)) {
/* 100:183 */         count += tempCell.getDemand();
/* 101:    */       } else {
/* 102:186 */         count++;
/* 103:    */       }
/* 104:189 */       tempCell = tempCell.getNext();
/* 105:    */     }
/* 106:192 */     return count;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Nodes insertNodes(Nodes insertNode)
/* 110:    */   {
/* 111:205 */     System.out.println("ERROR: InsertNodes was called in from NodesLinkedList");
/* 112:206 */     return null;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Nodes insertAfterNodes(Nodes toInsert, Nodes afterThis)
/* 116:    */   {
/* 117:218 */     Nodes currentNode = this.head;
/* 118:220 */     while (currentNode != this.tail)
/* 119:    */     {
/* 120:221 */       if (currentNode == afterThis)
/* 121:    */       {
/* 122:222 */         toInsert.setPrev(currentNode);
/* 123:223 */         toInsert.setNext(currentNode.getNext());
/* 124:224 */         currentNode.setNext(toInsert);
/* 125:225 */         toInsert.getNext().setPrev(toInsert);
/* 126:226 */         break;
/* 127:    */       }
/* 128:228 */       currentNode = currentNode.getNext();
/* 129:    */     }
/* 130:230 */     return currentNode;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public boolean insertLastNode(Nodes node)
/* 134:    */   {
/* 135:236 */     if (this.head.getNext() == this.tail)
/* 136:    */     {
/* 137:237 */       this.head.setNext(node);
/* 138:238 */       this.tail.setPrev(node);
/* 139:239 */       node.setPrev(this.head);
/* 140:240 */       node.setNext(this.tail);
/* 141:    */     }
/* 142:    */     else
/* 143:    */     {
/* 144:245 */       node.setNext(this.tail);
/* 145:246 */       node.setPrev(this.tail.getPrev());
/* 146:247 */       this.tail.getPrev().setNext(node);
/* 147:248 */       this.tail.setPrev(node);
/* 148:    */     }
/* 149:251 */     return true;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public Nodes removeNodes(Nodes removeNode)
/* 153:    */   {
/* 154:262 */     Nodes currentNode = this.head.getNext();
/* 155:263 */     Nodes nodeBeforeRemoveNode = null;
/* 156:265 */     while (currentNode != this.tail)
/* 157:    */     {
/* 158:266 */       if (currentNode.getIndex() == removeNode.getIndex())
/* 159:    */       {
/* 160:267 */         nodeBeforeRemoveNode = currentNode.getPrev();
/* 161:268 */         currentNode.getPrev().setNext(currentNode.getNext());
/* 162:269 */         currentNode.getNext().setPrev(currentNode.getPrev());
/* 163:270 */         currentNode.setNext(null);
/* 164:271 */         currentNode.setPrev(null);
/* 165:    */         
/* 166:273 */         break;
/* 167:    */       }
/* 168:275 */       currentNode = currentNode.getNext();
/* 169:    */     }
/* 170:277 */     return nodeBeforeRemoveNode;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public Nodes removeNodeByIndex(int index)
/* 174:    */   {
/* 175:286 */     Nodes currentNode = this.head.getNext();
/* 176:287 */     Nodes nodeBeforeRemoveNode = null;
/* 177:289 */     while (currentNode != this.tail)
/* 178:    */     {
/* 179:290 */       if (currentNode.getIndex() == index)
/* 180:    */       {
/* 181:291 */         nodeBeforeRemoveNode = currentNode.getPrev();
/* 182:292 */         currentNode.getPrev().setNext(currentNode.getNext());
/* 183:293 */         currentNode.getNext().setPrev(currentNode.getPrev());
/* 184:294 */         currentNode.setNext(null);
/* 185:295 */         currentNode.setPrev(null);
/* 186:    */         
/* 187:297 */         break;
/* 188:    */       }
/* 189:299 */       currentNode = currentNode.getNext();
/* 190:    */     }
/* 191:303 */     return currentNode;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public Nodes removeFromOtherRoute(Nodes removeNode)
/* 195:    */   {
/* 196:313 */     if ((removeNode.getPrev() != null) && (removeNode.getNext() != null))
/* 197:    */     {
/* 198:314 */       removeNode.getPrev().setNext(removeNode.getNext());
/* 199:315 */       removeNode.getNext().setPrev(removeNode.getPrev());
/* 200:    */       
/* 201:317 */       return removeNode.getPrev();
/* 202:    */     }
/* 203:320 */     return null;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public Nodes getNodesAtPosition(int pos)
/* 207:    */   {
/* 208:330 */     Nodes current = this.head;
/* 209:331 */     int currentPos = 0;
/* 210:333 */     while ((current != null) && (currentPos < pos))
/* 211:    */     {
/* 212:334 */       current = current.getNext();
/* 213:335 */       currentPos++;
/* 214:    */     }
/* 215:338 */     return current;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public Nodes getNodeByIndex(int index)
/* 219:    */   {
/* 220:347 */     Nodes currentNode = this.head.getNext();
/* 221:349 */     while (currentNode != this.tail)
/* 222:    */     {
/* 223:350 */       if (currentNode.getIndex() == index) {
/* 224:351 */         return currentNode;
/* 225:    */       }
/* 226:353 */       currentNode = currentNode.getNext();
/* 227:    */     }
/* 228:356 */     return null;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public int getTruckNum()
/* 232:    */   {
/* 233:364 */     return this.truckNum;
/* 234:    */   }
/* 235:    */   
/* 236:    */   public String getRouteString()
/* 237:    */   {
/* 238:373 */     StringBuffer buf = new StringBuffer();
/* 239:    */     
/* 240:375 */     Nodes node = getHead();
/* 241:376 */     while (node != null)
/* 242:    */     {
/* 243:377 */       buf.append(node.getIndex()).append(" ");
/* 244:378 */       node = node.getNext();
/* 245:    */     }
/* 246:381 */     return buf.toString();
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setFeasibility(Feasibility feasibilityVal)
/* 250:    */   {
/* 251:398 */     this.feasibility = feasibilityVal;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public void setTruckType(TruckType truckTypeVal)
/* 255:    */   {
/* 256:406 */     this.truckType = truckTypeVal;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public void setTruckNum(int truckNumVal)
/* 260:    */   {
/* 261:414 */     this.truckNum = truckNumVal;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public void collapseRoute()
/* 265:    */   {
/* 266:445 */     Nodes tempCell = this.head.getNext();
/* 267:446 */     Nodes firstCellInPUP = null;
/* 268:447 */     Nodes lastCellInPUP = null;
/* 269:448 */     int tempDemand = 1;
/* 270:449 */     String pupName = null;
/* 271:    */     try
/* 272:    */     {
/* 273:452 */       while (tempCell != this.tail) {
/* 274:454 */         if (!tempCell.getPickupPointName().equals(pupName))
/* 275:    */         {
/* 276:456 */           firstCellInPUP = tempCell;
/* 277:457 */           pupName = tempCell.getPickupPointName();
/* 278:459 */           while ((tempCell.getNext() != this.tail) && 
/* 279:460 */             (tempCell.getNext().getPickupPointName().equals(pupName)))
/* 280:    */           {
/* 281:461 */             tempDemand += tempCell.theShipment.getDemand();
/* 282:462 */             tempCell = tempCell.getNext();
/* 283:    */           }
/* 284:465 */           lastCellInPUP = tempCell;
/* 285:466 */           tempCell = tempCell.getNext();
/* 286:    */           
/* 287:468 */           firstCellInPUP.theShipment.setTempNext(firstCellInPUP.getNext());
/* 288:469 */           firstCellInPUP.theShipment.setTempDemand(firstCellInPUP.theShipment.getDemand());
/* 289:    */           
/* 290:471 */           firstCellInPUP.theShipment.setDemand(tempDemand);
/* 291:472 */           firstCellInPUP.setNext(tempCell);
/* 292:473 */           tempCell.setPrev(firstCellInPUP);
/* 293:475 */           if (firstCellInPUP != lastCellInPUP) {
/* 294:476 */             lastCellInPUP.setNext(null);
/* 295:    */           } else {
/* 296:479 */             firstCellInPUP.theShipment.setTempNext(null);
/* 297:    */           }
/* 298:482 */           tempDemand = 1;
/* 299:    */         }
/* 300:    */         else
/* 301:    */         {
/* 302:485 */           tempCell = tempCell.getNext();
/* 303:    */         }
/* 304:    */       }
/* 305:    */     }
/* 306:    */     catch (Exception e)
/* 307:    */     {
/* 308:490 */       System.out.println("Exception caught in collapseRoute() " + e);
/* 309:    */     }
/* 310:493 */     this.collapsed = true;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public void expandRoute()
/* 314:    */   {
/* 315:504 */     Nodes tempCell = this.head.getNext();
/* 316:505 */     Nodes endOfHidden = null;
/* 317:506 */     Nodes startOfHidden = null;
/* 318:    */     try
/* 319:    */     {
/* 320:509 */       while (tempCell != this.tail) {
/* 321:510 */         if (tempCell.theShipment.getTempNext() != null)
/* 322:    */         {
/* 323:511 */           startOfHidden = tempCell.theShipment.getTempNext();
/* 324:514 */           while (startOfHidden.getNext() != null) {
/* 325:515 */             startOfHidden = startOfHidden.getNext();
/* 326:    */           }
/* 327:518 */           endOfHidden = startOfHidden;
/* 328:519 */           startOfHidden = tempCell.theShipment.getTempNext();
/* 329:    */           
/* 330:    */ 
/* 331:522 */           endOfHidden.setNext(tempCell.getNext());
/* 332:523 */           tempCell.getNext().setPrev(endOfHidden);
/* 333:524 */           tempCell.setNext(tempCell.theShipment.getTempNext());
/* 334:525 */           tempCell.theShipment.setTempNext(null);
/* 335:526 */           tempCell.theShipment.setDemand(tempCell.theShipment.getTempDemand());
/* 336:527 */           tempCell.theShipment.setTempDemand(-1);
/* 337:    */           
/* 338:    */ 
/* 339:530 */           tempCell = endOfHidden.getNext();
/* 340:    */         }
/* 341:    */         else
/* 342:    */         {
/* 343:533 */           tempCell = tempCell.getNext();
/* 344:    */         }
/* 345:    */       }
/* 346:    */     }
/* 347:    */     catch (Exception e)
/* 348:    */     {
/* 349:538 */       System.out.println("Exception caught in expandRoute() " + e);
/* 350:    */     }
/* 351:    */   }
/* 352:    */   
/* 353:    */   public Object clone()
/* 354:    */   {
/* 355:548 */     NodesLinkedList clonedNodesLinkedList = new NodesLinkedList();
/* 356:    */     
/* 357:550 */     clonedNodesLinkedList.attributes = ((Attributes)this.attributes.clone());
/* 358:    */     
/* 359:552 */     clonedNodesLinkedList.setFeasibility((Feasibility)this.feasibility.clone());
/* 360:553 */     clonedNodesLinkedList.setTruckType((TruckType)this.truckType.clone());
/* 361:554 */     clonedNodesLinkedList.setTruckNum(this.truckNum);
/* 362:555 */     clonedNodesLinkedList.setHead((Nodes)this.head.clone());
/* 363:    */     
/* 364:557 */     expandRoute();
/* 365:559 */     if (this.head != this.tail)
/* 366:    */     {
/* 367:560 */       Nodes currentNodes = clonedNodesLinkedList.getHead();
/* 368:561 */       Nodes nextNodes = getHead().getNext();
/* 369:563 */       while (nextNodes != null)
/* 370:    */       {
/* 371:564 */         currentNodes.setNext((Nodes)nextNodes.clone());
/* 372:565 */         currentNodes.getNext().setPrev(currentNodes);
/* 373:566 */         currentNodes = currentNodes.getNext();
/* 374:567 */         nextNodes = nextNodes.getNext();
/* 375:570 */         if (nextNodes == null)
/* 376:    */         {
/* 377:571 */           clonedNodesLinkedList.setTail(currentNodes);
/* 378:572 */           currentNodes.setNext(null);
/* 379:    */         }
/* 380:    */       }
/* 381:    */     }
/* 382:579 */     clonedNodesLinkedList.getFeasibility().setRoute(clonedNodesLinkedList);
/* 383:    */     
/* 384:581 */     return clonedNodesLinkedList;
/* 385:    */   }
/* 386:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.NodesLinkedList
 * JD-Core Version:    0.7.0.1
 */