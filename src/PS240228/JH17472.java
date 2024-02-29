package PS240228;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JH17472 {
	static int[][] jido;
	static int[][] visited;
	static int[] dx = { -1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	static int islandNum = 2;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 0. 먼저 1을 찾았으면 순회를 돌면서 섬 영역을 확인하고 번호를 부여한다.
		 * 		그리고 배열을 순회하면서 0이 아닌 수를 만나면 상하좌우로 뻗는다.
		 * 		영역 밖으로 나가지 않고 다른 섬을 2 이상의 거리로 찾았으면, 그래프에 간선으로 추가한다.
		 * 		간선의 가중치는 계속 최솟값으로 업데이트되어야 한다.
		 * 
		 * 
		 * 
		 * 1. 먼저 섬의 개수만큼 정점의 개수를 설정한다.
		 * 2. 정점의 개수만큼 이차원배열을 만든다.
		 * 3. 각 섬마다 이어질 수 있는 간선들을 구한다.
		 * 		각 방향으로 모두 뻗어봤을 때, 2 이상의 거리로 다른 섬과 닿을 수 있다면 이어짐
		 * 
		 * 		각 섬의 위치를 순회하면서 상하좌우로 뻗어
		 * 	각 섬의 최소 x좌표, 최대 y좌표. 최대 x좌표, 최대 y좌표를 구해서 다른 섬의 범위가
		 *  내부에 속한다면 연결할 수 
		 * 
		 *  4. 그래프가 그려졌다면, MST를 구한다.
		 *  5. 크루스칼 알고리즘을 이용한다. MST를 구하고, 다리의 총 길이를 구한다.
		 *  6. MST가 모든 다리를 연결하고 있지 않다면, -1을 출력한다.
		 * 
		 * 
		 */	
		
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		jido = new int[N][M];
		visited = new int[N][M];
		
		int[][] bridge = new int[8][8];
		//Point[] edge = new Point[N*M+200]; 
		p = new int[8];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				jido[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {	
				if(jido[i][j] == 1) {
					DFS(i,j);
					
					islandNum++;
					
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < M; l++) {
							visited[k][l] = 0;
						}
					}
					
				}
			}
		}
		
		//섬을 돌아다니며 뻗기 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(jido[i][j] != 0) {
					//상하좌우로
					int tempX, tempY;
					
					for (int k = 0; k < 4; k++) {
						tempX = i+ dx[k];
						tempY = j+ dy[k];
						
						//다리로 이으려는 길이 범위 안이면서 바다라면
						if(tempX >=0 && tempX < N && tempY>=0 && tempY < M) {
							if(jido[tempX][tempY] == 0) {
								//System.out.println(tempX + " " + tempY + "방향으로 출발");
								//해당 방향으로 출발
								
								int bridgeCount = 1;
								
								while(true) {
									tempX += dx[k];
									tempY += dy[k];
									
									//System.out.println(tempX + " " + tempY + "방향으로 나아감");
									if(tempX >=0 && tempX < N && tempY>=0 && tempY < M) {
										if(jido[tempX][tempY] != 0) {
											//jido[tempX][tempY]가 도착 섬 번호, jido[i][j]가 섬 번호
											//System.out.println(tempX + " " + tempY + " " + bridgeCount + "이다!!");
											
											//System.out.println((jido[tempX][tempY]) + "에 도착, " + (jido[i][j]) + "에서 출발, 거리는 " +bridgeCount);
											
											
											int current = bridge[jido[i][j]][jido[tempX][tempY]];
											
											//System.out.println("c: " + current  + " " + bridgeCount);
											
											if(current == 0) {
												//최소값 검사 x
												if(bridgeCount > 1) {
													bridge[jido[i][j]][jido[tempX][tempY]] = bridgeCount;
												}
											}
											else {
												if(bridgeCount > 1 && bridgeCount < current) {
													bridge[jido[i][j]][jido[tempX][tempY]] = bridgeCount;
												}
											}
											break;
										}
										else {
											bridgeCount++;
										}
									}
									else {
										break;
									}	
								}	
							}	
						}
					}
				}
			}
		}
		
		int ganNum = 0;
		for (int i = 2; i < 8; i++) {
			for (int j = 2; j < 8; j++) {
				//System.out.print(bridge[i][j] + " ");
				if(bridge[i][j] != 0) {
					ganNum++;
				}
			}
			//System.out.println();
		}
		//System.out.println();
		
		//가장 가중치 작은 간선 하나씩 추가하면서 BFS 돌렸을 때, MST가 성립하면 그대로 끝
		//마지막까지 다 돌렸는데 정점을 다 못 돌았으면 -1 출력
		
		//graph에 간선 및 가중치 저장 완료
		int count = 0;
		
		//총 간선의 개수가 들어가야 함
		
		
		int[][] graph = new int[ganNum][3];
		//System.out.println("랜드넘:" + ganNum);
		
		for (int l = 2; l < 8; l++) {
			for (int m = l; m < 8; m++) {
				if(bridge[l][m] != 0) {
					//System.out.println("count: "  + count);
					
					graph[count][0] = l;
					graph[count][1] = m;
					graph[count][2] = bridge[l][m];
					count++;
				}
			}
		}
		
		
		Arrays.sort(graph, (o1,o2) -> Integer.compare(o1[2], o2[2]));
		
		
		makeSet();
		
//		for (int k = 0; k < graph.length; k++) {
//			for (int m = 0; m < graph[k].length; m++) {
//				System.out.print(graph[k][m] + " ");
//			}
//			System.out.println();
//		}
		
		int cost = Kruskal(graph);
		
		//MST가 아닌 경우 -1
		for (int i = 2; i < 8; i++) {
			//System.out.print(p[i] + " ");
			p[i] = find(i);
		}
		//System.out.println();
		
//		for (int i = 2; i < islandNum; i++) {
//			System.out.print(p[i] + " ");
//			//p[i] = find(i);
//		}
//		System.out.println();
		
		//System.out.println(islandNum);
		
		int comPar = p[2];
		for (int i = 2; i < islandNum; i++) {
			if(p[i] != comPar) cost = -1;
		}
		
		System.out.println(cost);
		
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(jido[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
	}
	
	private static int Kruskal(int[][] graph) {
		int cost = 0;
		for (int i = 0; i < graph.length; i++) {
			//System.out.println(find(graph[i][0]) + " " + find(graph[i][1]));
			
			if(find(graph[i][0]) != find(graph[i][1])) {
				cost += graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}

		return cost;
	}
	
	
	private static void DFS(int a, int b) {
		int tempX, tempY;
		visited[a][b] = 1;
		jido[a][b] = islandNum;
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(jido[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < 4; i++) {
			tempX = a+ dx[i];
			tempY = b+ dy[i];
			
			//System.out.println("tempx,y: " + tempX + " " + tempY);
			if(tempX >=0 && tempX < N && tempY>=0 && tempY < M) {
				if(jido[tempX][tempY] != 0 && visited[tempX][tempY] == 0) {
					//jido[tempX][tempY] = islandNum;
					//visited[tempX][tempY] = 1;
					DFS(tempX, tempY);
				}
			}
			
		}
	}
	
	//부모노드에 자기 자신 초기 세팅
	static void makeSet() {
		for(int i = 0; i < p.length; i++) p[i] = i;
	}
	
	static int find(int a) {
		//System.out.println("a: " + a);
		if(a == p[a]) return a;
		return find(p[a]);
	}
	static boolean union(int a, int b) {
		if(find(a) == find(b)) return false;
		p[find(b)] = find(a);
		return true;
	}
}





