package middle;


import utils.Node;

import java.util.HashMap;

public class middle138 {
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {

        if (head == null) return head;

        // 先进行当前节点的拷贝，在进行next的拷贝，之后现在所有节点都拷贝完了，就可以连接random节点了。
        if (!map.containsKey(head)) {
            Node headNew = new Node(head.val);   //当前节点的拷贝
            map.put(head,headNew);  //用来记录已经拷贝的节点，在random拷贝时可以找到对应的节点
            headNew.next = copyRandomList(head.next);  //next的拷贝
            headNew.random = copyRandomList(head.random);  //random的拷贝
        }

        return map.get(head);
    }
}
