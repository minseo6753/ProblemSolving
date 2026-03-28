import static java.lang.Character.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hashSet.add(s);
        }

        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (hashSet.contains(s)) {
                treeSet.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(treeSet.size()).append("\n");
        for (String s : treeSet) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }

}