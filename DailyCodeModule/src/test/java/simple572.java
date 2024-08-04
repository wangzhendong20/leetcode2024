import javax.swing.tree.TreeNode;

public class simple572 {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (root == null) return false;
         if (isTree(root, subRoot)) return true;

         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
     }

     private boolean isTree(TreeNode node1, TreeNode node2) {
         if (node1 == null && node2 == null) return true;
         if (node1 == null || node2 == null || node1.val != node2.val) return false;

         return isTree(node1.left, node2.left) && isTree(node1.right, node2.right);
     }

}
