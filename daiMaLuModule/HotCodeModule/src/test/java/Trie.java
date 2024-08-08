public class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }

        return true;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}



