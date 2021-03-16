package sankar.ojili.java.algos.fbleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

}

class GroupAnagramsSol {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String s: strs) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            if(!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<String>());
            }
            groupMap.get(key).add(s);
        }
        return groupMap.values().stream().collect(Collectors.toList());
    }
}
