package san.ojili.cansum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        int[] array = {2,5, 7};
        //System.out.println(canSumTabular(27, List.of(9), new HashMap<>()));

        System.out.println(canSumTabular(32, List.of(9, 5, 3, 2)));

    }

    static boolean canSum(int sum, List<Integer> array) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
             return false;
        }

        for (int num : array) {
            if (canSum(sum-num, array)) {
                return true;
            }
        }

        return false;
    }

    static boolean canSumMemo(int sum, List<Integer> array, Map<Integer, Boolean> memo) {
        if (memo.get(sum) != null) {
            return memo.get(sum);
        }
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }

        for (int num : array) {
            if (canSum(sum-num, array)) {
                memo.put(sum-num, true);
                return true;
            }
        }
        memo.put(sum, false);
        return false;
    }

    static boolean canSumTabular(int targetSum, List<Integer> nums) {
        boolean[] table = new boolean[targetSum+1];
        table[0] = true;
        for(int i=0; i< table.length; i++) { // o(m)
            if(table[i]) {
                for (int num : nums) { // 0(n)
                    if(i+num < table.length) {
                        table[i+num] = true;
                    }
                }
            }
        }
        // O(m*n)
        // O(m)
        return table[targetSum];
    }

}
