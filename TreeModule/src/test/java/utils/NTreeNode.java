package utils;

import org.w3c.dom.Node;

import java.util.List;

public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode(int val) {
        this.val = val;
    }

    public NTreeNode() {
    }

    public NTreeNode(int val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
