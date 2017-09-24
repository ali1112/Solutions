package test;

import java.util.Map;

public class SimpleContributionDistributor implements IContributionDistributor {

	@Override
	public Map<Integer, Double> distributeContribution(Map<Integer, Double> contributionMap, Double totalAmount) {
			
		return contributionMap;

	}

}
