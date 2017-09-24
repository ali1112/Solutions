package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PercentageContributionDistributor implements IContributionDistributor {

	@Override
	public Map<Integer, Double> distributeContribution(Map<Integer, Double> contributionMap, Double totalAmount) {
		
		Map<Integer, Double> resultContribution = null;
	
			resultContribution = new HashMap<>();
			Set<Integer> keySet = contributionMap.keySet();
			Iterator<Integer> itr = keySet.iterator();
			
			while(itr.hasNext()){
				Integer key = itr.next();
				Double percentage = contributionMap.get(key);
				Double amount = (totalAmount*percentage)/100;
				resultContribution.put(key, amount);
			}
			
		
		
		return resultContribution;
		
		
	}

}
