package middle;

public class middle208 {

}

class TrieNode {		// 节点
    boolean isWord; // 是否是终点
    TrieNode[] children = new TrieNode[26];  //存储包含的字符
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     *【向字典树插入单词word】
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就new出新节点；如果节点已经存在，cur顺着往下走就可以
     * @param word
     */
    public void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true; // 一个单词插入完毕，此时cur指向的节点即为一个单词的结尾
    }

    /**
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就是没找到，返回false;
     * 如果找到最后，判断是否是结尾isWord;
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }

        return cur.isWord;
    }

    /**
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就是没找到，返回false;
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }

    /**
     * >>> 经典的search方法，是通过一个cur指针(引用)，根据word的字符，一条路走下去
     *     >>> 其实，它还有一个思路———每次判断一个节点是否配对 的【递归】写法 ：
     */
    public boolean search2(String word) {
        return match(word, root, 0);
    }

    /* macth方法
    // 基本思路是：根据word和start得到此时的字符，然后看该字符是否与此时的节点node配对————即node.children[c]有值(!=null)
    // (其实start就相当于非递归写法中的for(i)的i)，用来遍历word
    */
    public boolean match(String word, TrieNode node, int start){		// 这个三个参数直接背下来，这是模板参数
        if(start == word.length()){
            return node.isWord;					// (★)
        }

        int c = word.charAt(start) - 'a';
        return node.children[c] != null && match(word, node.children[c], start + 1);
    }

}
