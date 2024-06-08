import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2, -2, 0,0,2,2};
	static int[] dy = {-1,1, -2,2, -1,1};
	static int[][] visited;
	static int N, c1,c2;
	static int[][] chess;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		visited = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(r1, r2));	
		
	}
	
	
	static int bfs(int r1, int r2) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(r1, r2));
		visited[r1][r2] = 1;
		int depth = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				for (int j = 0; j < 6; j++) {
					int tempX = temp.x+dx[j];
					int tempY = temp.y+dy[j];
					
					if(tempX>=0 && tempX <N && tempY >=0 && tempY < N) {
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(tempX == c1 && tempY == c2) {
								
								return depth+1;
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