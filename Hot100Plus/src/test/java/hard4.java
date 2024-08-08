public class hard4 {
    /**
     * 求两个有序数组的中位数 -> 求第k小的数
     * 核心思想是每次排除k/2个数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // 奇数时，取中间值；偶数时，取中间两个数的平均值;
        // 将奇数和偶数的情况合并处理，奇数时的k是相同的;
        // 例如 n = 1, m = 2, 那么left = 2, right = 2; 而 n=2,m=2,那么 left = 2, right = 3;
        return (getKth(nums1,0,n-1,nums2,0,m-1,left) + getKth(nums1,0,n-1,nums2,0,m-1,right)) * 0.5;
    }


    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) { //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) return nums2[start2 + k - 1];  // len1空了，那直接从nums2里选
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);  //k=1的时候取小的那个数

        // 每次排除 k/2 个数，然后递归查找
        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;

        if (nums1[i] > nums2[j]) { // 选大的那个，把小的那个数组里的前面的数排除掉
            return getKth(nums1, start1, end1, nums2, j+1, end2 , k - (j - start2 + 1));
        } else {
            return getKth(nums1, i+1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }


    /**
     * 通过不合并两个数组求中位数的方法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;

        int left = -1, right = -1;
        int aStart = 0, bStart = 0;

        for (int i = 0; i < len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }

        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }

    }
}
