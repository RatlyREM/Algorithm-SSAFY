import java.io.*;
import java.util.*;

public class Main {
	public static class Cow implements Comparable<Cow>{
		int end;
		int cost;
		
		public Cow(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
        public int compareTo(Cow n) {
            return this.cost - n.cost;
        }
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] min = new int[N+1];
		int[] visited = new int[N+1];
		
		//인접 리스트 방식으로 그래프 만들기
		ArrayList<Cow>[] graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Cow>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int Ai = Integer.parseInt(st.nextToken());
			int Bi = Integer.parseInt(st.nextToken());
			int Ci = Integer.parseInt(st.nextToken());
			
			graph[Ai].add(new Cow(Bi, Ci));
			graph[Bi].add(new Cow(Ai, Ci));
		}

		Arrays.fill(min, 50000001);
		
		PriorityQueue<Cow> pq = new PriorityQueue<>();
		
		min[1] = 0;
		pq.add(new Cow(1, 0));
		
		while(!pq.isEmpty()) {
			//pq에서 하나 추출
			Cow tempCow = pq.poll();
			
			//System.out.println(tempCow.end + " " + tempCow.cost);
			
			
			if(visited[tempCow.end] == 0) {
				visited[tempCow.end] = 1;
				
				
				//인접한 정점들 pq에 추가
				
				for(int i = 0; i < graph[tempCow.end].size(); i++) {
					Cow next = graph[tempCow.end].get(i);
					
					 if(min[next.end] > min[tempCow.end] + next.cost) {
		                    min[next.end] = min[tempCow.end] + next.cost;
		                    pq.offer(new Cow(next.end, min[next.end]));
		             }
					
				}
				
//				for (Cow i : graph[tempCow.end]) {	
//					//System.out.println(i.end + " 인접함");
//					//System.out.println(tempCow.end + " 와 인접한" + i.end);
//					
//					//System.out.println((min[tempCow.end] + i.cost) + " "+ min[i.end]);
//					//갈 수 있는 곳에 대해서는 모두 업데이트
//					if((min[tempCow.end] + i.cost) < min[i.end]) {
//						min[i.end] = min[tempCow.end] + i.cost;
//						pq.add(new Cow(i.end , i.cost));
//					}
//				}
			}
			
		}
		
		//System.out.println(Arrays.toString(min));
		System.out.println(min[N]);
	}
}