/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Shipment
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   private Shipment prev;
/*   9:    */   private Shipment next;
/*  10:    */   protected ShipmentPartialLinkedList shipParLL;
/*  11:    */   private int index;
/*  12:    */   private float demand;
/*  13:    */   private double xCoord;
/*  14:    */   private double yCoord;
/*  15:    */   private String customerType;
/*  16:    */   private boolean isPickup;
/*  17:    */   private boolean isDropOff;
/*  18:    */   private String dropType;
/*  19:    */   private String pickupType;
/*  20:    */   private float pickupWeight;
/*  21:    */   private float pickupVolume;
/*  22:    */   private float pickupDim;
/*  23:    */   private float dropOffWeight;
/*  24:    */   private float dropOffVolume;
/*  25:    */   private float dropOffDim;
/*  26:    */   private float travelTime;
/*  27:    */   private boolean locked;
/*  28:    */   private boolean isAssigned;
/*  29:    */   private boolean isSelected;
/*  30:    */   private String truckTypeNeeded;
/*  31:    */   private String pickUpPointName;
/*  32:    */   private int frequency;
/*  33:    */   private int noComb;
/*  34:    */   private int[] visitComb;
/*  35:    */   private int[][] currentComb;
/*  36:    */   private Nodes tempNext;
/*  37:    */   private int tempDemand;
/*  38:    */   protected float serviceTime;
/*  39:    */   protected String pickupPointName;
/*  40:    */   protected double polarAngle;
/*  41:    */   protected double polarDistance;
/*  42:    */   protected int custId;
/*  43:    */   protected String roadNo;
/*  44:    */   protected String roadName;
/*  45:    */   protected double fromLong;
/*  46:    */   protected double fromLat;
/*  47:    */   protected double toLong;
/*  48:    */   protected double toLat;
/*  49:    */   protected String fromNodes;
/*  50:    */   protected String toNodes;
/*  51:    */   
/*  52:    */   public Shipment()
/*  53:    */   {
/*  54: 72 */     this.index = -1;
/*  55: 73 */     this.prev = null;
/*  56: 74 */     this.next = null;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public ShipmentPartialLinkedList getShipParLL()
/*  60:    */   {
/*  61: 79 */     return this.shipParLL;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setShipParLL(ShipmentPartialLinkedList shipParLL)
/*  65:    */   {
/*  66: 83 */     this.shipParLL = shipParLL;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public double getxCoord()
/*  70:    */   {
/*  71: 87 */     return this.xCoord;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public int getFrequency()
/*  75:    */   {
/*  76: 91 */     return this.frequency;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setFrequency(int frequency)
/*  80:    */   {
/*  81: 96 */     this.frequency = frequency;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public int getNoComb()
/*  85:    */   {
/*  86:101 */     return this.noComb;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setNoComb(int noComb)
/*  90:    */   {
/*  91:106 */     this.noComb = noComb;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public int[] getVisitComb()
/*  95:    */   {
/*  96:111 */     return this.visitComb;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setVisitComb(int[] visitComb)
/* 100:    */   {
/* 101:116 */     this.visitComb = visitComb;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public int[][] getCurrentComb()
/* 105:    */   {
/* 106:121 */     return this.currentComb;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setCurrentComb(int[][] currentComb)
/* 110:    */   {
/* 111:126 */     this.currentComb = currentComb;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setPickup(boolean isPickup)
/* 115:    */   {
/* 116:131 */     this.isPickup = isPickup;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setDropOff(boolean isDropOff)
/* 120:    */   {
/* 121:136 */     this.isDropOff = isDropOff;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setSelected(boolean isSelected)
/* 125:    */   {
/* 126:141 */     this.isSelected = isSelected;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setxCoord(double xCoord)
/* 130:    */   {
/* 131:146 */     this.xCoord = xCoord;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public double getyCoord()
/* 135:    */   {
/* 136:150 */     return this.yCoord;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setyCoord(double yCoord)
/* 140:    */   {
/* 141:154 */     this.yCoord = yCoord;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public String getCustomerType()
/* 145:    */   {
/* 146:158 */     return this.customerType;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setCustomerType(String customerType)
/* 150:    */   {
/* 151:162 */     this.customerType = customerType;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public boolean getIsPickup()
/* 155:    */   {
/* 156:166 */     return this.isPickup;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setIsPickup(boolean isPickup)
/* 160:    */   {
/* 161:170 */     this.isPickup = isPickup;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public boolean getIsDropOff()
/* 165:    */   {
/* 166:174 */     return this.isDropOff;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setIsDropOff(boolean isDropOff)
/* 170:    */   {
/* 171:178 */     this.isDropOff = isDropOff;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getDropType()
/* 175:    */   {
/* 176:182 */     return this.dropType;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setDropType(String dropType)
/* 180:    */   {
/* 181:186 */     this.dropType = dropType;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String getPickupType()
/* 185:    */   {
/* 186:190 */     return this.pickupType;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setPickupType(String pickupType)
/* 190:    */   {
/* 191:194 */     this.pickupType = pickupType;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public float getPickupWeight()
/* 195:    */   {
/* 196:198 */     return this.pickupWeight;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public String getPickUpPointName()
/* 200:    */   {
/* 201:202 */     return this.pickUpPointName;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setPickUpPointName(String pickUpPointName)
/* 205:    */   {
/* 206:207 */     this.pickUpPointName = pickUpPointName;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setPickupWeight(float pickupWeight)
/* 210:    */   {
/* 211:212 */     this.pickupWeight = pickupWeight;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public float getPickupVolume()
/* 215:    */   {
/* 216:216 */     return this.pickupVolume;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setPickupVolume(float pickupVolume)
/* 220:    */   {
/* 221:220 */     this.pickupVolume = pickupVolume;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public float getPickupDim()
/* 225:    */   {
/* 226:224 */     return this.pickupDim;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setPickupDim(float pickupDim)
/* 230:    */   {
/* 231:228 */     this.pickupDim = pickupDim;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public float getDropOffWeight()
/* 235:    */   {
/* 236:232 */     return this.dropOffWeight;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public void setDropOffWeight(float dropOffWeight)
/* 240:    */   {
/* 241:236 */     this.dropOffWeight = dropOffWeight;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public float getDropOffVolume()
/* 245:    */   {
/* 246:240 */     return this.dropOffVolume;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setDropOffVolume(float dropOffVolume)
/* 250:    */   {
/* 251:244 */     this.dropOffVolume = dropOffVolume;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public float getDropOffDim()
/* 255:    */   {
/* 256:248 */     return this.dropOffDim;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public void setDropOffDim(float dropOffDim)
/* 260:    */   {
/* 261:252 */     this.dropOffDim = dropOffDim;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public boolean isLocked()
/* 265:    */   {
/* 266:256 */     return this.locked;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void setLocked(boolean locked)
/* 270:    */   {
/* 271:260 */     this.locked = locked;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public float getTravelTime()
/* 275:    */   {
/* 276:267 */     return this.travelTime;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public String getTravelTimeStr()
/* 280:    */   {
/* 281:275 */     double minutes = this.travelTime * 60.0F;
/* 282:276 */     int hours = (int)Math.round(minutes) / 60;
/* 283:277 */     int minInt = (int)minutes - hours * 60;
/* 284:278 */     String time = String.valueOf(hours) + ":" + String.valueOf(minInt);
/* 285:279 */     return time;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public float getServiceTime()
/* 289:    */   {
/* 290:285 */     return this.serviceTime;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public void setServiceTime(float serviceTime)
/* 294:    */   {
/* 295:289 */     this.serviceTime = serviceTime;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public double getPolarAngle()
/* 299:    */   {
/* 300:293 */     return this.polarAngle;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public void setPolarAngle(double polarAngle)
/* 304:    */   {
/* 305:297 */     this.polarAngle = polarAngle;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public double getPolarDistance()
/* 309:    */   {
/* 310:301 */     return this.polarDistance;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public void setPolarDistance(double polarDistance)
/* 314:    */   {
/* 315:305 */     this.polarDistance = polarDistance;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public double getFromLong()
/* 319:    */   {
/* 320:309 */     return this.fromLong;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public void setFromLong(double fromLong)
/* 324:    */   {
/* 325:313 */     this.fromLong = fromLong;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public double getFromLat()
/* 329:    */   {
/* 330:317 */     return this.fromLat;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public void setFromLat(double fromLat)
/* 334:    */   {
/* 335:321 */     this.fromLat = fromLat;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public double getToLong()
/* 339:    */   {
/* 340:325 */     return this.toLong;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public void setToLong(double toLong)
/* 344:    */   {
/* 345:329 */     this.toLong = toLong;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public double getToLat()
/* 349:    */   {
/* 350:333 */     return this.toLat;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public void setToLat(double toLat)
/* 354:    */   {
/* 355:337 */     this.toLat = toLat;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public boolean isSelected()
/* 359:    */   {
/* 360:341 */     return this.isSelected;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public void setIndex(int index)
/* 364:    */   {
/* 365:345 */     this.index = index;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setCustId(int custId)
/* 369:    */   {
/* 370:350 */     this.custId = custId;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public void setRoadNo(String roadNo)
/* 374:    */   {
/* 375:354 */     this.roadNo = roadNo;
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void setRoadName(String roadName)
/* 379:    */   {
/* 380:358 */     this.roadName = roadName;
/* 381:    */   }
/* 382:    */   
/* 383:    */   public void setFromNodes(String fromNodes)
/* 384:    */   {
/* 385:362 */     this.fromNodes = fromNodes;
/* 386:    */   }
/* 387:    */   
/* 388:    */   public void setToNodes(String toNodes)
/* 389:    */   {
/* 390:366 */     this.toNodes = toNodes;
/* 391:    */   }
/* 392:    */   
/* 393:    */   public boolean getIsAssigned()
/* 394:    */   {
/* 395:463 */     return this.isAssigned;
/* 396:    */   }
/* 397:    */   
/* 398:    */   public boolean getIsSelected()
/* 399:    */   {
/* 400:471 */     return this.isSelected;
/* 401:    */   }
/* 402:    */   
/* 403:    */   public void setIsSelected(boolean is)
/* 404:    */   {
/* 405:479 */     this.isSelected = is;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public void setIsAssigned(boolean is)
/* 409:    */   {
/* 410:487 */     this.isAssigned = is;
/* 411:    */   }
/* 412:    */   
/* 413:    */   public Shipment getPrev()
/* 414:    */   {
/* 415:495 */     return this.prev;
/* 416:    */   }
/* 417:    */   
/* 418:    */   public Shipment getNext()
/* 419:    */   {
/* 420:503 */     return this.next;
/* 421:    */   }
/* 422:    */   
/* 423:    */   public void setPrev(Shipment s)
/* 424:    */   {
/* 425:511 */     this.prev = s;
/* 426:    */   }
/* 427:    */   
/* 428:    */   public void setNext(Shipment s)
/* 429:    */   {
/* 430:519 */     this.next = s;
/* 431:    */   }
/* 432:    */   
/* 433:    */   public int getIndex()
/* 434:    */   {
/* 435:527 */     return this.index;
/* 436:    */   }
/* 437:    */   
/* 438:    */   public double getXCoord()
/* 439:    */   {
/* 440:535 */     return this.xCoord;
/* 441:    */   }
/* 442:    */   
/* 443:    */   public double getYCoord()
/* 444:    */   {
/* 445:543 */     return this.yCoord;
/* 446:    */   }
/* 447:    */   
/* 448:    */   public int getDemand()
/* 449:    */   {
/* 450:551 */     return (int)this.demand;
/* 451:    */   }
/* 452:    */   
/* 453:    */   public void setDemand(int d)
/* 454:    */   {
/* 455:559 */     this.demand = d;
/* 456:    */   }
/* 457:    */   
/* 458:    */   public int getTempDemand()
/* 459:    */   {
/* 460:563 */     return this.tempDemand;
/* 461:    */   }
/* 462:    */   
/* 463:    */   public void setTempDemand(int tempDemand)
/* 464:    */   {
/* 465:568 */     this.tempDemand = tempDemand;
/* 466:    */   }
/* 467:    */   
/* 468:    */   public Nodes getTempNext()
/* 469:    */   {
/* 470:573 */     return this.tempNext;
/* 471:    */   }
/* 472:    */   
/* 473:    */   public void setTempNext(Nodes tempNext)
/* 474:    */   {
/* 475:578 */     this.tempNext = tempNext;
/* 476:    */   }
/* 477:    */   
/* 478:    */   public String getTruckTypeNeeded()
/* 479:    */   {
/* 480:587 */     return this.truckTypeNeeded;
/* 481:    */   }
/* 482:    */   
/* 483:    */   public String getPickupPointName()
/* 484:    */   {
/* 485:596 */     return this.pickupPointName;
/* 486:    */   }
/* 487:    */   
/* 488:    */   public void setPickupPointName(String pickupPointName)
/* 489:    */   {
/* 490:601 */     this.pickupPointName = pickupPointName;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public int getCustId()
/* 494:    */   {
/* 495:606 */     return this.custId;
/* 496:    */   }
/* 497:    */   
/* 498:    */   public String getRoadNo()
/* 499:    */   {
/* 500:611 */     return this.roadNo;
/* 501:    */   }
/* 502:    */   
/* 503:    */   public String getRoadName()
/* 504:    */   {
/* 505:616 */     return this.roadName;
/* 506:    */   }
/* 507:    */   
/* 508:    */   public String getFromNodes()
/* 509:    */   {
/* 510:621 */     return this.fromNodes;
/* 511:    */   }
/* 512:    */   
/* 513:    */   public String getToNodes()
/* 514:    */   {
/* 515:626 */     return this.toNodes;
/* 516:    */   }
/* 517:    */   
/* 518:    */   public void setDemand(float demand)
/* 519:    */   {
/* 520:631 */     this.demand = demand;
/* 521:    */   }
/* 522:    */   
/* 523:    */   public void setTravelTime(float travelTime)
/* 524:    */   {
/* 525:636 */     this.travelTime = travelTime;
/* 526:    */   }
/* 527:    */   
/* 528:    */   public void setAssigned(boolean isAssigned)
/* 529:    */   {
/* 530:641 */     this.isAssigned = isAssigned;
/* 531:    */   }
/* 532:    */   
/* 533:    */   public void setTruckTypeNeeded(String truckTypeNeeded)
/* 534:    */   {
/* 535:646 */     this.truckTypeNeeded = truckTypeNeeded;
/* 536:    */   }
/* 537:    */   
/* 538:    */   public Object clone()
/* 539:    */   {
/* 540:671 */     Shipment clonedShipment = new Shipment();
/* 541:    */     
/* 542:673 */     clonedShipment.demand = this.demand;
/* 543:674 */     clonedShipment.index = this.index;
/* 544:675 */     clonedShipment.isAssigned = this.isAssigned;
/* 545:    */     
/* 546:    */ 
/* 547:678 */     clonedShipment.truckTypeNeeded = this.truckTypeNeeded;
/* 548:679 */     clonedShipment.xCoord = this.xCoord;
/* 549:680 */     clonedShipment.yCoord = this.yCoord;
/* 550:    */     
/* 551:682 */     return clonedShipment;
/* 552:    */   }
/* 553:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Shipment
 * JD-Core Version:    0.7.0.1
 */