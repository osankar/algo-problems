package san.ojili.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        Map<Integer, Long> memo = new HashMap<>();
        Long fib = fib(10, memo);
        System.out.printf("Fib 10: %d \n", fib);

        System.out.printf("Fib 10: %d", fibTabular(10));
    }

    static Long fib(int n, Map<Integer, Long> memo) {
        if (memo.get(n) != null)  {
            return memo.get(n);
        }
        if(n<=2) {
            return 1L;
        }
        memo.put(n,fib(n-1, memo) + fib(n-2, memo));
        return memo.get(n);
    }

    static long fibTabular(int num) {
        long[] fibTable = new long[num+1];
        fibTable[0]=0;
        fibTable[1]=1;
        for(int i=2; i<=num; i++) {
            fibTable[i] = fibTable[i-1]+fibTable[i-2];
        }
        return fibTable[num];
    }
}
