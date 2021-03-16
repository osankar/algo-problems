package sankar.ojili.java.algos.fbleet;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithkDistinctChars {
	 public static void main(String[] args) {
		LSKChars sol = new LSKChars();
		sol.lengthOfLongestSubstringKDistinct("eceba", 2);
	}
}

class LSKChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength = 0;
        int currentLength = 0;
        int start = 0, end = 0;
        Map<Character, Integer> tracker = new HashMap<>();
        while(end<s.length()) {
            currentLength ++;
            addCharacter(s.charAt(end), tracker);
            while(tracker.keySet().size() > k) {
                removeCharacter(s.charAt(start++), tracker);
                currentLength--;
            }
            maxLength= Math.max(currentLength, maxLength);
            end++;
        }
        return maxLength;
    }
    
    void addCharacter(char c,  Map<Character, Integer> tracker) {
        if(!tracker.containsKey(c)) {
            tracker.put(c, 0);
        }
        tracker.put(c, tracker.get(c)+1);
    }
    void removeCharacter(char c,  Map<Character, Integer> tracker) {
        if(tracker.get(c) == 1) {
            tracker.remove(c);
        } else {
        	tracker.put(c, tracker.get(c)-1);
        }
         
    }
}
