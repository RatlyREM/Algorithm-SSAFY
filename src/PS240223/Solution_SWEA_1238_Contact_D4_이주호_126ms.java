package PS240223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_이주호_126ms {
	
	static ArrayList<Integer>[] bisang;
	static int[] visited;
	static int[] depth;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 일단 입력받은 대로 그래프 구축(링크드 리스트)
		 * 2. 시작된 노드부터 BFS 진행
		 * 3. BFS가 끝나면, 방문된 노드 중 가장 번호가 큰 노드를 리턴한다.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = 10;
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int root = Integer.parseInt(st.nextToken());
			
			//연결 리스트 방식 -> AL 할당
			bisang = new ArrayList[102]; 
			visited = new int[102];
			depth = new int[102];
			
			 for (int j = 0; j < bisang.length; j++) {
				 bisang[j] = new ArrayList<Integer>();
		     }
			 
			st = new StringTokenizer(br.readLine());
			
			//그래프에 간선 할당
			for (int j = 0; j < num/2; j++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				//System.out.println(start + " " + end);
				
				bisang[start].add(end);
			}
			
			BFS(root);
			
			int maxDepth = -1;
			int maxNum = -1;
			//depth가 가장 높은 수 중 최댓값을 찾는다.
			for (int j = 0; j < depth.length; j++) {
				if(depth[j] > maxDepth) {
					maxDepth = depth[j];
					maxNum = j;
				}
				else if(depth[j] == maxDepth) {
					if(maxNum < j) maxNum = j;
				}
				
			}
			
			
			System.out.println("#"+ (i+1) + " " + maxNum);
			
			//초기화
			Arrays.fill(visited, 0);
			for(ArrayList<Integer> a: bisang) {
				a.clear();
			}
			
		}
	}
	
	private static void BFS(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(root);
		visited[root] = 1;
		depth[root] = 0;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i: bisang[temp]) {
				if(visited[i] == 0) {
					visited[i] = 1;
					depth[i] = depth[temp]+1;
					q.add(i);
				}
			}

		}
	}
}







