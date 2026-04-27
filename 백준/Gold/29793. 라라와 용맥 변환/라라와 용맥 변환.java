import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        String map = br.readLine();

        if (h == 1) {
            System.out.println(0);
            return;
        }
        if (h == 2) {
            System.out.println(two(map));
            return;
        }
        if (h == 3) {
            System.out.println(three(map));
            return;
        }
        if (h >= 4) {
            if (n == 1) {
                System.out.println(0);
                return;
            }
            if (n == 2) {
                System.out.println(two(map));
                return;
            }
            if (n == 3) {
                System.out.println(three(map));
                return;
            }
            System.out.println(-1);
        }
    }

    static int two(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i++;
            }
        }
        return count;
    }

    static int three(String s) {
        String[] permu = {"SRW", "SWR", "RSW", "RWS", "WSR", "WRS"};
        int min = 1_000_000;
        for (String seq : permu) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != seq.charAt(i % 3)) {
                    count++;
                }
            }
            if (count < min) {
                min = count;
            }
        }
        return min;
    }
}
