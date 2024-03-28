package xieCheng.xiecheng0313;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入待压缩的数组（字符串格式）：");
        String input = scanner.nextLine();
        scanner.close();

        String compressedOutput = compressArray(input);
        System.out.println("压缩后的数组：");
        System.out.println(compressedOutput);
    }

    public static String compressArray(String input) {
        List<Pair> pairs = parseInput(input);
        List<Pair> compressedPairs = compressPairs(pairs);
        return convertToListString(compressedPairs);
    }

    private static List<Pair> parseInput(String input) {
        List<Pair> pairs = new ArrayList<>();
        String[] elements = input.substring(1, input.length() - 1).split(",");
        for (String element : elements) {
            String[] parts = element.split("\\(");
            pairs.add(new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1].substring(0, parts[1].length() - 1))));
        }
        return pairs;
    }

    private static List<Pair> compressPairs(List<Pair> pairs) {
        List<Pair> compressedPairs = new ArrayList<>();
        Pair currentPair = null;
        for (Pair pair : pairs) {
            if (currentPair == null || currentPair.value == pair.value) {
                if (currentPair == null) {
                    currentPair = new Pair(pair.value, pair.count);
                } else {
                    currentPair.count += pair.count;
                }
            } else {
                compressedPairs.add(currentPair);
                currentPair = new Pair(pair.value, pair.count);
            }
        }
        if (currentPair != null) {
            compressedPairs.add(currentPair);
        }
        return compressedPairs;
    }

    private static String convertToListString(List<Pair> pairs) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            sb.append(pair.value).append("(").append(pair.count).append(")");
            if (i < pairs.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
