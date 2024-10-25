import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<Point> curVirusList;
	static List<Point> virusList;
	static int[][] visited;
	static int[][] lab;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int minValue = Integer.MAX_VALUE;
	
	static int M,N;

	public static void main(String[] args) throws IOException {
		/*
		 * 50*50 50개 중에서 10개 조합
		 * 1. 바이러스를 퍼뜨릴 칸 M개를 조합으로 고른다.
		 * 2. 해당 지역에서 BFS를 통해 퍼뜨린다.
		 * 3. 1초마다 모든 지역이 퍼진 상황인지 표시한다.
		 * 4. 만약 모든 상황이 끝났는데 다 퍼지지 못했다면 -1 출력.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		virusList = new ArrayList<>();
		curVirusList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				
				if(lab[i][j] == 1) lab[i][j] = -1;
				else if(lab[i][j] == 2) {
					lab[i][j] = 0;
					virusList.add(new Point(i,j));
				}
			}
		}
		
		//System.out.println(virusList.toString());
		
		//조합
		selectVirus(0,0);
		
		if(minValue == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minValue);
		}
	}
	
	//now는 개수, 현재 위치는?
	static void selectVirus(int cur, int now) {
		//다 채워졌으면
		if(now == M) {
			//System.out.println(curVirusList.toString());
			
			int[][] tempLab = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					tempLab[j][j2] = lab[j][j2];
				}
				//System.out.println();
			}
			
			
//			System.out.println("\n\ntempLab 시작!");
//			for (int j = 0; j < N; j++) {
//				for (int j2 = 0; j2 < N; j2++) {
//					System.out.print(tempLab[j][j2] + " ");
//				}
//				System.out.println();
//			}

			//각 지점에서 BFS 후 최솟값
			for (int i = 0; i < curVirusList.size(); i++) {
				
				
				//해당 지점을 시작으로 BFS를 돌림
				Queue<Point> qu = new LinkedList<>();
				visited = new int[N][N];
				
				qu.add(curVirusList.get(i));
				visited[curVirusList.get(i).x][curVirusList.get(i).y] = 1;
				
				
				
//				System.out.println("\n\nBFS 하나 시작!!");
//				for (int j = 0; j < N; j++) {
//					for (int j2 = 0; j2 < N; j2++) {
//						System.out.print(tempLab[j][j2] + " ");
//					}
//					System.out.println();
//				}
				
				int depth = 1;
				
				while(!qu.isEmpty()) {
					int qSize = qu.size();
					
					for (int k = 0; k < qSize; k++) {
						Point temp = qu.poll();
						
						for (int j = 0; j < 4; j++) {
							int tempX = temp.x + dx[j];
							int tempY = temp.y + dy[j];
							
							
							if(tempX >=0 && tempX < N && tempY >= 0 && tempY < N) {
								
								if(visited[tempX][tempY] == 0) {
									//System.out.println(tempX + " " + tempY + " 방문!!!");
									
									if(tempLab[tempX][tempY] == 0 || (tempLab[tempX][tempY] > depth)) {
										tempLab[tempX][tempY] = depth;
									}

									visited[tempX][tempY] = 1;
									
									if(tempLab[tempX][tempY] != -1) {
										qu.add(new Point(tempX, tempY));
									}
									
								}
							}
						}
						
						
					}
					
					
					depth++;
				}
				
	
				
				for (int a = 0; a < curVirusList.size(); a++) {
					tempLab[curVirusList.get(a).x][curVirusList.get(a).y] = 0;
				}
//				System.out.println("\n\nBFS 하나 끝!!");
//				for (int j = 0; j < N; j++) {
//					for (int j2 = 0; j2 < N; j2++) {
//						
//						System.out.print(tempLab[j][j2] + "  ");
//					}
//					System.out.println();
//				}
			}
			
			int end = isEnded(tempLab);
			
			//System.out.println("이번 최솟값은, " + end);
			if(end != -1) minValue = Math.min(minValue, end);
			
			return;
		}
		
		for (int i = cur; i < virusList.size(); i++) {
				curVirusList.add(virusList.get(i));
				selectVirus(i+1, now+1);				
				curVirusList.remove(curVirusList.size()-1);
		}
	}
	
	static int isEnded(int[][] tempLab) {
		int flag = 0;
		int maxValue = -1;
		
		//다 찼는지 확인, 0인 부분은 바이러스 시작지점인지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tempLab[i][j] == -1) continue;
				
				maxValue = Math.max(maxValue, tempLab[i][j]);
				if(tempLab[i][j] != 0) continue;
				
				//0인데 시작지점인가?
				for (int j2 = 0; j2 < curVirusList.size(); j2++) {
					if(curVirusList.get(j2).x == i && curVirusList.get(j2).y == j) {
						flag = 1;
						break;
					}
				}
				
				if(flag == 0) return -1;
				flag = 0;
			}
		}
		
		return maxValue;
	}
}