package middle;

import java.util.*;

public class middle49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            String newStr = changeStr(str);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            }else {
                List<String> array = new ArrayList<>();
                array.add(str);
                map.put(newStr,array);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> listEntry : map.entrySet()) {
            res.add(listEntry.getValue());
        }
        return res;
    }

    private String changeStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
