import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> names = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        names.add("");

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            names.add(name);
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (question.matches("[0-9]+")) {
                sb.append(names.get(Integer.parseInt(question)));
            }
            else {
                sb.append(map.get(question));
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}