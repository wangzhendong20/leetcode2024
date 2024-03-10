package utils;


public class HasNextNode {
    public int val;
    public HasNextNode left;
    public HasNextNode right;
    public HasNextNode next;

    public HasNextNode() {
    }

    public HasNextNode(int val) {
        this.val = val;
    }

    public HasNextNode(int val, HasNextNode left, HasNextNode right, HasNextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
