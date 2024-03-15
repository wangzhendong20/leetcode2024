package middle;

import java.util.Arrays;

public class middle452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
            return Integer.compare(o1[0],o2[0]);
        });
        int ans = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            right = Math.min(right,points[i][1]);
            if (points[i][0] > right) {
                right = points[i][1];
                ans++;
            }
        }
        return ans;

//        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
//
//        int count = 1;  // points 不为空至少需要一支箭
//        for (int i = 1; i < points.length; i++) {
//            if (points[i][0] > points[i - 1][1]) {  // 气球i和气球i-1不挨着，注意这里不是>=
//                count++; // 需要一支箭
//            } else {  // 气球i和气球i-1挨着
//                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 更新重叠气球最小右边界
//            }
//        }
//        return count;
    }
}
