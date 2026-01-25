import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Long> expPrefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        expPrefixSum = new ArrayList<Long>(); //i번째 인덱스:2^(i+1)-1까지의 누적합
        expPrefixSum.add(1L);
        for (long i = 2; i - 1 <= b; i *= 2) {
            Long last = expPrefixSum.get(expPrefixSum.size() - 1);
            expPrefixSum.add(last + i + last); //i*2-1까지의 누적합
        }

        System.out.println(prefixSum(b) - prefixSum(a - 1));
    }

    static long prefixSum(long num) {
        long tmp = 1 & num;
        long sum = tmp;

        for (int i = 1; tmp < num; i++) {
            long exp = 1L << i;
            tmp |= num & exp;

            if ((exp & num) > 0) {
                sum += expPrefixSum.get(i - 1);
                sum += tmp - exp + 1;
            }

        }
        return sum;
    }
}