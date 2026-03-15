import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x;
            switch (op) {
                case "all":
                    Arrays.fill(arr, 1);
                    break;
                case "empty":
                    Arrays.fill(arr, 0);
                    break;
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    arr[x]=1;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    arr[x]=0;
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(arr[x]).append("\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (arr[x] == 1) {
                        arr[x] = 0;
                    }
                    else {
                        arr[x] = 1;
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

}