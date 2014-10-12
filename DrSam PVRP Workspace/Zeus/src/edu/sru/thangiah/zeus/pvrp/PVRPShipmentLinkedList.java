package edu.sru.thangiah.zeus.pvrp;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * <p>Title:</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */


//import the parent class
import edu.sru.thangiah.zeus.core.ShipmentLinkedList;
import edu.sru.thangiah.zeus.core.Shipment;
import edu.sru.thangiah.zeus.core.ProblemInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PVRPShipmentLinkedList
		extends ShipmentLinkedList
		implements java.io.Serializable, java.lang.Cloneable {


/**
 * Constructor for the shipment linked list
 * Define it as below
 */
public PVRPShipmentLinkedList()
{
	setHead(new PVRPShipment()); //header node for head
	setTail(new PVRPShipment()); //tail node for tail
	linkHeadTail();			  //point head and tail to each other
	setNumShipments(0);
}


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


//INSERT_SHIPMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public void insertShipment(int node, double x, double y, double DUMMY, int demandQ, int frequency, int numberCombos,
						   int[] comboList, int[][] currentCombo)
{
	if (comboList.length <= ProblemInfo.MAX_COMBINATIONS)
	{
		//create an instance of the Shipment
		PVRPShipment thisShip = new PVRPShipment(node, x, y, DUMMY, demandQ, frequency, numberCombos, comboList, currentCombo);
		//add the instance to the linked list - in this case it is added at the end of the list
		//the total number of shipments is incremented in the insert
		insertLast(thisShip);
	} else
	{
		System.out.println("PVRPShipmentLinkedList: Maximum number of combinations exceeded");
	}
}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



/**
 * Returns the first shipment in the linked list
 * @return first shipment
 */
public PVRPShipment getPVRPHead() {
	return (PVRPShipment) getHead();
}

/**
 * Returns the tail shipment in the linked list
 * @return first shipment
 */
public PVRPShipment getPVRPTail() {
	return (PVRPShipment) getTail();
}


/**
 * This method will get the next shipment that is to be inserted based on the
 * type of shipment selection that has been defined in the main method
 * for the variable ProblemInfo.selectShipType
 * @param currDepot current depot being considered for the shipment
 * @param currDepotLL Depot linked list of the problem being solved
 * @param currShipmentLL shipment linked list from which the shipment to be
 * insertion is to be selected
 * @return PVRPShipment the shipment to be inserted
 */

public PVRPShipment getNextInsertShipment(PVRPDepotLinkedList currDepotLL,
										 PVRPDepot currDepot,
										 PVRPShipmentLinkedList currShipmentLL,
										 PVRPShipment currShip) {

	PVRPShipmentLinkedList selectShip = (PVRPShipmentLinkedList) ProblemInfo.
																	   selectShipType;


	return selectShip.getSelectShipment(currDepotLL, currDepot, currShipmentLL,currShip);
}

/**
 * This is a stub - Leave it as it is
 * The concrere getSelectShipment will be declared by the class inheriting this
 * class and implementing the actual insertion of shipment  *
 * @param currShipmentLL shipment linked list from which the shipment to be
 * insertion is to be selected
 * @return PVRPShipment the shipment to be inserted
 */

public PVRPShipment getSelectShipment(PVRPDepotLinkedList currDepotLL,
									 PVRPDepot currDepot,
									 PVRPShipmentLinkedList currShipmentLL,
									 PVRPShipment currShip) {
	return null;
}



/**
 * Print out the shipment linked list to the console
 * @param out PrintStream stream to output to
 *///PRINT_PVRP_SHIPMENTS_TO_CONSOLE	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public void printPVRPShipmentsToConsole()
{
	System.out.println(this.getNumShipments());

	Shipment ship = super.getHead();
	PVRPShipment PVRPShip;

	while (ship != getTail())
	{
		PVRPShip = (PVRPShipment) ship;
		System.out.println(PVRPShip.getIndex() + " " + PVRPShip.getTruckTypeNeeded() + " " +
								   PVRPShip.getDemand() + " " + PVRPShip.getXCoord() + " " +
								   //ship.getYCoord() + " " + ship.getPickUpPointName() +
								   PVRPShip.getYCoord() + " " +
								   PVRPShip.getYCoord() + " " +
								   PVRPShip.getExtraVariable()) ;
		ship = ship.getNext();
	}
}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


/**
 * Writes the shipments to the print stream
 * @param out PrintStream stream to output to
 */
//WRITE_PVRP_SHIPMENTS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public void writePVRPShipments(FileOutputStream out) throws IOException
{

	//VARIABLES
	Shipment ship = super.getHead();		//the linked list head

	PVRPShipment PVRPShip;

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Customer Data");	//create a worksheet




	int rowCounter = 0;		//tracks our rows
	int previousGetIndex = -10;

	while (ship != getTail())								//while we aren't at the tail of the doubly linked list
	{
		PVRPShip = (PVRPShipment) ship;

		ship = ship.getNext();								//get the next shipment


		Row row = sheet.createRow(rowCounter);		//make a new row
		int cellTracker = 0;						//tracks which cell we are currently at


		while (cellTracker != 5)					//while we haven't written all the cells for the given row
		{
			Cell cell = row.createCell(cellTracker);	//create new cell number X
			switch (cellTracker)						//SWITCH statement
			{
				case 0:
					cell.setCellValue(PVRPShip.getIndex());	//set each cell value to the correct value from the linked list
					break;
				case 1:
					cell.setCellValue(PVRPShip.getxCoord());
					break;
				case 2:
					cell.setCellValue(PVRPShip.getyCoord());

					break;
				case 3:
					cell.setCellValue(PVRPShip.getDemand());
					break;
				case 4:
					cell.setCellValue(PVRPShip.getFrequency());
					break;
				/**        case 5:								??????????????????????????MUST IMPLEMENT FOR ALL VARIABLES OF PVRP
				 cell.setCellValue(PVRPShip.getExtraVariable());
				 break;
				 case 6:
				 cell.setCellValue(PVRPShip.getIndex());
				 break;
				 case 7:*/
			}
			cellTracker++;			//increment our cell tracker
		}
		rowCounter++;				//move onto the next row


		//System.out.print("A NEW ROW");
	}

	workbook.write(out);
	out.close();

}
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




}



/**
 * Created by joshuasarver on 10/2/14.
 */
class PVRPNextNodeHeuristics     extends PVRPShipmentLinkedList{
	
public PVRPShipment getSelectShipment(PVRPDepotLinkedList currDepotLL,
									 PVRPDepot currDepot,
									 PVRPShipmentLinkedList currShipLL,
									 PVRPShipment currShip) {
	//currDepotLL is the depot linked list of the problem
	//currDepot is the depot under consideration
	//currShipLL is the set of avaialble shipments
	boolean isDiagnostic = false;
	//PVRPShipment temp = (PVRPShipment) getHead(); //point to the first shipment
	PVRPShipment temp = (PVRPShipment) currShipLL.getPVRPHead().getNext(); //point to the first shipment

	PVRPShipment foundShipment = null; //the shipment found with the criteria
	double angle;
	double foundAngle = 360; //initial value
	//double distance;
	//double foundDistance = 200; //initial distance
	double depotX, depotY;
	int type = 2;

	//Get the X and Y coordinate of the depot
	depotX = currDepot.getXCoord();
	depotY = currDepot.getYCoord();

	while (temp != currShipLL.getPVRPTail()) {

		if (isDiagnostic) {
			System.out.println("Temp is "+temp);
			System.out.println("Tail is "+getTail());
			System.out.print("Shipment " + temp.getIndex() + " ");

			if ( ( (temp.getXCoord() - depotX) >= 0) &&
						 ( (temp.getYCoord() - depotX) >= 0)) {
				System.out.print("Quadrant I ");
			}
			else if ( ( (temp.getXCoord() - depotX) <= 0) &&
							  ( (temp.getYCoord() - depotY) >= 0)) {
				System.out.print("Quadrant II ");
			}
			else if ( ( (temp.getXCoord()) <= (0 - depotX)) &&
							  ( (temp.getYCoord() - depotY) <= 0)) {
				System.out.print("Quadrant III ");
			}
			else if ( ( (temp.getXCoord() - depotX) >= 0) &&
							  ( (temp.getYCoord() - depotY) <= 0)) {
				System.out.print("Quadrant VI ");
			}
			else {
				System.out.print("No Quadrant");
			}
		}

		//if the shipment is assigned, skip it
		if (temp.getIsAssigned()) {
			if (isDiagnostic) {
				System.out.println("has been assigned");
			}

			temp = (PVRPShipment) temp.getNext();

			continue;
		}

		angle = calcPolarAngle(depotX, depotX, temp.getXCoord(),
									  temp.getYCoord());

		if (isDiagnostic) {
			System.out.println("  " + angle);
		}

		//check if this shipment should be tracked
		if (foundShipment == null) { //this is the first shipment being checked
			foundShipment = temp;
			foundAngle = angle;
		}
		else {
			if (angle < foundAngle) { //found an angle that is less
				foundShipment = temp;
				foundAngle = angle;
			}
		}
		temp =  (PVRPShipment) temp.getNext();
	}
	return foundShipment; //stub
}

PVRPNextNodeHeuristics(){

}

public static String WhoAmI() {
	return ("Selection Type: PVRP Next Node Heuristics");
}
}

