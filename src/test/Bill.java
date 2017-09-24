package test;

import java.util.Map;

public class Bill {

	Integer id;
	Integer groupId;
	Double totalAmount;
	SplitFormula splitFormula;
	Map<Integer, Double> billContributions;
	Map<Integer, Double> paidBy;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public SplitFormula getSplitFormula() {
		return splitFormula;
	}
	public void setSplitFormula(SplitFormula splitFormula) {
		this.splitFormula = splitFormula;
	}
	public Map<Integer, Double> getBillContributions() {
		return billContributions;
	}
	public void setBillContributions(Map<Integer, Double> billContributions) {
		this.billContributions = billContributions;
	}
	public Map<Integer, Double> getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(Map<Integer, Double> paidBy) {
		this.paidBy = paidBy;
	}	
	
	
}
