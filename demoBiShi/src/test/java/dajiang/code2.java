package dajiang;

import java.util.Arrays;
import java.util.Scanner;

public class code2 {
    public static int min_stations(int[] stations, int D) {

        int n = stations.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (stations[i] <= D) {
                dp[i] = 0;
                continue;
            }
            for (int j = i-1; j >=0 && stations[i] - stations[j] <= D; j--) {
                dp[i] = Math.min(dp[i],dp[j]);
            }
            dp[i] += 1;
        }

        if (dp[n-1] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[n-1];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int stations_size = 0;
        stations_size = in.nextInt();
        int[] stations = new int[stations_size];
        for(int stations_i = 0; stations_i < stations_size; stations_i++) {
            stations[stations_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int D;
        D = Integer.parseInt(in.nextLine().trim());

        res = min_stations(stations, D);
        System.out.println(String.valueOf(res));

    }
}
