import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		/*
		 * 하루마다 토마토가 전부 익었는지 검사해야 한다!
		 * BFS로 하루마다 익은 토마토가 퍼져나가도록 한다.
		 * 각 익은 토마토마다 BFS를 하나씩 진행.
		 * 
		 * 주변이 0이었으면 1로 바뀐다!
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] visited = new int[N][M];
		int[][] tomato = new int[N][M];

		Queue<Point> qu = new LinkedList<>();
		
		int result = -1;
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomato[i][j] == 1) {
					qu.add(new Point(i,j));
					visited[i][j] = 1;
					total++;
				}
				
				if(tomato[i][j] == -1) {
					total++;
				}
				
			}
		}
		
	
		int depth = 0;
		
		while(!qu.isEmpty()) {
			if(total == N*M) {
				result = depth;
				break;
			}
			
			int qnum = qu.size();
			
			for (int j = 0; j < qnum; j++) {
				Point temp = qu.poll();
				
				//주위 검사
				for (int i = 0; i < 4; i++) {
					int tempX = temp.x + dx[i];
					int tempY = temp.y + dy[i];
					
					if(tempX >= 0 && tempX < N && tempY >=0 && tempY < M) {
						if(visited[tempX][tempY] == 0 && tomato[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							tomato[tempX][tempY] = 1;
							total++;
							qu.add(new Point(tempX, tempY));
						}
					}
					
				}		
			}
			
			depth++;
		}

		System.out.println(result);
		
	}
	
	static int checkTomato(int[][] tomato, int N, int M) {
		//다 익었는지 검사
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j] != 0) {
					total++;
				}
			}
		}
		
		return total;
	}
}