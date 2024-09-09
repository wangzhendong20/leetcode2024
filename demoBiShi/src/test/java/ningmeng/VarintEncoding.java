package ningmeng;

import java.util.Scanner;

public class VarintEncoding {

    // 编码方法
    public static String encodeVarint(long value) {
        StringBuilder sb = new StringBuilder("0X");
        while ((value & ~0x7F) != 0) {
            sb.append(String.format("%02X", (value & 0x7F) | 0x80));
            value >>>= 7;
        }
        sb.append(String.format("%02X", value));
        return sb.toString();
    }

    // 解码方法
    public static long decodeVarint(String hexString) {
        byte[] bytes = hexStringToByteArray(hexString);
        long result = 0;
        int shift = 0;
        for (byte b : bytes) {
            result |= (long)(b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                break;
            }
            shift += 7;
        }
        return result;
    }

    // 将十六进制字符串转换为字节数组
    private static byte[] hexStringToByteArray(String hexString) {
        // 去除"0X"前缀
        hexString = hexString.replace("0X", "");
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        // 从输入中读取
        Scanner scanner = new Scanner(System.in);

        // 读取整数n和十六进制字符串x
        long n = scanner.nextLong();
        String hexString = scanner.next();

        // 编码
        String encoded = encodeVarint(n);
        System.out.println(encoded);

        // 解码
        long decoded = decodeVarint(hexString);
        System.out.println(decoded);
    }
}
