package middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class middle406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[people.length][]);
    }
}
