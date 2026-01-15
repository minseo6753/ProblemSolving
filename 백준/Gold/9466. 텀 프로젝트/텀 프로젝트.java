
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] choice = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            Boolean[] team = new Boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                team[i] = null;
            }
            int count = 0;
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (team[i] == null) {
                    int chosen = i;
                    while (true) {
                        if (team[chosen] != null) {
                            while (!stack.empty()) {
                                team[stack.pop()] = false;
                                count++;
                            }
                            break;
                        }
                        if (visited[chosen]) {
                            while (stack.peek() != chosen) {
                                team[stack.pop()] = true;
                            }
                            team[stack.pop()] = true;
                            while (!stack.empty()) {
                                team[stack.pop()] = false;
                                count++;
                            }
                            break;
                        }
                        stack.push(chosen);
                        visited[chosen] = true;
                        chosen = choice[chosen];
                    }
                }
            }
            output.append(count);
            output.append('\n');
        }
        System.out.println(output);
    }

}