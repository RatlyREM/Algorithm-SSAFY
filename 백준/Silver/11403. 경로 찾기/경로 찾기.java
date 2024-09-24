import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * BFS돌면서 j가 나오면 1로
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[N][N];
		int[][] result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//각 정점에 대해 BFS
		for (int i = 0; i < N; i++) {
			int[] visited = new int[N];
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.add(i);
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				
				for (int j = 0; j < N; j++) {
					if(graph[temp][j] == 1) {
						if(visited[j] == 0) {
							visited[j] = 1;
							result[i][j] = 1;
							q.add(j);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}	
	}
}