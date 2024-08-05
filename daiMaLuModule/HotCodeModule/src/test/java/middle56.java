import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2) -> o1[0]-o2[0]);

        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i-1][1]) {
                list.add(new int[]{intervals[i-1][0], intervals[i-1][1]});
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
                intervals[i][0] = intervals[i-1][0];
            }
        }

        list.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});

        int[][] ans= new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }
}
