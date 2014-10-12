/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public class DaysLinkedList
/*   7:    */   implements Serializable, Cloneable
/*   8:    */ {
/*   9:    */   private Day head;
/*  10:    */   private Day tail;
/*  11:    */   
/*  12:    */   public DaysLinkedList()
/*  13:    */   {
/*  14: 27 */     this.head = new Day();
/*  15: 28 */     this.tail = new Day();
/*  16: 29 */     this.head.setNext(this.tail);
/*  17: 30 */     this.tail.setPrev(this.head);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public Day getHead()
/*  21:    */   {
/*  22: 40 */     return this.head;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Day getTail()
/*  26:    */   {
/*  27: 48 */     return this.tail;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public int getSize()
/*  31:    */   {
/*  32: 65 */     int size = 0;
/*  33: 66 */     Day cell = this.head;
/*  34: 68 */     while (cell != null)
/*  35:    */     {
/*  36: 69 */       size++;
/*  37: 70 */       cell = cell.getNext();
/*  38:    */     }
/*  39: 73 */     return size;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void emptyList()
/*  43:    */   {
/*  44: 80 */     this.head.setNext(this.tail);
/*  45: 81 */     this.tail.setPrev(this.head);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Day insertDay(Day insertNode)
/*  49:    */   {
/*  50: 95 */     System.out.println("ERROR: InsertDay was called in from DayLinkedList");
/*  51: 96 */     return null;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Day insertAfterDay(Day toInsert, Day afterThis)
/*  55:    */   {
/*  56:108 */     Day currentNode = this.head.getNext();
/*  57:110 */     while (!currentNode.getDayOfWeek().equals("none"))
/*  58:    */     {
/*  59:111 */       if (currentNode == afterThis)
/*  60:    */       {
/*  61:112 */         toInsert.setPrev(currentNode);
/*  62:113 */         toInsert.setNext(currentNode.getNext());
/*  63:114 */         currentNode.setNext(toInsert);
/*  64:115 */         toInsert.getNext().setPrev(toInsert);
/*  65:116 */         break;
/*  66:    */       }
/*  67:118 */       currentNode = currentNode.getNext();
/*  68:    */     }
/*  69:120 */     return currentNode;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public boolean insertLastDay(Day day)
/*  73:    */   {
/*  74:127 */     if (this.head.getNext() == this.tail)
/*  75:    */     {
/*  76:128 */       this.head.setNext(day);
/*  77:129 */       this.tail.setPrev(day);
/*  78:130 */       day.setPrev(this.head);
/*  79:131 */       day.setNext(this.tail);
/*  80:    */     }
/*  81:    */     else
/*  82:    */     {
/*  83:136 */       day.setNext(this.tail);
/*  84:137 */       day.setPrev(this.tail.getPrev());
/*  85:138 */       this.tail.getPrev().setNext(day);
/*  86:139 */       this.tail.setPrev(day);
/*  87:    */     }
/*  88:142 */     return true;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public Day removeDay(Day removeNode)
/*  92:    */   {
/*  93:154 */     Day currentNode = this.head.getNext().getNext();
/*  94:155 */     Day nodeBeforeRemoveNode = null;
/*  95:158 */     if (currentNode == null) {
/*  96:159 */       return null;
/*  97:    */     }
/*  98:162 */     while (!currentNode.getDayOfWeek().equals("none"))
/*  99:    */     {
/* 100:163 */       if (currentNode.getIndex() == removeNode.getIndex())
/* 101:    */       {
/* 102:164 */         nodeBeforeRemoveNode = currentNode.getPrev();
/* 103:165 */         currentNode.getPrev().setNext(currentNode.getNext());
/* 104:166 */         currentNode.getNext().setPrev(currentNode.getPrev());
/* 105:167 */         currentNode.setNext(null);
/* 106:168 */         currentNode.setPrev(null);
/* 107:    */         
/* 108:170 */         break;
/* 109:    */       }
/* 110:172 */       currentNode = currentNode.getNext();
/* 111:    */     }
/* 112:174 */     return nodeBeforeRemoveNode;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Day removeNodeByIndex(int index)
/* 116:    */   {
/* 117:183 */     Day currentNode = this.head.getNext().getNext();
/* 118:184 */     Day nodeBeforeRemoveNode = null;
/* 119:187 */     if (currentNode == null) {
/* 120:188 */       return null;
/* 121:    */     }
/* 122:190 */     while (!currentNode.getDayOfWeek().equals("none"))
/* 123:    */     {
/* 124:191 */       if (currentNode.getIndex() == index)
/* 125:    */       {
/* 126:192 */         nodeBeforeRemoveNode = currentNode.getPrev();
/* 127:193 */         currentNode.getPrev().setNext(currentNode.getNext());
/* 128:194 */         currentNode.getNext().setPrev(currentNode.getPrev());
/* 129:195 */         currentNode.setNext(null);
/* 130:196 */         currentNode.setPrev(null);
/* 131:    */         
/* 132:198 */         break;
/* 133:    */       }
/* 134:200 */       currentNode = currentNode.getNext();
/* 135:    */     }
/* 136:204 */     return currentNode;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Day removeFromOtherRoute(Day removeNode)
/* 140:    */   {
/* 141:214 */     if ((removeNode.getPrev() != null) && (removeNode.getNext() != null))
/* 142:    */     {
/* 143:215 */       removeNode.getPrev().setNext(removeNode.getNext());
/* 144:216 */       removeNode.getNext().setPrev(removeNode.getPrev());
/* 145:    */       
/* 146:218 */       return removeNode.getPrev();
/* 147:    */     }
/* 148:221 */     return null;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public Day getDayAtPosition(int pos)
/* 152:    */   {
/* 153:231 */     Day current = this.head.getNext();
/* 154:232 */     int currentPos = 0;
/* 155:235 */     if (current == null) {
/* 156:236 */       return null;
/* 157:    */     }
/* 158:238 */     while ((current.equals("none")) && (currentPos < pos))
/* 159:    */     {
/* 160:239 */       current = current.getNext();
/* 161:240 */       currentPos++;
/* 162:    */     }
/* 163:243 */     return current;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public Day getNodeByIndex(int index)
/* 167:    */   {
/* 168:252 */     Day currentNode = this.head.getNext();
/* 169:255 */     if (currentNode == null) {
/* 170:256 */       return null;
/* 171:    */     }
/* 172:258 */     while (currentNode.equals("none"))
/* 173:    */     {
/* 174:259 */       if (currentNode.getIndex() == index) {
/* 175:260 */         return currentNode;
/* 176:    */       }
/* 177:262 */       currentNode = currentNode.getNext();
/* 178:    */     }
/* 179:265 */     return null;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public String getRouteString()
/* 183:    */   {
/* 184:275 */     StringBuffer buf = new StringBuffer();
/* 185:    */     
/* 186:    */ 
/* 187:278 */     Day node = getHead().getNext();
/* 188:281 */     if (node == null) {
/* 189:282 */       return null;
/* 190:    */     }
/* 191:283 */     while (node.equals("none"))
/* 192:    */     {
/* 193:285 */       buf.append(node.getIndex()).append(" ");
/* 194:286 */       node = node.getNext();
/* 195:    */     }
/* 196:289 */     return buf.toString();
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setHead(Day headVal)
/* 200:    */   {
/* 201:306 */     this.head = headVal;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setTail(Day tailVal)
/* 205:    */   {
/* 206:314 */     this.tail = tailVal;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void linkHeadTail()
/* 210:    */   {
/* 211:318 */     this.head.setNext(this.tail);
/* 212:319 */     this.tail.setPrev(this.head);
/* 213:320 */     this.head.setPrev(null);
/* 214:321 */     this.tail.setNext(null);
/* 215:    */   }
/* 216:    */   
/* 217:    */   public Object clone()
/* 218:    */   {
/* 219:329 */     DaysLinkedList clonedDayLinkedList = new DaysLinkedList();
/* 220:    */     
/* 221:331 */     clonedDayLinkedList.head = ((Day)this.head.clone());
/* 222:333 */     if (this.head != this.tail)
/* 223:    */     {
/* 224:334 */       Day currentDay = clonedDayLinkedList.head;
/* 225:335 */       Day nextDay = getHead().getNext();
/* 226:337 */       while (nextDay != null)
/* 227:    */       {
/* 228:338 */         currentDay.setNext((Day)nextDay.clone());
/* 229:339 */         currentDay.getNext().setPrev(currentDay);
/* 230:340 */         currentDay = currentDay.getNext();
/* 231:341 */         nextDay = nextDay.getNext();
/* 232:344 */         if (nextDay == null)
/* 233:    */         {
/* 234:345 */           clonedDayLinkedList.tail = currentDay;
/* 235:346 */           currentDay.setNext(null);
/* 236:    */         }
/* 237:    */       }
/* 238:    */     }
/* 239:    */     else
/* 240:    */     {
/* 241:352 */       clonedDayLinkedList.tail = clonedDayLinkedList.head;
/* 242:    */     }
/* 243:355 */     return clonedDayLinkedList;
/* 244:    */   }
/* 245:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.DaysLinkedList
 * JD-Core Version:    0.7.0.1
 */