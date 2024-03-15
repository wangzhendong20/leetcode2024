package simple;

import java.util.*;

public class simple1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = CalBit(o1);
                int count2 = CalBit(o2);
                if (count1 == count2) return Integer.compare(o1,o2);
                return Integer.compare(count1,count2);
            }
        }).mapToInt(Integer::intValue).toArray();
    }
    private int CalBit(int n) {
        int count = 0;
        if (n == 0) return count;

        while (n != 0) {
            n &= (n-1);  //清除最低位的1
            count++;
        }
        return count;
    }
}
