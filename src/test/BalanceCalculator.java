package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BalanceCalculator {

	IContributionDistributor contributionDistributor;
	
	public void calculateBalance(Bill bill, Groups groups){
		
		if(bill == null){
			System.out.println("Bill is null");
			return;
		}
		
		
		if(SplitFormula.AMOUNT.name().equals(bill.getSplitFormula().name())){
			contributionDistributor = new SimpleContributionDistributor();
		
		}
		
		else if(SplitFormula.PERCENTAGE.name().equals(bill.getSplitFormula().name())){
			contributionDistributor = new SimpleContributionDistributor();
		
		}
		
		Map<Integer, Double> contributionMap = contributionDistributor.distributeContribution(bill.getBillContributions(), bill.getTotalAmount());
		
		updateBalance(bill, contributionMap, groups);
		
	}
	
	public void updateBalance(Bill bill, Map<Integer, Double> contributionMap, Groups groups){
		
		Group group = groups.groupMap.get(bill.getGroupId());
		Map<Integer, Double> balanceMap = group.getBalanceMap();
		Map<Integer, Double> paidByMap = bill.getPaidBy();

		
		Set<Integer> keySet = balanceMap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		
		while(itr.hasNext()){
			Integer key = itr.next();
			
			Double amountToPay = contributionMap.get(key);
			
			if(amountToPay == null) return;

			if(paidByMap.containsKey(key)){
				
				amountToPay =  paidByMap.get(key) - amountToPay;
			
			}
			else{
				amountToPay = amountToPay * -1;
			}
			
			if( amountToPay > 0){
				balanceMap.put(key, amountToPay - balanceMap.get(key));
			}
			
			else{
				balanceMap.put(key, balanceMap.get(key) + amountToPay);
			}
			
			
		}
		
	}
}
