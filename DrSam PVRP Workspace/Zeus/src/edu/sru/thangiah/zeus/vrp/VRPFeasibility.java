package edu.sru.thangiah.zeus.vrp;

//import the parent class
import edu.sru.thangiah.zeus.core.Feasibility;
import edu.sru.thangiah.zeus.core.ProblemInfo;

/**
 *
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

public class VRPFeasibility
    extends Feasibility
    implements java.io.Serializable, java.lang.Cloneable {
  public VRPFeasibility() {
  }

  /**
   * Constructor for the feasibilty, will send the constants as well as a
   * pointer to the route that will be checked
   * @param maxd max duration
   * @param maxq max capacity
   * @param thisR the route
   */
  public VRPFeasibility(double maxd, float maxq, VRPNodesLinkedList thisR) {
    super(thisR);

    maxDuration = maxd;
    maxCapacity = maxq;
    //thisRoute = thisR;
  }

  /**
   * This function checks the feasibility of the route.
   * @return true if feasible, false if not.
   */
  public boolean isFeasible() {
    double currentDistance;
    double currentDemand;

    currentDistance = ProblemInfo.nodesLLLevelCostF.getTotalDistance(thisRoute);
    currentDemand = ProblemInfo.nodesLLLevelCostF.getTotalDemand(thisRoute);
    
    //System.out.println("Current Distance ="+ currentDistance);
    //System.out.println("Current Demand ="+ currentDemand);
    

    if ( (currentDistance <= maxDuration) && (currentDemand <= maxCapacity)) {
      return true;
    }
    else {
      return false;
    }
  }

}
