package edu.sru.thangiah.zeus.core;

import java.text.DecimalFormat;

/**
 * Used to hold information on the customer or package that is to be delivered
 * by a truck.
 * <p>Title: Nodes</p>
 * <p>Description: The Nodes class is used to hold information on the customer or
 * package that is to be delivered by a truck. An instance of the Nodes class has a number
 * of different variables. The variables to be used depends on the problem to be solved. Use only
 * those variables that are required for the problem and leave the others as is (do not delete them).
 * In addition, new variables locations can be defined if required.
 * A truck can consisit of one or more instances of Nodess.
 * The Nodes class is used by the VisitingNodesLinkedList class.</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0

 */
/** @todo Creates a problem to make it an abstract as it does not allow a
 * constructor and clone needs a constructor */
public class Nodes
    implements java.io.Serializable, java.lang.Cloneable {
  protected Nodes prev;
  protected Nodes next;
 protected Shipment theShipment;

  /** @todo This needs to be an abstact class but there are no abstract methods
   * that require to be defined for the inheriting class */
  /**
   * Default Constructor
   */
  /* public Nodes(){
   }*/

  /**
   * Constructor
   * @param s shipment conatining this cells information
   */
  /*public Nodes(Shipment s) {
      theShipment = s;
       }*/

  /**
   * Returns the previous point cell in the linked list
   * @return previous point cell
   */
  public Nodes getPrev() {
    return prev;
  }

  /**
   * Returns the next point cell in the linked list
   * @return next point cell
   */
  public Nodes getNext() {
    return next;
  }

  /**
   * Returns the shipment this point cell represents
   * @return the shipment
   */
  public Shipment getShipment() {
    return theShipment;
  }

  /**
   * Returns the point cell's index
   * @return point cell index
   */
  public int getIndex() {
    return theShipment.getIndex();
  }

  /**
   * Returns the point cell's demand
   * @return demand
   */
  public int getDemand() {
    return (int) theShipment.getDemand();
  }


  /**
   * Returns the pick up point at which this point cell is at
   * @return pick up point
   */
  public String getPickupPointName() {
    return theShipment.getPickUpPointName();
   }

  /**
   * Sets the previous cell in the linked list
   * @param p new previous cell
   */
  public void setPrev(Nodes p) {
    prev = p;
  }

  /**
   * Sets the next cell in the linked list
   * @param n new next cell
   */
  public void setNext(Nodes n) {
    next = n;
  }

  /**
   * Returns a formatted string of the point cell's information
   * @return point cell string
   */
  /*public String toString() {
    DecimalFormat df = new DecimalFormat("000");

    return "#" + df.format(theShipment.getIndex()) + " q=" +
        theShipment.getDemand() + " busType=" +
        theShipment.getTruckTypeNeeded() + " PuP=" +
        //theShipment.getPickUpPointName() +
        " (" + theShipment.getXCoord() +
        "," + theShipment.getYCoord() + ")";
  }*/

  /**
   * Creates a copy of this node and returns it. It will not create the next
   * and prev links, because this would cause infinate recursion. These are
   * set in the nodes linked list clone() function.
   * @return Object node clone
   */
  public Object clone() {
    Nodes clonedNode = new Nodes();

    clonedNode.theShipment = (Shipment)this.theShipment.clone();

    return clonedNode;
  }

}
