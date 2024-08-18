public class hard440 {
    /**
     * BFS+DFS
     * 考虑前缀树。
     * 字典序会给我们这样一个顺序，
     * 1作为根节点（前缀），子节点为10 - 19（以1为前缀）;
     * 10作为根节点，子节点为100 - 109（以10为前缀）;
     * 以此类推
     * 我们需要找k属于哪个根节点下的哪个子节点。
     * 假如1为根节点的全部的节点数都不够，那么bfs到2为根节点继续找
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        long point = 1;  // 当前指针
        long curN = 1;  // 当前前缀

        while (point < k) {
            long count = dfs(curN, curN, n);
            //当前要求数字是否在当前前缀下
            if (point + count > k) {//在当前前缀下
                curN *= 10;
                //修改指针,把指针指向该节点下第一个子节点的位置
                //当前节点的子节点中，取走当前根节点，dfs向下 (比如 1 -> 10)
                point++;
            } else {
                curN++;
                //修改指针,把指针指向同层下一前缀的起点
                //当前节点中总数都小于需要的数，可以全部取走，bfs到同层下一点 (比如 1 -> 2)
                point += count;
            }
        }

        return (int) curN;
    }


    /**
     * 确定指定前缀下的所有子节点数(包括当前节点)
     * 第一轮 curN = 1, nextN = 1 count计算的就是 1 - 1之间的个数
     * 第二轮 curN = 10, nextN = 19 count计算的就是 10 - 19之间的个数
     * 第二轮 curN = 100, nextN = 190 count计算的就是 100 - 199之间的个数
     * 依次类推...
     * 递归之后返回的就是节点前缀为1的子节点数
     * @param curN
     * @param nextN
     * @param n
     * @return
     */
    private long dfs(long curN, long nextN, int n) {
        if (curN > n) return 0;

        long count = Math.min(nextN, n) - curN + 1;

        return count + dfs(curN * 10, nextN * 10 + 9, n);
    }


}
