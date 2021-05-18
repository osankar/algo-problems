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
        //divide the problem into subproblems' In this case sum is reduced to sum-current_number.
        //Noe the problem reduced to find the combination to get to teh sum of sum-current_number
        //For every recurise call the sum goes down till it becomes 0.
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
    
    /**
    * Same as brute-force recursive but avoids repeated solving of subproblems by memoizing the results of the subproblems that are already solved.
    */
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
        //memoize the result of the subproblem
        memo.put(sum, bestCombination);
        return bestCombination;
    }

    static List<Integer> bestSumTabular(int targetSum, int[] nums) { //let sum be m abd nums be of size n, the time complexity is O(mXn) and space complexity is also o(mxN)
        List<List<Integer>> table = new ArrayList<>();
        //initialize all elements of the list with null; make all positions unreachable;
        for (int i=0; i<=targetSum; i++) {
            table.add(null);
        }
        //position 0 is reserved for base case i.e. way to reach sum of zero. 
        table.set(0, new ArrayList<>());
        for(int i=0; i< targetSum; i++) { 
            //A non reachable position indicates an impossible sum.
            //As we move from 0th postion to Nth position, we populate the position with the possible combination of number that sums up to the position/index.
            //We start 0th with empty List by the time we move to a Kth position, we would have various possibilities to reach all the K-1 positions. 
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
