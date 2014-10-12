package edu.sru.thangiah.zeus.vrp;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import edu.sru.thangiah.zeus.vrp.vrpcostfunctions.*;

public class VRPRoot {
  /**
   * Constructor. Runs the VRP and calculates the total CPU time
   */
  public VRPRoot() {

    //Settings for the ProblemInfo class
    //Problem info consists of a set of static values that are used by a number
    //of different classes. The following has to be set in order for the program
    //to function correctly.
    ProblemInfo.nodesLLLevelCostF = new VRPNodesLLCostFunctions();
    ProblemInfo.truckLevelCostF = new VRPTruckCostFunctions();
    ProblemInfo.truckLLLevelCostF = new VRPTruckLLCostFunctions();
    ProblemInfo.depotLevelCostF = new VRPDepotCostFunctions();
    ProblemInfo.depotLLLevelCostF = new VRPDepotLLCostFunctions();
    //Paths for temporary, input and output files
    //ProblemInfo.currDir gives the working directory of the program

	  //allows us to work with DOS based or Unix/Unix-like systems automagically
	  String FS = System.getProperty("file.separator");


	  //FILE LOCATIONS
	  ProblemInfo.tempFileLocation = ProblemInfo.workingDirectory + FS + "temp";                  //temp file location
	  ProblemInfo.inputPath = ProblemInfo.workingDirectory + FS + "data" + FS + "vrp" + FS + "Problems" + FS;    //input file location
	  ProblemInfo.outputPath = ProblemInfo.workingDirectory + FS + "data" + FS + "vrp" + FS + "Results" + FS; //output file location


	  //Solve the VRP for the enclosed data
   	new VRP("mdvrp_p01.txt");

  }
}
