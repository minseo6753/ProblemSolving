import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];
        int[] score = new int[1_000_001];
        boolean[] exist = new boolean[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            exist[cards[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            int num = cards[i];
            for (int j = num; j <= 1_000_000; j += num) {
                if (exist[j]) {
                    score[num]++;
                    score[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(score[cards[i]]).append(" ");
        }
        System.out.println(sb);
    }
}