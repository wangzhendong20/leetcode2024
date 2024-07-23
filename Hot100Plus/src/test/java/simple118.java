import java.util.ArrayList;
import java.util.List;

public class simple118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>(List.of(1,1));
        ans.add(List.of(1));
        if (numRows == 1) return ans;
        ans.add(pre);

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                row.add(pre.get(j) + pre.get(j+1));
            }
            row.add(1);
            ans.add(row);
            pre = row;
        }

        return ans;
    }
}
