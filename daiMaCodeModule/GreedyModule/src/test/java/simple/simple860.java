package simple;

public class simple860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        int[] money = new int[2];  //5的数量和10的数量

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            } else if (bills[i] == 10) {
                if (money[0] > 0) {
                    money[0]--;
                    money[1]++;
                } else {
                    return false;
                }
            } else {
                if (money[1] > 0) {
                    money[1]--;
                    if (money[0] > 0) {
                        money[0]--;
                    } else {
                        return false;
                    }
                } else if (money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
