package problem5;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> emp= new HashMap<>();
		emp.put("ram", 12);
		emp.put("shaym", 20);
		if(emp.containsKey("ram")) {
			System.out.println(emp.get("ram"));
		}else {
			System.out.println("employee not found");
		}
	}

}
