package sankar.ojili.java.algos.sort;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> {
	
	public void sort(List<T> elemnts) {
		for (int i=0; i<elemnts.size(); i++) {
			int minIdx = getMinIndex(i, elemnts);
			Commons.exchange(i, minIdx, elemnts);
		}
	}
	
	private int getMinIndex(int startIdx, List<T> elements) {
		int minIdx = startIdx;
		T min = elements.get(startIdx);
		for (int i= startIdx+1; i < elements.size(); i++) {
			if (Commons.less(elements.get(i), min)) {
				min = elements.get(i);
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	}
