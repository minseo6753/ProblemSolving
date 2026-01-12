import static java.lang.Math.abs;
import static java.util.Arrays.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] list;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        sort(list);

        List<TwoSum> twoSumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                twoSumList.add(new TwoSum(list[i] + list[j], list[i], list[j]));
            }
        }

        long result = 3_000_000_000L;
        int[] ans = new int[3];
        for (TwoSum twoSum : twoSumList) {
            int thirdIndex = lowerBound(-twoSum.sum);
            long threeSum = abs(twoSum.sum + (long) list[thirdIndex]);
            if (list[thirdIndex]!=twoSum.first&&list[thirdIndex]!=twoSum.second&&threeSum < result) {
                result = threeSum;
                ans[0] = twoSum.first;
                ans[1] = twoSum.second;
                ans[2] = list[thirdIndex];
            }
            if (thirdIndex != 0) {
                threeSum = abs(twoSum.sum + (long) list[thirdIndex - 1]);
                if (list[thirdIndex-1]!=twoSum.first&&list[thirdIndex-1]!=twoSum.second&&threeSum < result) {
                    result = threeSum;
                    ans[0] = twoSum.first;
                    ans[1] = twoSum.second;
                    ans[2] = list[thirdIndex - 1];
                }
            }
        }

        sort(ans);
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }

    static class TwoSum {
        public int sum;
        public int first;
        public int second;

        public TwoSum(int sum, int first, int second) {
            this.sum = sum;
            this.first = first;
            this.second = second;
        }
    }

    private static int lowerBound(int target) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (list[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}