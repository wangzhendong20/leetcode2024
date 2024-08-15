package yongyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int target = in.nextInt();
            int startFuel = in.nextInt();
            List<int[]> stations = new ArrayList<>();
            while (in.hasNext()) {
                String[] disAndFuel = in.next().split(",");
                int dis = Integer.parseInt(disAndFuel[0]);
                int fuel = Integer.parseInt(disAndFuel[1]);
                stations.add(new int[]{dis, fuel});
            }
//            String[] disAndFuel = in.next().split(",");
//            for (int i = 0; i < disAndFuel.length / 2; i++) {
//                int dis = Integer.parseInt(disAndFuel[2 * i]);
//                int fuel = Integer.parseInt(disAndFuel[2 * i + 1]);
//                stations.add(new int[]{dis, fuel});
//            }

            if (stations.size() == 0) {
                System.out.println(-1);
                continue;
            }


            System.out.println(maxAns(target, startFuel, stations));
        }

    }

    private static int maxAns(int target, int startFuel, List<int[]> stations) {
        int[] dp = new int[stations.size() + 1];
        dp[0] = startFuel;

        for (int i = 0; i < stations.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations.get(i)[0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations.get(i)[1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;
    }
}
