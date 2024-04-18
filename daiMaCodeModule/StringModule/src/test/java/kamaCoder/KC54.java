package kamaCoder;

import java.util.Scanner;

public class KC54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                sb.append("number");
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
