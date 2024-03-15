package simple;

public class simple1221 {
    public int balancedStringSplit(String s) {
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                sum++;
            } else {
                sum--;
            }
            if (sum == 0) {
                ans++;
                sum = 0;
            }
        }

        return ans;
    }
}
