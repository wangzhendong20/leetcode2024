package tongcheng;

public class code2 {
    public int StringSplit (String str) {
        int len = str.length();
        int[] leftCount = new int[len];
        int[] rightCount = new int[len];

        int maxCount = 0;
        leftCount[0] = str.charAt(0) == 'a'? 1 : 0;
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == 'a') {
                leftCount[i] = leftCount[i - 1] + 1;
            } else {
                leftCount[i] = leftCount[i - 1];
            }
        }

        rightCount[len - 1] = str.charAt(len - 1) == 'b'? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (str.charAt(i) == 'b') {
                rightCount[i] = rightCount[i + 1] + 1;
            } else {
                rightCount[i] = rightCount[i + 1];
            }
        }

        for (int i = 0; i < len - 1; i++) {
            maxCount = Math.max(maxCount,leftCount[i] + rightCount[i+1]);
        }

        return maxCount;
    }
}
