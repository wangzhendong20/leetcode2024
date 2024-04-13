public class middle11 {
    /**
     * 双指针
     * 每轮都计算
     * 哪边小就移动
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int hei = Math.min(height[left],height[right]);
            int len = right - left;
            ans = Math.max(ans,hei * len);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
