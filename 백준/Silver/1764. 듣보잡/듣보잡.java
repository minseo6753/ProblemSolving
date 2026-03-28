import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] hear = new String[n];
        for (int i = 0; i < n; i++) {
            hear[i] = br.readLine();
        }
        Arrays.sort(hear);

        String[] see = new String[m];
        for (int i = 0; i < m; i++) {
            see[i] = br.readLine();
        }
        Arrays.sort(see);

        StringBuilder sb = new StringBuilder();

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < n && p2 < m) {
            if (hear[p1].equals(see[p2])) {
                sb.append(hear[p1]).append("\n");
                count++;
                p1++;
                p2++;
            } else if (hear[p1].compareTo(see[p2]) > 0) {
                p2++;
            } else {
                p1++;
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

}