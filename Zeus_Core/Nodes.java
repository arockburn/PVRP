/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Nodes
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected Nodes prev;
/*   9:    */   protected Nodes next;
/*  10:    */   protected Shipment theShipment;
/*  11:    */   
/*  12:    */   public Nodes getPrev()
/*  13:    */   {
/*  14: 51 */     return this.prev;
/*  15:    */   }
/*  16:    */   
/*  17:    */   public Nodes getNext()
/*  18:    */   {
/*  19: 59 */     return this.next;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public Shipment getShipment()
/*  23:    */   {
/*  24: 67 */     return this.theShipment;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public int getIndex()
/*  28:    */   {
/*  29: 75 */     return this.theShipment.getIndex();
/*  30:    */   }
/*  31:    */   
/*  32:    */   public int getDemand()
/*  33:    */   {
/*  34: 83 */     return this.theShipment.getDemand();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public String getPickupPointName()
/*  38:    */   {
/*  39: 92 */     return this.theShipment.getPickUpPointName();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setPrev(Nodes p)
/*  43:    */   {
/*  44:100 */     this.prev = p;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setNext(Nodes n)
/*  48:    */   {
/*  49:108 */     this.next = n;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public Object clone()
/*  53:    */   {
/*  54:133 */     Nodes clonedNode = new Nodes();
/*  55:    */     
/*  56:135 */     clonedNode.theShipment = ((Shipment)this.theShipment.clone());
/*  57:    */     
/*  58:137 */     return clonedNode;
/*  59:    */   }
/*  60:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Nodes
 * JD-Core Version:    0.7.0.1
 */