import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 400000;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<Integer>();
        int n;
        while ((n = Integer.parseInt(st.nextToken())) != 0) {
            list.add(n);
        }

        int[][][] dp = new int[list.size() + 1][5][5];

        for (int i = list.size() - 1; i >= 0; i--) {
            Integer target = list.get(i);
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (i != 0 && left == right) {
                        dp[i][left][right] = INF;
                    }
                    else {
                        dp[i][left][right] = min(
                                calculateForce(left, target) + dp[i + 1][target][right],
                                calculateForce(right, target) + dp[i + 1][left][target]);
                    }
                }
            }
        }

        System.out.println(dp[0][0][0]);
    }


    public static int calculateForce(int foot, int target) {
        if (foot == 0) {
            return 2;
        }
        if (foot == target) {
            return 1;
        }
        if (abs(foot - target) == 2) {
            return 4;
        }
        return 3;
    }
}