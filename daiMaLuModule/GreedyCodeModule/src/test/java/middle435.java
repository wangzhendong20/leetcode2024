import java.util.Arrays;

public class middle435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;


        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            } else {
                count++;
            }
        }

        return intervals.length - count;
    }
}
