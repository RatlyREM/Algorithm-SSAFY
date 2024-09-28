import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		/*
		 * 여
		 * 덩어리 개수 확인!! -> 여러 덩어리면 종료
		 * 
		 */	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] bing = new int[N][M];
		int[][] tempArr;
		int[][] visited;
		int[][] tempVisited;
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				bing[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int depth = 0;
		
		//연별로 변화 진행!!
		while(true) {
			tempArr = new int[N][M];
			visited = new int[N][M];
			tempVisited = new int[N][M];
			
			outerLoop:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//처음으로 비어있는데 찾으면 거기서 한번만 BFS하면 됨
					
					if(bing[i][j] > 0) {
						//System.out.println("i: " + i + " j: " + j);
						//여기서 BFS 진행
						
						Queue<Point> q = new LinkedList<>();
						q.add(new Point(i,j));
						visited[i][j] = 1;
						
						while(!q.isEmpty()) {
							Point p = q.poll();
							int total = 0;

							for (int k = 0; k < 4; k++) {
								int tempX = p.x + dx[k];
								int tempY = p.y + dy[k];
								
								if(tempX >= 0 && tempX <N && tempY >=0 && tempY <M) {
									if(bing[tempX][tempY] == 0) total++;
									else {
										if(visited[tempX][tempY] == 0) {
											visited[tempX][tempY] = 1;
											
											q.add(new Point(tempX, tempY));
										}
									}
								}
							}
							
							//해당 지역의 주위에 0이 몇 개인지 tempArr에 삽입
							tempArr[p.x][p.y] = total;
							tempVisited[p.x][p.y] = 1;
						}
						
						break outerLoop;
					}
				}
				
				
			}
			
			int bingTotal = 0;
			int flag = 0;
			
//			System.out.println("방문한놈들 상황");
//			//녹은 빙산 빼면서 전체 비었는지 확인
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(tempVisited[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			//녹은 빙산 빼면서 전체 비었는지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tempVisited[i][j] == 0 && bing[i][j] != 0) {
						flag = 1;
						break;
					}
					
					bing[i][j] = (bing[i][j]-tempArr[i][j] < 0) ? 0 : bing[i][j]-tempArr[i][j];
					bingTotal += bing[i][j];
					
				}
			}
			
			//빙산이 없으면 그냥 0 아님?
			
			
			//빙산 여러 덩어리면 탈출
			if(flag == 1) break;
			
			//빙산 비었으면 탈출
			if(bingTotal == 0) {
				depth = 0;
				break;
			}
			
			depth++;
			
//			System.out.println("빙산 상황");
//			//녹은 빙산 빼면서 전체 비었는지 확인
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(bing[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		
		System.out.println(depth);
	}
}