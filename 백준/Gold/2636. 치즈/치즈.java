import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		/*
		 * 0. 바깥 공기에서 bfs해서 바깥부분 채우기
		 * 1. 바깥에서 한번만 파고들어가서 c인 부분을 찾기
		 * 2. c인 부분 없애기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		int[][] visited;
		Queue<Point> q = new LinkedList<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int totalBefore = 0;
		int totalTime = 0;
		
		//0,0에서 bfs 출발
		while(true) {
			visited = new int[N][M];
			visited[0][0] = 1;
			q.add(new Point(0,0));
			totalBefore = checkCheeze(N,M, board);
				
			if(totalBefore == 0) break;
			
			//bfs 출발
			while(!q.isEmpty()) {
				Point temp = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int tempX = temp.x + dx[i];
					int tempY = temp.y + dy[i];
					
					if(tempX>=0 && tempX <N && tempY >=0 && tempY <M) {
						if(visited[tempX][tempY]== 0) {
							visited[tempX][tempY]= 1;
							
							if(board[tempX][tempY]== 1) {
								board[tempX][tempY] = 2;
							}
							else {
								q.add(new Point(tempX, tempY));
							}
						}
					}
				}
			}
			
			//치즈 녹기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j] == 2) {
						board[i][j] = 0;
					}
				}
			}
			totalTime++;
			
			if(checkCheeze(N,M, board) == 0) break;
		}
		
		
		System.out.println(totalTime + "\n" + totalBefore);
	}
	
	static int checkCheeze(int N, int M, int[][] board) {
		int total = 0;
		
		//총 치즈조각 칸 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				total += board[i][j];
			}
		}
		
		return total;
	}
}