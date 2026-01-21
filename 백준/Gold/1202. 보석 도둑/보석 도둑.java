
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Jewel implements Comparable<Jewel>{
        int mass;
        int value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.mass - o.mass;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        PriorityQueue<Integer> value = new PriorityQueue<>(Comparator.reverseOrder());
        while (!bags.isEmpty()) {
            Integer bag = bags.poll();
            while (!jewels.isEmpty() && jewels.peek().mass <= bag) {
                value.add(jewels.poll().value);
            }
            if (!value.isEmpty()) {
                sum += value.poll();
            }
        }
        System.out.println(sum);
    }

}