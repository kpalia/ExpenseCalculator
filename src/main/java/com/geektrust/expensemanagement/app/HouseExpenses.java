///**
// * 
// */
//package com.geektrust.expensemanagement.app;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.geektrust.expensemanagement.constants.CommonConstants;
//import com.geektrust.expensemanagement.interfaces.HouseExpenseInterface;
//import com.geektrust.expensemanagement.interfaces.HouseInterface;
//
///**
// * @author Kamal.Palia
// *
// */
//public class HouseExpenses implements HouseExpenseInterface{
//	
//	private HouseExpenses() {}
//	
//	public void spend(String[] strArray) {
//		
//		if(strArray.length==CommonConstants.COUNT_5) {
//			divideExpenseInAll(strArray);
//			System.out.println(CommonConstants.SUCCESS); 
//		} else if(strArray.length==CommonConstants.COUNT_4) {
//			divideExpenseInSome(strArray);
//			System.out.println(CommonConstants.SUCCESS); 
//		}		
//	}
//	
//	public void clearDues(String[] strArray) {
//		Map<String, Integer> borrowerMap = null;
//		String duesClearBy = strArray[CommonConstants.INDEX_1];
//		int amount = Integer.parseInt(strArray[CommonConstants.INDEX_3]);
//		
//		if(!payerMap.isEmpty()) {
//			for(Map.Entry<String, Map<String,Integer>> mapEntrySet: payerMap.entrySet()) {
//				borrowerMap = mapEntrySet.getValue();
//				if(amount > borrowerMap.get(duesClearBy).intValue()) {
//					System.out.println(CommonConstants.INCORRECT_PAYMENT);
//				} else {
//					borrowerMap.replace(duesClearBy, borrowerMap.get(duesClearBy).intValue() - amount);
//					System.out.println(borrowerMap.get(duesClearBy).intValue());
//				}
//			}
//		}
//	}
//
//	public void dues(String[] strArray) {
//		for(Map.Entry<String, Map<String,Integer>> mapEntrySet: payerMap.entrySet()) {
//			if(mapEntrySet.getValue().get(strArray[1])!=null) {
//				System.out.println(mapEntrySet.getKey() + " " + mapEntrySet.getValue().get(strArray[1]).intValue());
//			} else if(payerMap.get(strArray[1])!=null) {
//				System.out.println(mapEntrySet.getValue().keySet().iterator().next() + " " + CommonConstants.COUNT_0);
//			}
//			if(payerMap.size()==1) {
//				houseMates.forEach((item) -> {
//					if(!item.equals(mapEntrySet.getKey()) && !item.equals(strArray[CommonConstants.INDEX_1])){
//						System.out.println(item + " " + CommonConstants.COUNT_0);
//					}
//				});
//			}
//		}		
//	}
//	
//	private static void divideExpenseInAll(String[] strArray) {
//		Map<String, Integer> borrowerMap = new HashMap<>(); //Who borrows money from lender
//		
//		String spentByMemberName = strArray[CommonConstants.INDEX_2];
//		String lentToMemberFirst = strArray[CommonConstants.INDEX_3];
//		String lentToMemberSecond = strArray[CommonConstants.INDEX_4];
//		int amount = Integer.parseInt(strArray[CommonConstants.INDEX_1])/CommonConstants.TOTAL_ROOMMATES_SIZE;
//		
//		if(payerMap.containsKey(spentByMemberName)) {
//			borrowerMap = payerMap.get(spentByMemberName);
//			borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue()+amount);
//			borrowerMap.replace(lentToMemberSecond, borrowerMap.get(lentToMemberSecond).intValue()+amount);
//		} else {
//			if(!payerMap.isEmpty()) {
//				for(Map.Entry<String, Map<String,Integer>> mapEntrySet: payerMap.entrySet()) {
//					borrowerMap = mapEntrySet.getValue();
//					if(borrowerMap.get(lentToMemberFirst)!=null && borrowerMap.get(lentToMemberFirst).intValue()>CommonConstants.COUNT_0) {
//						if(amount<borrowerMap.get(spentByMemberName)) {
//							borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue() + amount);
//						} else {
//							borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue() + borrowerMap.get(spentByMemberName));
//							Map<String, Integer> borrowerMap1 = new HashMap<>();
//							borrowerMap1.put(lentToMemberFirst, amount-mapEntrySet.getValue().get(spentByMemberName));
//							payerMap.put(spentByMemberName, borrowerMap1);
//						}						
//					} 
//					if(borrowerMap.get(lentToMemberSecond)!=null && borrowerMap.get(lentToMemberSecond).intValue()>CommonConstants.COUNT_0) {
//						if(amount<borrowerMap.get(spentByMemberName)) {
//							borrowerMap.replace(lentToMemberSecond, borrowerMap.get(lentToMemberSecond).intValue() + amount);
//						} else {
//							borrowerMap.replace(lentToMemberSecond, borrowerMap.get(lentToMemberSecond).intValue() + borrowerMap.get(spentByMemberName));
//							Map<String, Integer> borrowerMap1 = new HashMap<>();
//							borrowerMap1.put(lentToMemberSecond, amount-mapEntrySet.getValue().get(spentByMemberName));
//							payerMap.put(spentByMemberName, borrowerMap1);
//						}
//					}
//					if(borrowerMap.get(spentByMemberName)!=null && borrowerMap.get(spentByMemberName).intValue()>CommonConstants.COUNT_0) {
//						borrowerMap.put(spentByMemberName, (borrowerMap.get(spentByMemberName).intValue() - amount)<0?0:borrowerMap.get(spentByMemberName).intValue() - amount);
//					}
//				}
//			} else {
//				borrowerMap.put(lentToMemberFirst, amount);
//				borrowerMap.put(lentToMemberSecond, amount);
//				payerMap.put(spentByMemberName, borrowerMap);
//			}
//		}
//	}
//	
//	private static void divideExpenseInSome(String[] strArray) {
//		Map<String, Integer> borrowerMap = new HashMap<>(); //Who borrows money from lender
//		String spentByMemberName = strArray[CommonConstants.INDEX_2];
//		String lentToMemberFirst = strArray[CommonConstants.INDEX_3];		
//		int amount = Integer.parseInt(strArray[CommonConstants.INDEX_1])/CommonConstants.COUNT_2;
//		
//		if(payerMap.containsKey(spentByMemberName)) {
//			borrowerMap = payerMap.get(spentByMemberName);				
//			borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue()+amount);
//		} else {
//			if(!payerMap.isEmpty()) {
//				for(Map.Entry<String, Map<String,Integer>> mapEntrySet: payerMap.entrySet()) {
//					borrowerMap = mapEntrySet.getValue();
//					if(borrowerMap.get(lentToMemberFirst)!=null && borrowerMap.get(lentToMemberFirst).intValue()>CommonConstants.COUNT_0) {
//						if(amount<borrowerMap.get(spentByMemberName)) {
//							borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue() + amount);
//						} else {
//							borrowerMap.replace(lentToMemberFirst, borrowerMap.get(lentToMemberFirst).intValue() + borrowerMap.get(spentByMemberName));
//							Map<String, Integer> borrowerMap1 = new HashMap<>();
//							borrowerMap1.put(lentToMemberFirst, amount-mapEntrySet.getValue().get(spentByMemberName));
//							payerMap.put(spentByMemberName, borrowerMap1);
//						}						
//					} 
//					if(borrowerMap.get(spentByMemberName)!=null && borrowerMap.get(spentByMemberName).intValue()>CommonConstants.COUNT_0) {
//						borrowerMap.put(spentByMemberName, (borrowerMap.get(spentByMemberName).intValue() - amount)<0?0:borrowerMap.get(spentByMemberName).intValue() - amount);
//					}
//				}
//			} else {
//				borrowerMap.put(lentToMemberFirst, amount);
//				payerMap.put(spentByMemberName, borrowerMap);
//			}
//		}
//	}
//
//	@Override
//	public boolean isPersonMemberOfHouse() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
