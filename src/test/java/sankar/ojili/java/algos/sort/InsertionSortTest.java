package sankar.ojili.java.algos.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



public class InsertionSortTest {

	@Test
	public void test() throws Exception {
			List<Integer> list = new ArrayList<Integer>(
					List.of(1,  10,  3,  5,  12,  90,  5, 7, 100, -1));
			InsertionSort<Integer> sorter = new InsertionSort<>();
			sorter.sort(list);
			assertTrue(Commons.isSorted(list));
			
	}
}
