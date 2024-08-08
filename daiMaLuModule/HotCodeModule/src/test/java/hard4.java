public class hard4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len1 = (m + n + 1) / 2;
        int len2 = (m + n + 2) / 2;

        return (getKthElement(nums1,0,m-1,nums2,0,n-1,len1) + getKthElement(nums1,0,m-1,nums2,0,n-1,len2)) / 2.0;

    }

    private int getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return getKthElement(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(k / 2, len1) - 1;
        int j = start2 + Math.min(k / 2, len2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKthElement(nums1,start1,end1, nums2,j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKthElement(nums1,i+1, end1, nums2, start2, end2,k - (i - start1 + 1));
        }

    }
}
