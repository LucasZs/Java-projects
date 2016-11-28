package coinsV2developed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ShapeSeparator {
	public List<Set<Shape>> separete(Set<Shape> set) {
		List<Set<Shape>> list = new ArrayList<>();
		Set<Shape> tri = new HashSet<>();
		Set<Shape> cir = new HashSet<>();
		Set<Shape> rect = new HashSet<>();
		Iterator<Shape> it = set.iterator();

		while (it.hasNext()) {
			Shape next = it.next();
			if (next instanceof Circle) {
				cir.add(next);
			}

			else if (next instanceof Triangle) {
				tri.add(next);
			}

			else if (next instanceof Rectangle) {
				rect.add(next);
			}
		}

		if (!tri.isEmpty()) {
			list.add(tri);
		}
		if (!cir.isEmpty()) {
			list.add(cir);
		}
		if (!rect.isEmpty()) {
			list.add(rect);
		}
		return list;
	}
}
