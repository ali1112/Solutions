package test;

public enum SplitFormula {

	AMOUNT ("amount"),
	PERCENTAGE ("percentage");
	
	String splitFormula;
	
	public String getSplitFormula() {
		return splitFormula;
	}

	public void setSplitFormula(String splitFormula) {
		this.splitFormula = splitFormula;
	}

	SplitFormula(String splitFormula){
		this.splitFormula = splitFormula;
	}
	
}
