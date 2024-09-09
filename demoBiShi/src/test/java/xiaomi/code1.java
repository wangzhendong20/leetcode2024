package xiaomi;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> mapA = new TreeMap<>();
        TreeMap<Integer,Integer> mapB = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            mapA.put(sc.nextInt(), i);
        }
        for (int i = 0; i < n; i++) {
            mapB.put(sc.nextInt(), i);
        }

        int time = mapA.firstKey() + mapB.firstKey();
        if (mapA.firstEntry().getValue().equals(mapB.firstEntry().getValue())) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
                if (entry.getKey().equals(mapA.firstKey())) {
                    continue;
                } else {
                    min = Math.min(min, entry.getKey());
                    break;
                }
            }
            for (Map.Entry<Integer, Integer> entry : mapB.entrySet()) {
                if (entry.getKey().equals(mapB.firstKey())) {
                    continue;
                } else {
                    min = Math.min(min, entry.getKey());
                    break;
                }
            }
            if (min < time) {
                time = min;
            }
        } else {
            time = Math.max(mapA.firstKey(), mapB.firstKey());
        }


        System.out.println(time);

    }
}
