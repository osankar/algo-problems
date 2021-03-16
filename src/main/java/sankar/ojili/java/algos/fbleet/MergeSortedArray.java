package sankar.ojili.java.algos.fbleet;

public class MergeSortedArray {
	public static void main(String[] args) {
		InPlaceSolution sol = new InPlaceSolution();
		int[] array1 = { 0 };
		int[] array2 = { 1 };
		sol.merge(array1, 0, array2, 1);
		System.out.println(array1);
	}
}

class InPlaceSolution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		int j = m - 1, k = n - 1;
		while (j >= 0 && j < i) {
			if (j >= 0 && nums1[j] < nums2[k]) {
				nums1[i--] = nums2[k--];
			} else {
				nums1[i--] = nums1[j--];
			}
		}

		while (k >= 0 && i >= 0) {
			nums1[i--] = nums2[k--];
		}

	}
}

class MergeSortedArraySolution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] num1Copy = new int[nums1.length];
		for (int i = 0; i < m; i++) {
			num1Copy[i] = nums1[i];
		}
		int i = 0, j = 0, k = 0;
		while (j < m || k < n) {
			if (j >= m) {
				nums1[i++] = nums2[k++];
			} else if (k >= n) {
				nums1[i++] = num1Copy[j++];
			} else {
				if (num1Copy[j] < nums2[k]) {
					nums1[i++] = num1Copy[j++];
				} else {
					nums1[i++] = nums2[k++];
				}
			}
		}
	}
}
