package PS240429;

import java.io.*;
import java.util.*;

public class BJ_5972 {
	/*
	 * 다익스트라 문제풀이
	 * 1. 5만x5만이므로 인접 리스트 방식으로 그래프를 만든다. 양방향이므로 각 정점의 양쪽에서 삽입.
	 * 2. 시작 지점의 최솟값을 0으로 설정하고 pq에 삽입한다.
	 * 3. pq에서 하나 뽑고, 방문 안 했다면 방문.(pq는 비용이 작은 순으로 나오게 함)
	 * 4. 인접한 정점 살펴보기. 방문 안 했다면 큐에 삽입.
	 * 5. 본래 정점의 최소에 가는 비용을 더한 비용이 목적지의 현 최소비용보다 작다면 업데이트.
	 * 5. pq가 빈다면 반복문 종료
	 */
	
	public static class Cow {
		int d;
		int cost;
		
		public Cow(int d, int cost) {
			this.d = d;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Cow>[] graph = new ArrayList[N+1]; 
		int[] min = new int[N+1];
		int[] visited= new int[N+1];
		
		Arrays.fill(min, Integer.MAX_VALUE);
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Cow>();
		}
		//그래프 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int Ai = Integer.parseInt(st.nextToken());
			int Bi = Integer.parseInt(st.nextToken());
			int Ci = Integer.parseInt(st.nextToken());
			
			graph[Ai].add(new Cow(Bi, Ci));
			graph[Bi].add(new Cow(Ai, Ci));
		}
		
		
		PriorityQueue<Cow> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		min[1] = 0;
		pq.add(new Cow(1,0));
		
		
		while(!pq.isEmpty()) {
			Cow tempCow = pq.poll();

			if(visited[tempCow.d] != 0) continue;
			else {
				visited[tempCow.d] = 1;
				
				for (Cow i : graph[tempCow.d]) {
					if(min[i.d] > min[tempCow.d] + i.cost) {
						min[i.d] = min[tempCow.d] + i.cost;
					}
					
					if(visited[i.d] == 0) {
						pq.add(new Cow(i.d, min[i.d]));
					}
				}
			}	
		}
		
		System.out.println(min[N]);
	}
}



