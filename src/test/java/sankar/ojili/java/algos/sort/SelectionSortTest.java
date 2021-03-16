package sankar.ojili.java.algos.sort;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class SelectionSortTest {

	@Test
	public void test() throws Exception {
			List<Integer> list = new ArrayList<Integer>(
					List.of(1,  10,  3,  5,  12,  90,  5, 7, 100, -1));
			SelectionSort<Integer> sorter = new SelectionSort<>();
			sorter.sort(list);
			assertTrue(Commons.isSorted(list));
			
	}
	
	@Test
	public void less() {
		assertTrue(Commons.less(3, 10));
		assertFalse(Commons.less(10, 4));
	}
	
	
}
