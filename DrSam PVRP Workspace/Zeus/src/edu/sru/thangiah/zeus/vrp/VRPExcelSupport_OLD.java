package edu.sru.thangiah.zeus.vrp;

/**
 * Created by joshuasarver on 9/13/2014.
 */


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class VRPExcelSupport_OLD {

	public VRPExcelSupport_OLD(){
		//String dawg = inputRelativeLocation;
	}

	public void readFromExcel(String inputRelativeLocation){
		//Blank workbook

		//VARIABLES
		int currentRowNumber = 1;
		XSSFRow currentRowData;
		int problemType;
		int numberOfVehicles;
		int numberOfShipments;
		int horizonDays;
		double maxTravelTime;
		double maxCapacity;

		try {
			//Open up file
			FileInputStream excelInput = new FileInputStream(new File(inputRelativeLocation));

			//Create workbook
			XSSFWorkbook workbook = new XSSFWorkbook(excelInput);

			//Grab needed sheet from the file
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Set to use first row
			currentRowData = sheet.getRow(currentRowNumber);
			currentRowData = sheet.getRow(1);





			problemType			= (int)	currentRowData.getCell(0).getNumericCellValue();
			numberOfVehicles	= (int)	currentRowData.getCell(1).getNumericCellValue();
			numberOfShipments	= (int)	currentRowData.getCell(2).getNumericCellValue();
			horizonDays			= (int)	currentRowData.getCell(3).getNumericCellValue();
			maxTravelTime		= 		currentRowData.getCell(4).getNumericCellValue();
			maxCapacity			= 		currentRowData.getCell(5).getNumericCellValue();

			System.out.println("probType\t"+problemType);
			System.out.println("numVeh\t"+numberOfVehicles);
			System.out.println("numShip\t"+numberOfShipments);
			System.out.println("HorDay\t"+horizonDays);
			System.out.println("maxTravTime\t"+maxTravelTime);
			System.out.println("maxCap\t"+maxCapacity);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
