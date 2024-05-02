import java.io.*;
import java.util.*;

public class Main {
	static int[] family;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		
		//BFS
		//일단 그래프 만들기
		int[][] family = new int[n+1][n+1]; 
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			family[a][b] = 1;
			family[b][a] = 1;
		}
		
		//x부터 출발해서 bfs
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visited = new int[n+1];
		
		q.add(x);
		visited[x] = 1;
		int count = 0;
		
		while(!q.isEmpty()) {
			count++;
			
			int qSize = q.size();
			
			for (int j = 0; j < qSize; j++) {
				int current = q.poll();

				for (int i = 1; i <= n; i++) {
					if(family[current][i] == 1) {
						if(visited[i] == 0) {
							visited[i] = 1;
							
							q.add(i);
							
							if(i == y) {
								System.out.println(count);
								System.exit(0);
							}
						}
					}
				}
			}
		}
		
		System.out.println("-1");
	}

}