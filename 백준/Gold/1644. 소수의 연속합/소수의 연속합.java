import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> prefixSumList = new ArrayList<Integer>();
        prefixSumList.add(0);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                prefixSumList.add(prefixSumList.get(prefixSumList.size()-1) + i);
            }
        }

        int start = 0;
        int end = 1;
        int count = 0;
        while (start < end && end < prefixSumList.size()) {
            int prefixSum = prefixSumList.get(end) - prefixSumList.get(start);
            if (prefixSum == n) {
                count++;
                start++;
                end++;
            } else if (prefixSum < n) {
                end++;
            } else {
                start++;
            }
        }
        System.out.println(count);
    }

}