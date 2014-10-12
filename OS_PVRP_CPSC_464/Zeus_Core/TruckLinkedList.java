package edu.sru.thangiah.zeus.core;

/**
 * Maintains information about the trucks in the parent depot
 * <p>Title: TruckLinkedList</p>
 * <p>Description: Maintains information about the trucks in the parent depot</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class TruckLinkedList
    implements java.io.Serializable,
    java.lang.Cloneable {

  private Truck head;
  private Truck tail;
  private Attributes attributes;

  /**
   * Constructor
   */
  public TruckLinkedList() 
  {
      //head = new Truck();
      //tail = new Truck();
      //head.setNext(tail);
	  //tail.setPrev(head);
      //attributes = new Attributes();
   }

  /**
   * Returns the first truck in the linked list
   * @return first truck
   */
  public Truck getHead() {
	  return head;
  }

  /**
   * Returns the last truck in the linked list
   * @return last truck
   */
  public Truck getTail() {
	  return tail;
  }

  public void setHead(Truck head) {
	  this.head = head;
  }

  public void setTail(Truck tail) {
	  this.tail = tail;
  }

  
  public void linkHeadTail() {
      head.setNext(tail);
	  tail.setPrev(head);
	  head.setPrev(null);
	  tail.setNext(null);
  }
  
  /**
   * calculates the number of trucks in the list
   * @return number of trucks
   */
  public int getSize() {
	  int size = 0;
	  Truck truck = head.getNext();

	  while (truck != tail) {
      size++;
      truck = truck.getNext();
    }

    return size;
  }
  
  public Attributes getAttributes() {
	return attributes;
}

public void setAttributes(Attributes attributes) {
	this.attributes = attributes;
}

/**
   * Inserts truck as last node in the truck linked list
   * @param depot the specified depot to be inserted
   */
//the method was previously called insertLast
  public boolean insertTruckLast(Truck truck) 
  {
		// the route is empty
		    if (head.getNext() == tail) {
		      head.setNext(truck);
		      tail.setPrev(truck);
		      truck.setPrev(head);
		      truck.setNext(tail);
		    }
		    // the route is not empty
		    else {
		    	
		    	truck.setNext(tail);
		    	truck.setPrev(tail.getPrev());
		    	tail.getPrev().setNext(truck);
		    	tail.setPrev(truck);
		    
		    }	
	    return true; 
  }


  /**
   * Will insert a truck into the truck's linked list
   * @param truck the truck to insert
   * @return if it was inserted or not
   */
  /*public boolean insertTruck(Truck truck) {
    Truck currentTruck = head;

    truck.setPrev(null);
    truck.setNext(null);
    if (head == null) {
      //no buses exist in list, insert at head
      tail = head = truck;
      return true;
    }
    else {
      //at least head and last buses exist, loop to find insertion
      currentTruck = head.getNext();

      while (currentTruck != null) {
        if (truck.getTruckNum() < currentTruck.getTruckNum()) {
          currentTruck.getPrev().setNext(truck);
          truck.setPrev(currentTruck.getPrev());
          truck.setNext(currentTruck);
          currentTruck.setPrev(truck);

          return true;
        }
        currentTruck = currentTruck.getNext();
      }
    }
    //put the bus at the end
    tail.setNext(truck);
    truck.setPrev(tail);
    tail = truck;

    return true; //bus is always inserted
 
  } */

  /**
   * Attempts to find a truck given the unique id number
   * @param truckNum the unique truck id number
   * @return the truck if found, else returns null
   */
  public Truck find(int truckNum) {
    Truck currentTruck = head;

    while (currentTruck != null) {
      if (currentTruck.getTruckNum() == truckNum) {
        return currentTruck;
      }
      currentTruck = currentTruck.getNext();
    }
    return null;
  }

  /**
   * Returns the truck at the specified position, null, if not found
   * @param pos int position to find truck at
   * @return Truck truck at the postion
   */
  public Truck getTruckAtPos(int pos) {
    if (pos < 0 || pos > getSize()) {
      return null;
    }
    int count = 0;
    Truck temp = head;
    while (temp != null) {
      if (count == pos) {
        return temp;
      }
      count++;
      temp = temp.getNext();
    }
    return null;
  }

  /**
   * Removes a truck from the truck linked list and returns the previous truck.
   * @param truck the truck to be removed
   * @return the previous truck to the removed truck
   */
  public Truck removeTruck(Truck truck) {
    Truck tempTruck = head;
    Truck prevTruck = null;
    Truck nextTruck = null;

    while (tempTruck != null) {
      if (truck.getTruckNum() == tempTruck.getTruckNum()) {
        prevTruck = truck.getPrev();
        nextTruck = truck.getNext();
        if (truck == head) {
          head = nextTruck;
          if (nextTruck != null) {
            nextTruck.setPrev(null);
          }
          truck.setPrev(null);
          truck.setNext(null);
          return truck;
        }
        if (truck == tail) {
          tail = prevTruck;
          if (prevTruck != null) {
            prevTruck.setNext(null);
          }
          truck.setPrev(null);
          truck.setNext(null);
          return truck;
        }
        if (prevTruck != null) {
          prevTruck.setNext(nextTruck);
        }
        if (nextTruck != null) {
          nextTruck.setPrev(prevTruck);
        }
        truck.setPrev(null);
        truck.setNext(null);
        return truck;
      }
      tempTruck = tempTruck.getNext();
    }
    return null;
  }

  /**
   * When called the method will remove any truck that has a size of 2
   * in other words no shipments assigned to it
   */
  public void removeEmptyTrucks() {
    Truck truck = this.getHead();

    while (truck != null) {
      if (truck.getMainNodes().getSize() == 2) {
        removeTruck(truck);
        ProblemInfo.numTrucks--;
      }

      truck = truck.getNext();
    }
  }


  /**
   * Attempts to insert a shipment into the Truck linked list. Will attempt
   * to insert the shipment into each truck until one is found that can
   * accomodate the shipment
   * @param theShipment the shipment to insert
   * @return true if shipment serviced by a truck, false if not.
   */
  //public boolean insertShipment(Shipment theShipment) {
  //Only here as a place holder for the the mix fleet optimization methods
  //boolean status = false;
  /*
    Truck truck = this.getHead();

    while (truck != null) {
        //only attempt to insert the shipment into trucks that can accept it
        if (truck.compatableWith(theShipment)) {
            status = truck.getMainNodes().insertShipment(theShipment);

            // break out of the loop if a good truck is found.
            if (status) {
                break;
            }
        }

        truck = truck.getNext();
    }

    //can we create new trucks?
    if ((status == false) && (Settings.lockTrucks == false)) {
        //create a pointer to the last truck for referance
        Truck last = this.getTail();

        //loop to find the correct truck type for this customer
        for (int i = 0; i < ProblemInfo.truckTypes.size(); i++) {
            TruckType type = (TruckType) ProblemInfo.truckTypes.elementAt(i);

   if (type.getServiceType().equals(theShipment.getTruckTypeNeeded())) {
                //create a new truck with the truck number of the last + 1, the matching truck type
                //and use the first customer in the last truck (the depot) to get the depot x,y
                Truck newTruck = new Truck(type,
                        last.getMainNodes().getHead().getShipment()
                            .getXCoord(),
                        last.getMainNodes().getHead().getShipment()
                            .getYCoord());

                //attempt to put this shipment into the new truck
                status = newTruck.getMainNodes().insertShipment(theShipment);

                if (status == true) {
                    //the customer was inserted to the new truck, so insert the new truck to the linked list
                    this.insertTruck(newTruck);

                    return status;
                } else {
                    //customer could not be inserted into the new truck so return false
                    //and dont insert the new truck into the linked list (garbage collector
                    //will delete it)
                    return status;
                }
            }
        }
    }
   */
  //return status;
  //}

  /**
   * Returns a clone of this object
   * @return Object clone
   */
  public Object clone() {
    TruckLinkedList clonedTruckLinkedList = new TruckLinkedList();

    clonedTruckLinkedList.attributes = (Attributes)this.attributes.clone();
    clonedTruckLinkedList.head = (Truck)this.head.clone();

    if (this.head != this.tail) {
      Truck currentTruck = clonedTruckLinkedList.head;
      Truck nextTruck = this.getHead().getNext();

      while (nextTruck != null) {
        currentTruck.setNext( (Truck) nextTruck.clone()); //create the next depot
        currentTruck.getNext().setPrev(currentTruck); //set the next depot's prev
        currentTruck = currentTruck.getNext();
        nextTruck = nextTruck.getNext();

        //once next is null, we have found the tail of the list
        if (nextTruck == null) {
          clonedTruckLinkedList.tail = currentTruck;
          currentTruck.setNext(null);
        }

      }
    }
    else { //only 1 depot
      clonedTruckLinkedList.tail = clonedTruckLinkedList.head;
    }

    return clonedTruckLinkedList;
  }
}
