import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[][] visited;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		int minDepth = Integer.MAX_VALUE;
				
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//먼저 섬 찾기!!
		int sumNum = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//bfs로 섬 찾기 개시
				if(map[i][j] ==1 && visited[i][j] == 0) {
					bfs(i,j, sumNum);
					sumNum++;
				}
			}
		}
		
		visited = new int[N][N];
		//이제 각 섬끼리 연결할 최소 다리길이 찾기
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					int tempDepth = bfs2(i,j);
					
					if(tempDepth != -1) {
						if(tempDepth < minDepth) minDepth = tempDepth;
					}
					
					//visited 초기화 필요
					for (int k = 0; k < N; k++) {
						Arrays.fill(visited[k], 0);
					}
				}
				
			}
		}
		
		System.out.println(minDepth);
	}
	
	static int bfs2(int a, int b) {
		//depth 알아보면서 가다가, 자기 섬이랑 다른 섬 번호를 만나면 종료!!
		
		Queue<Point> qu = new LinkedList<Point>();
		
		qu.add(new Point(a,b));
		visited[a][b] = 1;
		
		int depth = 0;
		
		while(!qu.isEmpty()) {
			int tempSize = qu.size();
			
			for (int i = 0; i < tempSize; i++) {
				Point temp = qu.poll();
				
				for (int j = 0; j < 4; j++) {
					int tempX = temp.x + dx[j];
					int tempY = temp.y + dy[j];
					
					if(tempX>= 0 && tempX < N && tempY >=0 && tempY < N) {
						if(visited[tempX][tempY] == 0) {
							visited[tempX][tempY] = 1;
							
							if(map[tempX][tempY] == map[a][b]) continue;
							else if(map[tempX][tempY] != 0) {
								return depth;
							}
							
							
							qu.add(new Point(tempX, tempY));
						}
					}
					
				}
				
				
			}
			
			depth++;
		}
		return -1;
	}
	
	
	
	static void bfs(int a, int b, int num) {
		Queue<Point> qu = new LinkedList<Point>();
		
		qu.add(new Point(a,b));
		visited[a][b] = 1;
		map[a][b] = num;
		
		while(!qu.isEmpty()) {
			Point temp = qu.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempX = temp.x + dx[i];
				int tempY = temp.y + dy[i];
				
				if(tempX>= 0 && tempX < N && tempY >=0 && tempY < N) {
					if(visited[tempX][tempY] == 0 && map[tempX][tempY] != 0) {
						visited[tempX][tempY] = 1;
						map[tempX][tempY] = num;
						
						qu.add(new Point(tempX, tempY));
					}
				}
				
			}
			
		}
	}
}