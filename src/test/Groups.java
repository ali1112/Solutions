package test;

import java.util.HashMap;
import java.util.Map;

public class Groups {

	Map<Integer, Group> groupMap = new HashMap<Integer, Group>();

	public Groups(Map<Integer, Group> groupMap) {
		super();
		this.groupMap = groupMap;
	}

	public Map<Integer, Group> getGroupMap() {
		return groupMap;
	}

	public void setGroupMap(Map<Integer, Group> groupMap) {
		this.groupMap = groupMap;
	}
	
	
	
}
