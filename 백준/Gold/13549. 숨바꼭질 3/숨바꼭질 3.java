import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 모든 위치의 비용을 무한대로 설정한다. visited는 모두 0
		 * 2. N에서 시작하므로 해당 위치의 비용을 0으로 설정하고, pq에 넣는다.
		 * 3. pq에서 가장 우선순위가 높은 값을 뽑는다.
		 * 4. 해당 *2, -1, +1 한 번호에, 비용을 더한 값과 해당 위치의 최솟값이,
		 *  	visited되지 않았으면서 비용이 갱신되는지 살핀다. 
		 * 5. 갱신되었다면, (번호, 비용)을 pq에 삽입한다.
		 * 6. 만약 번호가 동생이 있는 위치에 도달했다면, 그만두고 시간을 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		int[] visited = new int[200001];
		int[] cost = new int[200001];
		PriorityQueue<Point> pq = new PriorityQueue<Point>((o1, o2) -> o1.y-o2.y);
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		visited[N] = 1;
		cost[N] = 0;
		pq.offer(new Point(N, 0));
		
		
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			
//			if(temp.x == K) {
//				System.out.println(cost[temp.x]);
//				break;
//			}
			
			visited[temp.x] = 1;
			
			//*2해보기
			
			if(temp.x * 2 < 200001) {
				if(visited[temp.x *2] == 0) {
					//비용이 갱신되는가?
					if(cost[temp.x *2] > (cost[temp.x])) {
						cost[temp.x*2] = cost[temp.x];
						pq.offer(new Point(temp.x *2, cost[temp.x*2]));
					}
				}
			}
			
			if(temp.x +1 < 200001) {
				//+1해보기
				if(visited[temp.x +1] == 0) {
					//비용이 갱신되는가?
					if(cost[temp.x +1] > (cost[temp.x] + 1)) {
						cost[temp.x+1] = cost[temp.x] + 1;
						pq.offer(new Point(temp.x +1, cost[temp.x+1]));
					}
				}
			}
			
			
			if(temp.x-1 >= 0 && temp.x-1 < 200001) {
				//-1해보기
				if(visited[temp.x -1] == 0) {
					//비용이 갱신되는가?
					if(cost[temp.x -1] > (cost[temp.x] + 1)) {
						cost[temp.x-1] = cost[temp.x] + 1;
						pq.offer(new Point(temp.x -1, cost[temp.x-1]));
					}
				}
			}
		}
		
		System.out.println(cost[K]);
	
	}
}