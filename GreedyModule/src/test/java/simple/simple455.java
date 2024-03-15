package simple;

import java.util.Arrays;

public class simple455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        int ans = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                ans++;
                j++;
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
