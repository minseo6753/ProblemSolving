import static java.lang.Character.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] names = new String[n + 1];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            names[i] = name;
            map.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (isDigit(question.charAt(0))) {
                sb.append(names[Integer.parseInt(question)]);
            }
            else {
                sb.append(map.get(question));
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}