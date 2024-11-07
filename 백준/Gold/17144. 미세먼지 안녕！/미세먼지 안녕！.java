import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] home = new int[R][C];
		List<Point> purifier = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < C; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
				if(home[i][j] == -1) purifier.add(new Point(i,j));
			}
		}
		
		//시간초
		for (int i = 0; i < T; i++) {
			//1. 확산
			//각각의 미세먼지에 대해 확산이 필요
			
			int[][] realHome = new int[R][C];
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					realHome[j][k] = home[j][k];
				}
			}
			
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					int validCount = 0;
					
					if(home[j][k] >= 5) {
						//확산 시작
						//공청기와 행이 똑같거나 유효하지 않은 범위면 out
						
						for (int l = 0; l < 4; l++) {
							int tempX = j+dx[l];
							int tempY = k+dy[l];
							
							if(tempX >=0 && tempX < R && tempY >=0 && tempY <C) {
								if(home[tempX][tempY] == -1) continue;
								//그냥 공청기 있는 칸은 확산이 안 됨
								
								realHome[tempX][tempY] += home[j][k]/5;
								validCount++;
								
								
//								if(l== 0) {
//									if(tempY != 0 || (tempY == 0 && tempX < purifier.get(0).x)) {
//										realHome[tempX][tempY] += home[j][k]/5;
//										validCount++;
//									}
//								}
//								else if(l==1) {
//									realHome[tempX][tempY] += home[j][k]/5;
//									validCount++;
//								}
//								else if(l==2) {
//									if(tempY != 0 || (tempY == 0 && tempX > purifier.get(1).x)) {
//										realHome[tempX][tempY] += home[j][k]/5;
//										validCount++;
//									}
//								}
//								else {
//									if(purifier.get(0).x != tempX && purifier.get(1).x != tempX) {
//										realHome[tempX][tempY] += home[j][k]/5;
//										validCount++;
//									}
//								}
							}
						}
					}
					
					realHome[j][k] -= (home[j][k]/5) * validCount;
				}
			}
			
			//다 끝냈으면 배열 덮어씌우기
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					home[j][k] = realHome[j][k];
				}
			}
			
//			System.out.println("확산 완료!!!");
//			for (int j = 0; j < R; j++) {
//				for (int k = 0; k < C; k++) {
//					System.out.print(home[j][k] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			
			//2. 공기청정기 작동
			//위쪽 공기청정
			//아래로
			Point up = purifier.get(0);
			
			for (int j = up.x; j > 0; j--) {
				home[j][0] = home[j-1][0];
			}
			
			//왼쪽으로
			for (int j = 0; j < C-1; j++) {
				home[0][j] = home[0][j+1];
			}
			
			//위쪽으로
			for (int j = 0; j < up.x; j++) {
				home[j][C-1] = home[j+1][C-1];
			}
			
			//오른쪽으로
			for (int j = C-1; j > 1; j--) {
				home[up.x][j] = home[up.x][j-1];
			}
			home[up.x][1] = 0;
			
			
			
			
			//아래쪽 공기청정
			Point down = purifier.get(1);
			
			//위쪽으로
			for (int j = down.x; j < R-1; j++) {
				home[j][0] = home[j+1][0];
			}
			
			//왼쪽으로
			for (int j = 0; j < C-1; j++) {
				home[R-1][j] = home[R-1][j+1];
			}
			
			//아래쪽으로
			for (int j = R-1; j >= down.x+1; j--) {
				home[j][C-1] = home[j-1][C-1];
			}
			
			//오른쪽으로
			for (int j = C-1; j > 1; j--) {
				home[down.x][j] = home[down.x][j-1];
			}
			home[down.x][1] = 0;
			
			
			//-1 복구해야함!
			home[up.x][up.y] = -1;
			home[down.x][down.y] = -1;
			
//			System.out.println("공청기 완료!!!");
//			for (int j = 0; j < R; j++) {
//				for (int k = 0; k < C; k++) {
//					System.out.print(home[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			//System.out.println();
		}
		
		int total = 0;
		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				//System.out.print(home[j][k] + " ");
				if(home[j][k] > 0) total+= home[j][k];
			}
			//System.out.println();
		}
		
		System.out.println(total);
	}
}