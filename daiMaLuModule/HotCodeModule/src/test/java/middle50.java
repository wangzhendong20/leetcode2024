public class middle50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;

        while (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) { // 奇数
                res *= x;
            }
            x *= x;
            b >>= 1;
        }

        return res;
    }

}
