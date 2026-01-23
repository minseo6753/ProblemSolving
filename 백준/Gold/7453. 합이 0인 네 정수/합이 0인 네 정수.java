
import static java.util.Arrays.sort;

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

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int[] ab = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = a[i] + b[j];
            }
        }
        sort(ab);
        int[] cd = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cd[i * n + j] = c[i] + d[j];
            }
        }
        sort(cd);
        int p1 = 0;
        int p2 = n * n - 1;
        long count = 0;
        while (p1 < n * n && p2 >= 0) {
            if (ab[p1] + cd[p2] == 0) {
                p1++;
                int tmp1 = 1;
                while (p1 < n * n && ab[p1 - 1] == ab[p1]) {
                    p1++;
                    tmp1++;
                }
                p2--;
                int tmp2 = 1;
                while (p2 >= 0 && cd[p2] == cd[p2 + 1]) {
                    p2--;
                    tmp2++;
                }
                count += (long) tmp1 * tmp2;
            } else if (ab[p1] + cd[p2] < 0) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.println(count);
    }

}