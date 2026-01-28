import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parent = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }
        int i;
        for (i = 1; i <= p; i++) {
            int a = Integer.parseInt(br.readLine());
            int root = find(a);
            if (root == 0) {
                break;
            }
            int root2 = find(root - 1);
            union(root2, root);
        }
        System.out.println(i-1);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }
}