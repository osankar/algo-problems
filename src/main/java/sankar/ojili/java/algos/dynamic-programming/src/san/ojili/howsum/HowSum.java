package san.ojili.howsum;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        int[] nums = {15,7};
       // System.out.println(howSum(303, nums));
        System.out.println(howSumMemo(303, nums, new HashMap<>()));
        System.out.println(howSumTabular(303, nums));
    }

    static List<Integer> howSum(int sum, int[] nums) {
        if (sum == 0) {
            return new ArrayList<>();
        }
        if(sum < 0) {
             return null;
        }
        for (int num : nums) {
            int reminder = sum-num;
            List<Integer> how = howSum(reminder, nums);
            if (how != null) {
                how.add(num);
                return how;
            }
        }
        return null;
    }

    static List<Integer> howSumMemo(int sum, int[] nums, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(sum)) {
            return memo.get(sum);
        }
        if (sum == 0) {
            return new ArrayList<>();
        }
        if(sum < 0) {
            return null;
        }
        for (int num : nums) {
            int reminder = sum-num;
            List<Integer> how = howSumMemo(reminder, nums, memo);
            if (how != null) {
                how.add(num);
                memo.put(sum, how);
                return how;
            }
        }
        memo.put(sum, null);
        return null;
    }

    //5, [2,1,3]
    //[[]], [[1]], [[2]], [[2,1]], [[2,1,1]], [[2,1,2]]
    static List<Integer> howSumTabular(int targetSum, int[] nums) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i=0; i <= targetSum; i++) {
            table.add(null);
        }

       table.set(0, new ArrayList<>());
        for(int i=0; i< table.size(); i++) { // O(m)
            if(table.get(i) != null) {
                for (int num: nums) { //O(n)
                    if(i+num < table.size()) {
                        List<Integer> how = new ArrayList<>(table.get(i)); //O(m)
                       how.add(num);
                       table.set(i+num, how);
                    }
                }
            }
        }
        return table.get(targetSum);
    }


}


