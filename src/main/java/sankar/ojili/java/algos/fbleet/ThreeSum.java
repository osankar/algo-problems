package sankar.ojili.java.algos.fbleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	public static void main(String[] args) {
		SolutionUniqueIndex sol = new SolutionUniqueIndex();
		sol.threeSum(new int[] {-1,0,1,2,-1,-4});
	}
	
}
class SolutionUniqueIndex {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        for (int i=0; i< nums.length-2; i++) {
            int remainingSum = 0- nums[i];
            List<List<Integer>> twoSum = twoSum(nums, i+1, remainingSum);
            for(List<Integer> l: twoSum) {
                l.add(0, nums[i]);
                result.add(l);
            }
        }
        return result;
    }
    
    List<List<Integer>> twoSum(int[] nums, int startIndex, int sum) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=startIndex; i< nums.length-1; i++) {
            int remainingSum = sum-nums[i];
            if(sumIndexMap.get(remainingSum) != null) {
                Integer l = sumIndexMap.get(remainingSum);
                List<Integer> tmpList= new ArrayList<>();
                tmpList.add(l);
                tmpList.add(nums[i]);
                result.add(tmpList);          
            }
           sumIndexMap.put(nums[i],nums[i]);
             
        }
         return result;
    }
    
   
}
class SolutionUniqueNumber {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        for (int i=0; i< nums.length-2; i++) {
            int remainingSum = 0- nums[i];
            List<List<Integer>> twoSum = twoSum(nums, i+1, remainingSum);
            for(List<Integer> l: twoSum) {
                l.add(0, nums[i]);
                result.add(l);
            }
        }
        return result;
    }
    
    List<List<Integer>> twoSum(int[] nums, int startIndex, int sum) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=startIndex; i< nums.length-1; i++) {
            int remainingSum = sum-nums[i];
            if(sumIndexMap.get(remainingSum) != null) {
                Integer l = sumIndexMap.get(remainingSum);
                List<Integer> tmpList= new ArrayList<>();
                tmpList.add(l);
                tmpList.add(nums[i]);
                result.add(tmpList);          
            }
           sumIndexMap.put(nums[i],nums[i]);
             
        }
         return result;
    }
}

class SolutionUniqueCombination {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++) {
            int j= i+1, k = nums.length-1;
            if(i >0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(j < k) {
                if(k < nums.length-1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++; k--;
                    
                }
            }
        }
        return result;
    }
    
    
}
