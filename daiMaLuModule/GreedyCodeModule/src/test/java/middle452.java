import java.util.Arrays;

public class middle452 {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> Long.compare(o1[0],o2[0])));
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}});
    }
}
