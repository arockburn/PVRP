//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE
package edu.sru.thangiah.zeus.pvrp.pvrpqualityassurance;

//IMPORTS
import edu.sru.thangiah.zeus.qualityassurance.QADepotLinkedList;

import java.util.Vector;




//CLASS
public class PVRPQADepotLinkedList    extends QADepotLinkedList
		implements java.io.Serializable, java.lang.Cloneable  {


	// CHECK_DISTANCE_CONSTRAINT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean checkDistanceConstraint()
	{
		boolean status = true;
		for (int i = 0; i < getDepots().size(); i++) {
			PVRPQADepot depot = (PVRPQADepot) getDepots().elementAt(i);
			status = status && depot.checkDistanceConstraint(depot);
		}
		return status;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	// CHECK_CAPACITY_CONSTRAINT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean checkCapacityConstraint()
	{
		boolean status = true;
		for (int i = 0; i < getDepots().size(); i++) {
			PVRPQADepot depot = (PVRPQADepot) getDepots().elementAt(i);
			status = status && depot.checkCapacityConstraint();
		}
		return status;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

}
