package edu.sru.thangiah.zeus.core;

/**
 * Maintains information on the depots from which trucks service customers.
 * <p>Title: Depot</p>
 * <p>Description: This class implements the Depot class. The Depot class maintains
 * information on the depots from which trucks service customers. The Depot class
 * is used by the DepotLinkedList class.</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0

 */
public class Depot
    implements java.io.Serializable, java.lang.Cloneable {
  private Depot next;
  private Depot prev;
  private  TruckLinkedList mainTrucks;
  private  int depotNum;
  private  double xCoord;
  private  double yCoord;
  private  Attributes attributes;

  private  String startLoc; //starting location name
  private  double startX; //longitude of starting location
  private  double startY; //latitude of starting location
  private  String endLoc; //ending location name
  private  double endX; //longitude of ending location
  private  double endY; //latitude of ending location

  /**
   * Default constructor
   */

  /**
   * Constructor. Creates the depot
   *
   */
  public Depot() {
	  prev = null;
	  next = null;
      depotNum = -1;
      xCoord = -1;
      yCoord = -1;
      //attributes = new Attributes();
      //mainTrucks = new TruckLinkedList();
   }
  
  /**
   * Constructor. Creates the depot
   * @param d depot number
   * @param x x-coordinate
   * @param y y-coordinate
   */
  public Depot(int d, float x, float y) {
      depotNum = d;
      xCoord = x;
      yCoord = y;
      attributes = new Attributes();
      mainTrucks = new TruckLinkedList();
   }

  /**
   * Returns the previous depot in the linked list
   * @return previous depot
   */
  public Depot getPrev() {
    return prev;
  }

  /**
   * Returns the next depot in the linked list
   * @return next depot
   */
  public Depot getNext() {
    return next;
  }

  /**
   * Sets the previous depot in the linked list
   * @param d new previous depot
   */
  public void setPrev(Depot d) {
    prev = d;
  }

  /**
   * Sets the next depot in the linked list
   * @param d new next depot
   */
  public void setNext(Depot d) {
    next = d;
  }

  /**
   * Returns the truck linked list
   * @return main trucks
   */
  public TruckLinkedList getMainTrucks() {
    return mainTrucks;
  }

  /**
   * Restores the truck linked list
   * @param tll TruckLinkedList the new truck linked list
   */
  public void setMainTrucks(TruckLinkedList tll) {
    mainTrucks = tll;
  }

  /**
   * Returns the depot's x-coordinate
   * @return x-coordinate
   */
  public double getXCoord() {
    return xCoord;
  }

  /**
   * Set's the depot's x-coordinate
   */
  public void setXCoord(double Xc) {
    xCoord = Xc;
  }

  /**
   * Returns the depots y-coordinate
   * @return y-coordinate
   */
  public double getYCoord() {
    return yCoord;
  }

  /**
   * Set's the depot's y-coordinate
   */
  public void setYCoord(double Yc) {
    yCoord = Yc;
  }

  /**
   * Returns the depot's number
   * @return depot number
   */
  public int getDepotNum() {
    return depotNum;
  }

  /**
   * Set's the depot's number
   */
  public void setDepotNum(int dNum) {
    depotNum = dNum;
  }

  /**
   * Returns the starting location
   * @return starting location
   */
  public String getStartLoc() {
    return startLoc;
  }

  /**
   * Set's the starting location
   */
  public void setStartLoc(String sLoc) {
    startLoc = sLoc;
  }

  /**
   * Returns the starting location longitude
   * @return starting location longitude
   */
  public double getStartY() {
    return startY;
  }

  /**
   * Set's starting location longitude
   */
  public void setStartY(float sLocLong) {
    startY = sLocLong;
  }

  /**
   * Returns the starting location latitude
   * @return starting location latitude
   */
  public double getStartX() {
    return startX;
  }

  /**
   * Set's starting location latitude
   */
  public void setStartX(float sLocLat) {
    startX = sLocLat;
  }

  /**
   * Returns the ending location
   * @return ending location
   */
  public String getEndLoc() {
    return endLoc;
  }

  /**
   * Set's the ending location
   */
  public void setEndLoc(String eLoc) {
    endLoc = eLoc;
  }

 /**
  * Returns the ending location longitude
  * @return ending location longitude
  */
 public double getEndY() {
   return endY;
 }

 /**
  * Set's ending location longitude
  */
 public void setEndY(float eLocLong) {
   endY = eLocLong;
 }

 /**
  * Returns the ending location latitude
  * @return ending location latitude
  */
 public double getEndX() {
   return endX;
 }

 /**
  * Set's ending location latitude
  */
 public void setEndXt(float eLocLat) {
   endX = eLocLat;
 }

  public double getxCoord() {
	return xCoord;
}

public void setxCoord(double xCoord) {
	this.xCoord = xCoord;
}

public double getyCoord() {
	return yCoord;
}

public void setyCoord(double yCoord) {
	this.yCoord = yCoord;
}

public Attributes getAttributes() {
	return attributes;
}

public void setAttributes(Attributes attributes) {
	this.attributes = attributes;
}

public void setStartX(double startX) {
	this.startX = startX;
}

public void setStartY(double startY) {
	this.startY = startY;
}

public void setEndX(double endX) {
	this.endX = endX;
}

public void setEndY(double endY) {
	this.endY = endY;
}

/**
   * Returns a string containing the information about the depot
   * @return depot string
   */
  public String toString() {
    return "#" + depotNum + " (" + xCoord + ", " + yCoord + ")" +
        attributes;
  }

  /**
   * This will return a clone of this depot.
   *
   * CAUTION: This method will not establish the next and prev links, due to
   * recursion issues, that is the responsibility of the depot linked list
   * clone function.
   * @return Object
   */
  public Object clone() {
    Depot clonedDepot = new Depot();

    clonedDepot.depotNum = this.depotNum;
    clonedDepot.xCoord = this.xCoord;
    clonedDepot.yCoord = this.yCoord;
    clonedDepot.attributes = (Attributes)this.attributes.clone();
    clonedDepot.mainTrucks = (TruckLinkedList)this.mainTrucks.clone();

    return clonedDepot;
  }
}
