import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class middle133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        return dfs(node,map);
    }

    /**
     * DFS
     * 需要用一个哈希表来存储已经建立好的节点
     * @param node
     * @param map
     * @return
     */
    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }

        return newNode;
    }
}
