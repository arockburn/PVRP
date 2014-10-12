package edu.sru.thangiah.zeus.pvrp.pvrpcostfunctions;

import edu.sru.thangiah.zeus.core.*;

abstract public class PVRPAbstractCostFunctions implements CostFunctions {

	/** Methods not used by PVRP in the computation of cost can be declared
	 * here with dummy methods. Then have the cost functions in the VRP
	 * inherit this class instead of the CostFunctions class.
	 */

	public float getTotalScore(Object o) {
		return 0;
	}

	public void setTotalScore(Object o) {

	}

}
