import static java.lang.Integer.min;

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
        int[][] price = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] cost = new int[n][3];
        int minimum = INF;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost[0][j] = INF;
            }
            cost[0][i] = price[0][i];
            for (int k = 1; k < n; k++) {
                cost[k][0] = price[k][0] + min(cost[k - 1][1], cost[k - 1][2]);
                cost[k][1] = price[k][1] + min(cost[k - 1][0], cost[k - 1][2]);
                cost[k][2] = price[k][2] + min(cost[k - 1][0], cost[k - 1][1]);
            }
            cost[n - 1][i] = INF;
            minimum = min(minimum, min(cost[n - 1][0], min(cost[n - 1][1], cost[n - 1][2])));
        }

        System.out.println(minimum);
    }

}