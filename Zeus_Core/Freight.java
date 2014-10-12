/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Freight
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected Freight prev;
/*   9:    */   protected Freight next;
/*  10:    */   protected int index;
/*  11:    */   protected String carrierCode;
/*  12:    */   protected String fromCity;
/*  13:    */   protected String fromState;
/*  14:    */   protected String toCity;
/*  15:    */   protected String toState;
/*  16:    */   protected int weight1;
/*  17:    */   protected String rate1;
/*  18:    */   protected int weight2;
/*  19:    */   protected String rate2;
/*  20:    */   protected int weight3;
/*  21:    */   protected String rate3;
/*  22:    */   protected String flatRate;
/*  23:    */   protected int rank;
/*  24:    */   
/*  25:    */   public Freight getPrev()
/*  26:    */   {
/*  27: 45 */     return this.prev;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public Freight getNext()
/*  31:    */   {
/*  32: 53 */     return this.next;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setPrev(Freight s)
/*  36:    */   {
/*  37: 61 */     this.prev = s;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setNext(Freight s)
/*  41:    */   {
/*  42: 69 */     this.next = s;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public int getIndex()
/*  46:    */   {
/*  47: 77 */     return this.index;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Object clone()
/*  51:    */   {
/*  52:102 */     Freight clonedShipment = new Freight();
/*  53:    */     
/*  54:    */ 
/*  55:105 */     clonedShipment.index = this.index;
/*  56:    */     
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:113 */     return clonedShipment;
/*  64:    */   }
/*  65:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Freight
 * JD-Core Version:    0.7.0.1
 */