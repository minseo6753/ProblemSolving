import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> accSumA = accumulate(a);
        List<Integer> accSumB = accumulate(b);

        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (Integer accSum : accSumA) {
            mapA.put(accSum, mapA.getOrDefault(accSum, 0) + 1);
        }

        long count = 0;
        for (Integer accSum : accSumB) {
            count += mapA.getOrDefault(t - accSum, 0);
        }

        System.out.println(count);
    }

    private static List<Integer> accumulate(int[] arr) {
        List<Integer> accSum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                accSum.add(sum);
            }
        }
        return accSum;
    }

}