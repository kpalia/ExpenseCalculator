/**
 * 
 */
package com.geektrust.expensemanagement.pojo;

/**
 * @author Kamal.Palia
 *
 */
public class ExpenseRecord {

	private String actionName = null;
	private String firstMemberName = null;
	private String secondMemberName = null;
	private String thirdMemberName = null;
	private int paidAmount = 0;
	private int expenseInBetweenMembers = 0;

	public ExpenseRecord() {}
	
	public ExpenseRecord(String actionName, String firstMemberName, String secondMemberName, String thirdMemberName,
			int paidAmount) {
		super();
		this.actionName = actionName;
		this.firstMemberName = firstMemberName;
		this.secondMemberName = secondMemberName;
		this.thirdMemberName = thirdMemberName;
		this.paidAmount = paidAmount;
	}
	
	public ExpenseRecord(String actionName, int paidAmount , String firstMemberName, String secondMemberName, String thirdMemberName) {
		super();
		this.actionName = actionName;
		this.firstMemberName = firstMemberName;
		this.secondMemberName = secondMemberName;
		this.thirdMemberName = thirdMemberName;
		this.paidAmount = paidAmount;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getFirstMemberName() {
		return firstMemberName;
	}

	public void setFirstMemberName(String firstMemberName) {
		this.firstMemberName = firstMemberName;
	}

	public String getSecondMemberName() {
		return secondMemberName;
	}

	public void setSecondMemberName(String secondMemberName) {
		this.secondMemberName = secondMemberName;
	}

	public String getThirdMemberName() {
		return thirdMemberName;
	}

	public void setThirdMemberName(String thirdMemberName) {
		this.thirdMemberName = thirdMemberName;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public int getExpenseInBetweenMembers() {
		return expenseInBetweenMembers;
	}

	public void setExpenseInBetweenMembers(int expenseInBetweenMembers) {
		this.expenseInBetweenMembers = expenseInBetweenMembers;
	}
}