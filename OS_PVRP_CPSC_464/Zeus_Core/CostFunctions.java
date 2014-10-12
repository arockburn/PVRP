package edu.sru.thangiah.zeus.core;

/**
 * Interface class defining the necessary cost functionsS
 * <p>Title: Zeus - A Unified Object Oriented Model for VRP's</p>
 * <p>Description: interface class provided for user to define for a specific problem</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public interface CostFunctions {
  /**
   * must return the total cost associated with the given object
   *
   * @param o
   * @return
   */
  public double getTotalCost(Object o);

  /**
   * must return the total constraint cost associated with the given object
   *
   * @param o
   * @return
   */
  //public double getTotalConstraintCost(Object o);

  /**
   * must return the total cross road penalty cost with the given object
   * @param o
   * @return
   */
  //public double getTotalCrossRoadPenaltyCost(Object o);

  /**
   * must return the total turn around penalty cost with the given object
   * @param o
   * @return
   */
  //public double getTotalTurnAroundPenaltyCost(Object o);

  /**
   * must return the total demand of the given object
   *
   * @param o
   * @return
   */
  public float getTotalDemand(Object o);

  /**
   * must return the total distance travelled by the given object
   *
   * @param o
   * @return
   */
  public double getTotalDistance(Object o);

  /**
   * must return the total travel time of the given object
   *
   * @param o
   * @return
   */
  public double getTotalTravelTime(Object o);

  /**
   * must return the maximum travel time of the given object
   * @param o
   * @return
   */
  public double getMaxTravelTime(Object o);

  /**
   * must return the average travel time of the given object
   * @param o
   * @return
   */
  public double getAvgTravelTime(Object o);

  /**
   * must return the total score of the given object
   * @param o
   * @return
   */
  public float getTotalScore(Object o);

  /**
   * sets the total cost associated with the object. This method may need to make
   * use of other methods to retrieve the required cost values.
   *
   * @param o
   */
  public void setTotalCost(Object o);

  /**
   * sets the total cost associated with the object. This method may need to make
   * use of other methods to retrieve the required cost values.
   *
   * @param o
   */
  //public void setTotalConstraintCost(Object o);

  /**
   * sets the total cross road penalty cost associated with the object. This
   * method may need to make use of other methods to retrieve the required demand
   * values.
   *
   * @param o
   */
  //public void setTotalCrossRoadPenaltyCost(Object o);

  /**
   * sets the total turn around penalty cost associated with the object. This
   * method may need to make use of other methods to retrieve the required demand
   * values.
   *
   * @param o
   */
  //public void setTotalTurnAroundPenaltyCost(Object o);

  /**
   * sets the total demand associated with the object. This method may need to make
   * use of other methods to retrieve the required demand values.
   *
   * @param o
   */
  public void setTotalDemand(Object o);

  /**
   * sets the total distance associated with the object. This method may need to make
   * use of other methods to retrieve the required distance values.
   *
   * @param o
   */
  public void setTotalDistance(Object o);

  /**
   * sets the total travel time associated with the object. This method may need to make
   * use of other methods to retrieve the required travel time values.
   *
   * @param o
   */
  public void setTotalTravelTime(Object o);

  /**
   * sets the max travel time associated with the object. This method may
   * need to make use of other methods to retrieve the required demand values.
   *
   * @param o
   */
  public void setMaxTravelTime(Object o);

  /**
   * sets the average travel time associated with the object. This method may
   * need to make use of other methods to retrieve the required demand values.
   *
   * @param o
   */
  public void setAvgTravelTime(Object o);

  /**
   * sets the total scosre associated with the object. This method may
   * need to make use of other methods to retrieve the required demand values.
   *
   *
   * @param o
   */
  public void setTotalScore(Object o);

  /**
   * calculate all the statistics for the given object.
   *
   * @param o
   */
  public void calculateTotalsStats(Object o);
}
