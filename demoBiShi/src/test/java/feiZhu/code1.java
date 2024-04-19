package feiZhu;

import java.util.ArrayList;
import java.util.List;

public class code1 {
    /**
     * 有字符串"yujwedjhccdskdsewirewrwsadmfnsdjwijweijewirwejreirjiejrieerirjeijriejriwklwweqpq"取出所有两个w之间的字符串并用归并排序进行排序 （字符串处理）。
     * @param args
     */
    public static void main(String[] args) {
        String s = "yujwedjhccdskdsewirewrwsadmfnsdjwijweijewirwejreirjiejrieerirjeijriejriwklwweqpq";
        List<String> list = new ArrayList<>();
        boolean flag = false;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'w') {
                if (!flag) {
                    start = i;
                    flag = true;
                } else {
                    list.add(s.substring(start+1,i));
                    start = i;
                }
            }
        }

        List<String> strings = mergeSort(list);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    private static List<String> mergeSort(List<String> list) {

        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<String> left = mergeSort(list.subList(0, mid));
        List<String> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);

    }

    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < left.size() && j < right.size();) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        if (i < left.size()) {
            result.addAll(left.subList(i, left.size()));
        } else if (j < right.size()) {
            result.addAll(right.subList(j, right.size()));
        }

        return result;
    }
}
