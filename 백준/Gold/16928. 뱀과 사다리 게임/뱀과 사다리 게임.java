import java.io.*;
import java.util.*;

public class Main {
	static int[] visited;
	static int minDepth = Integer.MAX_VALUE;
	static int count = 0;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] gameList = new List[101];
		visited = new int[101];
		int[] parent = new int[101];
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		dp = new int[101];
		Arrays.fill(dp, -1);
		Arrays.fill(parent, Integer.MAX_VALUE);
		
		for (int i = 1; i < 101; i++) {
			gameList[i] = new ArrayList<Integer>();
		}
		
		//사다리 연결
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			hm.put(s, d);
			
		}
		
		//뱀 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			hm.put(s, d);
			
		}
		
		for (int i = 1; i < 101; i++) {
			if(!hm.containsKey(i)) {
				//갈 수 있는 주사위만큼 그래프 연결
				for (int j = 1; j <= 6; j++) {
					if(i+j <= 100) gameList[i].add(i+j);
				}
			}
			
		}
		
		//BFS
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		visited[1] = 1;
		parent[1] = 0;
		
		int depth = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for (int j = 0; j < qSize; j++) {
				int temp = q.poll();
				
				if(hm.containsKey(temp)) {
					if(visited[hm.get(temp)] == 0) {
						visited[hm.get(temp)] =1;
						q.add(hm.get(temp));
					}
					parent[hm.get(temp)] = Math.min(parent[hm.get(temp)],parent[temp]);
					
				}
				else {
					for (int i = 0; i < gameList[temp].size(); i++) {
						if(visited[gameList[temp].get(i)] == 0) {
							visited[gameList[temp].get(i)] = 1;
							q.add(gameList[temp].get(i));
						}
						
						parent[gameList[temp].get(i)] = Math.min(parent[gameList[temp].get(i)],parent[temp]+1);
						
					}
				}
			}
			
			depth++;
		}
		
		System.out.println(parent[100]);
		
	}
}