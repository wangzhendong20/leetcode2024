public class simple136 {
    /**
     * 两个相同的数^异或为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(4^1^2^1^2);
    }
}
