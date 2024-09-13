import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][N];
		int count = 0;
		List<Integer> li = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				house[i][j] = s.charAt(j) - '0';
			}
		}
		
		
		Queue<Point> q = new LinkedList<Point>();
		
		int[][] frame = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(house[i][j] == 1 && frame[i][j] == 0) {
					//BFS 들어가기
					
					int[][] visited = new int[N][N];
					
					q.add(new Point(i,j));
					frame[i][j] = 1;
					visited[i][j] = 1;
					count = 1;
					
					while(!q.isEmpty()) {
						Point temp = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int tempX = temp.x+ dx[k];
							int tempY = temp.y+ dy[k];
							
							if(tempX >=0 && tempX <N && tempY >=0 && tempY <N) {
								if(visited[tempX][tempY] == 0) {
									visited[tempX][tempY] = 1;
									
									if(house[tempX][tempY] == 1) {
										q.add(new Point(tempX, tempY));
										frame[tempX][tempY] = 1;
										count++;
									}
								}
							}
						}
						
					}
					
					li.add(count);
					count = 0;
				}
				
			}
		}
		
		System.out.println(li.size());
		
		Collections.sort(li);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}
}