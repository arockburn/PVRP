package edu.sru.thangiah.zeus.pvrp;

import edu.sru.thangiah.zeus.core.Attributes;
//import the parent class
import edu.sru.thangiah.zeus.core.Depot;
import edu.sru.thangiah.zeus.core.TruckLinkedList;

/**
 *
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

public class PVRPDepot
		extends Depot
		implements java.io.Serializable, java.lang.Cloneable {

public PVRPDepot() {
	//set the attributes and the truck linked list
	setAttributes (new PVRPAttributes());
	setMainTrucks(new PVRPTruckLinkedList());
}

/**
 * Constructor. Creates the depot
 * @param d depot number
 * @param x x-coordinate
 * @param y y-coordinate
 */
public PVRPDepot(int d, double x, double y) {
	//The x,y and d (index number)
	//super(d, x, y);
	setDepotNum(d);
	setXCoord(x);
	setYCoord(y);

	setAttributes(new PVRPAttributes());
	setMainTrucks(new edu.sru.thangiah.zeus.pvrp.PVRPTruckLinkedList());
}

/**
 * Returns the truck linked list
 * @return main trucks
 */
public PVRPTruckLinkedList getMainTrucks() {
	return (PVRPTruckLinkedList)super.getMainTrucks();
}

/**
 * Returns the next depot in the linked list
 * @return next depot
 */
public PVRPDepot getNext() {
	return (PVRPDepot)super.getNext();
}


public void insertDepotLast(PVRPDepot depot) {

}
}
