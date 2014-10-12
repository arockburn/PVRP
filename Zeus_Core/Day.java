/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Day
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   private Day prev;
/*   9:    */   private Day next;
/*  10:    */   private String dayOfWeek;
/*  11:    */   private int index;
/*  12:    */   private NodesLinkedList mainNodes;
/*  13:    */   
/*  14:    */   public Day()
/*  15:    */   {
/*  16: 25 */     this.dayOfWeek = "none";
/*  17:    */   }
/*  18:    */   
/*  19:    */   public Day(String dayOfWeek)
/*  20:    */   {
/*  21: 29 */     this.dayOfWeek = dayOfWeek;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public Day getPrev()
/*  25:    */   {
/*  26: 37 */     return this.prev;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public Day getNext()
/*  30:    */   {
/*  31: 45 */     return this.next;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void setPrev(Day t)
/*  35:    */   {
/*  36: 53 */     this.prev = t;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setNext(Day t)
/*  40:    */   {
/*  41: 61 */     this.next = t;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public NodesLinkedList getNodesLinkedList()
/*  45:    */   {
/*  46: 69 */     return this.mainNodes;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setNodesLinkedList(NodesLinkedList nll)
/*  50:    */   {
/*  51: 77 */     this.mainNodes = nll;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public boolean isEmpty()
/*  55:    */   {
/*  56: 86 */     if ((this.mainNodes == null) || (this.mainNodes.getSize() <= 2)) {
/*  57: 87 */       return true;
/*  58:    */     }
/*  59: 90 */     return false;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public int getIndex()
/*  63:    */   {
/*  64: 96 */     return this.index;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setIndex(int index)
/*  68:    */   {
/*  69:100 */     this.index = index;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getDayOfWeek()
/*  73:    */   {
/*  74:135 */     return this.dayOfWeek;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setDayOfWeek(String dayOfWeek)
/*  78:    */   {
/*  79:139 */     this.dayOfWeek = dayOfWeek;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Object clone()
/*  83:    */   {
/*  84:149 */     Day clonedDay = new Day();
/*  85:    */     
/*  86:151 */     clonedDay.dayOfWeek = this.dayOfWeek;
/*  87:    */     
/*  88:153 */     return clonedDay;
/*  89:    */   }
/*  90:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Day
 * JD-Core Version:    0.7.0.1
 */