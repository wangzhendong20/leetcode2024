package middle;

import java.util.HashMap;

public class middle649 {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        boolean R = true;  //是否还存在R
        boolean D = true;   //是否还存在D

        int flag = 0;

        while (R && D) {   //轮次
            R = false;
            D = false;
            for (int i = 0; i < chars.length; i++) {  //单轮逻辑
                if (chars[i] == 'R') {
                    if (flag < 0) chars[i] = 0;
                    else R = true;
                    flag++;
                }
                if (chars[i] == 'D') {
                    if (flag > 0) chars[i] = 0;
                    else D = true;
                    flag--;
                }
            }
        }

        return R == true ? "Radiant" : "Dire";
    }
}
