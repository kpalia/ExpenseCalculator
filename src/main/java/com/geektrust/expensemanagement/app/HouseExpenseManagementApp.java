/**
 * 
 */
package com.geektrust.expensemanagement.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.geektrust.expensemanagement.constants.CommonConstants;
import com.geektrust.expensemanagement.pojo.ExpenseRecord;

/**
 * @author Kamal.Palia
 * 
 */
public class HouseExpenseManagementApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HouseExpenseManagementApp expneseCalc = new HouseExpenseManagementApp();
		expneseCalc.performAction(expneseCalc.readExpenseFileInList(args[CommonConstants.INDEX_0]));
	}

	/*
	 * @desc: Code read the file and returns the list containing lines
	 * @param: Absolute file path
	 */
	private List<String> readExpenseFileInList(String fileName)
	{
		List<String> lines = Collections.emptyList();
		try
		{
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		return lines;
	}

	/*
	 * @desc: Code reads the data line by line and perform respective actions.
	 * @param: List having lines
	 */
	private void performAction(List<String> lines) {
		String eachRecord = "";
		String[] recordArray;
		Iterator<String> itr = lines.iterator();
		ExpenseRecord recordObj = null;

		while (itr.hasNext()) {
			eachRecord = itr.next();
			recordArray = eachRecord.split(" ");
			recordObj = getExpenseRecordObj(recordArray);
			printOutput(conditionalCall(recordObj));
		}
	}

	private ExpenseRecord getExpenseRecordObj(String[] recordArray) {
		switch(recordArray[CommonConstants.INDEX_0]){    
			case CommonConstants.MOVE_IN:
			case CommonConstants.MOVE_OUT: 
			case CommonConstants.DUES:
				return new ExpenseRecord(recordArray[CommonConstants.INDEX_0], recordArray[CommonConstants.INDEX_1], null, null, 0);
			case CommonConstants.SPEND:
				if(recordArray.length == 5) {
					return new ExpenseRecord(recordArray[CommonConstants.INDEX_0], Integer.parseInt(recordArray[CommonConstants.INDEX_1]), 
							recordArray[CommonConstants.INDEX_2], recordArray[CommonConstants.INDEX_3], recordArray[CommonConstants.INDEX_4]);
				}
				return new ExpenseRecord(recordArray[CommonConstants.INDEX_0], Integer.parseInt(recordArray[CommonConstants.INDEX_1]), 
						recordArray[CommonConstants.INDEX_2], recordArray[CommonConstants.INDEX_3], null);				
			case CommonConstants.CLEAR_DUE:
				return new ExpenseRecord(recordArray[CommonConstants.INDEX_0], recordArray[CommonConstants.INDEX_1], 
						recordArray[CommonConstants.INDEX_2], null, Integer.parseInt(recordArray[CommonConstants.INDEX_3]));
			default:     
				return new ExpenseRecord();
		} 
	}

	private Object conditionalCall(ExpenseRecord recordObj) {
		GreekTrustHouse house = new GreekTrustHouse();
		switch(recordObj.getActionName()){    
			case CommonConstants.MOVE_IN:    
				return house.moveIntoHouse(recordObj);  
			case CommonConstants.MOVE_OUT:    
				return house.moveOutOfHouse(recordObj);  
			case CommonConstants.SPEND:
				return house.spend(recordObj);
			case CommonConstants.DUES:
				return house.dues(recordObj);
			case CommonConstants.CLEAR_DUE:
				return house.clearDues(recordObj);
			default:     
				return "Incorrect Command";  
		}
	}

	private void printOutput(Object returnValue) {
		System.out.println(returnValue);
	}
}
