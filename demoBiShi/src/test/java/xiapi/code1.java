package xiapi;

public class code1 {
    public boolean plantFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;
            if (i > 0 && i < flowerbed.length - 1 &&
                    (flowerbed[i] == 1 || flowerbed[i-1] == 1 || flowerbed[i+1] == 1)) {
                continue;
            } else if (i == 0 && (flowerbed[i] == 1 || flowerbed[i+1] == 1)) {
                continue;
            } else if (i == flowerbed.length - 1 && (flowerbed[i] == 1 || flowerbed[i-1] == 1)) {
                continue;
            } else {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
