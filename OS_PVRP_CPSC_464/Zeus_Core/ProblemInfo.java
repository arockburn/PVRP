package edu.sru.thangiah.zeus.core;

//required to solve the VRP problem


/**
 * Contains problem-specific information that may be used throughout Zeus.
 * Title: ProblemInfo
 * Description: This class contains problem-specific information that may be used
 *              throughout Zeus.  Static references to the cost functions for
 *              each of the levels in Zeus are included.
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */
public class ProblemInfo {
  /**
   * cost functions to be used at each level of the Zeus system.
   * if a different cost function is required, then implement the CostFunctions
   * interface, and then set the appropriate level here to point to an instance
   * of that implementation.
   */
  //The following cost functions are defined in the Root class of the problem
  //being implemented. For example, for the VRP problem it will be defined
  //in the VRPRoot class.

  //Constraints such as travel time and maximum capacity are not defined here as
  //each vehicle is capable of having its own constraints. Therefore it is
  //deffered to each of the truck rather than have a global variable.

  public static CostFunctions nodesLLLevelCostF;
  public static CostFunctions truckLevelCostF;
  public static CostFunctions truckLLLevelCostF;
  public static CostFunctions depotLevelCostF;
  public static CostFunctions depotLLLevelCostF;


  //Location of a temp directors that can be written to
  //Defined in the root class of the problem being implemented
  public static String workingDirectory = System.getProperty("user.dir");
  public static String tempFileLocation;
  public static String inputPath;
  public static String outputPath;
  public static String shortestPathFiles;
  
  //XML File path
  public static String XMLFilePath;

  //the different available truck types
  public static java.util.Vector truckTypes;

  //Shipment insertion:
  //the type of insert shipment to be performed. It will be defined in the
  //problem being solved. In the case of VRP, it will be defined in the VRP
  //class
  public static Object insertShipType;

  //Shipment selection:
  //The type of shipment selection to be performed. It will be defined in the
  //problem being solved. In the case of the VRP, it will be defined in the VRP
  //class
  public static Object selectShipType;

  //the current max truck number. Keeps track of the maximum number of trucks
  //in the problem
  //public static int maxTruckNum = 1;

  //information about the problem
  public static String fileName; //Problem file name
  public static int probType;      //Type of problem being solved
  public static int noOfVehs;      //No. of vehicles read in
  public static int noOfShips;     //No. of shipments read in
  public static int noOfDays;      //No. of days or depots for the problem

  //information about the problem
  public static int numDepots;
  public static int numTrucks;
  public static int numCustomers;

  //For multiple-day delivery
  public final static int MAX_COMBINATIONS = 12;
  public final static int MAX_HORIZON = 7;

  //the average speed that a bus will travel, used for calculating travel time
  public static double averageBusSpeed = 35;

  //Deviation from feasibility allowed for the problem being solveds
  public static float Deviation;

  //the following constants are used to distinguish the different types of nodes
  //in the distance matrix
  public static final int PICK_UP_POINT = 1;
  public static final int DEPOT = 2;
  public static final int TURN_AROUND_POINT = 3;

  //the following constants are used for student needs
  public static final String REGULAR = "Regular";
  public static final String MONITOR = "Monitor";
  public static final String WHEELCHAIR = "Wheelchair";
  public static final String WHEELCHAIR_ELEVATOR = "WheelchairElevator";

  //the following constants are used for student schools
  public static final String ELEMENTARY = "E";
  public static final String MIDDLE_SCHOOL = "M";
  public static final String HIGH_SCHOOL = "H";

  //the following constants are used for the depot types
  public static final int SCHOOL = 1;
  public static final int CONTRACTOR = 2;
  public static final int BUS_DRIVER_HOME = 3;
  public static final int WAREHOUSE = 4;

  //the following constants are used for the loading time for each type of student
  public static final double R_PICK_UP_TIME = 25; //25 seconds
  public static final double M_PICK_UP_TIME = 60; //1 minute
  public static final double W_PICK_UP_TIME = 120; //2 minutes
  public static final double WE_PICK_UP_TIME = 180; //3 minutes

  //the following constants are used for the cross road cost penalties for each type of student
  public static final double R_CROSS_ROAD_COST_PENALTY = .01;
  public static final double M_CROSS_ROAD_COST_PENALTY = .025;
  public static final double W_CROSS_ROAD_COST_PENALTY = .05;
  public static final double WE_CROSS_ROAD_COST_PENALTY = .5;
  
  //For vehicles
  public static final float vehicleSpeed = 50; //50 miles per hour
  
}
