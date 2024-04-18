package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class middle17_13 {
    /**
     * 前缀树 + DP
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        Arrays.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(),o1.length());
            }
        });
        PreTree preTree = new PreTree();
        for (String dic : dictionary) {
            preTree.insert(dic);
        }

        int[] dp = new int[sentence.length()+1]; // 以i-1为结尾的字符串有多少个未识别

        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i-1] + 1;
            List<Integer> search = preTree.search(sentence, i - 1); //搜索以i-1为结尾的字符串匹配情况
            for (Integer j : search) {
                dp[i] = Math.min(dp[i],dp[j]);  //跟匹配上了的取最小值
            }
        }
        return dp[sentence.length()];
    }


    class PreNode {
        boolean isWord;
        PreNode[] children = new PreNode[26];
    }

    class PreTree {
        PreNode root;

        public PreTree() {
            root = new PreNode();
        }

        public void insert(String word) {
            PreNode cur = root;
            for (int i = word.length()-1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new PreNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        /**
         * 找到 sentence 中以 sentence[end] 为结尾的单词(可能不止一个)，返回这些单词的开头下标 【★关键】
         * @param word
         * @return
         */
        public List<Integer> search(String word, int end) {
            List<Integer> list = new ArrayList<>();
            PreNode cur = root;
            for (int i = end; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    break;
                }
                cur = cur.children[c];
                if (cur.isWord) {
                    list.add(i);
                }
            }
            return list;
        }

    }
}


