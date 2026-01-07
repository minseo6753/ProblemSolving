import static java.lang.Integer.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] delay = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            inDegree = new int[n + 1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                inDegree[y]++;
            }

            List<Integer> topology = topologicalSort();

            int[] time = new int[n + 1];
            for (Integer number : topology) {
                time[number] += delay[number];
                for (int next : graph[number]) {
                    time[next] = max(time[next], time[number]);
                }
            }

            int w = Integer.parseInt(br.readLine());
            sb.append(time[w]).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Integer> topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer poll = queue.poll();
            result.add(poll);
            for (int v : graph[poll]) {
                if (--inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return result;
    }
}