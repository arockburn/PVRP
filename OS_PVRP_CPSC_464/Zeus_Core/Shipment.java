package edu.sru.thangiah.zeus.core;

import java.text.DecimalFormat;

/**
 * Stores all of the information about a Shipment.
 * Title: Shipment
 * Description: This class stores all of the information about a shipment.
 * Copyright: Copyright (c) 2003
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class Shipment
implements java.io.Serializable, java.lang.Cloneable {
	private Shipment prev;
	private Shipment next;
	//link to the partial shipment linked list
	protected ShipmentPartialLinkedList shipParLL;


	private int index;
	private float demand;
	private double xCoord;       //latitude
	private double yCoord;       //longitude
	private String customerType; //customer, depot
	private boolean isPickup;	 //shipment type: pickup - if the pickup and drop off are false, then it is an empty truck
	private boolean isDropOff;	 //shipment type: drop off
	private String dropType;	 //drop, live, backhaul
	private String pickupType;	 //pickup, live
	private float pickupWeight;
	private float pickupVolume;
	private float pickupDim;
	private float dropOffWeight;
	private float dropOffVolume;
	private float dropOffDim;
	private float travelTime;

	private boolean locked; //if the shipment is locked, it cannot be moved between trucks

	//protected float serviceTime;
	private boolean isAssigned; //true if the shipment has been assigned
	private boolean isSelected; //true if the shipment was selected
	private String truckTypeNeeded;

	private String pickUpPointName;
	private int frequency;
	private int noComb;
	private int[] visitComb; //the visit combination for the depots
	private int[][] currentComb; //the binary visit combinations
	
	private Nodes tempNext;
	private int tempDemand;


	protected float serviceTime; 
	protected String pickupPointName;
	protected double polarAngle;
	protected double polarDistance;

	protected int custId;
	protected String roadNo;
	protected String roadName;
	protected double fromLong, fromLat; //from longitude and latitude for the road segment
	protected double toLong, toLat; //from longitude and latitude for the road segment
	protected String fromNodes, toNodes; //Nodes that are connected to the from and to points of the road segment
	
	//default constructor
	public Shipment()
	{
		index = -1;
		prev=null;
		next=null;
	}


	public ShipmentPartialLinkedList getShipParLL() {
		return shipParLL;
	}

	public void setShipParLL(ShipmentPartialLinkedList shipParLL) {
		this.shipParLL = shipParLL;
	}

	public double getxCoord() {
		return xCoord;
	}

	public int getFrequency() {
		return frequency;
	}


	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	public int getNoComb() {
		return noComb;
	}


	public void setNoComb(int noComb) {
		this.noComb = noComb;
	}


	public int[] getVisitComb() {
		return visitComb;
	}


	public void setVisitComb(int[] visitComb) {
		this.visitComb = visitComb;
	}


	public int[][] getCurrentComb() {
		return currentComb;
	}


	public void setCurrentComb(int[][] currentComb) {
		this.currentComb = currentComb;
	}


	public void setPickup(boolean isPickup) {
		this.isPickup = isPickup;
	}


	public void setDropOff(boolean isDropOff) {
		this.isDropOff = isDropOff;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public boolean getIsPickup() {
		return isPickup;
	}

	public void setIsPickup(boolean isPickup) {
		this.isPickup = isPickup;
	}

	public boolean getIsDropOff() {
		return isDropOff;
	}

	public void setIsDropOff(boolean isDropOff) {
		this.isDropOff = isDropOff;
	}

	public String getDropType() {
		return dropType;
	}

	public void setDropType(String dropType) {
		this.dropType = dropType;
	}

	public String getPickupType() {
		return pickupType;
	}

	public void setPickupType(String pickupType) {
		this.pickupType = pickupType;
	}

	public float getPickupWeight() {
		return pickupWeight;
	}

	public String getPickUpPointName() {
		return pickUpPointName;
	}


	public void setPickUpPointName(String pickUpPointName) {
		this.pickUpPointName = pickUpPointName;
	}


	public void setPickupWeight(float pickupWeight) {
		this.pickupWeight = pickupWeight;
	}

	public float getPickupVolume() {
		return pickupVolume;
	}

	public void setPickupVolume(float pickupVolume) {
		this.pickupVolume = pickupVolume;
	}

	public float getPickupDim() {
		return pickupDim;
	}

	public void setPickupDim(float pickupDim) {
		this.pickupDim = pickupDim;
	}

	public float getDropOffWeight() {
		return dropOffWeight;
	}

	public void setDropOffWeight(float dropOffWeight) {
		this.dropOffWeight = dropOffWeight;
	}

	public float getDropOffVolume() {
		return dropOffVolume;
	}

	public void setDropOffVolume(float dropOffVolume) {
		this.dropOffVolume = dropOffVolume;
	}

	public float getDropOffDim() {
		return dropOffDim;
	}

	public void setDropOffDim(float dropOffDim) {
		this.dropOffDim = dropOffDim;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}	
	
	
	
	public float getTravelTime() {

		return travelTime;
	}

	public String getTravelTimeStr() {

		//convert the time to minutes and hours
		String time;
		int minInt;
		double minutes = travelTime * 60;
		int hours = (int)Math.round(minutes)/60;
		minInt = (int)minutes - (hours*60);
		time = String.valueOf(hours)+":"+String.valueOf(minInt);
		return time;
	}

	

	public float getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(float serviceTime) {
		this.serviceTime = serviceTime;
	}

	public double getPolarAngle() {
		return polarAngle;
	}

	public void setPolarAngle(double polarAngle) {
		this.polarAngle = polarAngle;
	}

	public double getPolarDistance() {
		return polarDistance;
	}

	public void setPolarDistance(double polarDistance) {
		this.polarDistance = polarDistance;
	}

	public double getFromLong() {
		return fromLong;
	}

	public void setFromLong(double fromLong) {
		this.fromLong = fromLong;
	}

	public double getFromLat() {
		return fromLat;
	}

	public void setFromLat(double fromLat) {
		this.fromLat = fromLat;
	}

	public double getToLong() {
		return toLong;
	}

	public void setToLong(double toLong) {
		this.toLong = toLong;
	}

	public double getToLat() {
		return toLat;
	}

	public void setToLat(double toLat) {
		this.toLat = toLat;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public void setCustId(int custId) {
		this.custId = custId;
	}

	public void setRoadNo(String roadNo) {
		this.roadNo = roadNo;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public void setFromNodes(String fromNodes) {
		this.fromNodes = fromNodes;
	}

	public void setToNodes(String toNodes) {
		this.toNodes = toNodes;
	}

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


	/* public Shipment(int ind, float x, float y, int d, int q,  int e, int comb,String t,
                  int[] vComb, int [][]cuComb)
      {

     index   = ind;
     xCoord   = x;
     yCoord  = y;
     serviceTime  = d;
     demand    = q;
     frequency = e;
     noComb   = comb;
     truckTypeNeeded = t;
     visitComb = vComb;
     currentComb = cuComb;
     isAssigned = false;
     next = null;

     //the combinations to be created should not exceed the maximum allowable
     //combination
     for (int i = 0; i < noComb; i++){
        visitComb[i] = vComb[i];
     }
      }
   public Shipment(int ind, int x, int y, int d,int q,  int e, int comb,String t,
                int[] vComb, int [][]cuComb)
    {

   index   = ind;
   xCoord   = x;
   yCoord  = y;
   serviceTime  = d;
   demand    = q;
   frequency = e;
   noComb   = comb;
   truckTypeNeeded = t;
   visitComb = vComb;
   currentComb = cuComb;
   isAssigned = false;
   next = null;

   //the combinations to be created should not exceed the maximum allowable
   //combination
   for (int i = 0; i < noComb; i++){
      visitComb[i] = vComb[i];
   }
    }*/


	/**
	 * Returns if the shipment has been assigned or not
	 * @return true- assigned, false- not assigned
	 */
	public boolean getIsAssigned() {
		return isAssigned;
	}

	/**
	 * Returns if the shipment has been selected or not
	 * @return true- assigned, false- not assigned
	 */
	public boolean getIsSelected() {
		return isSelected;
	}

	/**
	 * Sets the shipment as selected or not
	 * @param is true- assigned, false- not assigned
	 */
	public void setIsSelected(boolean is) {
		isSelected = is;
	}

	/**
	 * Sets the shipment to be assigned or not
	 * @param is true- assigned, false- not assigned
	 */
	public void setIsAssigned(boolean is) {
		isAssigned = is;
	}

	/**
	 * Returns the previous shipment in the shipment linked list
	 * @return previous shipment
	 */
	public Shipment getPrev() {
		return prev;
	}

	/**
	 * Returns the next shipment in the shipment linked list
	 * @return next shipment
	 */
	public Shipment getNext() {
		return next;
	}

	/**
	 * Sets the previous shipment in the shipment linked list
	 * @param s new previous shipment
	 */
	public void setPrev(Shipment s) {
		prev = s;
	}

	/**
	 * Sets the next shipment in the shipment linked list
	 * @param s new next shipment
	 */
	public void setNext(Shipment s) {
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
	 * Returns the demand of this shipment
	 * @return demand
	 */
	public int getDemand() {
		return (int) demand;
	}

	/**
	 * Sets the demand of this shipment
	 * @param d new demand
	 */
	public void setDemand(int d) {
		demand = d;
	}

	public int getTempDemand() {
		return tempDemand;
	}


	public void setTempDemand(int tempDemand) {
		this.tempDemand = tempDemand;
	}


	public Nodes getTempNext() {
		return tempNext;
	}


	public void setTempNext(Nodes tempNext) {
		this.tempNext = tempNext;
	}


	/**
	 * Returns the truck type needed for this shipment
	 * @return needed truck type
	 */
	public String getTruckTypeNeeded() {
		return truckTypeNeeded;
	}

	/**
	 * Returns the pickup point name for the shipment
	 *
	 */

	public String getPickupPointName() {
		return pickupPointName;
	}


	public void setPickupPointName(String pickupPointName) {
		this.pickupPointName = pickupPointName;
	}


	public int getCustId() {
		return custId;
	}


	public String getRoadNo() {
		return roadNo;
	}


	public String getRoadName() {
		return roadName;
	}


	public String getFromNodes() {
		return fromNodes;
	}


	public String getToNodes() {
		return toNodes;
	}


	public void setDemand(float demand) {
		this.demand = demand;
	}


	public void setTravelTime(float travelTime) {
		this.travelTime = travelTime;
	}


	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}


	public void setTruckTypeNeeded(String truckTypeNeeded) {
		this.truckTypeNeeded = truckTypeNeeded;
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
		Shipment clonedShipment = new Shipment();

		clonedShipment.demand = this.demand;
		clonedShipment.index = this.index;
		clonedShipment.isAssigned = this.isAssigned;
		//clonedShipment.pickUpPointName = this.pickUpPointName;
		//clonedShipment.serviceTime = this.serviceTime;
		clonedShipment.truckTypeNeeded = this.truckTypeNeeded;
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
