package simple;

import utils.TreeNode;

import java.util.*;

public class simple501 {

    HashMap<Integer,Integer> map = new HashMap<>();

    /**
     * 通用的二叉树搜索众数方法
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        traversal(root);
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Integer> ans = new ArrayList<>();
        int max = entries.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (max != entry.getValue()) {
                break;
            }
            ans.add(entry.getKey());
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void traversal(TreeNode node) {
        if (node == null) return;
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        traversal(node.left);
        traversal(node.right);
    }


    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    List<Integer> res = new ArrayList<>();
    /**
     * 二叉搜索树的众数方法
     * 中序遍历是有序的，在搜索树的时候计算频率，将count=maxCount的放入res中，若count>maxCount，则清空res，将新众数放入res
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        if (root == null) return new int[]{};
        traversal2(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void traversal2(TreeNode cur) {
        if (cur == null) return;

        traversal2(cur.left);

        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }

        if (count == maxCount) {
            res.add(cur.val);
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(cur.val);
        }

        pre = cur;

        traversal2(cur.right);
    }


}
