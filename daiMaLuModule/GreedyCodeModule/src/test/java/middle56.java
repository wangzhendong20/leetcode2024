import java.util.Arrays;
import java.util.LinkedList;

public class middle56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        int left = intervals[0][0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i-1][1]) {
                merged.add(new int[]{left, intervals[i-1][1]});
                left = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            }
        }

        merged.add(new int[]{left, intervals[intervals.length-1][1]});

        return merged.toArray(new int[merged.size()][]);
    }
}
