/*   1:    */ package edu.sru.thangiah.zeus.core;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public class Feasibility
/*   7:    */   implements Serializable, Cloneable
/*   8:    */ {
/*   9:    */   protected double maxDuration;
/*  10:    */   protected double maxDistance;
/*  11:    */   protected double maxTravelTime;
/*  12:    */   protected double maxCapacity;
/*  13:    */   protected NodesLinkedList thisRoute;
/*  14:    */   
/*  15:    */   public Feasibility() {}
/*  16:    */   
/*  17:    */   public Feasibility(NodesLinkedList thisR)
/*  18:    */   {
/*  19: 36 */     this.thisRoute = thisR;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public Feasibility(int maxd, int maxq, NodesLinkedList thisR)
/*  23:    */   {
/*  24: 49 */     this.thisRoute = thisR;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public boolean isFeasible()
/*  28:    */   {
/*  29: 77 */     System.out.println("Error: Is Feasible is being called from the Feasibility class");
/*  30: 78 */     return false;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setRoute(NodesLinkedList nodes)
/*  34:    */   {
/*  35: 88 */     this.thisRoute = nodes;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Object clone()
/*  39:    */   {
/*  40: 99 */     Feasibility clonedFeasibility = new Feasibility();
/*  41:    */     
/*  42:101 */     clonedFeasibility.maxCapacity = this.maxCapacity;
/*  43:102 */     clonedFeasibility.maxDuration = this.maxDuration;
/*  44:    */     
/*  45:104 */     return clonedFeasibility;
/*  46:    */   }
/*  47:    */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.Feasibility
 * JD-Core Version:    0.7.0.1
 */