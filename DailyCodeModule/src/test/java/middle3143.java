import java.util.*;

public class middle3143 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        Set<Character> set = new HashSet<>();
        TreeMap<Integer, List<Character>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(Math.max(Math.abs(points[i][0]), Math.abs(points[i][1])), key -> new ArrayList<>()).add(s.charAt(i));
        }
        int ans = 0;
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            List<Character> t = entry.getValue();
            for (Character c : t) {
                if (set.contains(c)) {
                    return ans;
                }
                set.add(c);
            }
            ans = set.size();
        }
        return ans;
    }

    public int maxPointsInsideSquare2(int[][] points, String s) {
        int[] minD = new int[26];
        Arrays.fill(minD, Integer.MAX_VALUE);
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int dis = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            int c = s.charAt(i) - 'a';
            if (dis < minD[c]) {
                // dis 是目前最小的，那么 minD[c] 是次小的
                min2 = Math.min(min2, minD[c]);
                minD[c] = dis;
            } else {
                // dis 可能是次小的
                min2 = Math.min(min2, dis);
            }
        }

        int ans = 0;
        for (int d : minD) {
            if (d < min2) {
                ans++;
            }
        }
        return ans;
    }

}
