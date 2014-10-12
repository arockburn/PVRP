package edu.sru.thangiah.zeus.core;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.core.XMLFileWriter;

/**
 * Contains instances of the Depot Class
 * <p>Title: DepotLinkedList</p>
 * <p>Description: This class implements the DepotLinkedList class. The Root class creates
 * an instance of a problem, like MDVRP, class. The problem, like MDVRP, class creates an instance
 * of the DepotLinkedList class. If the problem has only one depot then the DepotLinkedList class
 * will have only one instance of the Depot class, else it will have a linked list of multple
 * instances of the Depot class. </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class DepotLinkedList
    implements java.io.Serializable,
    java.lang.Cloneable {
  private Depot head;
  private Depot tail;
  private Attributes attributes;

  /**
   * Constructor
   */
  /* public DepotLinkedList() {
        attributes = new Attributes();
    }*/

	public DepotLinkedList()
	{
		head = new Depot();
		tail = new Depot();
		head.setNext(tail);
		tail.setPrev(head);
		attributes = new Attributes();
	}


  
  /**
   * Returns the first depot in the linked list
   * @return first depot
   */

  public Depot getHead() {
    return head;
  }

  /**
   * Returns the last depot in the linked list
   * @return last depot
   */
  public Depot getTail() {
    return tail;
  }

  /**
   * Attempts to insert the shipment into the depot linked list. Will loop
   * through the available depots until a depot is found that can accomodate
   * the shipment
   * @param theShipment the shipment to route
   * @return true if shipment serviced, false if not.
   */
  /*public boolean insertShipment(Shipment theShipment) {
      boolean status = false;

      Depot depot = this.getHead();

      while (depot != null) {
          status = depot.getMainTrucks().insertShipment(theShipment);

          if (status) {
              break;
          }

          depot = depot.getNext();
      }

      return status;
       }
   */

  public void setHead(Depot head) {
	this.head = head;
}



public void setTail(Depot tail) {
	this.tail = tail;
}

public void linkHeadTail() {
    head.setNext(tail);
	  tail.setPrev(head);
	  head.setPrev(null);
	  tail.setNext(null);
}


/**
   * Inserts depot as last node in the depot linked list
   * @param depot the specified depot to be inserted
   */
//the method was previously called insertLast
  public boolean insertDepotLast(Depot depot) 
  {
		// the route is empty
		    if (head.getNext() == tail) {
		      head.setNext(depot);
		      tail.setPrev(depot);
		      depot.setPrev(head);
		      depot.setNext(tail);
		    }
		    // the route is not empty
		    else {
		    	
		    	depot.setNext(tail);
		    	depot.setPrev(tail.getPrev());
		    	tail.getPrev().setNext(depot);
		    	tail.setPrev(depot);
		    
		    }	
	    return true; 
  }

  public Attributes getAttributes() {
	return attributes;
}



public void setAttributes(Attributes attributes) {
	this.attributes = attributes;
}



/**
   * Inserts a depots after another depot in the linked list
   * @param insertDepot depot to insert
   * @param beforeDepot depot to insert after
   */
 /* public void insertAfterDepot(Depot insertDepot, Depot beforeDepot) {
    Depot currentDepot = head.getNext();

    if (currentDepot.getNext()==tail) {
      head = insertDepot;
      insertDepot.setPrev(null);
      insertDepot.setNext(null);

      return;
    }

    while (currentDepot != tail) {
      if (currentDepot == beforeDepot) {
        if (beforeDepot.getNext() != null) {
          beforeDepot.getNext().setPrev(insertDepot);
          insertDepot.setNext(beforeDepot.getNext());
        }
        else {
          insertDepot.setNext(null);
        }

        beforeDepot.setNext(insertDepot);
        insertDepot.setPrev(beforeDepot);

        return;
      }

      currentDepot = currentDepot.getNext();
    }
  }*/

  /**
   * Removes the specified depot
   * @param depot depot to remove
   * @return removed depot
   * THIS CODE NEEDS TO BE CHECKED TO ENSURE THAT IT WORKS
   */
  /*public Depot removeDepot(Depot depot) {
    Depot tempDepot = head.getNext();
    Depot prevDepot = null;
    Depot nextDepot = null;

    while (tempDepot != tail) {
      if (depot.getDepotNum() == tempDepot.getDepotNum()) {
        prevDepot = depot.getNext();
        nextDepot = depot.getNext();

        if (depot == head) {
          head = nextDepot;

          if (nextDepot != null) {
            nextDepot.setPrev(null);
          }

          depot.setNext(null);
          depot.setPrev(null);

          return null;
        }

        if (depot == tail) {
          tail = prevDepot;

          if (prevDepot != null) {
            prevDepot.setNext(null);
          }

          depot.setNext(null);
          depot.setPrev(null);

          return prevDepot;
        }

        if (prevDepot != null) {
          prevDepot.setNext(nextDepot);
        }

        if (nextDepot != null) {
          nextDepot.setPrev(prevDepot);
        }

        depot.setNext(null);
        depot.setPrev(null);

        return prevDepot;
      }

      tempDepot = tempDepot.getNext();
    }

    return null;
  }
  
  */

  /**
   * This method loops through all depots and removes an empty truck
   */
  public void removeEmptyTrucks() {
    Depot depot = this.getHead().getNext();
    while (depot != tail) {
      depot.getMainTrucks().removeEmptyTrucks();
      depot = depot.getNext();
    }
  }

  
  
  /**
   * find a Depot in the linked list with Depot number key
   * @param key unique id of the depot
   * @return Depot pointer to the depot with the id, else null
   */
  protected Depot find(int key) {
    Depot current = head.getNext();

    while (current.getDepotNum() != key && current != tail) {
      if (current.getNext() == null) {
        return null;
      }
      else {
        current = current.getNext();
      }
    }
    
    if (current == tail) // did not find the depot
    {
    	current = null;
    }

    return current;
  }

  /**
   * Gets the number of buses in the depots
   * @return number of buses
   */
  public int getTotalNumTrucksUsed() {
    Depot currentDepot = head.getNext();
    Truck currentTruck, currentTruckTail;
    int numBusesUsed = 0;

    //loop through all depots
    while (currentDepot != tail) {
      currentTruck = currentDepot.getMainTrucks().getHead();
      currentTruckTail = currentDepot.getMainTrucks().getTail();

      //loop through all buses
      while (currentTruck != currentTruckTail) {
        //if bus is not empty, then increment number of used buses
        if (!currentTruck.isEmptyMainNodes()) {
          numBusesUsed++;
        }

        currentTruck = currentTruck.getNext();
      }

      currentDepot = currentDepot.getNext();
    }

    return numBusesUsed;
  }

  /** @todo Need to move out the collapse and expand routes */
  /**
   * Collapse all of the bus routes for each of the depots.
   */
  /*public void collapseAllRoutes() {
    Depot currentDepot = head;
    Truck currentTruck;

    //loop through all depots
    while (currentDepot != null) {
      currentTruck = currentDepot.getMainTrucks().getHead();

      //loop through all buses
      while (currentTruck != null) {
        currentTruck.getMainNodes().collapseRoute(); //collapse bus route
        currentTruck = currentTruck.getNext();
      }

      currentDepot = currentDepot.getNext();
    }
   }*/

  /**
   * Expand all of the bus routes for each of the depots.
   */
  /* Sam public void expandAllRoutes() {
    Depot currentDepot = head;
    Truck currentTruck;

    //loop through all depots
    while (currentDepot != null) {
      currentTruck = currentDepot.getMainTrucks().getHead();

      //loop through all buses
      while (currentTruck != null) {
        currentTruck.getMainNodes().expandRoute(); //expand bus route
        currentTruck = currentTruck.getNext();
      }

      currentDepot = currentDepot.getNext();
    }
   }*/

  /**
   * Returns the number of non-empty trucks used.
   * @return non empty trucks
   */
  public int getNumTrucksUsed() {
    int numT = 0;

    Depot depot = head.getNext();

    while (depot != tail) {
      Truck truck = depot.getMainTrucks().getHead().getNext();
      Truck truckTail = depot.getMainTrucks().getTail();

      while (truck != truckTail) {
        numT++;
        truck = truck.getNext();
      }

      depot = depot.getNext();
    }

    return numT;
  }

  /**
   * Returns the string that contains the current solution information for the
   * interface. Is a pipe '|' delimeted string. MUST have a pipe at the end.
   * @return solution string
   */
  public String getSolutionString() {
    return "Trucks Used = " + getTotalNumTrucksUsed() + " | " +
        attributes.toDetailedString();
  }
  
  /**
   * Will write the contents of the depot linked list to the file listed in out
   * @param out the stream to print to
   */
  public void printDepotLinkedList(java.io.PrintStream out) {

    //this.expandAllRoutes();

    out.println(ProblemInfo.numDepots);

    Depot depot = getHead().getNext();

    try {
      while (depot != getTail()) {
        out.println(depot.getDepotNum() + " " + depot.getXCoord() + " " +
                    depot.getYCoord() + " " + depot.getAttributes().getTotalDemand() +
                    " " +
                    depot.getAttributes().getTotalDistance() + " " +
                    depot.getMainTrucks().getSize());

        Truck truck = depot.getMainTrucks().getHead().getNext();
        Truck truckTail = depot.getMainTrucks().getTail();

        while (truck != truckTail) {
          out.println(truck.getTruckNum() + " " +
                      truck.getTruckType().getServiceType() + " " +
                      truck.getAttributes().getTotalDemand() + " " +
                      truck.getAttributes().getTotalDistance() + " " +
                      truck.getTruckType().getMaxCapacity() + " " +
                      truck.getTruckType().getMaxDuration() + " " +
                      truck.getMainNodes().getSize());

          Nodes cell = truck.getMainNodes().getHead().getNext();
          Nodes cellTail = truck.getMainNodes().getTail();

          while (cell != cellTail) {
            out.println(cell.getIndex() + " " + cell.getDemand() + " " +
                        cell.getShipment().getXCoord() + " " +
                        cell.getShipment().getYCoord() + " " +
                        cell.getShipment().getTruckTypeNeeded());
            cell = cell.getNext();
          }

          truck = truck.getNext();
        }

        depot = depot.getNext();
      }
    }
    catch (Exception e) {
      System.out.println("Error in printDepotLinkedList"+e);
      e.printStackTrace();
    }
  }

  
  
  /**
   * Will write the contents of the depot linked list converted to XML into an XML file
   * @param out the stream to print to
   */
  public void writeDepotLinkedListXML(String xmlFileName) {

	  //this.expandAllRoutes();
	  String topHeading="MDVRP";
	  Depot depot = head;
	  
	XMLFileWriter.writeToXML(xmlFileName,topHeading,depot,ProblemInfo.numDepots);

    /*out.println(ProblemInfo.numDepots);

    try {
      while (depot != null) {
        out.println(depot.getDepotNum() + " " + depot.getXCoord() + " " +
                    depot.getYCoord() + " " + depot.getAttributes().totalDemand +
                    " " +
                    depot.getAttributes().totalDistance + " " +
                    depot.getMainTrucks().getSize());

        Truck truck = depot.getMainTrucks().getHead();

        while (truck != null) {
          out.println(truck.getTruckNum() + " " +
                      truck.getTruckType().getServiceType() + " " +
                      truck.getAttributes().totalDemand + " " +
                      truck.getAttributes().totalDistance + " " +
                      truck.getTruckType().getMaxCapacity() + " " +
                      truck.getTruckType().getMaxDuration() + " " +
                      truck.getMainNodes().getSize());

          Nodes cell = truck.getMainNodes().getHead();

          while (cell != null) {
            out.println(cell.getIndex() + " " + cell.getDemand() + " " +
                        cell.getShipment().getXCoord() + " " +
                        cell.getShipment().getYCoord() + " " +
                        cell.getShipment().getTruckTypeNeeded());
            cell = cell.getNext();
          }

          truck = truck.getNext();
        }

        depot = depot.getNext();
      }
    }
    catch (Exception e) {
      System.out.println("Error in printDepotLinkedList"+e);
      e.printStackTrace();
    }*/
  }

  

  /**
   * Returns an exact copy of the depot linked list
   * @return Object depot linked list copy
   */
  public Object clone() {
    DepotLinkedList clonedDepotLinkedList = new DepotLinkedList();

    clonedDepotLinkedList.setAttributes((Attributes)this.getAttributes().clone());
    clonedDepotLinkedList.head = (Depot)this.head.clone();

    //must establish the links at this level to avoid recursing out of control
    clonedDepotLinkedList.head.setPrev(null);

    if (this.head != this.tail) {
      Depot currentDepot = clonedDepotLinkedList.head;
      Depot nextDepot = this.getHead().getNext();

      while (nextDepot != null) {
        currentDepot.setNext( (Depot) nextDepot.clone()); //create the next depot
        currentDepot.getNext().setPrev(currentDepot); //set the next depot's prev
        currentDepot = currentDepot.getNext();
        nextDepot = nextDepot.getNext();

        //once next is null, we have found the tail of the list
        if (nextDepot == null) {
          clonedDepotLinkedList.tail = currentDepot;
          currentDepot.setNext(null);
        }

      }
    }
    else { //only 1 depot
      clonedDepotLinkedList.tail = clonedDepotLinkedList.head;
    }

    return clonedDepotLinkedList;
  }
}
