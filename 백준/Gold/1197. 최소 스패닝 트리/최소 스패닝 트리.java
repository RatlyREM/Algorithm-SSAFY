import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static long totalCount = 0L;
	
	static class Vertex {
		int start;
		int end;
		int cost;
		
		public Vertex(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		/*
		 * 최소 스패닝 트리 
		 * 크루스칼
		 * 
		 * 1. 가중치가 가장 작은 간선을 뽑아낸다.
		 * 	-> 우선순위 큐를 통해 제일 가중치가 작은 (정점-> 정점)을 뽑아냄.
		 * 2. 해당 간선을 추가했을 때 사이클이 존재하는지 확인한다.(유니온-파인드로)
		 * 	-> 양 간선을 find로 보고 동일한지 확인한다.
		 * 	-> 동일하면, 사이클이 존재하므로 잇지 않는다.
		 * 	-> 동일하지 않으면, 사이클이 존재하지 않으므로 잇는다.
		 * 3. 해당 횟수마다 모든 정점이 연결되어 있는지 확인한다.
		 * 	-> 1에서 BFS 돌아서 visited 확인, 연결되어 있다면 가중치 비용합 출력.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Integer>[] answer = new List[V+1];
		int[] visited = new int[V+1];
		
		parent = new int[V+1];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArrayList<>();
			parent[i] = i;
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Vertex(s, e, c));
		}
		
		while(!pq.isEmpty()) {
			Vertex ver = pq.poll();
			
			int s = ver.start;
			int e = ver.end;
			
			if(find(s) != find(e)) {
				union(s,e);
				totalCount += ver.cost;
			}
		}
		
		System.out.println(totalCount);
		
	}
	
	static int find(int f) {
		if(parent[f] == f) return parent[f];
		return parent[f] = find(parent[f]);
	}
	
	static void union(int s, int e) {
		int rootS = find(s);
		int rootE = find(e);
		
		if(rootS < rootE) parent[rootE] = rootS;
		else parent[rootS] = rootE;
	}
}