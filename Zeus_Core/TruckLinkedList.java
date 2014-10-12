/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class TruckLinkedList
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   private Truck head;
/*   9:    */   private Truck tail;
/*  10:    */   private Attributes attributes;
/*  11:    */   
/*  12:    */   public Truck getHead()
/*  13:    */   {
/*  14: 37 */     return this.head;
/*  15:    */   }
/*  16:    */   
/*  17:    */   public Truck getTail()
/*  18:    */   {
/*  19: 45 */     return this.tail;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public void setHead(Truck head)
/*  23:    */   {
/*  24: 49 */     this.head = head;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void setTail(Truck tail)
/*  28:    */   {
/*  29: 53 */     this.tail = tail;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public void linkHeadTail()
/*  33:    */   {
/*  34: 58 */     this.head.setNext(this.tail);
/*  35: 59 */     this.tail.setPrev(this.head);
/*  36: 60 */     this.head.setPrev(null);
/*  37: 61 */     this.tail.setNext(null);
/*  38:    */   }
/*  39:    */   
/*  40:    */   public int getSize()
/*  41:    */   {
/*  42: 69 */     int size = 0;
/*  43: 70 */     Truck truck = this.head.getNext();
/*  44: 72 */     while (truck != this.tail)
/*  45:    */     {
/*  46: 73 */       size++;
/*  47: 74 */       truck = truck.getNext();
/*  48:    */     }
/*  49: 77 */     return size;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public Attributes getAttributes()
/*  53:    */   {
/*  54: 81 */     return this.attributes;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setAttributes(Attributes attributes)
/*  58:    */   {
/*  59: 85 */     this.attributes = attributes;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public boolean insertTruckLast(Truck truck)
/*  63:    */   {
/*  64: 96 */     if (this.head.getNext() == this.tail)
/*  65:    */     {
/*  66: 97 */       this.head.setNext(truck);
/*  67: 98 */       this.tail.setPrev(truck);
/*  68: 99 */       truck.setPrev(this.head);
/*  69:100 */       truck.setNext(this.tail);
/*  70:    */     }
/*  71:    */     else
/*  72:    */     {
/*  73:105 */       truck.setNext(this.tail);
/*  74:106 */       truck.setPrev(this.tail.getPrev());
/*  75:107 */       this.tail.getPrev().setNext(truck);
/*  76:108 */       this.tail.setPrev(truck);
/*  77:    */     }
/*  78:111 */     return true;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public Truck find(int truckNum)
/*  82:    */   {
/*  83:161 */     Truck currentTruck = this.head;
/*  84:163 */     while (currentTruck != this.tail)
/*  85:    */     {
/*  86:164 */       if (currentTruck.getTruckNum() == truckNum) {
/*  87:165 */         return currentTruck;
/*  88:    */       }
/*  89:167 */       currentTruck = currentTruck.getNext();
/*  90:    */     }
/*  91:169 */     return null;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Truck getTruckAtPos(int pos)
/*  95:    */   {
/*  96:178 */     if ((pos < 0) || (pos > getSize())) {
/*  97:179 */       return null;
/*  98:    */     }
/*  99:181 */     int count = 0;
/* 100:182 */     Truck temp = this.head;
/* 101:183 */     while (temp != null)
/* 102:    */     {
/* 103:184 */       if (count == pos) {
/* 104:185 */         return temp;
/* 105:    */       }
/* 106:187 */       count++;
/* 107:188 */       temp = temp.getNext();
/* 108:    */     }
/* 109:190 */     return null;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Truck removeTruck(Truck truck)
/* 113:    */   {
/* 114:199 */     Truck tempTruck = this.head;
/* 115:200 */     Truck prevTruck = null;
/* 116:201 */     Truck nextTruck = null;
/* 117:203 */     while (tempTruck != null)
/* 118:    */     {
/* 119:204 */       if (truck.getTruckNum() == tempTruck.getTruckNum())
/* 120:    */       {
/* 121:205 */         prevTruck = truck.getPrev();
/* 122:206 */         nextTruck = truck.getNext();
/* 123:207 */         if (truck == this.head)
/* 124:    */         {
/* 125:208 */           this.head = nextTruck;
/* 126:209 */           if (nextTruck != null) {
/* 127:210 */             nextTruck.setPrev(null);
/* 128:    */           }
/* 129:212 */           truck.setPrev(null);
/* 130:213 */           truck.setNext(null);
/* 131:214 */           return truck;
/* 132:    */         }
/* 133:216 */         if (truck == this.tail)
/* 134:    */         {
/* 135:217 */           this.tail = prevTruck;
/* 136:218 */           if (prevTruck != null) {
/* 137:219 */             prevTruck.setNext(null);
/* 138:    */           }
/* 139:221 */           truck.setPrev(null);
/* 140:222 */           truck.setNext(null);
/* 141:223 */           return truck;
/* 142:    */         }
/* 143:225 */         if (prevTruck != null) {
/* 144:226 */           prevTruck.setNext(nextTruck);
/* 145:    */         }
/* 146:228 */         if (nextTruck != null) {
/* 147:229 */           nextTruck.setPrev(prevTruck);
/* 148:    */         }
/* 149:231 */         truck.setPrev(null);
/* 150:232 */         truck.setNext(null);
/* 151:233 */         return truck;
/* 152:    */       }
/* 153:235 */       tempTruck = tempTruck.getNext();
/* 154:    */     }
/* 155:237 */     return null;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void removeEmptyTrucks()
/* 159:    */   {
/* 160:245 */     Truck truck = getHead();
/* 161:247 */     while (truck != null)
/* 162:    */     {
/* 163:248 */       if (truck.getMainNodes().getSize() == 2)
/* 164:    */       {
/* 165:249 */         removeTruck(truck);
/* 166:250 */         ProblemInfo.numTrucks -= 1;
/* 167:    */       }
/* 168:253 */       truck = truck.getNext();
/* 169:    */     }
/* 170:    */   }
/* 171:    */   
/* 172:    */   public Object clone()
/* 173:    */   {
/* 174:329 */     TruckLinkedList clonedTruckLinkedList = new TruckLinkedList();
/* 175:    */     
/* 176:331 */     clonedTruckLinkedList.attributes = ((Attributes)this.attributes.clone());
/* 177:332 */     clonedTruckLinkedList.head = ((Truck)this.head.clone());
/* 178:334 */     if (this.head != this.tail)
/* 179:    */     {
/* 180:335 */       Truck currentTruck = clonedTruckLinkedList.head;
/* 181:336 */       Truck nextTruck = getHead().getNext();
/* 182:338 */       while (nextTruck != null)
/* 183:    */       {
/* 184:339 */         currentTruck.setNext((Truck)nextTruck.clone());
/* 185:340 */         currentTruck.getNext().setPrev(currentTruck);
/* 186:341 */         currentTruck = currentTruck.getNext();
/* 187:342 */         nextTruck = nextTruck.getNext();
/* 188:345 */         if (nextTruck == null)
/* 189:    */         {
/* 190:346 */           clonedTruckLinkedList.tail = currentTruck;
/* 191:347 */           currentTruck.setNext(null);
/* 192:    */         }
/* 193:    */       }
/* 194:    */     }
/* 195:    */     else
/* 196:    */     {
/* 197:353 */       clonedTruckLinkedList.tail = clonedTruckLinkedList.head;
/* 198:    */     }
/* 199:356 */     return clonedTruckLinkedList;
/* 200:    */   }
/* 201:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.TruckLinkedList
 * JD-Core Version:    0.7.0.1
 */