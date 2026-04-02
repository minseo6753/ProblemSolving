import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n <= 20) {
            move(n, 1, 3);
            System.out.println(count);
            System.out.println(sb);
        } else {
            System.out.println(move(n));
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    private static void move(int height, int source, int target) {
        if (height == 0) {
            return;
        }

        int temp = 6 - source - target;

        move(height - 1, source, temp);
        sb.append(source).append(' ').append(target).append('\n');
        count++;
        move(height - 1, temp, target);
    }

    private static BigInteger move(int height) {
        BigInteger count = BigInteger.valueOf(1);
        for (int i = 2; i <= height; i++) {
            count = count.add(count).add(BigInteger.valueOf(1));
        }
        return count;
    }
}