import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	
	static int[][] visited;
	static int I;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine());
			
			int[][] chess= new int[I][I];
			visited = new int[I][I];
			
			st = new StringTokenizer(br.readLine());
			
			Point start= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			
			Point end= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			System.out.println(bfs(start, end));
			
			
			
			//초기화
			for (int j = 0; j < I; j++) {
				for (int j2 = 0; j2 < I; j2++) {
					visited[j][j2] = 0;
				}
			}
		}	
	}
	
	
	static int bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(start.x , start.y));
		visited[start.x][start.y] =1;
		int depth = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
//			System.out.println("큐 출력");
//			for(Point p : q) {
//				System.out.println(p.x + " " + p.y);
//			}
			for (int j = 0; j < qSize; j++) {
				Point temp = q.poll();
				
				
				for (int k = 0; k < 8; k++) {
					int tempX = temp.x + dx[k];
					int tempY = temp.y + dy[k];
					
					//System.out.println("시험: "+ tempX + " " + tempY);
					if(tempX >=0 && tempX < I && tempY >=0 && tempY <I) {
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(tempX == end.x && tempY == end.y) {
								return depth+1;
							}
							
							q.add(new Point(tempX, tempY));
						}
					}
					
				}
			}
			depth++;
		}
		
		return 0;
	}
}