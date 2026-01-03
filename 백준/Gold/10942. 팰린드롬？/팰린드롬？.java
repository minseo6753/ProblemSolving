import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;

            int p1 = i - 1;
            int p2 = i + 1;
            while (p1 >= 0 && p2 < n && sequence[p1] == sequence[p2]) {
                palindrome[p1][p2] = true;
                p1--;
                p2++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int p1 = i;
            int p2 = i + 1;
            while (p1 >= 0 && p2 < n && sequence[p1] == sequence[p2]) {
                palindrome[p1][p2] = true;
                p1--;
                p2++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(palindrome[s - 1][e - 1] ? 1 : 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}