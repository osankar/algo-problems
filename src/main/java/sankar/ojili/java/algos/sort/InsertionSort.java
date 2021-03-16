package sankar.ojili.java.algos.sort;

import java.util.List;

/**
 * Selection sort works by invariants
 * 1. All the elements left to the visitor including the visitor are sorted. 
 * 2. The elements to the right of the visitor are not yet seen. 
 * @author lojili
 *
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> {
	
	public void sort(List<T> list) {
		//1,  10,  3,  5,  12,  90,  5, 7, 100, -1
		for(int i=0; i < list.size(); i++) { //i = visitor pointer
			for(int j = i; j > 0; j--) { 
				//Make sure all elements between 0 and visitor are sorted. Don't visit beyond the visitor pointer
				if(Commons.less(list.get(j), list.get(j-1))) {
					Commons.exchange(j, j-1, list);
				} else {
					break;
				}
			}
		}
	}

}
