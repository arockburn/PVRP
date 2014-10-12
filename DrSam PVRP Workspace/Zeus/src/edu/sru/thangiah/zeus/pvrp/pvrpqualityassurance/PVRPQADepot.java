//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE
package edu.sru.thangiah.zeus.pvrp.pvrpqualityassurance;

//IMPORTS
import edu.sru.thangiah.zeus.qualityassurance.QADepot;



//CLASS
public class	PVRPQADepot
				extends QADepot
				implements java.io.Serializable, java.lang.Cloneable
{

	// CHECK_DISTANCE_CONSTRAINT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean checkDistanceConstraint(PVRPQADepot depot)
	{
		boolean status = true;
		for (int i = 0; i < getTrucks().size(); i++) {
			PVRPQATruck truck = (PVRPQATruck) getTrucks().elementAt(i);
			truck.checkDistanceConstraint(truck);
		}
		return status;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	// CHECK_CAPACITY_CONSTRAINT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean checkCapacityConstraint()
	{
		boolean status = true;
		for (int i = 0; i < getTrucks().size(); i++) {
			PVRPQATruck truck = (PVRPQATruck) getTrucks().elementAt(i);
			truck.checkCapacityConstraint(truck);
		}
		return status;
	}
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}
