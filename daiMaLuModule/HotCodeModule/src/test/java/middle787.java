import java.util.Arrays;

public class middle787 {

    /**
     * Bellman_ford之单源有限最短路
     * 模板题
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] misDist = new int[n];
        Arrays.fill(misDist,Integer.MAX_VALUE);
        misDist[src] = 0;

        for (int i = 1; i <= k+1; i++) {
            int[] misDist_copy = misDist.clone(); // 获取上一次计算的结果
            for (int[] flight : flights) {
                int start = flight[0], end = flight[1];
                int price = flight[2];
                // 注意使用 minDist_copy 来计算 minDist
                if (misDist_copy[start] != Integer.MAX_VALUE && misDist[end] > misDist_copy[start] + price) {
                    misDist[end] = misDist_copy[start] + price;
                }
            }
        }

        if (misDist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return misDist[dst];
        }

    }
}
