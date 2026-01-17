import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    static int[] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        matrix[0] = Integer.parseInt(st.nextToken());
        matrix[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[i] = c;
        }

        dp = new int[n + 1][n + 1];
        System.out.println(operation(0,n));
    }

    static int[][] dp;

    public static int operation(int start, int end) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        if (start + 1 == end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            min = min(min, operation(start, i) + operation(i, end) + matrix[start] * matrix[i] * matrix[end]);
        }
        return dp[start][end] = min;
    }
}

