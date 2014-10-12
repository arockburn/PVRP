package edu.sru.thangiah.zeus.core;

import java.io.PrintStream;

/**
 * Maintains all of the Shipments of the VRP.
 * Title: ShipmentLinkedList
 * Description: This class maintains all of the Shipments of the VRP.  Further
 *              information about each of the shipments is stored in the Shipment class.
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

/* TO DO
 * 
 * insert first method
 * 
 */
public class ShipmentLinkedList {
  private Shipment head;
  private Shipment tail;
  private int numShipments; //no of pickuppoints
  private int totalDemand;  //total no of customers for all the pickup points

  /**
   * Constructor
   */
  public ShipmentLinkedList() 
  {
	  //head = new Shipment();
      //tail = new Shipment();
      //head.setNext(tail);
	  //tail.setPrev(head);
      //numShipments = 0;
  }
  
  public void linkHeadTail() {
      head.setNext(tail);
	  tail.setPrev(head);
	  head.setPrev(null);
	  tail.setNext(null);
  }
  
  /**
   * Returns the first shipment in the linked list
   * @return first shipment
   */
  public Shipment getHead() {
    return head;
  }

  /**
   * Returns the last shipment in the linked list
   * @return last shipment
   */
  public Shipment getTail() {
    return tail;
  }

  public void setHead(Shipment head) {
	this.head = head;
}

public void setTail(Shipment tail) {
	this.tail = tail;
}

/**
   * Returns the number of shipment in the linked list
   * @return number of shipments
   */
  public int getNumShipments() {
    return numShipments;
  }

  public int getTotalDemand() {
	return totalDemand;
}

public void setTotalDemand(int totalDemand) {
	this.totalDemand = totalDemand;
}

public void setNumShipments(int numShipments) {
	this.numShipments = numShipments;
}

/**
   * Inserts student into last location in the shipment linked list.
   * @param shipment the student to be inserted into the last location of the linked
   * list.
   */
  public boolean insertLast(Shipment shipment) 
  {
	  //route is empty
	  if (head.getNext() == tail) {
		  head.setNext(shipment);
		  tail.setPrev(shipment);
		  shipment.setPrev(head);
		  shipment.setNext(tail);
	  }
	  // the route is not empty
	  else {
		  shipment.setNext(tail);
		  shipment.setPrev(tail.getPrev());
		  tail.getPrev().setNext(shipment);
		  tail.setPrev(shipment);
	  }
	  numShipments++; //increment number of pickup points
	  totalDemand+=shipment.getDemand(); //get the total number of students per pickup point
	  return true; 
  }

  /**
   * find a shipment in the linked list with shipment number as key
   * @param key is the unique address of the shipment
   * @return Shipment Pointer to the located shipment, null if shipment was not found
   */
  public Shipment find(int key) {
    boolean isDiagnostic = false;
    Shipment current = head.getNext();

    while (current.getNext() != tail) {
      if (current.getIndex() == key) {
        break;
      }

      current = current.getNext();
    }

    if (isDiagnostic) {
      System.out.println("found " + current.getIndex());
    }

    return current;
  }

  /**
   * Sets all the isSelected flags to false for all the shipments in the linked
   * list.
   * @return true is all shipments have been cleared.
   */
  public boolean clearAllSelected() {
    Shipment ship = head.getNext();

    while (ship != tail) {
      ship.setIsSelected(false);
      ship = ship.getNext();
    }
    return true;
  }

  /**
   * Returns if all shipments have beenselected  or not
   * @return true- all shipmentsselected, false- all shipments not selected
   */
  public boolean isAllShipsSelected() {
    Shipment ship = head.getNext();

    while (ship != tail) {
      if (ship.getIsSelected() == false) {
        return false;
      }
      else {
        ship = ship.getNext();
      }
    }
    return true;
  }

  /**
   * Returns if all shipments have been assigned or not
   * @return true- all shipments assigned, false- all shipments not assigned
   */
  public boolean isAllShipsAssigned() {
    Shipment ship = head.getNext();

    while (ship != tail) {
      if (ship.getIsAssigned() == false) {
        return false;
      }
      else {
        ship = ship.getNext();
      }
    }
    return true;
  }

  /**
   * Calculate the polar coordinate angle between two points
   * @param x1 x coordinate of first point
   * @param y1 y coordinate of first point
   * @param x x coordinate of second point
   * @param y y coordinate of second point
   * @return double the polar coordinate angle
   */
  protected double calcPolarAngle(double x1, double y1, double x, double y) {
    //find the polar coordinate angle between (x1,y1) and (x,y)
    double radian = 57.29578;
    double slope = 0;
    double xrun;
    double yrise;
    double angle;

    xrun = x - x1;
    yrise = y - y1;

    if (xrun > 0) {
      slope = yrise / xrun;

      if (yrise >= 0) {
        angle = Math.atan(slope) * radian;
      }
      else {
        angle = 360 + (Math.atan(slope) * radian);
      }
    }
    else if (xrun == 0) {
      if (yrise >= 0) {
        angle = 90.0;
      }
      else {
        angle = 270.0;
      }
    }
    else {
      slope = yrise / xrun;
      angle = 180 + (Math.atan(slope) * radian);
    }

    return angle;
  }

  /**
   * Calculate the eucledian distance between two points
   * @param x1 x coordinate of first point
   * @param y1 y coordinate of first point
   * @param x2 x coordinate of second point
   * @param y2 y coordinate of second point
   * @return double the euclidean distance
   */
  protected double calcDist(double x1, double x2, double y1, double y2) {
    double d = 0;

    try {
      d = (double) Math.sqrt( (double) ( ( (x2 - x1) * (x2 - x1)) +
                                        ( (y2 - y1) * (y2 - y1))));
    }
    catch (ArithmeticException e) {
      System.out.println(
          "Arithmetic Exception in calculating distance in ShipmentLinkedList " +
          e);
    }
    return d;
  }

  /**
   * Writes the shipments to the print stream
   * @param out PrintStream stream to output to
   */
  public void writeShipments(PrintStream out) {
    out.println(this.numShipments);

    Shipment ship = head.getNext();
    while (ship != tail) {
      out.println(ship.getIndex() + " " + ship.getTruckTypeNeeded() + " " +
                  ship.getDemand() + " " + ship.getXCoord() + " " +
                  //ship.getYCoord() + " " + ship.getPickUpPointName());
                  ship.getYCoord());
      ship = ship.getNext();
    }
  }

  /**
   * retrieves the visit combination for a PTSP
   * Constructor
   * @param combList   vector of combinations
   * @param combIndex  index to the combination
   * @param t          number of days in the planning horizon
   */

  public int[] getCurrentComb(int[] combList, int combIndex, int t) {
    //int combIndex;                   //index of chosen visit comb.
    int combCode;
    int[] decodedComb = new int[t];
    //combIndex = (int)((java.lang.Math.random()*a) + 1);
    //System.out.println("combIndex: " + combIndex);
    combCode = combList[combIndex];
    decodedComb = decodeTheComb(combCode, t);
    return decodedComb;

  }

  /**
   * decodes the visit combination from an int to array of 1's and 0's rep days
   * equivalent to bit pattern of code ex: 15 = 1111
   * code = int to decode, t = #of days in planning horizon
   * Constructor
   * @param i integer to decode
   * @param t number of days in planning horizon
   */

  public int[] decodeTheComb(int code, int t) {
    int num = code;
    int quot = -1; //initialize quotient to enter while
    int rem; //remainder
    //replace num with code
    int[] tempArray = new int[t];
    int[] decode = new int[t];
    int count = 0;
    int numDays = t; //#days in planning horizon
    while (quot != 0) {
      quot = num / 2;
      rem = num % 2;
      //System.out.println("quot "+quot);
      //System.out.println("rem "+rem);
      tempArray[count] = rem;
      count++;
      num = quot;
    }
    //reverse temp and store in decode
    for (int b = 0; b < t; b++) {
      decode[b] = tempArray[--numDays];
      //print array
      //for(int b=0; b<t; b++)
      //System.out.print(b + " : " +decode[b]+"  ");
      //System.out.println("");
    }
    return decode;

  } // end decodeTheComb

  /**
   * insert the shipment into the linked list
   * Constructor
   * @param ind index
   * @param x x-coordinate
   * @param y y-coordinate
   * @param q demand
   * @param d service time
   * @param e frequency
   * @param comb number of combination
   * @param vComb list of combinations (vector)
   * @param cuComb number of combinations (matrix)
   */

  /* public void insertShipment(int num, float x, float y, int q, int d, int e,int comb,String type,
                       int[] vComb, int[][] cuComb)
   {
       if (vComb.length <= ProblemInfo.MAX_COMBINATIONS)
       {
         //create an instance of the Shipment
   Shipment thisShip = new Shipment(num, x, y, d, q, e, comb, type, vComb, cuComb);
         //add the instance to the linked list - in this case it iis added at the end of the list
         //the total number of shipments is incremented in the insert
         insertLast(thisShip);
       }
       else
         System.out.println("ShipmentLinkedList: Maximum number of combinations exceeded");
   }*/

  /**
   * insert the shipment into the linked list
   * Constructor
   * @param ind index
   * @param x x-coordinate
   * @param y y-coordinate
   * @param q demand
   * @param d service time
   * @param e frequency
   * @param comb number of combination
   * @param vComb list of combinations (vector)
   * @param cuComb number of combinations (matrix)
   */

  /*public void insertShipment(int num, int x, int y, int q, int d, int e,int comb, String type,
                      int[] vComb, int[][] cuComb)
     {
      if (vComb.length <= ProblemInfo.MAX_COMBINATIONS)
      {
        //create an instance of the Shipment
   Shipment thisShip = new Shipment(num, x, y, d, q, e, comb, type, vComb, cuComb);
        //add the instance to the linked list - in this case it iis added at the end of the list
        //the total number of shipments is incremented in the insert
        insertLast(thisShip);
      }
      else
        System.out.println("ShipmentLinkedList: Maximum number of combinations exceeded");
     }*/


  /**
   * Display the linked list of shipments from first to last
   */

 /* public void displayForwardList() {
    System.out.print("List (first to last): ");
    Shipment current = head.getNext();
    while (current != tail) {
      //current.displayShipment();
      current = current.getNext();
    }
    System.out.println("");
  }*/

  /**
   * Display the linked list of shipments from last to first
   */
  public void displayBackwardList() {
    System.out.print("List (last to first): ");
    Shipment current = tail;
    while (current != head.getNext()) {
      //current.displayShipment();
      current = current.getPrev();

    }
    System.out.println("");
  }

  /**
   * check if the linked list is empty
   * @return boolean
   */
  public boolean isEmpty() {
    return (head.getNext() == null);
  }

  /**
   * delete the first shipment from the linked list
   * @return Shipment
   */

  /*  public Shipment deleteFirst()
    {
      boolean isDiagnostic=false;
      Shipment temp = head;

      //check for empty list
      if (isEmpty())
        return null;           //return null, if empty

      if(head.getNext() == null)    //if only one item in linked list
        tail = null;            //null <- last
      else
        head.getNext().getPrev() = null;  //null <- old next
      head = head.getNext();       //first -> old next
      temp.getNext() = null;         //ground pointer
      countShipments--;            //decrement number of shipments
      if (isDiagnostic)
         System.out.println("deleted "+ temp.getShipNo());
      return temp;              //return deleted node
    }
   */
  /**
   * delete the last shipment from the linked list
   * @return Shipment
   */

  /*  public Shipment deleteLast()
    {
      boolean isDiagnostic=false;
      Shipment temp = last;
      //check for empty list
      if (isEmpty())
        return null;            //if empty, return null

      if(first.next == null)    //if only one item in linked list
        first = null;           //null <- first
      else
        last.prev.next = null;  //old prev -> null
      last = last.prev;         //old prev -> last
      temp.next = null;         //ground pointer
      countShipments--;            //decrement number of shipments
      if (isDiagnostic)
         System.out.println("deleted "+ temp.getShipNo());
      return temp;              //return deleted node
    }

   */

}
