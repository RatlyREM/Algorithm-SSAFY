import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Point>[] li = new List[V+1];
        int[] minArr = new int[V+1];
        Arrays.fill(minArr, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(
                minArr[o1], minArr[o2]
        ));

        for (int i=1; i<= V; i++) {
            li[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            li[u].add(new Point(v,w));
        }

        minArr[K] = 0;
        pq.add(K);

        //다익스트라 시작
        while(!pq.isEmpty()) {
            int temp = pq.poll();

            for (Point p : li[temp]) {
                if(minArr[p.x] > minArr[temp] + p.y) {
                    minArr[p.x] = minArr[temp] + p.y;
                    pq.add(p.x);
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=V; i++) {
            if(minArr[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }
            else {
                sb.append(minArr[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}