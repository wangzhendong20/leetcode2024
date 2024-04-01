package xiaPi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class code1 {
    public static String reverses(String original_str) {
        StringBuilder sb = new StringBuilder();
        List<List<Character>> lowCharList = new ArrayList<>();
        List<Character> otherChar = new ArrayList<>();
        String[] strings = original_str.split(" ");
        for (String string : strings) {
            List<Character> lowChar = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isLowerCase(string.charAt(i))) {
                    if (!lowChar.isEmpty()){
                        Collections.reverse(lowChar);
                        lowCharList.add(lowChar);
                        lowChar = new ArrayList<>();
                    }
                    otherChar.add(string.charAt(i));
                } else {
                    lowChar.add(string.charAt(i));
                }
            }
            if (Character.isLowerCase(string.charAt(string.length()-1))) {
                Collections.reverse(lowChar);
                lowCharList.add(lowChar);
            }
            int index = lowCharList.size() - 1;

            for (int i = 0; i < string.length(); i++) {
                if (i != 0 && !Character.isLowerCase(string.charAt(i))) {
                    if (index >= 0){
                        List<Character> characters = lowCharList.get(index);
                        for (Character character : characters) {
                            sb.append(character);
                        }
                        index--;
                    }
                    sb.append(string.charAt(i));
                } else if (i == 0 && !Character.isLowerCase(string.charAt(i))) {
                    sb.append(string.charAt(i));
                }
            }
            if (index >= 0) {
                List<Character> characters = lowCharList.get(index);
                for (Character character : characters) {
                    sb.append(character);
                }
            }
            sb.append(" ");
            lowCharList.clear();
            lowChar.clear();
            otherChar.clear();
        }

        return String.valueOf(sb.deleteCharAt(sb.length()-1));
    }

    public static void main(String[] args) {
        String ori_Str = "Shopee is Our family 123";
        System.out.println(reverses(ori_Str));
    }

}
