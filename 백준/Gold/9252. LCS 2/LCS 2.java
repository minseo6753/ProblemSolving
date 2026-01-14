
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int length;
        char c;
        Node prev;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        Node[][] dp = new Node[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = new Node();
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j].length = dp[i - 1][j - 1].length + 1;
                    dp[i][j].c = s1.charAt(i - 1);
                    dp[i][j].prev = dp[i - 1][j - 1];
                } else {
                    if (dp[i - 1][j].length > dp[i][j - 1].length) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()].length);

        StringBuilder sb=new StringBuilder();
        Node node = dp[s1.length()][s2.length()];
        while(node.length!=0) {
            sb.append(node.c);
            node = node.prev;
        }
        System.out.println(sb.reverse());
    }

}