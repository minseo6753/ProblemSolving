import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i == 0 || arr.get(arr.size() - 1) < a) {
                arr.add(a);
                len = arr.size();
            } else {
                int start = 0;
                int end = arr.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (arr.get(mid) >= a) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                arr.set(start, a);
                len = Math.max(len, start + 1);
            }
        }
        System.out.println(len);
    }

}