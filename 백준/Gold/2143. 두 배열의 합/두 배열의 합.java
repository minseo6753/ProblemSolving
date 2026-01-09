import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n + 1];
        a[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] b = new long[m + 1];
        b[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
        }

        List<Long> prefixSumA = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                prefixSumA.add(a[j] - a[i - 1]);
            }
        }
        prefixSumA.sort(Comparator.naturalOrder());
        List<Long> prefixSumB = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                prefixSumB.add(b[j] - b[i - 1]);
            }
        }
        prefixSumB.sort(Comparator.reverseOrder());

        long count = 0;
        int pA = 0;
        int pB = 0;
        while (pA < prefixSumA.size() && pB < prefixSumB.size()) {
            if (prefixSumA.get(pA) + prefixSumB.get(pB) == t) {
                pA++;
                pB++;
                long sameA = 1;
                long sameB = 1;
                while (pA < prefixSumA.size() && prefixSumA.get(pA - 1).equals(prefixSumA.get(pA))) {
                    sameA++;
                    pA++;
                }
                while (pB < prefixSumB.size() && prefixSumB.get(pB - 1).equals(prefixSumB.get(pB))) {
                    sameB++;
                    pB++;
                }
                count += sameA * sameB;
            } else if (prefixSumA.get(pA) + prefixSumB.get(pB) < t) {
                pA++;
            } else {
                pB++;
            }
        }

        System.out.println(count);
    }

}