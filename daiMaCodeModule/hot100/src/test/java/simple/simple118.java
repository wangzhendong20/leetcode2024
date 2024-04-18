package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class simple118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        ans.add(List.of(1));
        if (numRows == 1) {
            return ans;
        }
        pre.add(1);
        pre.add(1);
        ans.add(pre);
        if (numRows == 2) {
            return ans;
        }


        for (int i = 2; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            ans.add(cur);
            pre = cur;
        }

        return ans;
    }
}
