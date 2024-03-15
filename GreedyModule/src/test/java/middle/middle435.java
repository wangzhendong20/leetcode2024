package middle;

import java.util.Arrays;

public class middle435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1],o2[1]));

        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
