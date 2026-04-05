import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n)).append("\n");
        }

        System.out.println(sb);
    }

    static int[] memo = new int[12];

    private static int dp(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        if(n==3)return 4;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dp(n - 3) + dp(n - 2) + dp(n - 1);
        return memo[n];
    }
}