package weiZhong;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] mofang = {{1,2,3},{4,5,6},{7,8,9}};
            for (int i = 0; i < n; i++) {
                int[] tmp = new int[3];
                int index = 0;
                switch (in.nextInt()) {
                    case 1:
                        tmp[index++] = mofang[0][2];
                        tmp[index++] = mofang[0][0];
                        tmp[index] = mofang[0][1];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[0][j] = tmp[index++];
                        }
                        break;
                    case 2:
                        tmp[index++] = mofang[1][2];
                        tmp[index++] = mofang[1][0];
                        tmp[index] = mofang[1][1];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[1][j] = tmp[index++];
                        }
                        break;
                    case 3:
                        tmp[index++] = mofang[2][2];
                        tmp[index++] = mofang[2][0];
                        tmp[index] = mofang[2][1];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[2][j] = tmp[index++];
                        }
                        break;
                    case 4:
                        tmp[index++] = mofang[1][0];
                        tmp[index++] = mofang[2][0];
                        tmp[index] = mofang[0][0];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[j][0] = tmp[index++];
                        }
                        break;
                    case 5:
                        tmp[index++] = mofang[1][1];
                        tmp[index++] = mofang[2][1];
                        tmp[index] = mofang[0][1];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[j][1] = tmp[index++];
                        }
                        break;
                    case 6:
                        tmp[index++] = mofang[1][2];
                        tmp[index++] = mofang[2][2];
                        tmp[index] = mofang[0][2];
                        index = 0;
                        for (int j = 0; j < 3; j++) {
                            mofang[j][2] = tmp[index++];
                        }
                        break;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(mofang[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
