package com.geektrust.expensemanagement.interfaces;

import java.util.Set;
import java.util.TreeSet;

import com.geektrust.expensemanagement.pojo.ExpenseRecord;
import com.geektrust.expensemanagement.pojo.HouseMember;

public interface HouseInterface {
	public Set<HouseMember> houseMembersSet = new TreeSet<>();
	public String moveIntoHouse(ExpenseRecord recordObj);
	public String moveOutOfHouse(ExpenseRecord recordObj);
	public HouseMember getMemberOfHouse(String personName);
}
