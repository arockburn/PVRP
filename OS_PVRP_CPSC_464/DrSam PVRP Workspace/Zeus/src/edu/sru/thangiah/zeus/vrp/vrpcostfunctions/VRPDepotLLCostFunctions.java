package edu.sru.thangiah.zeus.vrp.vrpcostfunctions;

import edu.sru.thangiah.zeus.core.*;
import edu.sru.thangiah.zeus.vrp.VRPDepotLinkedList;

/**
 * Cost functions specific to Depot LinkedList level
 * <p>Title: Zeus - A Unified Object Oriented Model for VRP's</p>
 * <p>Description: cost functions specific to Depot LinkedList level</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class VRPDepotLLCostFunctions
    extends VRPAbstractCostFunctions implements
    java.io.Serializable {

  public double getTotalCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalCost(o);

    return depotLL.getAttributes().getTotalCost();
  }

  /* public double getTotalConstraintCost(Object o) {
     VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
     setTotalConstraintCost(o);

     return depotLL.getAttributes().totalConstraintCost;
   }*/

  /*public double getTotalCrossRoadPenaltyCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalCrossRoadPenaltyCost(o);

    return depotLL.getAttributes().totalCrossRoadPenaltyCost;
     }*/

  /*public double getTotalTurnAroundPenaltyCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalTurnAroundPenaltyCost(o);

    return depotLL.getAttributes().totalTurnAroundPenaltyCost;
     }*/

  public float getTotalDemand(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalDemand(o);

    return (int) depotLL.getAttributes().getTotalDemand();
  }

  public double getTotalDistance(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalDistance(o);

    return depotLL.getAttributes().getTotalDistance();
  }

  public double getTotalTravelTime(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setTotalTravelTime(o);

    return depotLL.getAttributes().getTotalTravelTime();
  }

  public double getMaxTravelTime(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setMaxTravelTime(o);

    return depotLL.getAttributes().getMaxTravelTime();
  }

  public double getAvgTravelTime(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    setAvgTravelTime(o);

    return depotLL.getAttributes().getAvgTravelTime();
  }

  public void setTotalCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    double cost = 0;

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      cost += ProblemInfo.depotLevelCostF.getTotalCost(d);
      d = d.getNext();
    }

    depotLL.getAttributes().setTotalCost(cost);
  }

  /*public void setTotalConstraintCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    double cost = 0;

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      cost += ProblemInfo.depotLevelCostF.getTotalConstraintCost(d);
      d = d.getNext();
    }

    depotLL.getAttributes().totalConstraintCost = cost;
     }*/

  /*public void setTotalCrossRoadPenaltyCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    depotLL.getAttributes().totalCrossRoadPenaltyCost = 0;

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      depotLL.getAttributes().totalCrossRoadPenaltyCost += ProblemInfo.
          depotLevelCostF.getTotalCrossRoadPenaltyCost(d);
      d = d.getNext();
    }
     }*/

  /*public void setTotalTurnAroundPenaltyCost(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    depotLL.getAttributes().totalTurnAroundPenaltyCost = 0;

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      depotLL.getAttributes().totalTurnAroundPenaltyCost += ProblemInfo.
          depotLevelCostF.getTotalTurnAroundPenaltyCost(d);
      d = d.getNext();
    }
     }*/

  public void setTotalDemand(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    depotLL.getAttributes().setTotalDemand(0);

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      depotLL.getAttributes().setTotalDemand(depotLL.getAttributes().getTotalDemand() + (float) ProblemInfo.depotLevelCostF.
          getTotalDemand(d));
      d = d.getNext();
    }
  }

  public void setTotalDistance(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    depotLL.getAttributes().setTotalDistance(0);

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      depotLL.getAttributes().setTotalDistance(depotLL.getAttributes().getTotalDistance()  + (float) ProblemInfo.depotLevelCostF.
          getTotalDistance(d));
      d = d.getNext();
    }
  }

  public void setTotalTravelTime(Object o) {
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
     depotLL.getAttributes().setTotalTravelTime(0);

    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      depotLL.getAttributes().setTotalTravelTime(depotLL.getAttributes().getTotalTravelTime() + ProblemInfo.depotLevelCostF.
          getTotalTravelTime(d));
      d = d.getNext();
    }
  }

  public void setMaxTravelTime(Object o) {
    double max = 0;
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    Depot d = depotLL.getHead();

    while (d != depotLL.getTail()) {
      if (ProblemInfo.depotLevelCostF.getMaxTravelTime(d) > max) {
        max = ProblemInfo.depotLevelCostF.getMaxTravelTime(d);
      }

      d = d.getNext();
    }

    depotLL.getAttributes().setMaxTravelTime(max);
  }

  public void setAvgTravelTime(Object o) {
    double avg = 0;
    VRPDepotLinkedList depotLL = (VRPDepotLinkedList) o;
    Depot d = depotLL.getHead();

    if (ProblemInfo.depotLLLevelCostF.getTotalDemand(depotLL) != 0) {
      while (d != depotLL.getTail()) {
        avg +=
            (ProblemInfo.depotLevelCostF.getAvgTravelTime(d) *
             ProblemInfo.depotLevelCostF.getTotalDemand(d));
        d = d.getNext();
      }

      depotLL.getAttributes().setAvgTravelTime(avg /
          ProblemInfo.depotLLLevelCostF.getTotalDemand(depotLL));
    }
    else {
      depotLL.getAttributes().setAvgTravelTime(0);
    }
  }

  /** @todo Might not need CrossRoadPenaltyCost and TurnAroundPenaltyCost */
  public void calculateTotalsStats(Object o) {
    setTotalDemand(o);
    setTotalDistance(o);
    setTotalTravelTime(o);
    setMaxTravelTime(o);
    setAvgTravelTime(o);
    //setTotalCrossRoadPenaltyCost(o);
    //setTotalTurnAroundPenaltyCost(o);
    setTotalCost(o);
    //setTotalConstraintCost(o);
  }
}
