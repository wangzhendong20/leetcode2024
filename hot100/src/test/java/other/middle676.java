package other;

public class middle676 {
    class MagicDictionary {

        PreTree preTree;

        public MagicDictionary() {
            preTree = new PreTree();
        }

        public void buildDict(String[] dictionary) {
            for (String dic : dictionary) {
                preTree.Treeinsert(dic);
            }
        }

        public boolean search(String searchWord) {
            return preTree.Treesearch(searchWord);
        }
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

        public void Treeinsert(String word) {
            PreNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new PreNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        public boolean Treesearch(String word) {
            return match(word,root,0,true);
        }

        private boolean match(String word, PreNode node, int start, boolean hasChance) {
            if (start == word.length()) {
                return node.isWord && !hasChance;
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    // 对于存在的每个匹配
                    if (i == word.charAt(start) - 'a' && match(word,node.children[i], start+1, hasChance)) {
                        //如果当前匹配，继续向下匹配
                        return true;
                    }

                    if (i != word.charAt(start) - 'a' && hasChance && match(word,node.children[i], start+1, false)) {
                        //当前不匹配，但是没修改过，继续向下匹配
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
