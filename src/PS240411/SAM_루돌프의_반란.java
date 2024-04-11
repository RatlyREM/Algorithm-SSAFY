package PS240411;

import java.io.*;
import java.util.*;
import java.awt.*;

public class SAM_루돌프의_반란 {
	static Point[] santa;
	static int[] santaScore;
	static Point deer;
	static int P;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] sdx = {-1,0,1,0};
	static int[] sdy = {0,1,0,-1};
	
	static int N;
	static int[] outSanta;
	static int[] stunSanta;
	static int[][] game;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //판 크기
		int M = Integer.parseInt(st.nextToken()); //턴 수
		P = Integer.parseInt(st.nextToken()); //산타 수
		int C = Integer.parseInt(st.nextToken()); //루돌프의 힘
		int D = Integer.parseInt(st.nextToken()); //산타의 힘
		
		game = new int[N+1][N+1];
		santa = new Point[P+1]; //산타의 위치
		santaScore = new int[P+1];
		outSanta = new int[P+1];
		stunSanta = new int[P+1];
		
		
		st = new StringTokenizer(br.readLine());
		
		int rx= Integer.parseInt(st.nextToken());
		int ry= Integer.parseInt(st.nextToken());
		
		//현 루돌프 위치 업데이트
		deer = new Point(rx, ry);
				
		//루돌프 초기위치 지정
		game[rx][ry] = -1;
		
		//산타 위치 입력
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sanNum = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			//산타 위치 업데이트
			santa[sanNum] = new Point(sx,sy);
			
			game[sx][sy] = sanNum;
		}
		
		
		//게임 개시
		for (int i = 0; i < M; i++) {
			//루돌프의 이동
			//가장 가까운 산타에게로, 우선 산타 거리를 잼
			int nSanta = nearSanta();
			
			//상하좌대각선 중 어느 방향으로 가야 그 산타와 가까워지는가?
			int direction = goDeer(nSanta);
			
			//충돌했다면
			if(game[deer.x + dx[direction]][deer.y+ dy[direction]] != 0) {
				//밀려나는 산타 적용 필요
				//점수 획득
				santaScore[nSanta] += C;
				
				//밀려난 산타가 떨어질 위치는?
				int pushX = santa[nSanta].x + dx[direction]*C;
				int pushY = santa[nSanta].y + dy[direction]*C;
				
				//산타 위치 업데이트
				santa[nSanta].x = pushX;
				santa[nSanta].y = pushY;
				
				if(pushX <= 0 || pushX >N || pushY <= 0 || pushY >N) {
					//탈락
					outSanta[nSanta] = 1;
				}
				else {
					//기절
					
					if(game[pushX][pushY] != 0) {
						int tx = pushX + dx[direction];
						int ty = pushY + dy[direction];
						int tempSanta = game[pushX][pushY];
						
						while(true) {
							if(tx <= 0 || tx >N || ty <= 0 || ty >N) {
								//이전 산타 탈락

								outSanta[tempSanta] = 1;
								break;
							}
							else {
								if(game[tx][ty] == 0) {
									game[tx][ty] = tempSanta;
									
									santa[tempSanta].x = tx;
									santa[tempSanta].y = ty;
									break;
								}
								else {
									santa[tempSanta].x = tx;
									santa[tempSanta].y = ty;
									
									int t = tempSanta;
						
									tempSanta = game[tx][ty];
									game[tx][ty] = t;
								}	
							}
							
							tx += dx[direction];
							ty += dy[direction];
							
						}	
					}

					stunSanta[nSanta]= 2;//2턴 후부터 복귀
					game[pushX][pushY] =nSanta;
				}
			}
			
			//루돌프 위치 업데이트 필요
			
			game[deer.x][deer.y] = 0;
			
			deer.x +=  dx[direction];
			deer.y +=  dy[direction];
			
			
			game[deer.x][deer.y] = -1;
			
			
			//산타의 이동
			
			for (int j = 1; j <= P; j++) {
				if(outSanta[j] == 0 && stunSanta[j] != 0) {
					stunSanta[j]--;
					continue;
				}
				else if(outSanta[j] == 0) {
					int sDirection = goSanta(j);
					
					if(sDirection== -1) continue;
					else {
						//이동한 산타 위치 업데이트 해줘야함!!
						game[santa[j].x][santa[j].y] = 0;
						
						santa[j].x += sdx[sDirection];
						santa[j].y += sdy[sDirection];
					}
					
					if(game[santa[j].x][santa[j].y] == -1) {
						santaScore[j] += D;
						
						//밀려난 산타가 떨어질 위치는?
						int push2X = santa[j].x - sdx[sDirection]*D;
						int push2Y = santa[j].y - sdy[sDirection]*D;

						if(push2X <= 0 || push2X >N || push2Y <= 0 || push2Y >N) {
							//탈락
							outSanta[j] = 1;
						}
						else {
							//기절
							if(game[push2X][push2Y] != 0) {
								int stx = push2X - sdx[sDirection];
								int sty = push2Y - sdy[sDirection];
								int stempSanta = game[push2X][push2Y];
								
								
								while(true) {
									if(stx <= 0 || stx >N || sty <= 0 || sty >N) {
										//이전 산타 탈락
										outSanta[stempSanta] = 1;
										break;
									}
									else {
										if(game[stx][sty] == 0) {
											game[stx][sty] = stempSanta;
											
											santa[stempSanta].x = stx;
											santa[stempSanta].y = sty;
											break;
										}
										else {
											santa[stempSanta].x = stx;
											santa[stempSanta].y = sty;
											
											int t = stempSanta;
								
											stempSanta = game[stx][sty];
											game[stx][sty] = t;
										}
									}
									
									stx -= sdx[sDirection];
									sty -= sdy[sDirection];
									
								}
								
							}
							santa[j].x = push2X;
							santa[j].y = push2Y;
							
							stunSanta[j]= 1;//2턴 후부터 복귀
							game[push2X][push2Y] =j;
						}
					} else {
						game[santa[j].x][santa[j].y] = j;
						
					}
				}
				
			}
			
			int total = 0;
			
			for (int k = 1; k <= P; k++) {
				total += outSanta[k];
				
				if(outSanta[k] == 0) {
					santaScore[k]++;
				}
			}
			
			if(total == P) break;
		}
		
		for (int j = 1; j <= P; j++) {
			System.out.print(santaScore[j] + " ");
		}
		
		
	}
	
	static int goSanta(int s) {
		//산타 돌진시키는 함수
		//우선 어느 방향이 맞을지 정하기!
		int minDir = -1; 
		int minDis = (int) (Math.pow((santa[s].x - deer.x), 2) + Math.pow((santa[s].y - deer.y), 2));
				
		for (int i = 0; i < 4; i++) {
			int tempX = santa[s].x + sdx[i];
			int tempY = santa[s].y + sdy[i];
					
			if(tempX >= 1 && tempX < (N+1) && tempY >=1 && tempY <(N+1)) {
				if(game[tempX][tempY] != 0 && game[tempX][tempY] != -1) {
					continue;
				}
				
				int temp = (int) (Math.pow((tempX - deer.x), 2) + Math.pow((tempY - deer.y), 2));
						
				if(temp < minDis) {
					minDis = temp;
					minDir = i;
				}
			}
		}
				
		return minDir;
	}
	
	static int goDeer(int s) {
		//루돌프 돌진시키는 함수
		//우선 어느 방향이 맞을지 정하기!
		int minDir = -1; 
		int minDis = 2000000;
		
		for (int i = 0; i < 8; i++) {
			int tempX = deer.x + dx[i];
			int tempY = deer.y + dy[i];
		
			if(tempX >= 1 && tempX < (N+1) && tempY >=1 && tempY <(N+1)) {
				int temp = (int) (Math.pow((tempX - santa[s].x), 2) + Math.pow((tempY - santa[s].y), 2));
				
				if(temp < minDis) {
					minDis = temp;
					minDir = i;
				}
			}
		}
		
		return minDir;
	}
	
	static int nearSanta() {
		int minSanta = -1;
		int minFar = 2000000;
		
		for (int i = 1; i <= P; i++) {
			//게임에서 탈락한 산타는 제외!!!
			if(outSanta[i] == 1) continue;
			
			//각 산타에서부터 거리 구하기
			int temp = (int) (Math.pow((santa[i].x - deer.x), 2) + Math.pow((santa[i].y - deer.y), 2));
		
			if(temp < minFar) {
				minFar = temp;
				minSanta = i;
			}
			else if(temp == minFar) {
				if(santa[i].x > santa[minSanta].x) {
					minSanta = i;
				}
				else if(santa[i].x == santa[minSanta].x) {
					if(santa[i].y > santa[minSanta].y) {
						minSanta = i;
					}
				}
			}
		}
		
		return minSanta;
	}
}