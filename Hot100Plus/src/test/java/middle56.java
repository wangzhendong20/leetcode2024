import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle56 {
    /**
     * 56. 合并区间
     * 排序 + 贪心法
     * 重叠区间问题
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2) -> o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start,end});

        return list.toArray(new int[list.size()][]);
    }
}
