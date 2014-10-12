package edu.sru.thangiah.zeus.pvrp;

//import the parent class
import edu.sru.thangiah.zeus.core.Shipment;

/**
 *
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

public class PVRPShipment
		extends Shipment
		implements java.io.Serializable, java.lang.Cloneable {

private double extraVariable;

public PVRPShipment(){

}


public PVRPShipment(int i, double depotX, double depotY, int i1, int i2, String d, String s) {
}
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
public PVRPShipment(int customerNumber, double xCoordinate, double yCoordinate, double DUMMY, int demand, int frequency, int numberCombinations, int list[], int currentCombination[][])
{
	setIndex(customerNumber);       //set node number
	setxCoord(xCoordinate);         //set x coordinate
	setyCoord(yCoordinate);            //set y coordinate
	setDemand(demand);                //set the demand for the node
	setFrequency(frequency);        //set the visit frequency for the node
	//set


	extraVariable = Math.random();
}


//calls the super in Shipment
public PVRPShipment(int i, float x, float y, int d, int q, int e, int comb,
				   String t,
				   int[] vComb, int[][] cuComb) {
	//super(ind, x, y, d, q, e, comb, t, vComb, cuComb);
	setIndex(i);
	setxCoord(x);
	setyCoord(y);
	setDemand(q);
	//serviceTime = d;

	// frequency = e;
	// noComb = comb;
	setTruckTypeNeeded(t);
	//visitComb = vComb;
	//currentComb = cuComb;
	setIsAssigned(false);
	setIsSelected(false);
	setNext(null);

	//the combinations to be created should not exceed the maximum allowable
	//combination
    /*for (int i = 0; i < noComb; i++) {
      visitComb[i] = vComb[i];
    }*/

	extraVariable = Math.random();
}

//calls the super in shipment
public PVRPShipment(int i, int x, int y, int d, int q, int e, int comb,
				   String t,
				   int[] vComb, int[][] cuComb) {
	//super(ind, x, y, d, q, e, comb, t, vComb, cuComb);
	//serviceTime = d;
	//frequency = e;
	//noComb = comb;
	//visitComb = vComb;
	//currentComb = cuComb;

	setIndex(i);
	setxCoord(x);
	setyCoord(y);
	setDemand(q);
	//serviceTime = d;

	// frequency = e;
	// noComb = comb;
	setTruckTypeNeeded(t);
	//visitComb = vComb;
	//currentComb = cuComb;
	setIsAssigned(false);

	setNext(null);

	//the combinations to be created should not exceed the maximum allowable
	//combination
    /*for (int i = 0; i < noComb; i++) {
      visitComb[i] = vComb[i];
    }*/

	extraVariable = Math.random();
}


public double getExtraVariable() {
	return extraVariable;
}
}
