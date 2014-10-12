package edu.sru.thangiah.zeus.pvrp;

import edu.sru.thangiah.zeus.core.ProblemInfo;
//import the parent class
import edu.sru.thangiah.zeus.core.Truck;
import edu.sru.thangiah.zeus.pvrp.pvrpnodeslinkedlist.PVRPNodesLinkedList;

public class PVRPTruck
        extends Truck implements java.io.Serializable, java.lang.Cloneable {
    public PVRPTruck() {

        //Assign the nodes linkes list
        setMainNodes(new PVRPNodesLinkedList());

        //Assign the attributes
        setAttributes(new PVRPAttributes());
    }

    /**
     * Constructor
     * @param tt truck type
     * @param depotX depot's x coordinate
     * @param depotY depot's y coordinate
     */
    public PVRPTruck(PVRPTruckType tt, double depX, double depY) {
        //super(tt, depX, depY);
        setAttributes(new PVRPAttributes());
        setDepotX(depX);
        setDepotY(depY);
        setTruckNum(ProblemInfo.numTrucks++);
        setTruckType(tt);

        setMainNodes(new PVRPNodesLinkedList(tt, depX, depY, getTruckNum()));

    }



    /**
     * Returns the visit nodes linked list (route)
     * @return route
     */
    public PVRPNodesLinkedList getPVRPMainNodes() {
        return (PVRPNodesLinkedList) getMainNodes();
    }

    /**
     * Returns the next depot in the linked list
     * @return next depot
     */
    public PVRPTruck getPVRPNext() {
        return (PVRPTruck) getNext();
    }

    /**
     * Creates a clone of the current trucks. Does not create the next and prev
     * links, that is the responsibility of the truck linked list clone() function
     * @return Object truck clone
     */
    public Object clone() {
        PVRPTruck clonedTruck = new PVRPTruck();

        clonedTruck.setAttributes((PVRPAttributes)this.getAttributes().clone());
        clonedTruck.setDepotX(this.getDepotX());
        clonedTruck.setDepotY(this.getDepotY());
        clonedTruck.setMainNodes((PVRPNodesLinkedList)this.getMainNodes().clone());
        clonedTruck.setTruckNum(this.getTruckNum());
        clonedTruck.setTruckType((PVRPTruckType)this.getTruckType().clone());

        return clonedTruck;
    }

}
