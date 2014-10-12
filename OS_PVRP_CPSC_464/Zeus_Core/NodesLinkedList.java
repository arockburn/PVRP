package edu.sru.thangiah.zeus.core;

/**
 * Maintains all of the Nodess of a truck route.
 * Title: NodesLinkedList
 * Description: This class maintains all of the Nodess of a truck route.  The
 *              first and last Nodess are always the first depot and last
 *              depot of the truck route. Further information about each of the Nodess
 *              is stored in the Nodes class.
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
/** @todo Creates a problem to make it an abstract as it does not allow a
 * constructor and clone needs a constructor */
public class NodesLinkedList
    implements java.io.Serializable,
    java.lang.Cloneable {
  private Nodes head;
  private Nodes tail;
  private int truckNum; //absolutely required as used in the optimizations
  private TruckType truckType;
  private boolean collapsed = false;
  //public Attributes attributes = new Attributes();
  private Attributes attributes;
  private Feasibility feasibility;

  
  /**
   * Default constructor.
   */
  public NodesLinkedList() 
  {
      //head = new Nodes();
      //tail = new Nodes();
      //head.setNext(tail);
	  //tail.setPrev(head);
      //attributes = new Attributes();
   }

  /**
   * Constructor
   * @param tT truck type
   * @param depotX depot x-coordinate
   * @param depotY depot y-coordinate
   */
 /** public NodesLinkedList(TruckType tT, float depotX, float depotY, int tN) {
      truckType = tT;
      truckNum  = tN;
      //feasibility = new Feasibility(truckType.getMaxDuration(),
      //        truckType.getMaxCapacity(), this);
      //head = new Nodes(new Shipment(0, depotX, depotY, 0, 0, "D", "D"));
      //tail = new Nodes(new Shipment(-1, depotX, depotY, 0, 0, "D", "D"));
      //head.setNext(tail);
      //tail.setPrev(head);
       }
*/
  /**
   * Return the reference to feasible.
   * @return Feasibility
   */
  public Feasibility getFeasibility() {
    return feasibility;
  }

  /**
   * Returns the first cell in the linked list
   * @return first cell
   */
  public Nodes getHead() {
    return head;
  }
  

  /**
   * Returns the last cell in the linked list
   * @return last cell
   */
  public Nodes getTail() {
    return tail;
  }

  /**
   * Returns the current cost of the route (will not be updated for any new
   * changes)
   * @return current cost
   */
  public double getCost() {
	  return attributes.getTotalCost();
  }

  /**
   * Sets the head of the linked list
   * @param headVal value of the head of the linked list
   */
  public void setHead(Nodes headVal) {
	  head = headVal;
  }
  
  /**
   * Points to the node after next
   * @param headVal value of the head of the linked list
   */
  public void setHeadNext(Nodes headVal) {
	  head.next = headVal;
  }

  /**
   * Sets the tail of the linked list
   * @param tailVal value of the head of the linked list
   */
  public void setTail(Nodes tailVal) {
	  tail = tailVal;
  }

  public void linkHeadTail() {
	  head.setNext(tail);
	  tail.setPrev(head);
	  head.setPrev(null);
	  tail.setNext(null);
  }

  public Attributes getAttributes() {
	return attributes;
}

public void setAttributes(Attributes attributes) {
	this.attributes = attributes;
}

/**
   * Gets the truck type servicing this route
   * @return truck type
   */
  public TruckType getTruckType() {
	  return truckType;
  }

  /**
   * Return if the route has been collapsed or not
   * @return true- collapsed, false- not collapsed
   */
  /* public boolean isCollapsed() {
    return collapsed;
  }*/

  /**
   * Calculates the number of point cell in the list
   * @return number of point cells
   */
  public int getSize() {
    int size = 0;
    Nodes cell = getHead().getNext();

    while (cell != getTail()) {
      size++;
      cell = cell.getNext();
    }

    return size;
  }

  /**
   * Removes all shipments from the linked list
   */
  public void emptyList() {
    head.setNext(tail);
    tail.setPrev(head);
  }

  /**
   * Gets the actual size for the route if it has been collapsed. Will return
   * the actual demand + the two depots
   * @return the size of the route
   */
  public int getCollapsedSize() {
    Nodes tempCell = head.getNext();
    int count = 0;

    while (tempCell != tail) {
      if ( (tempCell != head) && (tempCell != tail)) {
        count += tempCell.getDemand();
      }
      else {
        count++;
      }

      tempCell = tempCell.getNext();
    }

    return count;
  }

  /**
   * Ths is method should be declared by the inheriting class
   * Same as insertShipment except the insertion parameter must be specified
   * as a point cell and also the previous point cell is returned. This method
   * is used by the local optimization methods
   * @param insertNode Nodes that is to be inserted into the route
   * @return Nodes that is previous to the inserted Nodes.
   */

  public Nodes insertNodes(Nodes insertNode) {
    System.out.println("ERROR: InsertNodes was called in from NodesLinkedList");
    return null;
  }

  /**
   * Insert Nodes after the specified Nodes.
   * @param toInsert Nodes to be inserted
   * @param afterThis Nodes in the route after which the other Nodes is
   * to be inserted.
   * @return returns beforePC if insertion is successful, returns null if insertion
   * is not successful.
   */
  public Nodes insertAfterNodes(Nodes toInsert, Nodes afterThis) {
    Nodes currentNode = head;

    while (currentNode != tail) {
      if (currentNode == afterThis) {
        toInsert.setPrev(currentNode);
        toInsert.setNext(currentNode.getNext());
        currentNode.setNext(toInsert);
        toInsert.getNext().setPrev(toInsert);
        break;
      }
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }
  
  public boolean insertLastNode(Nodes node) 
  {
		// the route is empty
		    if (head.getNext() == tail) {
		      head.setNext(node);
		      tail.setPrev(node);
		      node.setPrev(head);
		      node.setNext(tail);
		    }
		    // the route is not empty
		    else {
		    	
		    	node.setNext(tail);
		    	node.setPrev(tail.getPrev());
		    	tail.getPrev().setNext(node);
		    	tail.setPrev(node);
		    
		    }	
	    return true; 
  }


  /**
   * Removes a Node from this route and returns the node that was
   * before it.
   * @param removeNode  Node to be removed from the route
   * @return Node that was before the Node that was removed
   */
  public Nodes removeNodes(Nodes removeNode) {
    Nodes currentNode = head.getNext();
    Nodes nodeBeforeRemoveNode = null;

    while (currentNode != tail) {
      if (currentNode.getIndex() == removeNode.getIndex()) {
        nodeBeforeRemoveNode = currentNode.getPrev();
        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
        currentNode.setNext(null);
        currentNode.setPrev(null);

        break;
      }
      currentNode = currentNode.getNext();
    }
    return nodeBeforeRemoveNode;
  }

  /**
   * This method will remove a node by its index
   * @param index the index of the node to remove
   * @return the node before the removed node
   */
  public Nodes removeNodeByIndex(int index) {
    Nodes currentNode = head.getNext();
    Nodes nodeBeforeRemoveNode = null;

    while (currentNode != tail) {
      if (currentNode.getIndex() == index) {
        nodeBeforeRemoveNode = currentNode.getPrev();
        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
        currentNode.setNext(null);
        currentNode.setPrev(null);

        break;
      }
      currentNode = currentNode.getNext();
    }

    //return nodeBeforeRemoveNode;
    return currentNode;
  }

  /**
   * Removes a Node from any route that it exists in and returns the
   * Node that was before it.
   * @param removeNode Nodes to be removed from any route
   * @return Node that was before the Nodes removed
   */
  public Nodes removeFromOtherRoute(Nodes removeNode) {
    if ( (removeNode.getPrev() != null) && (removeNode.getNext() != null)) {
      removeNode.getPrev().setNext(removeNode.getNext());
      removeNode.getNext().setPrev(removeNode.getPrev());

      return removeNode.getPrev();
    }
    else {
      return null;
    }
  }

  /**
   * Returns the Nodes at the specified position in the list.
   * @param pos position of the Nodes to be returned
   * @return Nodes at the specified position
   */
  public Nodes getNodesAtPosition(int pos) {
    Nodes current = head;
    int currentPos = 0;

    while ( (current != null) && (currentPos < pos)) {
      current = current.getNext();
      currentPos++;
    }

    return current;
  }

  /**
   * This method will retrieve a node by its index
   * @param index the index of the node to get
   * @return Nodes the node, or null
   */
  public Nodes getNodeByIndex(int index) {
    Nodes currentNode = head.getNext();

    while (currentNode != tail) {
      if (currentNode.getIndex() == index) {
        return currentNode;
      }
      currentNode = currentNode.getNext();
    }

    return null;
  }

  /**
   * Returns the truck number of this nodes linked list
   * @return int truck number
   */
  public int getTruckNum() {
    return truckNum;
  }

  /**
   * Will return a string of all the pick up points in the route.
   * @return String string of pick up points.
   */
  public String getRouteString() {
    //use the string buffer because it performs better than using "" + ""
    StringBuffer buf = new StringBuffer();

    Nodes node = this.getHead();
    while (node != null) {
      buf.append(node.getIndex()).append(" ");
      node = node.getNext();
    }

    return buf.toString();
  }

  /**
   * Sets the value for the collapsed
   * @param collapsedVal collapse is either set to true or false
   */
  /*public void setCollapsed(boolean collapsedVal) {
    collapsed = collapsedVal;
  }
*/

  /**
   * Sets the value for feasibility
   * @param feasibilityVal feasibility value
   */
  public void setFeasibility(Feasibility feasibilityVal) {
    feasibility = feasibilityVal;
  }

  /**
   * Sets the truck type
   * @param truckTypeVal value of the truckType
   */
  public void setTruckType(TruckType truckTypeVal) {
    truckType = truckTypeVal;
  }

  /**
   * Sets the truck number
   * @param truckNumVal value of the truck number
   */
  public void setTruckNum(int truckNumVal) {
    truckNum = truckNumVal;
  }

 

  /**
   * Trims the route to one Nodes per stop so that the optimization
   * methods work better.
   *
   * Original route looked like this: (S# - student:pick up point, D - depot)
   * D - S1 - S1 - S1 - S1 - S2 - S2 - S2 - S2 - S3 - S3 - S3 - S3 - D
   *
   * Now looks like this:
   * D
   * |
   * S1 - S1 - S1 - S1  each of these students at same pick up point
   * |
   * S2 - S2 - S2 - S2
   * |
   * S3 - S3 - S3 - S3
   * |
   * D
   *
   * This will prevent the optimization functions from splitting visits to pick
   * up points.  These routes will have the same cost, because the distance has
   * not changed. There is no additional distance for picking up multiple students
   * from a pick up point.
   */
  /** @todo This needs to be moved out of here */
  public void collapseRoute() {
    //if (!collapsed) {
    Nodes tempCell = head.getNext(); //start at first pick up point
    Nodes firstCellInPUP = null;
    Nodes lastCellInPUP = null;
    int tempDemand = 1;
    String pupName = null; //name of the pick up point

    try {
      while (tempCell != tail) { //loop through all the cells until last depot

        if (!tempCell.getPickupPointName().equals(pupName)) {
          //if we have found a new pick up point
          firstCellInPUP = tempCell; //save that cell
          pupName = tempCell.getPickupPointName(); //save the name

          while ( (tempCell.getNext() != tail) &&
                 tempCell.getNext().getPickupPointName().equals(pupName)) {
            tempDemand += tempCell.theShipment.getDemand();
            tempCell = tempCell.getNext();
          }

          lastCellInPUP = tempCell; //save the last cell
          tempCell = tempCell.getNext(); //incremant tempCell to next one

          firstCellInPUP.theShipment.setTempNext(firstCellInPUP.getNext()); //connect cells in this PUP to tempNext
          firstCellInPUP.theShipment.setTempDemand(firstCellInPUP.theShipment.getDemand());
              ;
          firstCellInPUP.theShipment.setDemand(tempDemand);
          firstCellInPUP.setNext(tempCell); //connect the first cell directly to the next PUP
          tempCell.setPrev(firstCellInPUP);

          if (firstCellInPUP != lastCellInPUP) {
            lastCellInPUP.setNext(null); //disconnect last cell from next PUP
          }
          else {
            firstCellInPUP.theShipment.setTempNext(null); //only cell from this PUP, nothing to save
          }

          tempDemand = 1;
        }
        else {
          tempCell = tempCell.getNext();
        }
      }
    }
    catch (Exception e) {
      System.out.println("Exception caught in collapseRoute() " + e);
    }

    collapsed = true;
    //}
  }

  /**
   * Expands the collapsed route to the original route. Extracts all the cells
   * hidden by the collapseRoute() method.
   */
  /** @todo This needs to be moved out of here */
  public void expandRoute() {
    //if (collapsed) {
    Nodes tempCell = head.getNext();
    Nodes endOfHidden = null;
    Nodes startOfHidden = null;

    try {
      while (tempCell != tail) {
        if (tempCell.theShipment.getTempNext() != null) { //there are hidden cells
          startOfHidden = tempCell.theShipment.getTempNext();

          //loop through all the hidden cell until you find the last
          while (startOfHidden.getNext() != null) {
            startOfHidden = startOfHidden.getNext();
          }

          endOfHidden = startOfHidden;
          startOfHidden = tempCell.theShipment.getTempNext();

          //tempCell_hidden now equals the last hidden cell
          endOfHidden.setNext(tempCell.getNext()); //link the last hidden cell to the next pup
          tempCell.getNext().setPrev(endOfHidden);
          tempCell.setNext(tempCell.theShipment.getTempNext()); //reattach the first hidden cell
          tempCell.theShipment.setTempNext(null);
          tempCell.theShipment.setDemand(tempCell.theShipment.getTempDemand());
          tempCell.theShipment.setTempDemand(-1);

          //increment tempCell
          tempCell = endOfHidden.getNext();
        }
        else {
          tempCell = tempCell.getNext();
        }
      }
    }
    catch (Exception e) {
      System.out.println("Exception caught in expandRoute() " + e);
    }

    //collapsed = false;
    // }
  }

  /** @todo Check to make sure that these work */
  public Object clone() {

    NodesLinkedList clonedNodesLinkedList = new NodesLinkedList();

    clonedNodesLinkedList.attributes = (Attributes)this.attributes.clone();
   // clonedNodesLinkedList.setCollapsed(this.collapsed);
    clonedNodesLinkedList.setFeasibility( (Feasibility)this.feasibility.clone());
    clonedNodesLinkedList.setTruckType( (TruckType)this.truckType.clone());
    clonedNodesLinkedList.setTruckNum(this.truckNum);
    clonedNodesLinkedList.setHead( (Nodes)this.head.clone());

    this.expandRoute();

    if (this.head != this.tail) {
      Nodes currentNodes = (Nodes) clonedNodesLinkedList.getHead();
      Nodes nextNodes = (Nodes)this.getHead().getNext();

      while (nextNodes != null) {
        currentNodes.setNext( (Nodes) nextNodes.clone()); //create the next depot
        currentNodes.getNext().setPrev(currentNodes); //set the next depot's prev
        currentNodes = (Nodes) currentNodes.getNext();
        nextNodes = (Nodes) nextNodes.getNext();

        //once next is null, we have found the tail of the list
        if (nextNodes == null) {
          clonedNodesLinkedList.setTail(currentNodes);
          currentNodes.setNext(null);
        }

      }
    }

    //Set the route for the feasibility
    clonedNodesLinkedList.getFeasibility().setRoute(clonedNodesLinkedList);

    return clonedNodesLinkedList;
  }

}
