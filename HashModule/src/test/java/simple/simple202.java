package simple;

import java.util.HashSet;

public class simple202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = happy(n);
        }
        return true;
    }

    private int happy(int number) {
        int sum = 0;
        while (number > 0) {
            sum += Math.pow(number % 10,2);
            number = number / 10;
        }
        return sum;
    }

}
