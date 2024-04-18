package middle;

import java.util.Arrays;

public class middle151 {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        ch = removeExtraSpaces(ch);
        reverse(ch,0,ch.length-1);
        int start = 0;
        for (int i = 0; i <= ch.length; i++) {
            if (i == ch.length || ch[i] == ' ') {
                reverse(ch,start,i-1);
                start = i+1;
            }
        }
        return String.valueOf(ch);
    }

    private void reverse(char[] ch, int start, int end){ //翻转，区间写法：左闭右闭 []
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }

    private char[] removeExtraSpaces(char[] ch) {
        int slow = 0;
        for (int fast = 0; fast < ch.length; fast++) {
            if (ch[fast] != ' ') {
                if (slow != 0) ch[slow++] = ' '; //手动控制空格，给单词之间添加空格。slow != 0说明不是第一个单词，需要在单词前添加空格。
                while (fast < ch.length && ch[fast] != ' '){
                    ch[slow++] = ch[fast++];
                }
            }
        }
        return Arrays.copyOfRange(ch,0,slow);
    }
}
