import java.util.Scanner;

public class KM107 {

    static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[1005];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            parent[v] = u;
        }

        public int find(int u) {
            if (u == parent[u]) return u;
            else return parent[u] = find(parent[u]);
        }
        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        UF uf = new UF(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            uf.join(u,v);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean res = uf.find(start) == uf.find(end);

        System.out.println(uf.isSame(start,end) == true ? 1 : 0);
    }
}
