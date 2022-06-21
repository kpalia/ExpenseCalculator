/**
 * 
 */
package com.geektrust.expensemanagement.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.geektrust.expensemanagement.constants.CommonConstants;
import com.geektrust.expensemanagement.interfaces.HouseExpenseInterface;
import com.geektrust.expensemanagement.interfaces.HouseInterface;
import com.geektrust.expensemanagement.pojo.ExpenseRecord;
import com.geektrust.expensemanagement.pojo.HouseMember;

/**
 * @author Kamal.Palia
 *
 */
public class GreekTrustHouse implements HouseInterface, HouseExpenseInterface{

	@Override
	public String moveIntoHouse(ExpenseRecord recordObj) {
		if(houseMembersSet.size()<CommonConstants.TOTAL_ROOMMATES_SIZE) {
			HouseMember hm = new HouseMember();
			hm.setMemberName(recordObj.getFirstMemberName());
			houseMembersSet.add(hm);
//			System.out.println(CommonConstants.SUCCESS);
			return CommonConstants.SUCCESS;
		} 
		//System.out.println(CommonConstants.HOUSEFUL);
		return CommonConstants.HOUSEFUL;
	}

	@Override
	public String moveOutOfHouse(ExpenseRecord recordObj) {
		if(houseMembersSet.size()>CommonConstants.COUNT_0) {
			HouseMember houseMember = getMemberOfHouse(recordObj.getFirstMemberName());
			if(houseMember!=null && houseMember.getMyDueAmount()==0 && houseMember.getAmountIPaid()==0) {
//				System.out.println(CommonConstants.SUCCESS);
				return CommonConstants.SUCCESS;
			}
		}
		//System.out.println(CommonConstants.FAILURE);
		return CommonConstants.FAILURE;
	}

	@Override
	public String spend(ExpenseRecord recordObj) {
		int dividedAmount = 0;
		HouseMember firstHouseMember = getMemberOfHouse(recordObj.getFirstMemberName());
		HouseMember secondHouseMember = getMemberOfHouse(recordObj.getSecondMemberName());
		HouseMember thirdHouseMember = recordObj.getThirdMemberName()!=null?getMemberOfHouse(recordObj.getThirdMemberName()):null;
		
		if(firstHouseMember==null || secondHouseMember==null || (recordObj.getThirdMemberName()!=null && thirdHouseMember==null)) {
			return CommonConstants.MEMBER_NOT_FOUND;
		}
		
		if(firstHouseMember.getAmountPaidBetweenMembers()!=null && !firstHouseMember.getAmountPaidBetweenMembers().isEmpty()) {
			List<Map<String, Integer>> amountPaidBetweenMembers = firstHouseMember.getAmountPaidBetweenMembers();
		} else {
			Map<String, Integer> innerMap = new HashMap<>();
			if(null!=thirdHouseMember) {
				dividedAmount = recordObj.getPaidAmount()/CommonConstants.COUNT_3;
				
				firstHouseMember.setMyDueAmount(firstHouseMember.getMyDueAmount()-dividedAmount);
				secondHouseMember.setMyDueAmount(secondHouseMember.getMyDueAmount()+dividedAmount);
				thirdHouseMember.setMyDueAmount(thirdHouseMember.getMyDueAmount()+dividedAmount);
				
				innerMap.put(secondHouseMember.getMemberName(), dividedAmount);				
				innerMap.put(thirdHouseMember.getMemberName(), dividedAmount);
				
			} else {
				dividedAmount = recordObj.getPaidAmount()/CommonConstants.COUNT_2;
				
				firstHouseMember.setMyDueAmount(firstHouseMember.getMyDueAmount()-dividedAmount);
				secondHouseMember.setMyDueAmount(secondHouseMember.getMyDueAmount()+dividedAmount);
				
				innerMap.put(secondHouseMember.getMemberName(), dividedAmount);
				
			}
			firstHouseMember.getAmountPaidBetweenMembers().add(innerMap);
			firstHouseMember.setAmountIPaid(dividedAmount);
		}
		return CommonConstants.SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List dues(ExpenseRecord recordObj) {
		HouseMember firstHouseMember = getMemberOfHouse(recordObj.getFirstMemberName());
		if(firstHouseMember!=null) {
			return firstHouseMember.getAmountPaidBetweenMembers();
		}
		return new ArrayList<>();
	}

	@Override
	public String clearDues(ExpenseRecord recordObj) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public HouseMember getMemberOfHouse(String personName) {
		if(houseMembersSet.size()>CommonConstants.COUNT_0) {
			Optional<HouseMember> matchingMember = houseMembersSet.stream().filter(houseMemberObj -> houseMemberObj.getMemberName().equals(personName)).findFirst();
			return matchingMember.isPresent()?matchingMember.get():null;
		}
		return null;
	}
}
