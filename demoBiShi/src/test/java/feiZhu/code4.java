package feiZhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class code4 {
    public static void sort(List<String> list) {
        Collections.sort(list, Comparator.nullsLast(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("ghi");
        list.add(null);
        list.add("def");


        sort(list);
        for (String str : list){
            System.out.println(str);
        }
    }
}
