/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class ShipmentPartial
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected ShipmentPartial prev;
/*   9:    */   protected ShipmentPartial next;
/*  10:    */   protected int index;
/*  11:    */   boolean locked;
/*  12:    */   protected boolean isAssigned;
/*  13:    */   protected boolean isSelected;
/*  14:    */   protected String truckTypeNeeded;
/*  15:    */   
/*  16:    */   ShipmentPartial()
/*  17:    */   {
/*  18: 31 */     this.index = -1;
/*  19: 32 */     this.prev = null;
/*  20: 33 */     this.next = null;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public boolean isAssigned()
/*  24:    */   {
/*  25: 43 */     return this.isAssigned;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public boolean getSelected()
/*  29:    */   {
/*  30: 51 */     return this.isSelected;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setSelected(boolean is)
/*  34:    */   {
/*  35: 59 */     this.isSelected = is;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setAssigned(boolean is)
/*  39:    */   {
/*  40: 67 */     this.isAssigned = is;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public ShipmentPartial getPrev()
/*  44:    */   {
/*  45: 75 */     return this.prev;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public ShipmentPartial getNext()
/*  49:    */   {
/*  50: 83 */     return this.next;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setPrev(ShipmentPartial s)
/*  54:    */   {
/*  55: 91 */     this.prev = s;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setNext(ShipmentPartial s)
/*  59:    */   {
/*  60: 99 */     this.next = s;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public int getIndex()
/*  64:    */   {
/*  65:107 */     return this.index;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getTruckTypeNeeded()
/*  69:    */   {
/*  70:116 */     return this.truckTypeNeeded;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Object clone()
/*  74:    */   {
/*  75:121 */     ShipmentPartial clonedShipment = new ShipmentPartial();
/*  76:    */     
/*  77:123 */     clonedShipment.index = this.index;
/*  78:124 */     clonedShipment.isAssigned = this.isAssigned;
/*  79:    */     
/*  80:    */ 
/*  81:127 */     clonedShipment.truckTypeNeeded = this.truckTypeNeeded;
/*  82:    */     
/*  83:129 */     return clonedShipment;
/*  84:    */   }
/*  85:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.ShipmentPartial
 * JD-Core Version:    0.7.0.1
 */