import java.util.*;

public class KM110 {
    /**
     * BFS
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String beginStr = sc.next();
        String endStr = sc.next();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        HashMap<String,Integer> map = new HashMap<>(); //记录每个字符串的路径长度
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginStr);
        map.put(beginStr,1);

        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            int path = map.get(curStr);

            for (int i = 0; i < curStr.length(); i++) {
                char[] newWord = curStr.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {  //替换每个字母
                    newWord[i] = j;
                    String newWordStr = new String(newWord);
                    if (newWordStr.equals(endStr)) { //找到目标字符串
                        System.out.println(path + 1);
                        return;
                    }

                    //如果没字符串没有访问过，且在字符串集合中
                    if (set.contains(newWordStr) && !map.containsKey(newWordStr)) {
                        map.put(newWordStr,path+1);
                        queue.offer(newWordStr);
                    }
                }
            }

        }
        System.out.println(0);

    }
}
