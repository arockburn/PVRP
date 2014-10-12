/*  1:   */ package edu.sru.thangiah.zeus.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public class ProblemInfo
/*  6:   */ {
/*  7:   */   public static CostFunctions nodesLLLevelCostF;
/*  8:   */   public static CostFunctions truckLevelCostF;
/*  9:   */   public static CostFunctions truckLLLevelCostF;
/* 10:   */   public static CostFunctions depotLevelCostF;
/* 11:   */   public static CostFunctions depotLLLevelCostF;
/* 12:41 */   public static String workingDirectory = System.getProperty("user.dir");
/* 13:   */   public static String tempFileLocation;
/* 14:   */   public static String inputPath;
/* 15:   */   public static String outputPath;
/* 16:   */   public static String shortestPathFiles;
/* 17:   */   public static String XMLFilePath;
/* 18:   */   public static Vector truckTypes;
/* 19:   */   public static Object insertShipType;
/* 20:   */   public static Object selectShipType;
/* 21:   */   public static String fileName;
/* 22:   */   public static int probType;
/* 23:   */   public static int noOfVehs;
/* 24:   */   public static int noOfShips;
/* 25:   */   public static int noOfDays;
/* 26:   */   public static int numDepots;
/* 27:   */   public static int numTrucks;
/* 28:   */   public static int numCustomers;
/* 29:   */   public static final int MAX_COMBINATIONS = 12;
/* 30:   */   public static final int MAX_HORIZON = 7;
/* 31:86 */   public static double averageBusSpeed = 35.0D;
/* 32:   */   public static float Deviation;
/* 33:   */   public static final int PICK_UP_POINT = 1;
/* 34:   */   public static final int DEPOT = 2;
/* 35:   */   public static final int TURN_AROUND_POINT = 3;
/* 36:   */   public static final String REGULAR = "Regular";
/* 37:   */   public static final String MONITOR = "Monitor";
/* 38:   */   public static final String WHEELCHAIR = "Wheelchair";
/* 39:   */   public static final String WHEELCHAIR_ELEVATOR = "WheelchairElevator";
/* 40:   */   public static final String ELEMENTARY = "E";
/* 41:   */   public static final String MIDDLE_SCHOOL = "M";
/* 42:   */   public static final String HIGH_SCHOOL = "H";
/* 43:   */   public static final int SCHOOL = 1;
/* 44:   */   public static final int CONTRACTOR = 2;
/* 45:   */   public static final int BUS_DRIVER_HOME = 3;
/* 46:   */   public static final int WAREHOUSE = 4;
/* 47:   */   public static final double R_PICK_UP_TIME = 25.0D;
/* 48:   */   public static final double M_PICK_UP_TIME = 60.0D;
/* 49:   */   public static final double W_PICK_UP_TIME = 120.0D;
/* 50:   */   public static final double WE_PICK_UP_TIME = 180.0D;
/* 51:   */   public static final double R_CROSS_ROAD_COST_PENALTY = 0.01D;
/* 52:   */   public static final double M_CROSS_ROAD_COST_PENALTY = 0.025D;
/* 53:   */   public static final double W_CROSS_ROAD_COST_PENALTY = 0.05D;
/* 54:   */   public static final double WE_CROSS_ROAD_COST_PENALTY = 0.5D;
/* 55:   */   public static final float vehicleSpeed = 50.0F;
/* 56:   */ }


/* Location:           E:\DrSam PVRP Workspace\zeuscore\
 * Qualified Name:     edu.sru.thangiah.zeus.core.ProblemInfo
 * JD-Core Version:    0.7.0.1
 */