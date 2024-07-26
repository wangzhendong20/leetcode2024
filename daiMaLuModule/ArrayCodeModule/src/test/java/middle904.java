import java.util.HashMap;

public class middle904 {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int slow = 0;
        for (int fast = 0; fast < fruits.length; fast++) {
            map.put(fruits[fast],map.getOrDefault(fruits[fast],0)+1);
            while(map.size() > 2) {
                map.put(fruits[slow],map.getOrDefault(fruits[slow],0)-1);
                if (map.get(fruits[slow]) == 0) {
                    map.remove(fruits[slow]);
                }
                slow++;
            }
            ans = Math.max(ans, fast - slow + 1);
        }

        return ans;
    }
}
