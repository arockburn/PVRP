//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE
package edu.sru.thangiah.zeus.pvrp.pvrpqualityassurance;


//IMPORTS
import edu.sru.thangiah.zeus.qualityassurance.QAShipmentLinkedList;




//CLASS
public class 	PVRPQAShipmentLinkedList
				extends QAShipmentLinkedList
				implements java.io.Serializable, java.lang.Cloneable
{

	//***********	DECLARATION_S	**********************************************************************************\\
	public PVRPQAShipmentLinkedList()
	{
	}


	// CUSTOMER_SERVICED_ONLY_ONCE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
/**
//???????????????????????????????????  THIS SHOULD BE CHANGED TO ONLY ONCE PER DAY ON VALID DAYS
 */
	public boolean customerServicedOnlyOnce(PVRPQADepotLinkedList qaDepots)
	{
		//loop through all the shipments and mark which are serviced and count the number of times
		//the customers are serviced. Each shipment should be serviced no more than once
		for (int i = 0; i < qaDepots.getDepots().size(); i++)
		{
			PVRPQADepot d = (PVRPQADepot) qaDepots.getDepots().elementAt(i);
			for (int j = 0; j < d.getTrucks().size(); j++)
			{
				PVRPQATruck t = (PVRPQATruck) d.getTrucks().elementAt(j);
				for (int k = 0; k < t.getNodes().size(); k++)
				{
					PVRPQANode n = (PVRPQANode) t.getNodes().elementAt(k);
					for (int l = 0; l < getShipments().size(); l++)
					{
						PVRPQAShipment s = (PVRPQAShipment) getShipments().elementAt(l);
						if (s.getIndex() == n.getIndex())
						{
							s.setServecount(s.getServecount() + 1);
							break;
						}
					}
				}
			}
		}

		boolean ret = true;
		//loop through shipments and look for anomolies
		for (int l = 0; l < getShipments().size(); l++)
		{
			PVRPQAShipment s = (PVRPQAShipment) getShipments().elementAt(l);
			if (s.getServecount() != 1)
			{
				edu.sru.thangiah.zeus.core.Settings.printDebug(edu.sru.thangiah.zeus.
																	   core.Settings.ERROR,
																	  "Shipment " + s.getIndex() + " is serviced " + s.getServecount() + " time(s)");
				ret = false;
			}
		}

		return ret;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

}
