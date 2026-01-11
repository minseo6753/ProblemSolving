import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<Integer>();
        int n;
        while ((n = Integer.parseInt(st.nextToken())) != 0) {
            list.add(n);
        }

        dp = new int[5][5][list.size()];

        int left = 0;
        int right = 0;

        System.out.println(recur(left, right, 0));
    }

    public static int[][][] dp;

    public static int recur(int left, int right, int i) {
        if (dp[left][right][i] != 0) {
            return dp[left][right][i];
        }

        Integer target = list.get(i);

        int leftForce = calculateForce(left, target);
        int rightForce = calculateForce(right, target);

        if (i == list.size() - 1) {
            return min(leftForce, rightForce);
        }

        dp[left][right][i] = min(recur(target, right, i + 1) + leftForce, recur(left, target, i + 1) + rightForce);
        return dp[left][right][i];
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