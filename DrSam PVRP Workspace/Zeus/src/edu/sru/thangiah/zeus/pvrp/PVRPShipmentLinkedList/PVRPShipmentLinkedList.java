//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE
package edu.sru.thangiah.zeus.pvrp.PVRPShipmentLinkedList;


//IMPORTS
import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.core.Shipment;
import edu.sru.thangiah.zeus.core.ShipmentLinkedList;
import edu.sru.thangiah.zeus.pvrp.PVRPDepot;
import edu.sru.thangiah.zeus.pvrp.PVRPDepotLinkedList;
import edu.sru.thangiah.zeus.pvrp.PVRPShipment;

import java.io.PrintStream;
import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.pvrp.PVRPShipmentLinkedList.PVRPShipmentLinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;


//CLASS
public class PVRPShipmentLinkedList
		extends ShipmentLinkedList
		implements java.io.Serializable, java.lang.Cloneable
{


	//***********	DECLARATION_S	**********************************************************************************\\
	public PVRPShipmentLinkedList()
	{
		setTail(new PVRPShipment());
		setHead(new PVRPShipment());
		linkHeadTail();
		setNumShipments(0);
	}



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
			System.out.println("VRPShipmentLinkedList: Maximum number of combinations exceeded");
		}
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//GET_PVRP_HEAD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public PVRPShipment getPVRPHead()
	{
		return (PVRPShipment) getHead();
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//GET_PVRP_TAIL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public PVRPShipment getPVRPTail(){	return (PVRPShipment) getTail();	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//GET_NEXT_INSERT_SHIPMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public PVRPShipment getNextInsertShipment(PVRPDepotLinkedList currDepotLL, PVRPDepot currDepot,
											  PVRPShipmentLinkedList currShipmentLL, PVRPShipment currShip)
	{
		PVRPShipmentLinkedList selectShip = (PVRPShipmentLinkedList) ProblemInfo.selectShipType;

		return selectShip.getSelectShipment(currDepotLL, currDepot, currShipmentLL, currShip);
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//GET_SELECT_SHIPMENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public PVRPShipment getSelectShipment(PVRPDepotLinkedList currDepotLL, PVRPDepot currDepot,
										  PVRPShipmentLinkedList currShipmentLL, PVRPShipment currShip)
	{
		return null;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//PRINT_PVRP_SHIPMENTS_TO_CONSOLE	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void printPVRPShipmentsToConsole()
	{
		System.out.println(this.getNumShipments());

		Shipment ship = super.getHead();
		PVRPShipment pvrpShip;

		while (ship != getTail())
		{
			pvrpShip = (PVRPShipment) ship;
			System.out.println(pvrpShip.getIndex() + " " + pvrpShip.getTruckTypeNeeded() + " " +
					pvrpShip.getDemand() + " " + pvrpShip.getXCoord() + " " +
					//ship.getYCoord() + " " + ship.getPickUpPointName() +
					pvrpShip.getYCoord() + " " +
					pvrpShip.getYCoord() + " " +
					pvrpShip.getExtraVariable()) ;
			ship = ship.getNext();
		}
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//WRITE_PVRP_SHIPMENTS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void writePVRPShipments(FileOutputStream out) throws IOException
	{

		//VARIABLES
		Shipment ship = super.getHead();		//the linked list head

		PVRPShipment pvrpShip;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Customer Data");	//create a worksheet




		int rowCounter = 0;		//tracks our rows
		int previousGetIndex = -10;

		while (ship != getTail())								//while we aren't at the tail of the doubly linked list
		{
			pvrpShip = (PVRPShipment) ship;

			ship = ship.getNext();								//get the next shipment


			Row row = sheet.createRow(rowCounter);		//make a new row
			int cellTracker = 0;						//tracks which cell we are currently at


			while (cellTracker != 5)					//while we haven't written all the cells for the given row
			{
				Cell cell = row.createCell(cellTracker);	//create new cell number X
				switch (cellTracker)						//SWITCH statement
				{
					case 0:
						cell.setCellValue(pvrpShip.getIndex());	//set each cell value to the correct value from the linked list
						break;
					case 1:
						cell.setCellValue(pvrpShip.getxCoord());
						break;
					case 2:
						cell.setCellValue(pvrpShip.getyCoord());

						break;
					case 3:
						cell.setCellValue(pvrpShip.getDemand());
						break;
					case 4:
						cell.setCellValue(pvrpShip.getFrequency());
						break;
					/**        case 5:								??????????????????????????MUST IMPLEMENT FOR ALL VARIABLES OF PVRP
					 cell.setCellValue(pvrpShip.getExtraVariable());
					 break;
					 case 6:
					 cell.setCellValue(pvrpShip.getIndex());
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

