import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i]=br.readLine().toCharArray();
        }

        visited = new boolean[n][m];
        completed = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                recur(i,j);
            }
        }

        System.out.println(count);
    }

    static boolean[][] visited;
    static boolean[][] completed;
    static int count;

    static void recur(int r, int c) {
        if (completed[r][c]) {
            return;
        }

        if (visited[r][c]) {
            count++;
        } else {
            visited[r][c] = true;
            char direction = map[r][c];
            if (direction == 'U') {
                recur(r - 1, c);
            } else if (direction == 'D') {
                recur(r + 1, c);
            } else if (direction == 'L') {
                recur(r, c - 1);
            } else if (direction == 'R') {
                recur(r, c + 1);
            }
        }

        completed[r][c]=true;
    }

}

