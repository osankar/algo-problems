package san.ojili.numconstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumWaysConstruct {
    public static void main(String[] args) {
       // System.out.println(numWays("abcdefg", List.of("ab",  "f", "g", "abcde")));
        System.out.println(numWaysTabular("abcdefgf", List.of("ab", "cd", "cde", "e", "f", "g", "abcde")));
        //System.out.println(numWaysMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eeeeee", "eeeeeeeee", "eeeeeeeeeee"), new HashMap<>()));
        //"eeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee"))
    }

    static int numWays(String targetWord, List<String> wordBank) {
        if (targetWord.equals("")) {
            return 1;
        }
        int ways = 0;
        for (String word: wordBank) {
            if (targetWord.startsWith(word)) {
                ways+= numWays(targetWord.substring(word.length()), wordBank);
            }
        }
        return ways;
    }

    static int numWaysMemo(String targetWord, List<String> wordBank, Map<String, Integer> memo) {
        if (targetWord.equals("")) {
            return 1;
        }
        if(memo.containsKey(targetWord)) {
           return memo.get(targetWord);
        }
        int ways = 0;
        for (String word: wordBank) {
            if (targetWord.startsWith(word)) {
                ways+= numWaysMemo(targetWord.substring(word.length()), wordBank, memo);
            }
        }
        memo.put(targetWord, ways);
        return ways;
    }

    //"abcdefg", List.of("ab",  "f", "g", "abcde")
    //[1, 0, 1, 0, 0, 1, 1, 1]

    static int numWaysTabular(String targetWord, List<String> wordBank) {
        int[] waysTable = new int[targetWord.length()+1];
        waysTable[0] = 1;
        for(int i=0; i< targetWord.length(); i++) { //O(m)
            String current = targetWord.substring(i);
            for(String word : wordBank) { //O(n)
                if(current.startsWith(word)) {
                    waysTable[i+word.length()] =  waysTable[i]+ waysTable[i+word.length()];
                }
            }
        }
        return waysTable[targetWord.length()];
    }
}
