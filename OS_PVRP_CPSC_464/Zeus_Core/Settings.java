package edu.sru.thangiah.zeus.core;

/**
 * Global setting for Zeus
 * <p>Title: Settings</p>
 * <p>Description: Global Settings for Zeus, including debugging and locking of
 * trucks.  The Settings class should not contain any information that is problem specific</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author Sam R. Thangiah
 * @version 2.0
 */

public class Settings {
  //Allows trucks to be added as and when needed
  public static boolean lockTrucks = false;

  public static java.io.PrintStream debugStream = System.out;

  //debug settings
  public static int debugLevel = 3;
  public static final int OFF = 0;
  public static final int ERROR = 1;
  public static final int WARNING = 2;
  public static final int COMMENT = 3;
  private static final String[] dbg = {
      "OFF", "ERROR", "WARNING", "COMMENT"};

  public static void printDebug(int level, String msg) {
    if (level <= debugLevel) {
      debugStream.println(dbg[level] + " \"" + msg + "\" " +
                          new java.sql.Timestamp(new java.util.Date().getTime()));
    }
  }

}
