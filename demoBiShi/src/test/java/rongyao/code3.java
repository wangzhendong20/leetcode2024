package rongyao;

import java.util.*;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] distanceStr = in.nextLine().split(",");
            int[] distance = new int[distanceStr.length];
            for (int i = 0; i < distanceStr.length; i++) {
                distance[i] = Integer.parseInt(distanceStr[i]);
            }

            String[] condistanceStr = in.nextLine().split(",");
            int[] condistance = new int[condistanceStr.length];
            for (int i = 0; i < condistanceStr.length; i++) {
                condistance[i] = Integer.parseInt(condistanceStr[i]);
            }

            String[] lightStr = in.nextLine().split(",");
            int[] lights = new int[lightStr.length];
            for (int i = 0; i < lightStr.length; i++) {
                lights[i] = Integer.parseInt(lightStr[i]);
            }

            String[] scoreStr = in.nextLine().split(",");
            int[] scores = new int[scoreStr.length];
            for (int i = 0; i < scoreStr.length; i++) {
                scores[i] = Integer.parseInt(scoreStr[i]);
            }

            List<int[]> cars = new ArrayList<>();
            for (int i = 0; i < distance.length; i++) {
                int dis = distance[i];
                int condis = condistance[i];
                int light = lights[i];

                int noCondition = dis - condis;
                int noTime = noCondition / 10;
                int haveTime = condis / 2;
                int lightTime = light* 15 / 2 ;

                int allTime = noTime + haveTime + lightTime;
                cars.add(new int[]{i, allTime, scores[i]});

            }

            int ans = 0;
            int maxScore = cars.get(0)[2];
            Collections.sort(cars, Comparator.comparingInt(o -> o[1]));
            for (int i = 1; i < cars.size(); i++) {
                if (cars.get(i)[2] > maxScore) {
                    ans = i;
                    maxScore = cars.get(i)[2];
                }
            }

            System.out.println((cars.get(ans)[0]+1) + "," + cars.get(ans)[1]);


        }
    }
}
