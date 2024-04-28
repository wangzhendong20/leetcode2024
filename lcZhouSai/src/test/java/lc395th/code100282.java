package lc395th;

public class code100282 {
    public long minEnd(int n, int x) {
        long index = x;
        int i = 0;
        while (i < n) {
            long temp = index & x;
            if (temp == x) {
                i++;
                index++;
            } else {
                index = index | x;
            }
        }

        return index - 1;
    }
}
