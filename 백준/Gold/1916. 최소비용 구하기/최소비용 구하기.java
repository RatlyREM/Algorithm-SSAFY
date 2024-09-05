import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] minVer = new long[N+1];
        Arrays.fill(minVer, Long.MAX_VALUE);
        int[][] city = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                city[i][j] = -1;
            }
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(city[start][end] != -1) {
                city[start][end] = Math.min(city[start][end], cost);
            }
            else {
                city[start][end] = cost;
            }

        }

        st = new StringTokenizer(br.readLine());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Long.compare(minVer[o1], minVer[o2]));

        //다익스트라 시작
        minVer[sCity] = 0;
        pq.add(sCity);

        while(!pq.isEmpty()) {
            int temp = pq.poll();

            //이어진 길 중 최소인지 업데이트, 업데이트됐으면 큐에 삽입
            for(int i=1; i<=N; i++) {
                if (city[temp][i] > -1) {
                    if(minVer[i] > (minVer[temp] + city[temp][i])) {
                        minVer[i] = minVer[temp] + city[temp][i];

                        pq.add(i);
                    }
                }
            }
        }

        System.out.println(minVer[eCity]);
    }
}