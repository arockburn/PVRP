package edu.sru.thangiah.zeus.core;

//geoCLustering package
import edu.sru.thangiah.zeus.geoClust.*;

/**
 * Maintains information about the trucks
 * <p>Title: Truck</p>
 * <p>Description: Maintains information about the trucks</p>
 * <p>Truck Operations:
 * - truck1.equals(truck2); // will compare truck types to see if the same
 * - truck1 == truck2; // will do bit comparason to see if trucks are identical
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class Truck
    implements java.io.Serializable, java.lang.Cloneable {
  private Truck prev;
  private Truck next;
  private int truckNum;
  private TruckType truckType;
  private double depotX;
  private double depotY;
  //A truck can consist either of a NodesLinkedList or a DaysLinkedList depending on the problem to be solved
  private NodesLinkedList mainNodes;
  private DaysLinkedList mainDays;
  private RoadSegmentsLinkedList mainRoadSegments;
  private Attributes attributes;
  private Shape shape;

  /**
   * Default Constructor
   */
  public Truck() {
	  prev = null;
	  next = null;
	  truckNum=-1;

  }

  /**
   * Constructor
   * @param tt truck type
   * @param depotX depot's x coordinate
   * @param depotY depot's y coordinate
   */
  public Truck(TruckType tt, float depX, float depY) {
    attributes = new Attributes();
    depotX = depX;
    depotY = depY;
    //truckNum = ProblemInfo.numTrucks++;
    truckType = tt;
    //mainNodes = new NodesLinkedList(truckType, depotX, depotY,truckNum);
  }

  /**
   * Returns the previous truck in the linked list
   * @return previous truck
   */
  public Truck getPrev() {
    return prev;
  }

  /**
   * Returns the next truck in the linked list
   * @return next truck
   */
  public Truck getNext() {
    return next;
  }

  /**
   * Sets the previous truck in the linked list
   * @param t new previous truck
   */
  public void setNext(Truck t) {
    next = t;
  }
  
  /**
   * Sets the previous truck in the linked list
   * @param t new previous truck
   */
  public void setPrev(Truck t) {
    prev = t;
  }

  /**
   * Sets the next truck in the linked list
   * @param t new next truck
   */
  public void truck(Truck t) {
    next = t;
  }

  /**
   * Returns the visit nodes linked list (route)
   * @return route
   */
  public NodesLinkedList getMainNodes() {
    return mainNodes;
  }

  /**
   * Restores the node linked list
   * @param nll NodesLinkedList new nodes linked list
   */
  public void setMainNodes(NodesLinkedList nll) {
    mainNodes = nll;
  }

  public DaysLinkedList getMainDays() {
	return mainDays;
}

public void setMainDays(DaysLinkedList mainDays) {
	this.mainDays = mainDays;
}

/**
  * Returns the road segments linked list (route)
  * @return route
  */
 public RoadSegmentsLinkedList getMainRoadSegments() {
   return mainRoadSegments;
 }

 /**
  * Restores the road segment linked  list
  * @param nll NodesLinkedList new nodes linked list
  */
 public void setMainRoadSegments (RoadSegmentsLinkedList rsll) {
   mainRoadSegments = rsll;
 }


  /**
   * Returns this truck's number
   * @return truck number
   */
  public int getTruckNum() {
    return truckNum;
  }

  /**
   * Returns this truck's type
   * @return truck type
   */
  public TruckType getTruckType() {
    return truckType;
  }

  /**
   * This will return if the two trucks are of the same type
   * @param otherTruck truck to compare to this type
   * @return true - same type, false - different types
   *
   * @todo  --- this method needs implemented --- in the inheriting class
   */
  public boolean equals(Truck otherTruck) {
    return otherTruck.getTruckType().getServiceType().equals(this.getTruckType()
        .getServiceType());
  }

  /**
   * Returns whether a truck is compatable with a shipment
   * @param aShip shipment to compare
   * @return true- ship is ok, false- truck can't service this
   */
  public boolean compatableWith(Shipment aShip) {
    return aShip.getTruckTypeNeeded().equals(truckType.getServiceType());
  }

  /**
   * Returns whether or not the bus is empty
   * @return true - the bus is empty, false - the bus is not empty
   */
  public boolean isEmptyMainNodes() {
    //if ( (mainNodes == null) || (mainNodes.getSize() <= 2)) {
	  if ( (mainNodes.getHead() == mainNodes.getTail()) || (mainNodes.getSize() <= 2)) {	
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Returns whether or not the bus is empty
   * @return true - the bus is empty, false - the bus is not empty
   */
  public boolean isEmptyMainDays() {
    //if ( (mainDays == null) || (mainDays.getSize() <= 2)) {
    if ( (mainDays.getHead() == mainDays.getTail()) || (mainDays.getSize() <= 2)) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * String evaluation of truck
   * @return truck's string
   */
  public String toString() {
    //String s = "#" + truckNum + " " + truckType.getServiceType() +
    //    " Max Q=";
    String s = "#" + truckNum + " " +
        " Max Q="+truckType.getMaxCapacity()+" Max Dist ="+truckType.getMaxDistance();
  /*  if (truckType.getMaxCapacity() == Integer.MAX_VALUE) {
      s += " \u221E"; //unicode for infinity
    }
    else {
      s += truckType.getMaxCapacity();
    }

    s += " Max D=";

    if (truckType.getMaxDuration() == Integer.MAX_VALUE) {
      s += " \u221E"; //unicode for infinity
    }
    else {
      s += truckType.getMaxDuration();
    }

    s += (" " + attributes);*/

    return s;
  }

  public Attributes getAttributes() {
	return attributes;
}

public void setAttributes(Attributes attributes) {
	this.attributes = attributes;
}

public void setTruckNum(int truckNum) {
	this.truckNum = truckNum;
}

public void setTruckType(TruckType truckType) {
	this.truckType = truckType;
}

public void setShape(Shape shape) {
	this.shape = shape;
}

/**
   * Creates a clone of the current trucks. Does not create the next and prev
   * links, that is the responsibility of the truck linked list clone() function
   * @return Object truck clone
   */
  public Object clone() {
    Truck clonedTruck = new Truck();

    clonedTruck.attributes = (Attributes)this.attributes.clone();
    clonedTruck.depotX = this.depotX;
    clonedTruck.depotY = this.depotY;
    clonedTruck.mainNodes = (NodesLinkedList)this.mainNodes.clone();
    clonedTruck.truckNum = this.truckNum;
    clonedTruck.truckType = (TruckType)this.truckType.clone();

    return clonedTruck;
  }

  /* The following code is from the geoClustering class */
  /**
   * This class constructor is the default constructor, it creates a default polygon
   * @return ShapeBase
   */
  public Shape newShape() {
    shape = new Shape();
    return shape;

  }

  /**
   * This class constructor is passed the number of sides N, the radius of the
   * circumscribed circle, the x coord for the center, the y coord for the
   * center, and the rotation angle
   * @param n is the number of sides
   * @param r is the radius of the circumscribed circle
   * @param x_o is x coord of the orgin for the polygon
   * @param y_o is y coord of the orgin for the polygon
   * @param deg is the rotation of the polygon
   * @return ShapeBase
   */

  public Shape newShape(int n, double r, float x_o, float y_o, int deg) {
    shape = new Shape(n, r, x_o, y_o, deg);
    return shape;

  }

  /**
   * This class constructor is passed the number of sides N.
   * @param n is the number of sides
   * @return ShapeBase
   */

  public Shape newShape(int n) {
    shape = new Shape(n);
    return shape;

  }

  /**
   * This class constructor is passed the number of sides N, the radius of the
   * circumscribed circle, and a vertex for the center.
   * @param n is the number of sides
   * @param r is the radius of the circumscribed circle
   * @param c is the center point of the circle
   * @return ShapeBase
   */

  public Shape newShape(int n, double r, Vertex c) {
    shape = new Shape(n, r, c);
    return shape;

  }

  /**
   * Returns the shape object attached to truck
   * @return ShapeBase
   *
   */
  public Shape getShape() {
    return shape;
  }

  /**
   *
   * @param depotXVal double
   */
  public void setDepotX(double depotXVal) {
    depotX = depotXVal;
  }

  /**
   *
   * @return double
   */
    public double getDepotX() {
    return depotX;
  }

  /**
   *
   * @param depotYVal double
   */
    public void setDepotY(double depotYVal) {
    depotY = depotYVal;
  }

  /**
   *
   * @return double
   */
    public double getDepotY() {
    return depotY;
  }


}
