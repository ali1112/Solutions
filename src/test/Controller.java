package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Controller {

	
	public static void main(String args[]){
		
		Person person1 = new Person(1, "person1");
		Person person2 = new Person(2, "person2");
		Person person3 = new Person(3, "person3");
		Person person4 = new Person(4, "person4");

		Map<Integer, Double> map = new HashMap<>();
		map.put(person1.getId(), (double) 0);
		map.put(person2.getId(), (double) 0);
		map.put(person3.getId(), (double) 0);
		
		Group group1 = new Group(1, "Group1", map);
		
		/*Map<Integer, Double> map2 = new HashMap<>();

		map2.put(person2.getId(), (double) 0);
		map2.put(person3.getId(), (double) 0);
		map2.put(person4.getId(), (double) 0);
*/
		Group group2 = new Group(2, "Group2", map);
		
		Map<Integer, Group> groupMap = new HashMap<>();

		groupMap.put(group1.getId(), group1);
		groupMap.put(group2.getId(), group2);

		Groups groups = new Groups(groupMap);
		
		
		
		
		
		Bill  bill = new Bill();
		
		Map<Integer, Double> billContributions = new HashMap<>();

		billContributions.put(1, (double) 150);
		billContributions.put(2, (double) 50);
		billContributions.put(3, (double) 100);


		Map<Integer, Double> billPaidBy = new HashMap<>();	
		billPaidBy.put(1, (double) 100);
		billPaidBy.put(2, (double) 200);

		
		bill.setId(1);
		bill.setBillContributions(billContributions);
		bill.setPaidBy(billPaidBy);
		bill.setGroupId(1);
		bill.setSplitFormula(SplitFormula.AMOUNT);
		bill.setTotalAmount(300.00);
		
		Controller controller = new Controller();

		controller.processBill(bill, groups);
		controller.diplayPersonBalace(groups.getGroupMap().get(bill.getId()));	
		
		
		Bill  bill2 = new Bill();
		
		Map<Integer, Double> billContributions2 = new HashMap<>();

		
		billContributions2.put(1, (double) 100);
		billContributions2.put(2, (double) 50);
		billContributions2.put(3, (double) 100);


		Map<Integer, Double> billPaidBy2 = new HashMap<>();	
		billPaidBy.put(1, (double) 200);
		billPaidBy.put(2, (double) 50);

		
		bill2.setId(2);
		bill2.setBillContributions(billContributions2);
		bill2.setPaidBy(billPaidBy2);
		bill2.setGroupId(1);
		bill2.setSplitFormula(SplitFormula.AMOUNT);
		bill2.setTotalAmount(250.00);
		
		System.out.println("....................");
		
		controller.processBill(bill, groups);
		controller.diplayPersonBalace(groups.getGroupMap().get(bill.getId()));	
		
		//controller.processBill(bill2, groups);
		
	//	controller.diplayPersonBalace(groups.getGroupMap().get(bill2.getGroupId()));	

		
	}
	
	
	public void processBill(Bill bill, Groups groups){
		
		BalanceCalculator balanceCalculator =  new BalanceCalculator();
		balanceCalculator.calculateBalance(bill, groups);
		
	}
	
	public void diplayPersonBalace(Group group){
		
		Map<Integer, Double> balanceMap = group.getBalanceMap();
		Set<Integer> keySet = balanceMap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		
		while(itr.hasNext()){
			Integer key = itr.next();
			
			System.out.println("PersonID =  "+key +" GroupId "+group.getId()+ " Balance = "+balanceMap.get(key) );

			
		}
		
	}
	
}

