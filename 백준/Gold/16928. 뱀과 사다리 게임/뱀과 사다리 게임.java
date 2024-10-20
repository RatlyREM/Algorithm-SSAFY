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
			
			//gameList[s].add(d);
			hm.put(s, d);
			
		}
		
		//뱀 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			//gameList[s].add(d);
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
		
		//DFS
		//DFS(gameList, 1, 0, hm);
		
		//BFS
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		visited[1] = 1;
		parent[1] = 0;
		
		int depth = 0;
		
		while(!q.isEmpty()) {
			//System.out.println("temp: ");
			//System.out.println(Arrays.toString(parent));
			
			int qSize = q.size();
			
			//System.out.println(q.toString());
			
			for (int j = 0; j < qSize; j++) {
				int temp = q.poll();
				//System.out.println("이번 temp는:  "+ temp);
//				if(temp == 100) {
//					System.out.println(depth);
//					System.exit(0);
//				}
				
//				for (int i = 0; i < gameList[temp].size() ; i++) {
//					System.out.print(gameList[temp].get(i) + ", ");
//				}
//				System.out.println();
				
				if(hm.containsKey(temp)) {
					if(visited[hm.get(temp)] == 0) {
						visited[hm.get(temp)] =1;
						
						//System.out.println(hm.get(temp) + ", " + " 에 " +  temp +"," + parent[temp] +   "자리꺼 그대로 넣음!!");
						
						//System.out.println(hm.get(temp) + "자리꺼 채워짐!!!!!!!!!"+parent[hm.get(temp)]);
						//System.out.println(Arrays.toString(parent));
						
						
						q.add(hm.get(temp));
					}
					parent[hm.get(temp)] = Math.min(parent[hm.get(temp)],parent[temp]);
					
				}
				else {
					//System.out.println("맵에 없음!!");
					for (int i = 0; i < gameList[temp].size(); i++) {
						if(visited[gameList[temp].get(i)] == 0) {
							visited[gameList[temp].get(i)] = 1;
							q.add(gameList[temp].get(i));
							
							//System.out.println(gameList[temp].get(i) + " 가 현재 수임!!!");
							//System.out.println(parent[gameList[temp].get(i)] + "이랑 "+ (parent[temp]+1) + "중에 선택!!");
							
							
						}
						
						parent[gameList[temp].get(i)] = Math.min(parent[gameList[temp].get(i)],parent[temp]+1);
						
					}
					
					
				}
				
//				for (int i = 0; i < gameList[temp].size(); i++) {
//					if(visited[gameList[temp].get(i)] == 0) {
//						visited[gameList[temp].get(i)] = 1;
//						q.add(gameList[temp].get(i));
//						
//						System.out.println(gameList[temp].get(i) + "달성!!" + temp);
//						
//						if(hm.containsKey(temp)) {
//							parent[hm.get(gameList[temp].get(i))] = Math.min(parent[gameList[temp].get(i)] , depth);
//						}
//						else {
//							parent[gameList[temp].get(i)] = Math.min(parent[gameList[temp].get(i)] , depth+1);
//						}
//						
//						
//						
//					}
//				}
			}
			
			depth++;
		}
		
		System.out.println(parent[100]);
		
	}
	
//	static void DFS(List<Integer>[] gameList, int now, int depth, HashMap<Integer, Integer> hm) {
//		//count++;
//		//if(count==100) System.exit(0);
//		//visited[now] = 1;
//		//만약 맵에 들어가 있으면 바로 그곳으로 출발
//		System.out.println("현재는 " + now);
//		
//		if(now == 100) {
//			System.out.println("현재 " + now + "에 있음!!" + "그리고 " + depth+ "번 주사위 던짐");
//			
//			minDepth = Math.min(minDepth, depth);
//			return;
//		}
//		
//		if(hm.containsKey(now)) {
//			if(visited[hm.get(now)] == 0) {
//				visited[hm.get(now)] = 1;
//				DFS(gameList, hm.get(now), depth, hm);
//				visited[hm.get(now)] = 0;
//			}
//		}
//		else {
//			System.out.println(now+"에서 갈 수 있는 길은 + " + gameList[now].size());
//			for (int i = 0; i < gameList[now].size(); i++) {
//				//System.out.println(now+"의 " + gameList[now].get(i) + "로 가는 길 탐색!!!");
//				
//				if(visited[gameList[now].get(i)] == 0) {
//					visited[gameList[now].get(i)] = 1;
//					
//					
//					if(dp[gameList[now].get(i)] == -1) {
//						DFS(gameList, gameList[now].get(i), depth+1, hm);
//						System.out.println(gameList[now].get(i) + " 끝내고 돌아옴!!");
//						visited[gameList[now].get(i)] = 0;
//					}
//					//System.out.println("길 찾았다!! " + now + " -> " + gameList[now].get(i));
//					
//					
//				}
//			}
//			
//			
//		}
		
	//}
	
}