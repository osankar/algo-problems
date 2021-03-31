package san.ojili.bestsum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        System.out.println("Memoization");
        long start =System.currentTimeMillis();
     //   System.out.println(dynamicBestSumMemo(50,new int[]{1, 2, 25}, new HashMap<>()));
        System.out.println(bestSumMemo(112,new int[]{1, 2, 25}, new HashMap<>()));
        System.out.println("");
        System.out.println(bestSumTabular(112, new int[]{1, 2, 25}));

       /* System.out.println("Naive");
        start =System.currentTimeMillis();
        System.out.println(bestSum(50, new int[]{1, 2, 25,25}));
        System.out.printf("Time: %d", System.currentTimeMillis()-start);*/
    }

    static List<Integer> bestSum(int sum, int[] nums) {
        if (sum==0) {
            return new ArrayList<>();
        }
        if (sum < 0) {
            return null;
        }
        List<Integer> bestCombination = null;
        for (int num : nums) {
            int reminderSum = sum-num;
            List<Integer> combination = bestSum(reminderSum, nums);
            if(combination != null) {
                combination.add(num);
                if (bestCombination == null || bestCombination.size() > combination.size()) {
                    bestCombination = combination;
                }
            }
        }
        return bestCombination;
    }

    static List<Integer> bestSumMemo(int sum, int[] nums, Map<Integer, List<Integer>> memo) {
       // System.out.println(memo);
        if (memo.containsKey(sum)) {
            return memo.get(sum);
        }
        if (sum < 0) {
            return null;
        }
        if (sum == 0) {
            return new ArrayList<>();
        }

       List<Integer> bestCombination = null;
        for(int num : nums) {
            List<Integer> combination = bestSumMemo(sum - num, nums, memo);
            if(combination != null) {
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add(num);
                if(bestCombination == null || bestCombination.size() > newCombination.size()) {
                    bestCombination = newCombination;
                }
            }
        }
        memo.put(sum, bestCombination);
        return bestCombination;
    }

    static List<Integer> bestSumTabular(int targetSum, int[] nums) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i=0; i<=targetSum; i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());
        for(int i=0; i< targetSum; i++) {
            if (table.get(i) == null) {
                continue;
            }
            for (int num : nums) {
                if (i + num > targetSum) {
                   continue;
                }
                List<Integer> currentCombination = table.get(i + num);
                List<Integer> combinationAtI = table.get(i);
                if (currentCombination == null || currentCombination.size() - 1 > combinationAtI.size()) {
                    List<Integer> newCombination = new ArrayList<>(combinationAtI);
                    newCombination.add(num);
                    table.set(i + num, newCombination);
                }
            }
        }
        return table.get(targetSum);
    }
}
