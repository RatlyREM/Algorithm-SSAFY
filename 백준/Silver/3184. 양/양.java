import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[][] visited;
	static int sheep = 0;
	static int wolf = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static char[][] yard;
	static int R,C;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 방문하지 않은 영역의 동물이라면, bfs를 돌린다.
		 * 2. BFS 돌고 났는데 늑대>= 양 이라면, 늑대 수만 증가시킨다.
		 * 3. BFS 돌고 났는데 양> 늑대 라면, 양 수만 증가시킨다.
		 * 4. 총 양과 늑대 수를 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		yard = new char[R][C];
		visited = new int[R][C];
		
		int resultS= 0;
		int resultW = 0;
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < C; j++) {
				yard[i][j] = temp.charAt(j);
			}
		}
		
		//BFS 진행
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(yard[i][j] == 'v' || yard[i][j] == 'o') {
					if(visited[i][j] == 0) {
						
						if(yard[i][j] == 'v') wolf++;
						else sheep++;
						
						bfs(i,j);
						
						//System.out.println("늑대: " + wolf + " 양: " + sheep);
						if(wolf >= sheep) resultW += wolf;
						else resultS += sheep;
						
						sheep = 0;
						wolf = 0;
					}
				}
			}
		}
		
		System.out.println(resultS + " " + resultW);
		
	}
	
	static void bfs(int a, int b) {
		//System.out.println(a + " " + b + " bfs 시작");
		Queue<Point> q = new LinkedList<Point>();
		
		//방문
		q.add(new Point(a,b));
		visited[a][b] = 1;
		
		
		//bfs 시작
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempX = temp.x + dx[i];
				int tempY = temp.y + dy[i];
				
				if(tempX >= 0 && tempX <R && tempY >= 0 && tempY <C) {
					if(yard[tempX][tempY] != '#') {
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(yard[tempX][tempY] == 'v') {
								wolf++;
							}
							else if(yard[tempX][tempY] == 'o') {
								sheep++;
							}
							
							q.add(new Point(tempX, tempY));
							
						}
					}
					
					
				}
				
			}	
		}
	}
}