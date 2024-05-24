import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};

	static int totalCount = 0;
	
	public static class Shark {
		int x;
		int y;
		int l;
		int fish;
		
		public Shark() {
		}
		public Shark(int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] space = new int[N][N];
		int[][] visited;
		
		Shark shark = new Shark();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				
				if(space[i][j] == 9) {
					shark = new Shark(i,j,2);
				}
			}
		}
		
		//BFS를 통해 가장 가까운 거리에 있는 먹을 수 있는 물고기를 찾는다.
		//같은 depth에서는 다 가져오고 위치 확인, 해당 depth에서 발견했다면 종료.
		
		PriorityQueue<Point> fish = new PriorityQueue<>((o1, o2) ->  {
			if(o1.x != o2.x) return o1.x-o2.x;
			else return o1.y-o2.y;
		});

		Queue<Point> q = new LinkedList<Point>();

		while(true) {
			visited = new int[N][N];
			q.add(new Point(shark.x, shark.y));
			visited[shark.x][shark.y] = 1;
			
			int flag = 0;
			int count = 0;
			
			while(!q.isEmpty()) {
				//상하좌우 돌면서 bfs
				count++;
				
				int qSize = q.size();
				
				for (int i = 0; i < qSize; i++) {
					Point temp = q.poll();

					for (int j = 0; j < 4; j++) {
						int tempX = temp.x + dx[j];
						int tempY = temp.y + dy[j];
						
						//범위 안이라면
						if(tempX >=0 && tempX <N && tempY >=0 && tempY <N) {
							if(visited[tempX][tempY] == 0) {
								visited[tempX][tempY] = 1;
								
								/*
								 * 물고기 크기가 크다면, 방문만 하고 큐에 추가 x
								 * 같다면, 방문하고 큐에 추가
								 * 작다면, 방문하고 큐에 추가하지 말기, 먹을 물고기에 추가
								 */
								
								if(space[tempX][tempY] <= shark.l) {
									q.add(new Point(tempX, tempY));
									
									if(space[tempX][tempY] != 0 && space[tempX][tempY] != 9) {
										if(space[tempX][tempY] < shark.l) {
											flag = 1;
											fish.add(new Point(tempX, tempY));
										}
									}
								}
							}
						}		
					}
				}
				
				
				//물고기 발견
				if(flag == 1) {
					Point pp = fish.poll();

					//물고기 먹었으면, 걸린 시간 업데이트, 상어 위치 업데이트, 물고기 상황, 상어 크기 업데이트
					totalCount += count;
					
					space[shark.x][shark.y] = 0;
					
					shark.x = pp.x;
					shark.y = pp.y;

					space[shark.x][shark.y] = 9;
					
					shark.fish += 1;
					
					if(shark.fish == shark.l) {
						shark.l += 1;
						shark.fish = 0;
					}
					
					q.clear();
					fish.clear();
					
					break;
				}
			}
			
			//끝나고 나왔는데 먹을 물고기 발견 못함
			if(flag == 0) {
				//엄마 상어에게 도움 요청
				System.out.println(totalCount);
				break;
			}
		}
		
	}
}