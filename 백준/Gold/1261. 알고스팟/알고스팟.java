import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static class Point {
		int x;
		int y;
		int wall;
		
		public Point(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
		
	}
	public static void main(String[] args) throws IOException {
		/*
		 * 다익스트라.
		 * https://mountain96.tistory.com/25
		 * DFS나 BFS는 정점간 가중치가 동일하고, 얼마나 적은 수의 노드를 거쳤는지가 중요함.
		 * 
		 * 반면 다익스트라는 정점간 가중치가 다르고, 얼마나 최소 가중치의 간선을 거치며
		 * 도달했는지가 중요.
		 * 
		 * 얼마나 적은 수의 벽을 부수고 도달하였는지가 중요하므로 다익스트라 사용 가능.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][] minArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j)- '0';
			}
			
			Arrays.fill(minArr[i], Integer.MAX_VALUE);
		}
		
		
		//1,1에서 다익스트라 출발!!
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.wall- o2.wall);
		
		pq.add(new Point(0,0,0));
		minArr[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempX = p.x+ dx[i];
				int tempY = p.y+ dy[i];
				int nowBroke = p.wall;
				
				if(tempX >=0 && tempX <N && tempY >=0 && tempY < M) {
					if(arr[tempX][tempY] ==1) {
						nowBroke++;
					}
					
					if(minArr[tempX][tempY] > nowBroke) {
						minArr[tempX][tempY] = nowBroke;
						pq.add(new Point(tempX, tempY, nowBroke));
					}
				}
			}
			
		}
		
		System.out.println(minArr[N-1][M-1]);
	}
}