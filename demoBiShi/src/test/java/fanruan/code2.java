package fanruan;

import java.util.*;

public class code2 {

    private HashMap<Integer, ArrayList<Integer>> dp = new HashMap<Integer, ArrayList<Integer>>();

    class Pair {
        int num;
        ArrayList<Integer> usedNums;
        public Pair(int num, ArrayList<Integer> usedNums) {
            this.num = num;
            this.usedNums = usedNums;
        }
    }
    private ArrayList<Integer> findNums(int N) {
        //BFS
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i*i*i <= N; i++) {
            nums.add(i*i*i);
        }

        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(N, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int remain = cur.num;
            ArrayList<Integer> usedNums = cur.usedNums;
            if (remain == 0) {
                Collections.sort(usedNums, Collections.reverseOrder());
                return usedNums;
            }
            for (int i = nums.size() - 1; i >= 0 ; i--) {
                int num = nums.get(i);
                if (num <= remain) {
                    ArrayList<Integer> newUsedNums = new ArrayList<>(usedNums);
                    newUsedNums.add((int)Math.cbrt(num));
                    queue.offer(new Pair(remain - num, newUsedNums));
                }
            }
        }
        return null;
    }

    private ArrayList<Integer> findNums2(int N) {
        if (N == 0) return new ArrayList<>();
        if (dp.containsKey(N)) return dp.get(N);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = (int)Math.cbrt(N); i > 0; i--) {
            int num = i * i * i;
            if (num <= N) {
                ArrayList<Integer> curList = new ArrayList<>(findNums(N - num));
                curList.add(i);
                if (res.isEmpty() || curList.size() < res.size()) {
                    res = curList;
                }
            }
        }

        dp.put(N, res);
        Collections.sort(res,Collections.reverseOrder());

        return res;
    }


    public ArrayList<Integer> MinimumK (int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (N == 1) {
            result.add(1);
            return result;
        }

        return findNums(N);

    }
}
