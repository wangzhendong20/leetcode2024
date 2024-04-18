package simple;

import java.util.HashMap;
import java.util.HashSet;

public class simple1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int ar : arr) {
            map.put(ar,map.getOrDefault(ar,0)+1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            set.add(value);
        }

        if (set.size() != map.size()) {
            return false;
        }
        return true;
    }
}
