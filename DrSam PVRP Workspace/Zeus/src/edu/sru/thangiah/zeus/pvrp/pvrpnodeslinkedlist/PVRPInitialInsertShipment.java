package edu.sru.thangiah.zeus.pvrp.pvrpnodeslinkedlist;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.pvrp.PVRPNodes;
import edu.sru.thangiah.zeus.pvrp.PVRPShipment;

public class PVRPInitialInsertShipment
extends PVRPNodesLinkedList {
	public boolean getInsertShipment(PVRPNodesLinkedList currNodeLL,
			PVRPShipment theShipment) {

		PVRPNodes tmpPtr;
		//currNodeLL is the reference to the current node linked list being considered for insertion
		//theShipment is the shipment to be inserted
		PVRPNodes theCell = new PVRPNodes(theShipment);

		// the route is empty
		if (currNodeLL.getHead().getNext() == currNodeLL.getTail()) {
			currNodeLL.setHeadNext(theCell);
			currNodeLL.getTail().setPrev(theCell);
			theCell.setPrev(currNodeLL.getHead());
			theCell.setNext(currNodeLL.getTail());

			//print out current route
			/*{
  System.out.println("Printing PVRPNodesLinkedList");
  PVRPNodes tempPtr= (PVRPNodes)currNodeLL.getHead();
  while (tempPtr != (PVRPNodes)currNodeLL.getTail())
  {
	  System.out.println("Node number and Demand is:"+tempPtr.getIndex()+" "+tempPtr.getDemand());
	  tempPtr = tempPtr.getPVRPNext();
  }
  System.out.println("Done Printing");    	  
}*/

			//if its not feasible, return route to what it was and return false
			if (!currNodeLL.getFeasibility().isFeasible()) {
				//remove the inserted node
				tmpPtr = (PVRPNodes) currNodeLL.getHead().getNext();
				tmpPtr.setNext(null);
				tmpPtr.setPrev(null);

				//point the head and tail to each other
				currNodeLL.setHeadNext(currNodeLL.getTail());
				currNodeLL.getTail().setPrev(currNodeLL.getHead());

				//print out current route
				/*{
	  System.out.println("Printing Undo PVRPNodesLinkedList");
	  PVRPNodes tempPtr= (PVRPNodes)currNodeLL.getHead();
	  while (tempPtr != (PVRPNodes)currNodeLL.getTail())
	  {
		  System.out.println("Node number and Demand is:"+tempPtr.getIndex()+" "+tempPtr.getDemand());
		  tempPtr = tempPtr.getPVRPNext();
	  }
	  System.out.println("Done Printing");    	  
}*/

				return false;
			}
		}
		// the route is not empty
		else {
			double cost = Double.MAX_VALUE;
			PVRPNodes costCell = null; //cell after which the new cell was inserted to achieve cost

			PVRPNodes prevCell = (PVRPNodes) currNodeLL.getHead();
			PVRPNodes nextCell = (PVRPNodes) currNodeLL.getHead().getNext();

			while (nextCell != currNodeLL.getTail()) {
				//insert the cell after current prevCell
				prevCell.setNext(theCell);
				theCell.setPrev(prevCell);
				theCell.setNext(nextCell);
				nextCell.setPrev(theCell);

				//check to see if the new route is feasible
				if (currNodeLL.getFeasibility().isFeasible()) {
					//calculate the cost
					double tempCost = ProblemInfo.nodesLLLevelCostF.getTotalCost(
							currNodeLL);

					//decide if this cell should be saved
					if (tempCost < cost) {
						cost = tempCost;
						costCell = prevCell;
					}
				}
				//remove the new cell
				prevCell.setNext(nextCell);
				nextCell.setPrev(prevCell);
				theCell.setNext(null);
				theCell.setPrev(null);

				//set prevCell and nextCell to the next cells in linked list
				prevCell = nextCell;
				nextCell = (PVRPNodes) prevCell.getNext();
				//print out current route
				/*{
	  System.out.println("Printing PVRPNodesLinkedList");
	  PVRPNodes tempPtr= (PVRPNodes)currNodeLL.getHead();
	  while (tempPtr != (PVRPNodes)currNodeLL.getTail())
	  {
		  System.out.println("Node number and Demand is:"+tempPtr.getIndex()+" "+tempPtr.getDemand());
		  tempPtr = tempPtr.getPVRPNext();
	  }
	  System.out.println("Done Printing");    	  
}*/
			}



			if (costCell != null) {
				prevCell = costCell;
				nextCell = (PVRPNodes) prevCell.getNext();
				prevCell.setNext(theCell);
				theCell.setPrev(prevCell);
				theCell.setNext(nextCell);
				nextCell.setPrev(theCell);
			}
			else {
				return false;
			}
		}

		theShipment.setIsAssigned(true);
		ProblemInfo.nodesLLLevelCostF.calculateTotalsStats(currNodeLL);

		{
			System.out.println("Route is:");
			PVRPNodes tempPtr= (PVRPNodes)currNodeLL.getHead();
			while (tempPtr != (PVRPNodes)currNodeLL.getTail())
			{
				System.out.print(tempPtr.getIndex()+"("+tempPtr.getDemand()+")-");
				tempPtr = tempPtr.getPVRPNext();
			}
			System.out.println();
		}

		return true;
	}

	//The WhoAmI methods gives the id of the assigned object
	//It is a static method so that it can be accessed without creating an object
	public static String WhoAmI() {
		return ("Insertion Type: Initial insertion heuristic");
	}
}

