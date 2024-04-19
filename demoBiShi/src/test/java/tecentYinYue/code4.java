package tecentYinYue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code4 {
    public static int maxLen (String s, int k) {
        int n = s.length();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  Integer.compare(o2, o1);
            }
        });
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                if (sum > 0) {
                    pq.add(sum);
                    sum = 0;
                }
            }
        }

        if (sum > 0) {
            pq.add(sum);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Integer cur = pq.poll();
            if (cur == 0) {
                k++;
                continue;
            }
            if (cur == 1) {
                continue;
            }
            if (cur == 2) {
                pq.add(cur-1);
                continue;
            }
            if (cur % 2 != 0) {
                pq.add(cur / 2);
                pq.add(cur / 2);
            } else {
                pq.add(cur / 2);
                pq.add(cur / 2 - 1);
            }
        }

        if (k > 0) return 0;
        return pq.isEmpty()? 0 : pq.peek();
    }

    public static void main(String[] args) {
        String s = "110111011110011111101111111";
        System.out.println(maxLen(s,2));
    }
}
