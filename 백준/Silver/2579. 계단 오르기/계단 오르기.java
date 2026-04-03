import static java.lang.Integer.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stair1 = new int[n + 2];
        int[] stair2 = new int[n + 2];
        for (int i = 2; i < n + 2; i++) {
            stair1[i] = stair2[i] = Integer.parseInt(br.readLine());
            stair1[i] += stair2[i - 1];
            stair2[i] += max(stair1[i - 2], stair2[i - 2]);
        }

        System.out.println(max(stair1[n + 1], stair2[n + 1]));
    }

}