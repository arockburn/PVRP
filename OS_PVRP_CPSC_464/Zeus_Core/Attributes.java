package edu.sru.thangiah.zeus.core;

import java.text.*;

/**
 * Contains all the infomation calculated by the cost functions
 * <p>Title: Attributes</p>
 * <p>Description: Contains all the infomation calculated by the cost functions</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class Attributes
/** @todo should the variables be declared as private and accessed through methods */
    implements java.io.Serializable, java.lang.Cloneable {
  private double totalDemand = 0; //total demand for the route
  private double totalDistance = 0; //total distance of the route
  private double totalCost = 0; //total cost of the route
  //public double totalConstraintCost = 0; //total constraint cost of the route
  //public double totalCrossRoadPenaltyCost = 0; //total penalty cost due to student crossing the road
  //public double totalTurnAroundPenaltyCost = 0; //total penalty cost due to bus turn arounds
  private double totalTravelTime = 0; //total amount of time bus is traveling on the route
  private double maxTravelTime = 0; //max travel time for a student
  private double avgTravelTime = 0; //average travel time for the students

  /**
   * Constructor
   */
  /* public Attributes() {
   }*/

  /**
   * Returns a string of the attributes
   * @return attributes
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.00");

    return " totQ=" + df.format(totalDemand) + " totD=" +
        df.format(totalDistance) + " $" + df.format(totalCost);
  }

  public double getTotalDemand() {
	return totalDemand;
}

public void setTotalDemand(double totalDemand) {
	this.totalDemand = totalDemand;
}

public double getTotalDistance() {
	return totalDistance;
}

public void setTotalDistance(double totalDistance) {
	this.totalDistance = totalDistance;
}

public double getTotalCost() {
	return totalCost;
}

public void setTotalCost(double totalCost) {
	this.totalCost = totalCost;
}

public double getTotalTravelTime() {
	return totalTravelTime;
}

public void setTotalTravelTime(double totalTravelTime) {
	this.totalTravelTime = totalTravelTime;
}

public double getMaxTravelTime() {
	return maxTravelTime;
}

public void setMaxTravelTime(double maxTravelTime) {
	this.maxTravelTime = maxTravelTime;
}

public double getAvgTravelTime() {
	return avgTravelTime;
}

public void setAvgTravelTime(double avgTravelTime) {
	this.avgTravelTime = avgTravelTime;
}

/**
   * Returns a detailed, pipe-delimited string. For use in the interface.
   * NOTE: There must be a pipe after the final field!
   * @return detailed string
   */
  public String toDetailedString() {
    DecimalFormat df = new DecimalFormat("0.00");

    return "Total Demand = " + df.format(totalDemand) +
        "| Total Distance = " + df.format(totalDistance) +
        "| Total Travel Time = " + df.format(totalTravelTime) +
        "| Total Cost = $" + df.format(totalCost) + "|";
  }

  /**
   * Creates a clone of this object.
   * @return Object the clone
   */
  public Object clone() {
    Attributes clonedAttributes = new Attributes();

    clonedAttributes.avgTravelTime = this.avgTravelTime;
    clonedAttributes.maxTravelTime = this.maxTravelTime;
    //clonedAttributes.totalConstraintCost = this.totalConstraintCost;
    clonedAttributes.totalCost = this.totalCost;
    //clonedAttributes.totalCrossRoadPenaltyCost = this.totalCrossRoadPenaltyCost;
    clonedAttributes.totalDemand = this.totalDemand;
    clonedAttributes.totalDistance = this.totalDistance;
    clonedAttributes.totalTravelTime = this.totalTravelTime;
    //clonedAttributes.totalTurnAroundPenaltyCost = this.
    //    totalTurnAroundPenaltyCost;

    return clonedAttributes;
  }
}
