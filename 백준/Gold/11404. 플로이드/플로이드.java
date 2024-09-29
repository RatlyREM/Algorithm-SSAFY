import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n+1][n+1];
		
		for (int i = 1; i < n+1; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}
		
		//그래프 등록
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		//X-> Y로 가는 비용보다 (X-> 1) + (1-> Y)가 더 작으면 업뎃.
		//거쳐서 가는 정점들 순회
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				for (int k = 1; k < n+1; k++) {
					if(graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE) graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		//출력
		for (int q = 1; q < n+1; q++) {
			for (int w = 1; w < n+1; w++) {
				if(graph[q][w] == Integer.MAX_VALUE) System.out.print(0 + " ");
				else System.out.print(graph[q][w] + " ");
			}
			System.out.println();
		}
	}
}