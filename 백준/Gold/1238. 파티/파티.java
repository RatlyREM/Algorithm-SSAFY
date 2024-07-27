import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static int N;
	static int maxTotal= -1;
	static int[][] graph;
	static int[][] reverseGraph;
	static int[] visited;
	static int[] minArr;
	static PriorityQueue<Point> pq;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 다익스트라.
		 * 1. 먼저 출발점을 우선순위 큐에 넣고, 최단거리를 0으로 초기화
		 * 2. 주변 노드들을 탐색하고, 바꿀 수 있는거 바꾸기. 바뀌면 큐에 넣기
		 * 3. 우선 순위 큐에서 하나 빼기. 주변을 살피며 갱신되는게 있으면 큐에 넣기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		minArr = new int[N+1];
		graph = new int[N+1][N+1];
		reverseGraph = new int[N+1][N+1];
		pq = new PriorityQueue<Point>((o1, o2) ->  {
			return o1.y- o2.y;
		});
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
			reverseGraph[b][a] = c;
			
			
		}
		
		int[] temp = dijk(X, graph);
		int[] xToI = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			xToI[i] = temp[i];
		}
		
		int[] temp2 = dijk(X, reverseGraph);
		int[] iToX = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			iToX[i] = temp2[i];
		}
		
		
		
		for (int i = 1; i <= N; i++) {
			//i-> X, X-> i의 최단거리 합을 재야 함.
			if(i != X) {
				int total = iToX[i] + xToI[i];
				maxTotal = Math.max(maxTotal, total);	
			}
			
		}
		
		System.out.println(maxTotal);
	}

	private static int[] dijk(int i, int[][] graph) {
		visited = new int[N+1];
		Arrays.fill(minArr, Integer.MAX_VALUE);
		
		minArr[i] = 0;
		
		pq.add(new Point(i,0));
		
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			
			if(visited[temp.x] == 0) {
				visited[temp.x] = 1;
				
				for (int j = 1; j <= N; j++) {
					if(graph[temp.x][j] != 0) {
						int t = minArr[temp.x] + graph[temp.x][j];
						
						if(t < minArr[j]) {
							minArr[j] = t;
							
							if(visited[j] == 0) {
								pq.add(new Point(j, t));
							}
						}
					}
				}
				
			}
			
			
			
		}
		
		return minArr;
	}

}