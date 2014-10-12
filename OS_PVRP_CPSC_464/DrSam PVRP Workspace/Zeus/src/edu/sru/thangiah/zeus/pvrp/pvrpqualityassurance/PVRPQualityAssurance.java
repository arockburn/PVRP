//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE
package edu.sru.thangiah.zeus.pvrp.pvrpqualityassurance;


//IMPORTS
import edu.sru.thangiah.zeus.pvrp.PVRPDepotLinkedList;
import edu.sru.thangiah.zeus.pvrp.PVRPShipmentLinkedList;
import edu.sru.thangiah.zeus.pvrp.PVRPShipmentLinkedList.*;
import edu.sru.thangiah.zeus.qualityassurance.QualityAssurance;





//CLASS
public class	PVRPQualityAssurance
				extends QualityAssurance
{

	//***********	CLASS_VARIABLES	**********************************************************************************\\
	PVRPDepotLinkedList mainDepots;
	PVRPShipmentLinkedList mainShipments;
	PVRPQADepotLinkedList pvrpQADepots;
	PVRPQAShipmentLinkedList pvrpQAShipments;


	//***********	DECLARATIONS00	**********************************************************************************\\
	public PVRPQualityAssurance(PVRPDepotLinkedList md, PVRPShipmentLinkedList ms) {
		//used for writing out the files
		mainDepots = md;
		mainShipments = ms;
		//used for reading in the information
		pvrpQAShipments = new PVRPQAShipmentLinkedList();
		pvrpQADepots = new PVRPQADepotLinkedList();

		//Write out the information that is in the data structures. This does not read the original file
		//Might need another function that reads in the original files and checks if they are correct

		/** CODE THESE FUNCTIONS */
	//	writeFiles();
	//	readShipmentFile();
	//	readSolutionFile();
	}


	// RUN_QA >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean runQA()
	{
		boolean isGood = true;
		/** @todo CHeck the integrity of the data. That is, are there shipments that are larger than then largest capacity
		 * available trucks */
		//Area all the customer being serviced and are they serviced only once
		System.out.print("Check on all customers being serviced and serviced no more than once:");
		isGood = pvrpQAShipments.customerServicedOnlyOnce(pvrpQADepots);
		if (isGood)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}

		//Check on maximum travel time of truck
		System.out.print("Check on maximum travel time of trucks:");
		isGood = isGood && pvrpQADepots.checkDistanceConstraint();
		/** @todo Need a check to ensure that the constraints of the routes are met - maximum distance and capacity*/
		if (isGood)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}

		//Check on maximum demand of a truck
		System.out.print("Check on maximum demand of trucks:");

		isGood = isGood && pvrpQADepots.checkCapacityConstraint();
		/** @todo Need a check to ensure that the constraints of the routes are met - maximum distance and capacity*/
		if (isGood)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}

		return isGood;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}
