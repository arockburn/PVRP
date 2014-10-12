package edu.sru.thangiah.zeus.core;

import java.text.DecimalFormat;

/**
 * Stores all of the information about a Carrier.
 * Title: Shipment
 * Description: This class stores all of the information about a Carrier.
 * Copyright: Copyright (c) 2014
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class Carrier
    implements java.io.Serializable, java.lang.Cloneable {
  protected Carrier prev;
  protected Carrier next;
  protected int index;
  
  
  //Added 3/16/2014
  //Carrier information
  protected String carrierCode;
  protected String carrierName;
  protected boolean sendByFax;
  protected boolean sendByEmail;
  protected String areaCode;
  protected String faxNumber;
  protected String emailAddress;
  
  protected String safetyRating;
  protected String safetyRatingDate;
  protected String contractDate;
  protected String insEndDate;
  protected String initBaud;
  protected String normalBaud;
  
  //address
  protected double xCoord; //latitude
  protected double yCoord; //longitude
  protected String addressOne;
  protected String addressTwo;
  protected String state;
  protected String zip;


  /**
   * Default constructor
   */
  /*public Shipment(){
       }*/

  /**
   * Constructor
   * @param i index
   * @param x x-coordinate
   * @param y y-coordinate
   * @param q demand
   * @param d service time
   * @param t truck type
   * @param p pick up point name
   */
  /*public Shipment(int i, float x, float y, float q, float d, String t,
      String p) {
      index = i;
      xCoord = x;
      yCoord = y;
      demand = q;
      serviceTime = d;
      truckTypeNeeded = t;
      pickUpPointName = p;
       }*/

  /**
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


  

  /**
   * Returns the previous shipment in the shipment linked list
   * @return previous shipment
   */
  public Carrier getPrev() {
    return prev;
  }

  /**
   * Returns the next shipment in the shipment linked list
   * @return next shipment
   */
  public Carrier getNext() {
    return next;
  }

  /**
   * Sets the previous shipment in the shipment linked list
   * @param s new previous shipment
   */
  public void setPrev(Carrier s) {
    prev = s;
  }

  /**
   * Sets the next shipment in the shipment linked list
   * @param s new next shipment
   */
  public void setNext(Carrier s) {
    next = s;
  }

  /**
   * Returns the shipment's index
   * @return shipment index
   */
	public int getIndex() {
    return index;
  }

  /**
   * Returns the shipment's x-coordinate
   * @return x-coordinate
   */
  public double getXCoord() {
    return xCoord;
  }

  /**
   * Returns the shipment's y-coordinate
   * @return y-coordinate
   */
  public double getYCoord() {
    return yCoord;
  }



  /**
   * Returns a formatted string of the shipment's information
   * @return shipment string
   */
  /*public String toString() {
    DecimalFormat df = new DecimalFormat("000");

    return "#" + df.format(index) + " pup=" + pickUpPointName + " q=" +
        demand + " (" + xCoord + "," + yCoord + ") serv=" + serviceTime +
        " truck=" + truckTypeNeeded + " assigned=" + isAssigned;
     }
   */
  /**
   * This will make a copy of this shipment and return it. It will not create
   * a copy of the next and prev links, this is the responsibility of the
   * shipment linked list clone() method. This will also not copy the temp
   * demand and temp next variables, so the route containing this shipment
   * must be fully expanded.
   * @return Object clone
   */
  public Object clone() {
    Carrier clonedShipment = new Carrier();

    //clonedShipment.demand = this.demand;
    clonedShipment.index = this.index;
    //clonedShipment.isAssigned = this.isAssigned;
    //clonedShipment.pickUpPointName = this.pickUpPointName;
    //clonedShipment.serviceTime = this.serviceTime;
    //clonedShipment.truckTypeNeeded = this.truckTypeNeeded;
    clonedShipment.xCoord = this.xCoord;
    clonedShipment.yCoord = this.yCoord;

    return clonedShipment;
  }

  /**
   * TDisplay the shipment information
   */

  /* public void displayShipment()
   {
      int i;
      String s;

      System.out.println("Shipment number is " + index);
      System.out.println("  Vertex x is  " + xCoord);
      System.out.println("  Vertex Y is  " + yCoord);
      System.out.println("  Duration is  " + serviceTime);
      System.out.println("  Demand is    " + demand);
      System.out.println("  Frequency is " + frequency);
      System.out.println("  Number of Combinations is " + noComb);
      if (noComb > 0)
      {
         System.out.println("  The combinations are: ");

         for (i = 0; i < noComb; i++) {
            System.out.println("  " + visitComb[i]);
         }
      }
      if(noComb > 0 && currentComb!=null)
      {
         System.out.println("  Current visit Comb: ");
         for(int h=0; h<noComb;h++){
            System.out.print("  ");
            for(int k = 0;k < currentComb[h].length; k++){
              s = Integer.toString(currentComb[h][k]);
              System.out.print(s);
            }
            System.out.println(" ");
          }
          System.out.println("");
      }
    }
   */
}
