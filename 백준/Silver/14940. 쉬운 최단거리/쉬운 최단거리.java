import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[][] mapp;
	static int[][] distance;
	static int[][] visited;
	static int n,m;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		mapp = new int[n][m];
		distance = new int[n][m];
		visited = new int[n][m];
		Point two = new Point();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				mapp[i][j] = Integer.parseInt(st.nextToken());
				if(mapp[i][j] == 2) two = new Point(i,j);
			}
		}
		
		bfs(two.x, two.y);
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mapp[i][j] == 1 && distance[i][j] == 0) {
					distance[i][j] = -1;
				}
				
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	static void bfs(int a, int b) {
		Queue<Point> qu = new LinkedList<Point>();
		
		qu.add(new Point(a,b));
		
		visited[a][b] = 1;
		
		int depth = 0;
		
		while(!qu.isEmpty()) {
			int s = qu.size();
			for (int i = 0; i < s; i++) {
				Point temp = qu.poll();
				distance[temp.x][temp.y] = depth;
				
				for (int j = 0; j < 4; j++) {
					int tempX = temp.x+dx[j];
					int tempY = temp.y+dy[j];
					
					if(tempX >= 0 && tempX < n && tempY >= 0 && tempY < m) {
						if(visited[tempX][tempY] == 0) {
							if(mapp[tempX][tempY] == 1) {
								visited[tempX][tempY] = 1;
								qu.add(new Point(tempX, tempY));
							}
						}
					}
				}
			}
			
			depth++;
		}
	}
	
}