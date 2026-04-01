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
            int[] fibo = fibo(n);
            sb.append(fibo[0]).append(" ").append(fibo[1]).append("\n");
        }

        System.out.println(sb);
    }

    static int[][] memo = new int[41][2];

    private static int[] fibo(int n) {
        if (memo[n][0] != 0) {
            return memo[n];
        }
        if(n==0){
            return new int[]{1, 0};
        }
        if(n==1){
            return new int[]{0, 1};
        }
        int[] fibo1 = fibo(n-1);
        int[] fibo2 = fibo(n - 2);
        memo[n][0] = fibo1[0] + fibo2[0];
        memo[n][1] = fibo1[1] + fibo2[1];
        return memo[n];
    }
}