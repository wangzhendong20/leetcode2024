package middle;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class middle1382 {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        traversal(root,path);
        int[] array = path.stream().mapToInt(Integer::intValue).toArray();
        TreeNode node = build(array,0,array.length-1);
        return node;

    }

    private void traversal(TreeNode node, List<Integer> path) {
        if (node == null) return;

        traversal(node.left,path);
        path.add(node.val);
        traversal(node.right,path);
    }

    private TreeNode build(int[] array, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(array[mid]);

        root.left = build(array,left,mid-1);
        root.right = build(array,mid+1,right);

        return root;
    }


}
