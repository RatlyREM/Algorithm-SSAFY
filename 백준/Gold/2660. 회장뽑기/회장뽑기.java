import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * BFS 한번 갔을 때 1점.
		 * 두번 갔을 때 2점.
		 * 
		 * BFS로 전부 다 탐색하는 depth를 구해서 최소를 구하면 됨!
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] li = new List[N+1];
		int minDepth = Integer.MAX_VALUE;
		List<Point> depthList = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a== -1 && b==-1) break;
			
			li[a].add(b);
			li[b].add(a);
		}
		
		//각각 BFS 실행
		for (int i = 1; i <= N; i++) {
			Queue<Integer> q = new LinkedList<>();
			int[] visited = new int[N+1];
			int depth = -1;
			
			q.add(i);
			visited[i] = 1;
			
			//i-> temp
			while(!q.isEmpty()) {
				int qSize = q.size();
				
				for (int k = 0; k < qSize; k++) {
					int temp = q.poll();
					
					for (int j = 0; j < li[temp].size(); j++) {
						if(visited[li[temp].get(j)] == 0) {
							visited[li[temp].get(j)] = 1;
							
							q.add(li[temp].get(j));
						}
					}
				}
				
				depth++;
			}
			
			//depth 최솟값 계산
			minDepth = Math.min(minDepth, depth);
			depthList.add(new Point(i, depth));
		}
		
		int total = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < depthList.size(); i++) {
			if(depthList.get(i).y == minDepth) {
				total++;
				sb.append(depthList.get(i).x + " ");
			}
		}
		
		System.out.println(minDepth + " " + total);
		System.out.println(sb.toString());
	}
}