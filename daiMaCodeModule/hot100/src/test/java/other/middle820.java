package other;

import java.util.Arrays;
import java.util.Comparator;

public class middle820 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(),o1.length());
            }
        });
        int ans = 0;
        PreTree preTree = new PreTree();
        for (String word : words) {
            ans += preTree.insert(word);
        }
        return ans;
    }

    class PreNode {
        boolean isWord;
        PreNode[] children = new PreNode[26];
    }

    /**
     * 构建一棵倒序的前缀树
     */
    class PreTree {
        PreNode root;

        public PreTree() {
            root = new PreNode();
        }

        /**
         * 如果是新词的话就统计长度
         *
         * @param word
         * @return
         */
        public int insert(String word) {
            PreNode cur = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new PreNode();
                    isNew = true;
                }
                cur = cur.children[c];
            }

            cur.isWord = true;
            return isNew ? word.length() + 1 : 0;
        }
    }
}


