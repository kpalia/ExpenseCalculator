/**
 * 
 */
package com.geektrust.expensemanagement.interfaces;

import java.util.List;

import com.geektrust.expensemanagement.pojo.ExpenseRecord;

/**
 * @author Kamal.Palia
 *
 */
public interface HouseExpenseInterface {
	public String spend(ExpenseRecord recordObj);
	@SuppressWarnings("rawtypes")
	public List dues(ExpenseRecord recordObj);
	public String clearDues(ExpenseRecord recordObj);
}
