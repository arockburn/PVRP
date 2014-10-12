package edu.sru.thangiah.zeus.pvrp;

import edu.sru.thangiah.zeus.core.DaysLinkedList;

/**
 * Created by jks1010 on 10/2/2014.
 */
public class PVRPDaysLinkedList
            extends DaysLinkedList
            implements java.io.Serializable, java.lang.Cloneable
{

public PVRPDaysLinkedList(){
    setHead(new PVRPNodes());
    setTail(new PVRPNodes());
    linkHeadTail();



}

private void setTail(PVRPNodes pvrpNodes) {

}

private void setHead(PVRPNodes pvrpNodes) {

}


}
