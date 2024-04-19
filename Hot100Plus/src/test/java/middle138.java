import utils.Node;

import java.util.HashMap;

public class middle138 {
    /**
     * 138. 复制带随机指针的链表
     * 使用map来记录当前节点的复制节点，避免重复复制
     * 之后先进行当前节点的拷贝，在进行next的拷贝，之后现在所有节点都拷贝完了，就可以连接random节点了。
     * @param head
     * @return
     */
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;


        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }

        return map.get(head);
    }
}
