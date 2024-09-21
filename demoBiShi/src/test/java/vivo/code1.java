package vivo;

public class code1 {
    public int staffGroup (int[] staff) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i] == 1) {
                zero++;
            } else {
                one++;
            }
        }

        int group = 0;
        if (zero >= one) {
            group = zero;
        } else {
            group += zero;
            one = one - zero;
            if(one % 3 == 0) {
                group += one/3;
            } else {
                group += one/3+1;
            }

        }

        return group;
    }
}
