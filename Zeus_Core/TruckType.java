/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class TruckType
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   private int truckNo;
/*   9: 15 */   private double fixedCost = 0.0D;
/*  10: 16 */   private double variableCost = 1.0D;
/*  11: 17 */   private double carrierCost = 1.0D;
/*  12:    */   private double maxDuration;
/*  13:    */   private double maxDistance;
/*  14:    */   private double maxTravelTime;
/*  15:    */   private float maxCapacity;
/*  16:    */   private float maxVolume;
/*  17:    */   private float actualCapacity;
/*  18:    */   private float minCapacity;
/*  19:    */   private String serviceType;
/*  20:    */   private String carrierName;
/*  21:    */   private String carrierId;
/*  22:    */   private String busId;
/*  23:    */   private String routeNo;
/*  24:    */   private String vinNo;
/*  25:    */   private String yearOfBus;
/*  26:    */   private String ageOfBus;
/*  27:    */   private String contractorName;
/*  28:    */   private double contractorCost;
/*  29:    */   private String earliestAvailDate;
/*  30:    */   private String earliestAvailTime;
/*  31:    */   private String latestAvailDate;
/*  32:    */   private String latestAvailTime;
/*  33:    */   private int noOfTrailers;
/*  34:    */   private String[] trailerType1;
/*  35:    */   private int trailer1Capacity;
/*  36:    */   private String trailer1Dimension;
/*  37:    */   private String[] trailerType2;
/*  38:    */   private int trailer2Capacity;
/*  39:    */   private String trailer2Dimension;
/*  40:    */   private boolean truckTracking;
/*  41:    */   private int maxStops;
/*  42:    */   
/*  43:    */   public TruckType() {}
/*  44:    */   
/*  45:    */   public TruckType(int N, int D, int Q, String s)
/*  46:    */   {
/*  47: 79 */     this.truckNo = N;
/*  48: 80 */     this.serviceType = s;
/*  49: 82 */     if (D == 0) {
/*  50: 83 */       this.maxDuration = 2147483647.0D;
/*  51:    */     } else {
/*  52: 86 */       this.maxDuration = D;
/*  53:    */     }
/*  54: 89 */     if (Q == 0) {
/*  55: 90 */       this.maxCapacity = 2.147484E+009F;
/*  56:    */     } else {
/*  57: 93 */       this.maxCapacity = Q;
/*  58:    */     }
/*  59: 96 */     this.fixedCost = this.maxCapacity;
/*  60: 97 */     this.variableCost = (this.maxCapacity / 1000.0D);
/*  61:    */   }
/*  62:    */   
/*  63:    */   public int getTruckNo()
/*  64:    */   {
/*  65:105 */     return this.truckNo;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setTruckNo(int tNo)
/*  69:    */   {
/*  70:112 */     this.truckNo = tNo;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getServiceType()
/*  74:    */   {
/*  75:120 */     return this.serviceType;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setServiceType(String mSer)
/*  79:    */   {
/*  80:127 */     this.serviceType = mSer;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public double getMaxDuration()
/*  84:    */   {
/*  85:135 */     return this.maxDuration;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setMaxDuration(double mDur)
/*  89:    */   {
/*  90:142 */     this.maxDuration = mDur;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public double getMaxTravelTime()
/*  94:    */   {
/*  95:150 */     return this.maxTravelTime;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setMaxTravelTime(double mTravTime)
/*  99:    */   {
/* 100:157 */     this.maxTravelTime = mTravTime;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public double getMaxDistance()
/* 104:    */   {
/* 105:165 */     return this.maxDistance;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setMaxDistance(double mDist)
/* 109:    */   {
/* 110:172 */     this.maxDistance = mDist;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public float getMaxCapacity()
/* 114:    */   {
/* 115:182 */     return this.maxCapacity;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setMaxCapacity(float mCost)
/* 119:    */   {
/* 120:189 */     this.maxCapacity = mCost;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public float getMaxVolume()
/* 124:    */   {
/* 125:193 */     return this.maxVolume;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setMaxVolume(float maxVolume)
/* 129:    */   {
/* 130:197 */     this.maxVolume = maxVolume;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public float getActualCapacity()
/* 134:    */   {
/* 135:206 */     return this.actualCapacity;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setActualCapacity(float mCost)
/* 139:    */   {
/* 140:214 */     this.actualCapacity = mCost;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public float getMinCapacity()
/* 144:    */   {
/* 145:223 */     return this.minCapacity;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setMinCapacity(float mCost)
/* 149:    */   {
/* 150:230 */     this.minCapacity = mCost;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public double getFixedCost()
/* 154:    */   {
/* 155:238 */     return this.fixedCost;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setFixedCost(double fixCost)
/* 159:    */   {
/* 160:245 */     this.fixedCost = fixCost;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public double getContractorCost()
/* 164:    */   {
/* 165:253 */     return this.carrierCost;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setContractorCost(double contCost)
/* 169:    */   {
/* 170:260 */     this.carrierCost = contCost;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public double getVariableCost()
/* 174:    */   {
/* 175:268 */     return this.variableCost;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setContractorName(String contName)
/* 179:    */   {
/* 180:275 */     this.carrierName = contName;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getContractorName()
/* 184:    */   {
/* 185:283 */     return this.carrierName;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setBusId(String bId)
/* 189:    */   {
/* 190:290 */     this.busId = bId;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String getBusId()
/* 194:    */   {
/* 195:298 */     return this.busId;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public String getRouteNo()
/* 199:    */   {
/* 200:306 */     return this.routeNo;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public String getVinNo()
/* 204:    */   {
/* 205:314 */     return this.vinNo;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String getYearOfBus()
/* 209:    */   {
/* 210:322 */     return this.yearOfBus;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public String getAgeOfBus()
/* 214:    */   {
/* 215:330 */     return this.ageOfBus;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setVariableCost(double varCost)
/* 219:    */   {
/* 220:339 */     this.variableCost = varCost;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public double getCarrierCost()
/* 224:    */   {
/* 225:343 */     return this.carrierCost;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setCarrierCost(double carrierCost)
/* 229:    */   {
/* 230:347 */     this.carrierCost = carrierCost;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public String getCarrierName()
/* 234:    */   {
/* 235:351 */     return this.carrierName;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setCarrierName(String carrierName)
/* 239:    */   {
/* 240:355 */     this.carrierName = carrierName;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String getCarrierId()
/* 244:    */   {
/* 245:359 */     return this.carrierId;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setCarrierId(String carrierId)
/* 249:    */   {
/* 250:363 */     this.carrierId = carrierId;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getEarliestAvailDate()
/* 254:    */   {
/* 255:367 */     return this.earliestAvailDate;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setEarliestAvailDate(String earliestAvailDate)
/* 259:    */   {
/* 260:371 */     this.earliestAvailDate = earliestAvailDate;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getEarliestAvailTime()
/* 264:    */   {
/* 265:375 */     return this.earliestAvailTime;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setEarliestAvailTime(String earliestAvailTime)
/* 269:    */   {
/* 270:379 */     this.earliestAvailTime = earliestAvailTime;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public String getLatestAvailDate()
/* 274:    */   {
/* 275:383 */     return this.latestAvailDate;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setLatestAvailDate(String latestAvailDate)
/* 279:    */   {
/* 280:387 */     this.latestAvailDate = latestAvailDate;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public String getLatestAvailTime()
/* 284:    */   {
/* 285:391 */     return this.latestAvailTime;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public void setLatestAvailTime(String latestAvailTime)
/* 289:    */   {
/* 290:395 */     this.latestAvailTime = latestAvailTime;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public int getNoOfTrailers()
/* 294:    */   {
/* 295:399 */     return this.noOfTrailers;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public void setNoOfTrailers(int noOfTrailers)
/* 299:    */   {
/* 300:403 */     this.noOfTrailers = noOfTrailers;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public String[] getTrailerType1()
/* 304:    */   {
/* 305:407 */     return this.trailerType1;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void setTrailerType1(String[] trailerType1)
/* 309:    */   {
/* 310:411 */     this.trailerType1 = trailerType1;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public int getTrailer1Capacity()
/* 314:    */   {
/* 315:415 */     return this.trailer1Capacity;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public void setTrailer1Capacity(int trailer1Capacity)
/* 319:    */   {
/* 320:419 */     this.trailer1Capacity = trailer1Capacity;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public String getTrailer1Dimension()
/* 324:    */   {
/* 325:423 */     return this.trailer1Dimension;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public void setTrailer1Dimension(String trailer1Dimension)
/* 329:    */   {
/* 330:427 */     this.trailer1Dimension = trailer1Dimension;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public String[] getTrailerType2()
/* 334:    */   {
/* 335:431 */     return this.trailerType2;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public void setTrailerType2(String[] trailerType2)
/* 339:    */   {
/* 340:435 */     this.trailerType2 = trailerType2;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public int getTrailer2Capacity()
/* 344:    */   {
/* 345:439 */     return this.trailer2Capacity;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public void setTrailer2Capacity(int trailer2Capacity)
/* 349:    */   {
/* 350:443 */     this.trailer2Capacity = trailer2Capacity;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public String getTrailer2Dimension()
/* 354:    */   {
/* 355:447 */     return this.trailer2Dimension;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void setTrailer2Dimension(String trailer2Dimension)
/* 359:    */   {
/* 360:451 */     this.trailer2Dimension = trailer2Dimension;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public boolean isTruckTracking()
/* 364:    */   {
/* 365:455 */     return this.truckTracking;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setTruckTracking(boolean truckTracking)
/* 369:    */   {
/* 370:459 */     this.truckTracking = truckTracking;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public int getMaxStops()
/* 374:    */   {
/* 375:463 */     return this.maxStops;
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void setMaxStops(int maxStops)
/* 379:    */   {
/* 380:467 */     this.maxStops = maxStops;
/* 381:    */   }
/* 382:    */   
/* 383:    */   public void setRouteNo(String routeNo)
/* 384:    */   {
/* 385:471 */     this.routeNo = routeNo;
/* 386:    */   }
/* 387:    */   
/* 388:    */   public void setVinNo(String vinNo)
/* 389:    */   {
/* 390:475 */     this.vinNo = vinNo;
/* 391:    */   }
/* 392:    */   
/* 393:    */   public void setYearOfBus(String yearOfBus)
/* 394:    */   {
/* 395:479 */     this.yearOfBus = yearOfBus;
/* 396:    */   }
/* 397:    */   
/* 398:    */   public void setAgeOfBus(String ageOfBus)
/* 399:    */   {
/* 400:483 */     this.ageOfBus = ageOfBus;
/* 401:    */   }
/* 402:    */   
/* 403:    */   public String toXML()
/* 404:    */   {
/* 405:487 */     String xml = "";
/* 406:    */     
/* 407:489 */     xml = xml + " <TruckType fC=" + this.fixedCost + " vC=" + this.variableCost + 
/* 408:490 */       " maxD=" + this.maxDuration + " maxC=" + this.maxCapacity + " sT=" + 
/* 409:491 */       this.serviceType + 
/* 410:492 */       "> </TruckType> ";
/* 411:    */     
/* 412:494 */     return xml;
/* 413:    */   }
/* 414:    */   
/* 415:    */   public Object clone()
/* 416:    */   {
/* 417:502 */     TruckType clonedTruckType = new TruckType();
/* 418:    */     
/* 419:504 */     clonedTruckType.fixedCost = this.fixedCost;
/* 420:505 */     clonedTruckType.maxCapacity = this.maxCapacity;
/* 421:506 */     clonedTruckType.maxDuration = this.maxDuration;
/* 422:507 */     clonedTruckType.serviceType = this.serviceType;
/* 423:508 */     clonedTruckType.truckNo = this.truckNo;
/* 424:509 */     clonedTruckType.variableCost = this.variableCost;
/* 425:    */     
/* 426:511 */     return clonedTruckType;
/* 427:    */   }
/* 428:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.TruckType
 * JD-Core Version:    0.7.0.1
 */