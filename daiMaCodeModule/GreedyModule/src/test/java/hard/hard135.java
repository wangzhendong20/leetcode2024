package hard;

import java.util.Arrays;

public class hard135 {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        Arrays.fill(candyVec,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) candyVec[i] = candyVec[i-1] + 1;
        }
        for (int i = ratings.length - 2;  i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
            }
        }
        return Arrays.stream(candyVec).sum();
    }
}
