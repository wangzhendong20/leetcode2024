package simple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class simple657 {
    public boolean judgeCircle(String moves) {
        int col = 0;
        int row = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') col++;
            else if (c == 'D') col--;
            else if (c == 'L') row++;
            else if (c == 'R') row--;
        }
        if (row == 0 && col == 0) return true;
        return false;
    }
}
