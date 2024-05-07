import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

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
			// TODO Auto-generated constructor stub
		}
		public Shark(int x, int y, int l) {
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * NxN 크기의 공간, 물고기 M마리, 상어 1마리
		 * 처음 상어의 크기는 2. 물고기 크기는 제각각.
		 * 상어는 1초에 상하좌우로 인접한 한 칸씩 이동.
		 * 
		 * 자기보다 큰 물고기가 있는 칸은 못 지나감.
		 * 작은 물고기는 먹을 수 있음.
		 * 크기가 같은 물고기는 먹진 못하지만, 지나가기는 가능
		 * 
		 * 물고기가 1마리라면, 그 물고기 먹으러
		 * 1마리보다 많다면, 가장 가까운 물고기 먹으러
		 * 		거리는, 지나야 하는 칸의 개수의 최솟값
		 * 
		 * 거리가 같다면, 왼쪽 위의 물고기 먹기
		 * 
		 * 물고기를 먹으면, 그 칸은 빈 칸이 됨.
		 * 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 1 증가(먹은 물고기 수 저장
		 * 
		 * 먹을 수 있는 물고기가 없다면, 종료
		 */
		
		/*
		 * 1. 입력받은 상어와 물고기들을 배열에 삽입한다.
		 * 2. 인접한 물고기를 찾는다.
		 * 		각 물고기들의 위치를 순회하며 상어와 가장 가까운 거리에 있는 물고기를 찾는다.
		 */
		
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
		
		//ArrayList<Point> fish = new ArrayList<Point>();
		
		PriorityQueue<Point> fish = new PriorityQueue<>((o1, o2) ->  {
			if(o1.x != o2.x) return o1.x-o2.x;
			else return o1.y-o2.y;
		});

		Queue<Point> q = new LinkedList<Point>();
		//int ccc = 0;
		//여기서부터 빙빙 돌기
		while(true) {
//			System.out.println("새로 시작");
//			ccc++;
//			if(ccc == 3) {
//				break;
//			}
			
			//System.out.println("상어 위치는" + shark.x + " " + shark.y);
			
			
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
					
					//System.out.println("큐에 들어있던 " + temp.x + " " + temp.y);
					
					for (int j = 0; j < 4; j++) {
						int tempX = temp.x + dx[j];
						int tempY = temp.y + dy[j];
						
						//범위 안이라면
						if(tempX >=0 && tempX <N && tempY >=0 && tempY <N) {
							//방문하지 않았다면
							if(visited[tempX][tempY] == 0) {
								visited[tempX][tempY] = 1;
								
								if(space[tempX][tempY] <= shark.l) {
									q.add(new Point(tempX, tempY));
									
									if(space[tempX][tempY] != 0 && space[tempX][tempY] != 9) {
										//먹을 물고기 발견!, 가는데 몇 초 걸리는지도 업뎃 필요
										if(space[tempX][tempY] < shark.l) {
											flag = 1;
											fish.add(new Point(tempX, tempY));
										}
									}
								}
								//물고기 크기가 크지 않다면
								//크다면, 방문만 하고 큐에 추가 x
								//같다면, 방문하고 큐에 추가
								//작다면, 방문하고 큐에 추가하지 말기, 먹을 물고기에 추가
							}
						}
						
						
					}
					
					
				}
				
//				System.out.println("하나 끝, 큐 상태는");
//				
//				for(Point p : q) {
//					System.out.println(p.x + " " + p.y);
//				}
				
				
				//물고기 발견
				if(flag == 1) {
					//System.out.println("가는데 " + count+ "초 걸림!!");
					
					Point pp = fish.poll();
					
					//System.out.println("물고기 " + pp.x + " " + pp.y + " 여깄는거 먹음!!");
					
					//물고기 먹었으면, 걸린 시간 업데이트, 상어 위치 업데이트, 물고기 상황, 상어 크기 업데이트
					totalCount += count;
					
					space[shark.x][shark.y] = 0;
					
					shark.x = pp.x;
					shark.y = pp.y;
					
					//System.out.println(shark.x + " " + shark.y + "를 " + pp.x + " " + pp.y + "에 넣음");
					
					space[shark.x][shark.y] = 9;
					
					shark.fish += 1;
					
					//System.out.println("상어의 크기는 " + shark.l + " , 이번에 먹어서 " + shark.fish);
					if(shark.fish == shark.l) {
						//System.out.println("상어 크기 1 증가!!");
						shark.l += 1;
						shark.fish = 0;
					}
					
					
//					for (Point p : fish) {
//						System.out.println("물고기는 " + p.x + " " + p.y + "있음");
//					}
					
					q.clear();
					fish.clear();
					
					break;
				}
			}
			
			
			
//			System.out.println("현재 배열 상태::");
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(space[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			
			//끝나고 나왔는데 먹을 물고기 발견 못함
			if(flag == 0) {
				//엄마 상어에게 도움 요청
				System.out.println(totalCount);
				break;
			}
		}
		
	}
}