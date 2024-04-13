package weiZhong;

import java.util.*;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int C = in.nextInt();
            Unit unit = new Unit(N+1);
            PriorityQueue<GraphNode> list = new PriorityQueue<GraphNode>(new Comparator<GraphNode>() {
                @Override
                public int compare(GraphNode o1, GraphNode o2) {
                    return Integer.compare(o1.value,o2.value);
                }
            });


            for (int i = 0; i < N * (N - 1) / 2; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int value = in.nextInt();
                list.add(new GraphNode(from,to,value));
            }
            int sum = 0;
            while (!list.isEmpty()) {
                GraphNode node = list.poll();
                if (unit.find(node.from) == unit.find(node.to)) {
                    continue;
                } else {
                    sum += node.value * C;
                    unit.join(node.from,node.to);
                }
            }
            System.out.println(sum);
        }
    }


    static class GraphNode {
        int from;
        int to;
        int value;

        public GraphNode(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        public GraphNode() {

        }
    }

    static class Unit {
        int[] father;

        public Unit(int N) {
            father = new int[N];
            for (int i = 0; i < N; i++) {
                father[i] = i;
            }
        }

        public void join(int from, int to) {
            from = find(from);
            to = find(to);
            if (from == to) return;
            father[to] = from;
        }

        public int find(int to) {
            return to == father[to] ? to : find(father[to]);
        }
    }
}
