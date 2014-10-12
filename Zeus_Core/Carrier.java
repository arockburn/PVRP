/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Carrier
/*   6:    */   implements Serializable, Cloneable
/*   7:    */ {
/*   8:    */   protected Carrier prev;
/*   9:    */   protected Carrier next;
/*  10:    */   protected int index;
/*  11:    */   protected String carrierCode;
/*  12:    */   protected String carrierName;
/*  13:    */   protected boolean sendByFax;
/*  14:    */   protected boolean sendByEmail;
/*  15:    */   protected String areaCode;
/*  16:    */   protected String faxNumber;
/*  17:    */   protected String emailAddress;
/*  18:    */   protected String safetyRating;
/*  19:    */   protected String safetyRatingDate;
/*  20:    */   protected String contractDate;
/*  21:    */   protected String insEndDate;
/*  22:    */   protected String initBaud;
/*  23:    */   protected String normalBaud;
/*  24:    */   protected double xCoord;
/*  25:    */   protected double yCoord;
/*  26:    */   protected String addressOne;
/*  27:    */   protected String addressTwo;
/*  28:    */   protected String state;
/*  29:    */   protected String zip;
/*  30:    */   
/*  31:    */   public Carrier getPrev()
/*  32:    */   {
/*  33: 96 */     return this.prev;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public Carrier getNext()
/*  37:    */   {
/*  38:104 */     return this.next;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setPrev(Carrier s)
/*  42:    */   {
/*  43:112 */     this.prev = s;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setNext(Carrier s)
/*  47:    */   {
/*  48:120 */     this.next = s;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public int getIndex()
/*  52:    */   {
/*  53:128 */     return this.index;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public double getXCoord()
/*  57:    */   {
/*  58:136 */     return this.xCoord;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public double getYCoord()
/*  62:    */   {
/*  63:144 */     return this.yCoord;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Object clone()
/*  67:    */   {
/*  68:170 */     Carrier clonedShipment = new Carrier();
/*  69:    */     
/*  70:    */ 
/*  71:173 */     clonedShipment.index = this.index;
/*  72:    */     
/*  73:    */ 
/*  74:    */ 
/*  75:    */ 
/*  76:178 */     clonedShipment.xCoord = this.xCoord;
/*  77:179 */     clonedShipment.yCoord = this.yCoord;
/*  78:    */     
/*  79:181 */     return clonedShipment;
/*  80:    */   }
/*  81:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Carrier
 * JD-Core Version:    0.7.0.1
 */