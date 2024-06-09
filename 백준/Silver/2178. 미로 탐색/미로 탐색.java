import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] miro = new int[N][M];
		int[][] visited = new int[N][M];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < M; j++) {
				miro[i][j] = temp.charAt(j)- '0';
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0,0));
		visited[0][0] = 1;
		int depth = 1;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				
				for (int j = 0; j < 4; j++) {
					int tempX = temp.x+ dx[j];
					int tempY = temp.y+ dy[j];
					
					if(tempX >=0 && tempX < N && tempY >=0 && tempY <M) {
						
						//System.out.println(tempX + " " + tempY + "   일단 들어옴" + visited[tempX][tempY]);
						
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(miro[tempX][tempY] == 1) {
								//System.out.println(tempX + " " + tempY + "   진격");
								
								if(tempX == (N-1) && tempY == (M-1)) {
									System.out.println(depth+1);
									//System.out.println("종료!!!!!!!!!!!!");
									System.exit(0);
								}
								
								q.add(new Point(tempX, tempY));
							
								
							}
						}
					}
					
				}
			}
			
			depth++;
		}
	}
}