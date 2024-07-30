import java.util.Scanner;

public class KM108 {

    static class UF{
        int[] father;

        public UF(int n){
            father = new int[1005];
            for(int i=0;i<n;i++){
                father[i] = i;
            }
        }

        public int find(int u) {
            if (u == father[u]) return u;
            else return father[u] = find(father[u]);
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            father[v] = u;
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
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (uf.isSame(u,v)) {
                System.out.println(u + " " + v);
                return;
            } else {
                uf.join(u,v);
            }
        }
    }
}
