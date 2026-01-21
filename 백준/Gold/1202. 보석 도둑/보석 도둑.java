
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Jewel {
        int mass;
        int value;

        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

    static class JewelMassComparator implements Comparator<Jewel> {
        @Override
        public int compare(Jewel o1, Jewel o2) {
            return o1.mass - o2.mass;
        }
    }

    static class JewelValueComparator implements Comparator<Jewel> {
        @Override
        public int compare(Jewel o1, Jewel o2) {
            return o2.value - o1.value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>(new JewelMassComparator());
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
        PriorityQueue<Jewel> portable = new PriorityQueue<>(new JewelValueComparator());
        while (!bags.isEmpty()) {
            Integer bag = bags.poll();
            while (!jewels.isEmpty() && jewels.peek().mass <= bag) {
                portable.add(jewels.poll());
            }
            if (!portable.isEmpty()) {
                sum += portable.poll().value;
            }
        }
        System.out.println(sum);
    }

}