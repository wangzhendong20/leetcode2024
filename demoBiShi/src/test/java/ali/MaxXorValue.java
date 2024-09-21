package ali;

import java.util.*;

public class MaxXorValue {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] constraints = new int[n][2];


        // Read input constraints
        for (int i = 0; i < n; i++) {
            constraints[i][0] = sc.nextInt();
            constraints[i][1] = sc.nextInt();
        }

        List<List<Long>> possibleNumbersList = new ArrayList<>();
        // Generate all possible numbers based on constraints
        for (int i = 0; i < n; i++) {
            int lowBit = constraints[i][0];
            int highBit = constraints[i][1];
            Set<Long> possibleNumbers = new HashSet<>();

            generateNumbers(lowBit, highBit, possibleNumbers);


            List<Long> possibleNumbersListTmp = new ArrayList<>(possibleNumbers);
            possibleNumbersList.add(possibleNumbersListTmp);
        }

        for (long num : possibleNumbersList.get(0)) {
            findMaxXorHelper(possibleNumbersList, 1, num);
        }


        System.out.println(max % MOD);
    }

    private static void generateNumbers(int lowBit, int highBit, Set<Long> possibleNumbers) {
        long start = (1 << (long) lowBit) + (1 << (long) highBit);
        possibleNumbers.add(start);
        for (int i = highBit-1; i > lowBit; i--) {
            Long numTmp = start + (1 << (long) i);
            possibleNumbers.add(numTmp);
        }
    }

    static long max = Integer.MIN_VALUE;

    private static void findMaxXorHelper(List<List<Long>> lists, int index, long currentXor) {
        // 如果所有列表都已经遍历完，返回当前异或值
        if (index == lists.size()) {
            max = Math.max(max, currentXor);
            return;
        }

        // 遍历当前列表中的每个元素
        for (long num : lists.get(index)) {
            // 递归计算下一个列表
            findMaxXorHelper(lists, index + 1, (currentXor ^ num));
        }
    }
}
