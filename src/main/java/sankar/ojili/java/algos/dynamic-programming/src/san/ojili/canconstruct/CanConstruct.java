package san.ojili.canconstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
      System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeee", List.of("e", "ee", "e", "eeee", "eeeeee")));
      System.out.println(canConstructTabular("eeeeeeeeeeeeeeeeeeeeeeeee", List.of("e", "ee", "e", "eeee", "eeeeee")));
      //  System.out.println(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee"), new HashMap<>()));
    }

    static boolean canConstruct(String targetWord, List<String> wordList) {
        System.out.println(targetWord);
        if (targetWord.equals("")) {
            return true;
        }

        for(String word : wordList) {
            if(targetWord.startsWith(word)) {
                String remainingTarget = targetWord.substring(word.length());
                System.out.println(remainingTarget);
                if (canConstruct(remainingTarget, wordList)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canConstructMemo(String targetWord, List<String> wordList, Map<String, Boolean> memo) {
        if (memo.containsKey(targetWord)) {
            return memo.get(targetWord);
        }
        if (targetWord.equals("")) {
            return true;
        }


        for(String word : wordList) {
            if(targetWord.startsWith(word)) {
                String remainingTarget = targetWord.substring(word.length());
                if (canConstructMemo(remainingTarget, wordList, memo)) {
                    memo.put(targetWord, true);
                    return true;
                }
            }
        }
        memo.put(targetWord, false);
        return false;
    }
    //"abcd" [a, b, d, c]
   // [t, t, t, t, f]
    static boolean canConstructTabular(String targetWord, List<String> wordBank) {
        boolean[] table = new boolean[targetWord.length()+1];
        table[0]=true;
        for(int i=0; i<= targetWord.length(); i++) {
            if(table[i]) {
                String currentTarget = targetWord.substring(i);
                for(String word : wordBank) {
                    if(currentTarget.startsWith(word)) {
                        table[i+word.length()] = true;
                    }
                }
            }
        }

        return table[targetWord.length()];
    }
}
