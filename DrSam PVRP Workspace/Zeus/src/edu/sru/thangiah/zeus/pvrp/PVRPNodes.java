package edu.sru.thangiah.zeus.pvrp;

//import the parent class
import edu.sru.thangiah.zeus.core.Nodes;

/**
 *
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

public class PVRPNodes
		extends Nodes
		implements java.io.Serializable, java.lang.Cloneable {


private PVRPNodes PVRPNext;

public PVRPNodes() {
}

/**
 * Constructor
 * @param s shipment conatining this cells information
 */
public PVRPNodes(PVRPShipment s) {
	//super(s);
	theShipment = s;
}

/**
 * Returns the next point cell in the linked list
 * @return next point cell
 */
public PVRPNodes getPPVRPNext() {
	return (PVRPNodes) next;
}

/**
 * Creates a copy of this node and returns it. It will not create the next
 * and prev links, because this would cause infinate recursion. These are
 * set in the nodes linked list clone() function.
 * @return Object node clone
 */
public Object clone() {
	PVRPNodes clonedNode = new PVRPNodes();

	clonedNode.theShipment = (PVRPShipment)this.theShipment.clone();

	return clonedNode;
}

public PVRPNodes getPVRPNext() {
	return PVRPNext;
}
}
