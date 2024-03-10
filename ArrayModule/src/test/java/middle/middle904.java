package middle;

import java.util.HashMap;

public class middle904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0) + 1);
            while (map.size() > 2 ) {
                map.put(fruits[left],map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
