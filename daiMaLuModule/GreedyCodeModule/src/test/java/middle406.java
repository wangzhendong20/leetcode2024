import java.util.Arrays;
import java.util.LinkedList;

public class middle406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            queue.add(pos, people[i]);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
