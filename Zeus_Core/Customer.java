/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Customer
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected Customer prev;
/*   9:    */   protected Customer next;
/*  10:    */   protected int index;
/*  11:    */   protected String customerCode;
/*  12:    */   protected String carrierName;
/*  13:    */   protected double xCoord;
/*  14:    */   protected double yCoord;
/*  15:    */   protected String addressOne;
/*  16:    */   protected String addressTwo;
/*  17:    */   protected String state;
/*  18:    */   protected String zip;
/*  19:    */   
/*  20:    */   public Customer getPrev()
/*  21:    */   {
/*  22: 43 */     return this.prev;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Customer getNext()
/*  26:    */   {
/*  27: 51 */     return this.next;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setPrev(Customer s)
/*  31:    */   {
/*  32: 59 */     this.prev = s;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setNext(Customer s)
/*  36:    */   {
/*  37: 67 */     this.next = s;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public int getIndex()
/*  41:    */   {
/*  42: 75 */     return this.index;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public double getXCoord()
/*  46:    */   {
/*  47: 83 */     return this.xCoord;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public double getYCoord()
/*  51:    */   {
/*  52: 91 */     return this.yCoord;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Object clone()
/*  56:    */   {
/*  57:117 */     Customer clonedShipment = new Customer();
/*  58:    */     
/*  59:    */ 
/*  60:120 */     clonedShipment.index = this.index;
/*  61:    */     
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65:125 */     clonedShipment.xCoord = this.xCoord;
/*  66:126 */     clonedShipment.yCoord = this.yCoord;
/*  67:    */     
/*  68:128 */     return clonedShipment;
/*  69:    */   }
/*  70:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Customer
 * JD-Core Version:    0.7.0.1
 */