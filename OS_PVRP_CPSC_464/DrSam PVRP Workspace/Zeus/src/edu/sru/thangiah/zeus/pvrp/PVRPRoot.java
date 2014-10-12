//PVRP PROBLEM
//CPSC 464
//AARON ROCKBURN; JOSHUA SARVER

//***********	DECLARATION_S_OTHER	**********************************************************************************\\
// FUNCTION_START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//PACKAGE TITLE

package edu.sru.thangiah.zeus.pvrp;


//IMPORT STATEMENTS
//import com.sun.tools.javah.Util;
import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.pvrp.pvrpcostfunctions.*;





//CLASS
public class PVRPRoot
{

	//***********	DECLARATION_S	**********************************************************************************\\
	public PVRPRoot() throws Exception
	{

		//SETUP SOME PARAMETERS FOR THE PROBLEM INFO CLASS
		//these are all very important...the program will not function
		//properly without them
		ProblemInfo.nodesLLLevelCostF = new PVRPNodesLLCostFunctions();
		ProblemInfo.truckLevelCostF = new PVRPTruckCostFunctions();
		ProblemInfo.truckLLLevelCostF = new PVRPTruckLLCostFunctions();
		ProblemInfo.depotLevelCostF = new PVRPDepotCostFunctions();
		ProblemInfo.depotLLLevelCostF = new PVRPDepotLLCostFunctions();


		//allows us to work with DOS based or Unix/Unix-like systems automagically
		String FS = System.getProperty("file.separator");


		//FILE LOCATIONS
		ProblemInfo.tempFileLocation = ProblemInfo.workingDirectory + FS + "temp";                  //temp file location
		ProblemInfo.inputPath = ProblemInfo.workingDirectory + FS + "data" + FS + "PVRP" + FS + "data" + FS;    //input file location
		ProblemInfo.outputPath = ProblemInfo.workingDirectory + FS + "data" + FS + "PVRP" + FS + "results" + FS; //output file location


		//CREATE NEW PVRP PROBLEM WITH DATA FROM THE SPECIFIED FILE NAME
		new PVRP("input_2.xlsx");
	}
}
