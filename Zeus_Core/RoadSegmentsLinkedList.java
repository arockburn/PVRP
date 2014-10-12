/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ 
/*   5:    */ public class RoadSegmentsLinkedList
/*   6:    */ {
/*   7:    */   protected RoadSegments head;
/*   8:    */   protected RoadSegments tail;
/*   9:    */   protected int numRoadSegments;
/*  10:    */   protected int totalDemand;
/*  11:    */   
/*  12:    */   public RoadSegmentsLinkedList()
/*  13:    */   {
/*  14: 25 */     this.head = new RoadSegments();
/*  15: 26 */     this.tail = new RoadSegments();
/*  16: 27 */     this.head.setNext(this.tail);
/*  17: 28 */     this.tail.setPrev(this.head);
/*  18: 29 */     this.numRoadSegments = 0;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public RoadSegments getHead()
/*  22:    */   {
/*  23: 37 */     return this.head;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public RoadSegments getTail()
/*  27:    */   {
/*  28: 45 */     return this.tail;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public int getNumRoadSegments()
/*  32:    */   {
/*  33: 53 */     return this.numRoadSegments;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public boolean insertLast(RoadSegments roadSegment)
/*  37:    */   {
/*  38: 65 */     if (this.head.getNext() == this.tail)
/*  39:    */     {
/*  40: 66 */       this.head.setNext(roadSegment);
/*  41: 67 */       this.tail.setPrev(roadSegment);
/*  42: 68 */       roadSegment.setPrev(roadSegment);
/*  43: 69 */       roadSegment.setNext(roadSegment);
/*  44:    */     }
/*  45:    */     else
/*  46:    */     {
/*  47: 73 */       roadSegment.setNext(this.tail);
/*  48: 74 */       roadSegment.setPrev(this.tail.getPrev());
/*  49: 75 */       this.tail.getPrev().setNext(roadSegment);
/*  50: 76 */       this.tail.setPrev(roadSegment);
/*  51:    */     }
/*  52: 79 */     this.numRoadSegments += 1;
/*  53: 80 */     this.totalDemand += roadSegment.getDemand();
/*  54: 81 */     return true;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public RoadSegments find(int key)
/*  58:    */   {
/*  59: 90 */     boolean isDiagnostic = false;
/*  60: 91 */     RoadSegments current = this.head;
/*  61: 93 */     while (current.getNext() != this.tail)
/*  62:    */     {
/*  63: 94 */       if (current.getIndex() == key) {
/*  64:    */         break;
/*  65:    */       }
/*  66: 98 */       current = current.getNext();
/*  67:    */     }
/*  68:101 */     if (isDiagnostic) {
/*  69:102 */       System.out.println("found " + current.getIndex());
/*  70:    */     }
/*  71:105 */     return current;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public boolean deleteAllRoadSegments()
/*  75:    */   {
/*  76:113 */     this.head = null;
/*  77:114 */     this.tail = null;
/*  78:115 */     this.numRoadSegments = 0;
/*  79:    */     
/*  80:117 */     return true;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public boolean clearAllSelected()
/*  84:    */   {
/*  85:126 */     RoadSegments roadSeg = this.head.getNext();
/*  86:128 */     while (roadSeg != this.tail)
/*  87:    */     {
/*  88:129 */       roadSeg.isSelected = false;
/*  89:130 */       roadSeg = roadSeg.getNext();
/*  90:    */     }
/*  91:132 */     return true;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public boolean isAllShipsSelected()
/*  95:    */   {
/*  96:140 */     RoadSegments roadSeg = this.head.getNext();
/*  97:142 */     while (roadSeg != this.tail)
/*  98:    */     {
/*  99:143 */       if (!roadSeg.getSelected()) {
/* 100:144 */         return false;
/* 101:    */       }
/* 102:147 */       roadSeg = roadSeg.getNext();
/* 103:    */     }
/* 104:150 */     return true;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public boolean isAllShipsAssigned()
/* 108:    */   {
/* 109:158 */     RoadSegments roadSeg = this.head.getNext();
/* 110:160 */     while (roadSeg != this.tail)
/* 111:    */     {
/* 112:161 */       if (!roadSeg.isAssigned()) {
/* 113:162 */         return false;
/* 114:    */       }
/* 115:165 */       roadSeg = roadSeg.getNext();
/* 116:    */     }
/* 117:168 */     return true;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void displayBackwardList()
/* 121:    */   {
/* 122:175 */     System.out.print("List (last to first): ");
/* 123:176 */     RoadSegments current = this.tail.getPrev();
/* 124:177 */     while (current != this.head) {
/* 125:179 */       current = current.getPrev();
/* 126:    */     }
/* 127:182 */     System.out.println("");
/* 128:    */   }
/* 129:    */   
/* 130:    */   public boolean isEmpty()
/* 131:    */   {
/* 132:190 */     return this.head.getNext() == null;
/* 133:    */   }
/* 134:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.RoadSegmentsLinkedList
 * JD-Core Version:    0.7.0.1
 */