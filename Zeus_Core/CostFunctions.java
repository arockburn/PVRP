package edu.sru.thangiah.zeus.core;

public abstract interface CostFunctions
{
  public abstract double getTotalCost(Object paramObject);
  
  public abstract float getTotalDemand(Object paramObject);
  
  public abstract double getTotalDistance(Object paramObject);
  
  public abstract double getTotalTravelTime(Object paramObject);
  
  public abstract double getMaxTravelTime(Object paramObject);
  
  public abstract double getAvgTravelTime(Object paramObject);
  
  public abstract float getTotalScore(Object paramObject);
  
  public abstract void setTotalCost(Object paramObject);
  
  public abstract void setTotalDemand(Object paramObject);
  
  public abstract void setTotalDistance(Object paramObject);
  
  public abstract void setTotalTravelTime(Object paramObject);
  
  public abstract void setMaxTravelTime(Object paramObject);
  
  public abstract void setAvgTravelTime(Object paramObject);
  
  public abstract void setTotalScore(Object paramObject);
  
  public abstract void calculateTotalsStats(Object paramObject);
}


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.CostFunctions
 * JD-Core Version:    0.7.0.1
 */