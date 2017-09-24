package test;

import java.util.Map;

public interface IContributionDistributor {

	Map<Integer, Double> distributeContribution(Map<Integer, Double> contributionMap, Double totalAmount);
	
}
