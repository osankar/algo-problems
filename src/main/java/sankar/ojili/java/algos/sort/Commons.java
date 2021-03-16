package sankar.ojili.java.algos.sort;

import java.util.List;

public class Commons {
	public static <T extends Comparable<T>> boolean less(T first, T second) {
		return first.compareTo(second)< 0;
	}
	
	public static <T extends Comparable<T>>void exchange(int i, int j, List<T> list) {
		T swap = list.get(i);
		list.set(i, list.get(j));
		list.set(j, swap);
	}
	
	public static <T extends Comparable<T>> boolean isSorted(List<T> elements) {
		for (int i=1; i< elements.size(); i++) {
			if (less(elements.get(i), elements.get(i-1))) {
				return false;
			}
		}
		
		return true;
	}
}
