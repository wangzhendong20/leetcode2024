public class middle738 {
    public int monotoneIncreasingDigits(int n) {
        if (n == 0) return 0;
        char[] digits = String.valueOf(n).toCharArray();
        int index = digits.length;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] > digits[i+1]) {
                digits[i]--;
                index = i+1;
            }
        }

        if (index != digits.length) {
            for (int i = index; i < digits.length; i++) {
                digits[i] = '9';
            }
        }


        return Integer.parseInt(new String(digits));
    }
}
