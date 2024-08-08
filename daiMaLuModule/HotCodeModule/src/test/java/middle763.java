import java.util.ArrayList;
import java.util.List;

public class middle763 {
    public List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<Integer>();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            index = Math.max(index, map[s.charAt(i) - 'a']);
            if (i == index) {
                res.add(i - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
