import java.util.Arrays;

public class hard135 {
    public int candy(int[] ratings) {
        int count = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        for (int i = 0; i < candies.length; i++) {
            count += candies[i];
        }

        return count;
    }
}
