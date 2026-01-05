import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(n);

        int m = Integer.parseInt(st.nextToken());
        int cycle = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!graph.union(a, b) && cycle == 0) {
                cycle = i + 1;
            }
        }
        System.out.println(cycle);
    }

    static class Graph {

        private int[] parent;

        Graph(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int findRoot(int v) {
            if (parent[v] == v) {
                return v;
            }
            return parent[v] = findRoot(parent[v]);
        }

        public boolean union(int v, int w) {
            int root1 = findRoot(v);
            int root2 = findRoot(w);
            if (root1 != root2) {
                parent[root1] = root2;
                return true;
            }
            return false;
        }
    }
}