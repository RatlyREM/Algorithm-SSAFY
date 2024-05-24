package PS240430;

import java.io.*;
import java.util.*;

public class BJ_14503 {
	//반시계 방향 왼쪽부터 살펴보기
	static int[] dx = {-1,0, 1,0};
	static int[] dy = {0,1,0, -1};
	
	public static class Robot {
		int x;
		int y;
		int dir;
		
		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * 문제 이해
		 * 방은 빈칸이나 벽.
		 * 청소기 방향은 동서남북.
		 * 
		 * 1. 현재 칸 청소 X -> 청소.
		 * 2. 주변에 청소되지 않은 칸이 없다면 -> 
		 * 		후진 가능하다면 한 칸 후진.
		 * 		후진이 불가능(벽) -> 작동 멈춤.
		 * 
		 * 3. 청소되지 않은 칸이 있다면,
		 * 		반시계 방향으로 90도 회전 후 해당 칸이 청소되지 않았다면 그쪽으로 전진 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//방 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cleanCount = 0;
		
		//청소기 위치, 방향
		st = new StringTokenizer(br.readLine());
		
		//로봇 위치
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int[][] room = new int[N][M];
		
		//방 상태 입력
		//0이면 청소되지 않은 빈칸, 1이면 벽. 2면 청소 완료된 빈칸
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//청소 시작
		while(true) {
			//현재 칸이 청소되지 않았다면
			if(room[robot.x][robot.y] == 0) {
				//청소
				room[robot.x][robot.y] = 2;
				cleanCount++;
			}
			
			//주변 상태 확인(청소되지 않은 빈 칸 찾기(0))
			int cleanFlag = 0;
			//int cleanDir = -1;
			
			for (int i = 0; i < 4; i++) {
				//주변 범위 벗어나는지 확인 필요
				
				int tempX = robot.x + dx[i%4];
				int tempY = robot.y + dy[i%4];
				
				//범위 안에 들어간다면
				if(tempX >=0 && tempX <N && tempY >= 0 && tempY <M) {
					//청소되지 않은 빈 칸이 있다면?
					if(room[tempX][tempY] == 0) {
						cleanFlag = 1;

						//방향 90도 회전
						if(robot.dir == 0) robot.dir = 3;
						else robot.dir= robot.dir-1;
						
						break;
					}
				}
			}
			
			//주변에 청소되지 않은 빈칸이 없음
			if(cleanFlag == 0) {
				int tempDir = 0;
				
				if(robot.dir == 1 || robot.dir == 0) {
					tempDir = robot.dir +2;
				}
				else {
					tempDir = robot.dir -2;
				}
				
				//벽이 아니라면 후진
				if(room[robot.x + dx[tempDir]][robot.y + dy[tempDir]] != 1) {
					robot.x = robot.x + dx[tempDir];
					robot.y = robot.y + dy[tempDir];
				}//벽이라면
				else {
					//탈출
					break;
				}
				
			}
			else {
				//바라보는 방향 기준으로 앞쪽 칸이 청소되지 않았는지 확인
				
				if(room[robot.x + dx[robot.dir]][robot.y + dy[robot.dir]] == 0) {
					//로봇 위치 업데이트
					robot.x = robot.x + dx[robot.dir];
					robot.y = robot.y + dy[robot.dir];
				}
			}
		}
		
		
		System.out.println(cleanCount);
	}
}
