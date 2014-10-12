package edu.sru.thangiah.zeus.pvrp;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by joshuasarver on 9/13/2014.
 */


import java.io.*;
import java.util.Iterator;

import edu.sru.thangiah.zeus.core.ProblemInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import java.io.*;
import java.util.*;
import edu.sru.thangiah.zeus.core.*;
import edu.sru.thangiah.zeus.vrp.vrpqualityassurance.*;
import edu.sru.thangiah.zeus.gui.*;

import javax.lang.model.type.NullType;





public class PVRPExcel__OLD
{
	//private PVRPShipmentLinkedList mainShipments = new PVRPShipmentLinkedList(); //customers read in from a file or database that are available
	public String inputPath = "";
	public String outputPath = "";

	public PVRPExcel__OLD(String relativeInputPath, String relativeOutputPath)
	{

		inputPath = relativeInputPath;
		outputPath = relativeOutputPath;

	}

	public String readProblemInfoFromExcel() throws IOException
	{
		int rowNumber = 1;
		int numberOfFields = 4; //YOU WILL PROBABLY NEED TO MODIFY THIS!
		XSSFRow rowData;
		String problemInfo = "";

		//Open up file
		FileInputStream excelInput = new FileInputStream(new File(inputPath));

		//Create workbook
		XSSFWorkbook workbook = new XSSFWorkbook(excelInput);

		//Grab needed sheet from the file
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Set to use first row
		rowData = sheet.getRow(rowNumber);

		for(int count = 0; count < numberOfFields; count++)
		{
			problemInfo += rowData.getCell(count + 1);
		}

		excelInput.close(); //ALWAYS CLOSE THE FILE

		return problemInfo;
	}


	public String readNodesFromExcel() throws IOException
	{

		//VARIABLES
		int currentRowNumber = 1;
		XSSFRow currentRowData;
		int customerNumber = -1;
		double xCoordinate = -1;
		double yCoordinate = -1;
		int demandQ = -1;
		int frequency = -1;
		int numberOfColumns = 5;
		String excelContents = "";




			//Open up file
			FileInputStream excelInput = new FileInputStream(new File(inputPath));

			//Create workbook
			XSSFWorkbook workbook = new XSSFWorkbook(excelInput);

			//Grab needed sheet from the file
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Set to use first row
			currentRowData = sheet.getRow(currentRowNumber);
			//currentRowData = sheet.getRow(51);

//&&&&&&&&&&&&&&&&&&&&&&&&*******************

			sheet = workbook.getSheetAt(0);
			for (Row row : sheet)
			{
				int countColumns = 0;

				for (Cell cell : row)
				{
					if(row.getRowNum() != 0) //FIRST ROW FOR PROBLEM DATA
					{
						switch (countColumns)
						{
							case 0:

								customerNumber = (int) getCellData(cell);
								excelContents += customerNumber+" ";
								break;
							case 1:
								xCoordinate = getCellData(cell);
								excelContents += xCoordinate+" ";
								break;
							case 2:
								yCoordinate = getCellData(cell);
								excelContents += yCoordinate+" ";
								break;
							case 3:
								demandQ = (int) getCellData(cell);
								excelContents += demandQ+" ";
								break;
							case 4:
								frequency = (int) getCellData(cell);
								excelContents += frequency+"\n";
								break;
						}
						countColumns++;
					}
				}
				//mainShipments.insertShipment(customerNumber, xCoordinate, yCoordinate, demandQ, frequency);
			}

		excelInput.close();
		return excelContents;

//****************************************


	}

	public double getCellData(Cell cell)
	{ //CODE FROM http://stackoverflow.com/questions/6508203/when-getting-cell-content-using-apache-poi-library-i-get-both-cannot-get-a-num
		long x;
		if(cell.getCellType() == 0)
			x = (long)cell.getNumericCellValue();
		else if(cell.getCellType() == 1)
			x = Long.parseLong(cell.getStringCellValue());
		else
			x = -1;
		return x;

	}
}


//}
