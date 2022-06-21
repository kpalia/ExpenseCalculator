/**
 * 
 */
package com.geektrust.expensemanagement.pojo;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kamal.Palia
 *
 */
public class HouseMember implements Comparable<HouseMember>{
	
	private String memberName = null;
	private List<Map<String, Integer>> amountPaidBetweenMembers = new ArrayList<>();
	private int amountIPaid = 0;
	private int myDueAmount = 0;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public List<Map<String, Integer>> getAmountPaidBetweenMembers() {
		return amountPaidBetweenMembers;
	}
	public void setAmountPaidBetweenMembers(Map<String, Integer> amountPaidBetweenMembers) {
		this.amountPaidBetweenMembers.add(amountPaidBetweenMembers);
	}
	public int getAmountIPaid() {
		return amountIPaid;
	}
	public void setAmountIPaid(int amountIPaid) {
		this.amountIPaid = amountIPaid;
	}
	public int getMyDueAmount() {
		return myDueAmount;
	}
	public void setMyDueAmount(int myDueAmount) {
		this.myDueAmount = myDueAmount;
	}
	@Override
	public int compareTo(HouseMember o) {
		return o.getMemberName().compareToIgnoreCase(getMemberName());
	}
}
