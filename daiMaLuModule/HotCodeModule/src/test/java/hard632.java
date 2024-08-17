import java.util.Arrays;
import java.util.List;

public class hard632 {
    /**
     * 滑动窗口
     *     // 核心思路:将每个数及其隶属组存入二维数组,然后按照数字大小升序,
     *     // (每个一维数组下标0记录数字下标1记录隶属组)
     *     // 再使用滑动窗口直到包含指定的组,然后再收缩窗口直到数据遍历完毕,取最小区间即可.
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // 数据总数
        int n = 0;
        for(List<Integer> list : nums){
            n += list.size();
        }
        // 二维数组
        int x = 0, y = 0;
        int[][] ordered = new int[n][2];
        for(List<Integer> list : nums){
            for(Integer tmp : list){
                ordered[x][0] = tmp;
                ordered[x][1] = y;
                x++;
            }
            y++;
        }
        // 排序-按照数字排序
        Arrays.sort(ordered,(o1,o2) -> o1[0] - o2[0]);
        // 存储区间结果
        int[] result = new int[2];
        // 统计窗口内每个组所对应数字的具体个数
        int[] count = new int[nums.size()];
        // 滑动窗口内组的个数
        int groupSize = 0;
        // 找到指定数量的组后缩小窗口即减少组内元素的数量
        int tmp = 0;
        for(int i = 0; i < n; i++){
            // 如果没有记录过这个组则组的数量+1并且标记这个组内的元素数量也+1
            // 否则只记录组内元素数量+1
            // 这一步就是滑动窗口直到包含所有组,组内元素数量一般大于组的个数
            if(count[ordered[i][1]]++ == 0){
                groupSize++;
            }
            if(groupSize == nums.size()){
                // 找到指定数量的组后缩小窗口即减少组内元素的数量
                while(count[ordered[tmp][1]] > 1){
                    count[ordered[tmp++][1]]--;
                }
                // 包含初始条件/后续缩小窗口的结果
                if((result[0] == 0 && result[1] == 0)
                        || result[1] - result[0] > ordered[i][0] - ordered[tmp][0]){
                    result = new int[]{ordered[tmp][0],ordered[i][0]};
                }
            }
        }
        return result;
    }
}
