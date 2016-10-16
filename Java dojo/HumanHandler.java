package test_new;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HumanHandler {

	public static void main(String[] args) {
		//Human attila = new Human("Attila", 25, 1.85);
		Human attila = new Human("Attil", 25, 1.85);
		Human zalan = new Human("Zalán", 28, 1.80);

		Set<Human> humans = new HashSet<>();
		humans.add(attila);
		humans.add(zalan);
		System.out.println("Set size: " + humans.size());
		
		Map<Human, Integer> humanMap = new HashMap<>();
		humanMap.put(attila, 1);
		humanMap.put(zalan, 2);
		System.out.println("Map size: " + humanMap.size());
		System.out.println("Map value: " + humanMap.get(attila));
		
		List<Human> humanList = new ArrayList<>();
		humanList.add(attila);
		humanList.add(attila);
		humanList.add(attila);
		humanList.add(zalan);
		System.out.println("List size: " + humanList.size());
		System.out.println("List index: " + humanList.indexOf(zalan));
	}

}
