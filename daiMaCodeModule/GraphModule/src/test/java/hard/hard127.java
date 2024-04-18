package hard;

import java.util.*;

public class hard127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        Deque<String> deque = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        deque.offer(beginWord);
        map.put(beginWord,1);
        while (!deque.isEmpty()) {
            String word = deque.poll();
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] words = word.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    words[i] = k;
                    String newWord = new String(words);
                    if (newWord.equals(endWord)) return path+1;
                    if (!wordSet.contains(newWord) || map.containsKey(newWord)) continue;
                    map.put(newWord,path+1);
                    deque.offer(newWord);
                }
            }

        }
        return 0;
    }
}
