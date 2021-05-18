package san.ojili.allconstruct;

import java.util.*;

public class AllConstruct {

    public static void main(String[] args) {
        //System.out.println(allConstruct("ab", List.of("a", "b", "ab")));
        System.out.println(allConstructMemo("abc", List.of("a", "b", "ab","c", "bc"), new HashMap<>()));
        System.out.println(allConstructTabular("abc", List.of("a", "b", "ab", "c", "bc")));
        //System.out.println(allConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eeee", "eeeeee", "eeeeeeee", "e"), new HashMap<>()));
        //"eeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee"))
    }

    static List<List<String>> allConstruct(String targetWord, List<String> wordBank) {
        if(targetWord.equals("")) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<String>> allWays = new ArrayList<>();
        for(String word: wordBank) {
            if(targetWord.startsWith(word)) {
                List<List<String>> ways = allConstruct(targetWord.substring(word.length()), wordBank);
                for (List<String> way : ways) {
                    way.add(word);
                    allWays.add(way);
                }
            }
        }
        return allWays;
    }

    static List<List<String>> allConstructMemo(String targetWord, List<String> wordBank, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(targetWord)) {
            return copy(memo.get(targetWord));
        }
        if(targetWord.isEmpty()) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<String>> allWays =  new ArrayList<>();
        for (String word: wordBank) {
            if(targetWord.startsWith(word)) {
                var currentWays = allConstructMemo(targetWord.substring(word.length()), wordBank, memo);
                for (var currentWay : currentWays) {
                    List<String>  way = new ArrayList<>(currentWay);
                    way.add(word);
                    allWays.add(way);
                }
            }
        }
        memo.put(targetWord, allWays);
        return allWays;
    }

    static List<List<String>> copy(List<List<String>> list) {
        List<List<String>> copy = new ArrayList<>();
        list.stream().forEach(l -> copy.add(new ArrayList<>(l)));
        return copy;
    }

    static List<List<String>> allConstructTabular(String targetWord, List<String> wordBank) {
        List<List<List<String>>> allWays = new ArrayList<>();
        for (int i=0; i<= targetWord.length(); i++) {
            allWays.add(new ArrayList<>());
        }
        allWays.get(0).add(new ArrayList<>()); // base case
        for(int i=0; i<= targetWord.length(); i++) {
            String current = targetWord.substring(i);
            if(allWays.get(i) != null) {
                List<List<String>> waysFromCurrent = allWays.get(i);
                for(String word : wordBank) {
                    if(current.startsWith(word)) {
                       List<List<String>> ways = allWays.get(i+word.length());
                       for(List<String> wayFromCurrent : waysFromCurrent) {
                           List<String> way = new ArrayList<>(wayFromCurrent);
                           way.add(word);
                           ways.add(way);
                       }
                    }
                }
            }
        }
        return allWays.get(targetWord.length());
    }
}
