package yongyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int target = in.nextInt();
            int startFuel = in.nextInt();
            List<int[]> stations = new ArrayList<>();
            String[] disAndFuel = in.next().split(",");
            for (int i = 0; i < disAndFuel.length / 2; i++) {
                int dis = Integer.parseInt(disAndFuel[2 * i]);
                int fuel = Integer.parseInt(disAndFuel[2 * i + 1]);
                stations.add(new int[]{dis, fuel});
            }

            if (startFuel < 0 || startFuel < stations.get(0)[0]) {
                System.out.println(-1);
                continue;
            }

            int curDistance = startFuel;
            int nextDistance = startFuel;
            int ans = 0;
            for(int i = 0; i < stations.size(); i++) {
                if (nextDistance < stations.get(i)[0]) {
                    System.out.println(-1);
                    break;
                } else {
                    nextDistance = Math.max(nextDistance, curDistance + stations.get(i)[1]);
                    if (curDistance == stations.get(i)[0]) {
                        ans++;
                        curDistance = nextDistance;
                    }
                }
            }

            if (nextDistance < target) {
                System.out.println(-1);
                break;
            }

            System.out.println(ans);
        }

    }
}
