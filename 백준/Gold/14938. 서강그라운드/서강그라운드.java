import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 다익스트라?
		 * 각 정점까지의 최단거리를 구하고,
		 * 최단거리 배열 돌면서 아이템 개수 더하면 될듯?
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int maxTotal = -1;
		
		int[] items = new int[n+1];
		int[][] ground = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			ground[a][b] = cost;
			ground[b][a] = cost;
		}
		
		//각 지역마다 다익스트라를?
		for (int i = 1; i <= n; i++) {
			int[] minArr = new int[n+1];
			Arrays.fill(minArr, Integer.MAX_VALUE);
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(minArr[o1], minArr[o2]));
			
			minArr[i] = 0;
			pq.add(i);
			
			while(!pq.isEmpty()) {
				int temp = pq.poll();
				
				for (int j = 1; j <= n; j++) {
					if(ground[temp][j] > 0) {
						if(minArr[j] > minArr[temp] + ground[temp][j]) {
							minArr[j] = minArr[temp] + ground[temp][j];
							pq.add(j);
						}
					}
				}
			}
			
			int total = 0;
			
			for (int j = 1; j <= n; j++) {
				if(minArr[j] <= m) {
					total += items[j];
				}
			}
			
			maxTotal = Math.max(maxTotal, total);
		}
		
		
		System.out.println(maxTotal);
	}
}