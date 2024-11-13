import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 각 칸을 순회하며 BFS로 가장 큰 안전 거리를 찾기.
		 * 2. BFS를 통해 1이 가장 먼저 등장한 depth를 저장한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] shark = new int[N][M];
		int maxSafe = -1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] visited = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		
		//안전 거리 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				for (int a = 0; a < N; a++) {
					for (int k = 0; k < M; k++) {
						visited[a][k] = 0;
						
					}
				}
				
				int m = BFS(shark, visited, q, i,j);
				if(m != -1) {
					maxSafe = Math.max(maxSafe, m);
				}
			}
		}
		
		System.out.println(maxSafe);
		
	}
	
	static int BFS(int[][] shark, int[][] visited, Queue<Point> q, int i, int j) {
		if(shark[i][j] == 1) return 0;
		
		q.add(new Point(i,j));
		visited[i][j] = 1;
		
		int depth = 1;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for (int a = 0; a < qSize; a++) {
				Point p = q.poll();
				
				for (int k = 0; k < 8; k++) {
					int tempX = p.x+dx[k];
					int tempY = p.y+dy[k];
					
					if(tempX >= 0 && tempX <N && tempY >=0 && tempY <M) {
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(shark[tempX][tempY] == 1) {
								q.clear();
								return depth;
							}
							q.add(new Point(tempX, tempY));
						}
					}
				}
				
			}
			
			depth++;
			
		}
		
		return -1;
	}
}