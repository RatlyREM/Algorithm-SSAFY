import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
	static Queue<Point> q;
	static Queue<Point> wq;
	static int R,C;
	
	static char[][] tddup;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] waterDepth;
	static int[][] GoDepth;
	
	static int[][] visitedW;
	static int[][] visitedG;
	
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. queue에 현재 S 위치 삽입
		 * 2. 이번 턴에 흐를 물 위치 업데이트
		 * 		-> BFS로. 방문하지 않은 물 위치 *로 업데이트(D나 X일 경우에 업데이트 불가능)
		 * 3. 업데이트한 물 위치, 돌 위치 확인하면서 queue에서 빼서 상하좌우 가능한 자리 찾고, queue에
		 * 삽입
		 * 		-> 만약 queue가 비었는데 이전에 뺐던게 D라면, 몇분 걸렸는지 파악하고 종료
		 * 		-> 만약 queue가 비었는데 이전에 뺐던게 D가 아니라면, KAKTUS
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		tddup = new char[R][C];
		q = new LinkedList<Point>();
		wq = new LinkedList<Point>();
		waterDepth = new int[R][C];
		GoDepth = new int[R][C];
		
		visitedW = new int[R][C];
		visitedG = new int[R][C];
		
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < s.length(); j++) {
				tddup[i][j] = s.charAt(j);
				if(tddup[i][j] == '*') {
					visitedW[i][j] = 1;
					wq.add(new Point(i,j));
				}
				else if(tddup[i][j] == 'S') {
					visitedG[i][j] = 1;
					q.add(new Point(i,j));
				}
			}
			
		}
		
		waterBFS();
	}
	
	static void waterBFS() {
		int minute =0;
		
		while(true) {
			int waterSize = wq.size();
			int goSize = q.size();
			
			if(q.isEmpty()) {
				System.out.println("KAKTUS");
				break;
			}
			
			for (int a = 0; a < waterSize; a++) {
				Point tp = wq.poll();
				
				for (int i = 0; i < 4; i++) {
					int tempX = tp.x+ dx[i];
					int tempY = tp.y+ dy[i];
					
					if(tempX>=0 && tempX <R && tempY >=0 && tempY <C) {
						if(visitedW[tempX][tempY] == 0) {
							if(tddup[tempX][tempY] != 'X' && tddup[tempX][tempY] != 'D') {
								visitedW[tempX][tempY] = 1;
								tddup[tempX][tempY] = '*';
								wq.add(new Point(tempX, tempY));
								waterDepth[tempX][tempY] = waterDepth[tp.x][tp.y]+1;
							}
						}
					}
				}
			}
			
			for (int a = 0; a < goSize; a++) {
				Point tp2 = q.poll();
				
				if(tddup[tp2.x][tp2.y] == 'D') {
					System.out.println(minute);
					System.exit(0);
				}
				
				for (int i = 0; i < 4; i++) {
					int tempX = tp2.x+ dx[i];
					int tempY = tp2.y+ dy[i];
					
					if(tempX>=0 && tempX <R && tempY >=0 && tempY <C) {
						if(visitedG[tempX][tempY] == 0) {
							if(tddup[tempX][tempY] != 'X' && tddup[tempX][tempY] != '*') {
								visitedG[tempX][tempY] = 1;
								q.add(new Point(tempX, tempY));
								
								//System.out.println(tempX + " " + tempY + "들어가면서, " + (GoDepth[tp2.x][tp2.y]+1) + "깊이 업뎃");
								GoDepth[tempX][tempY] = GoDepth[tp2.x][tp2.y]+1;
							}
						}
					}
				}
			}
			
			
			minute++;
			
		}
//		
//		int cDepth = 0;
//		int nDepth = 0;
//		
//		while(!wq.isEmpty()) {
//			Point tp = wq.poll();
//			
//			if(waterDepth[tp.x][tp.y] > cDepth) {
//				
//				//한 depth 끝남!!
//				
////				System.out.println("물난리.");
////				for (int i = 0; i < R; i++) {
////					for (int j = 0; j < C; j++) {
////						System.out.print(tddup[i][j] + " ");
////					}
////					System.out.println();
////				}
////				
////				System.out.println();
//				
//				
//				while(true) {
//					if(q.isEmpty()) {
//						System.out.println("KAKTUS");
//						System.exit(0);
//						
//					}
//					Point tp2 = q.poll();
//					
//					
////					System.out.println(tp2.x + " " + tp2.y);
////					System.out.println();
//					
//					if(tddup[tp2.x][tp2.y] == 'D') {
//						System.out.println(nDepth);
//						System.exit(0);
//					}
//					
//					if(GoDepth[tp2.x][tp2.y] > nDepth) {
//						q.add(tp2);
////						for (Point p: q) {
////							System.out.print(p.x + " " + p.y + "안녕!!");
////						}
////						System.out.println("빠져나감!!");
//						nDepth++;
//						break;
//					}
//					
//					for (int i = 0; i < 4; i++) {
//						int tempX = tp2.x+ dx[i];
//						int tempY = tp2.y+ dy[i];
//						
//						if(tempX>=0 && tempX <R && tempY >=0 && tempY <C) {
//							if(visitedG[tempX][tempY] == 0) {
//								if(tddup[tempX][tempY] != 'X' && tddup[tempX][tempY] != '*') {
//									visitedG[tempX][tempY] = 1;
//									q.add(new Point(tempX, tempY));
//									
//									//System.out.println(tempX + " " + tempY + "들어가면서, " + (GoDepth[tp2.x][tp2.y]+1) + "깊이 업뎃");
//									GoDepth[tempX][tempY] = GoDepth[tp2.x][tp2.y]+1;
//								}
//							}
//						}
//					}
//				}	
//				
//				
////				goBFS();
////				
//				
//				cDepth++;
//			}
//			
//			
//			for (int i = 0; i < 4; i++) {
//				int tempX = tp.x+ dx[i];
//				int tempY = tp.y+ dy[i];
//				
//				if(tempX>=0 && tempX <R && tempY >=0 && tempY <C) {
//					if(visitedW[tempX][tempY] == 0) {
//						if(tddup[tempX][tempY] != 'X' && tddup[tempX][tempY] != 'D') {
//							visitedW[tempX][tempY] = 1;
//							tddup[tempX][tempY] = '*';
//							wq.add(new Point(tempX, tempY));
//							waterDepth[tempX][tempY] = waterDepth[tp.x][tp.y]+1;
//						}
//					}
//				}
//			}
//		}
	}
	
	static void goBFS() {
		int cDepth = 0;
		
		while(!q.isEmpty()) {
			Point tp = q.poll();
			
			if(GoDepth[tp.x][tp.y] > cDepth) {
				cDepth++;
			}
			
			if(tddup[tp.x][tp.y] == 'D') {
				System.out.println(cDepth);
				System.exit(0);
			}
			
			for (int i = 0; i < 4; i++) {
				int tempX = tp.x+ dx[i];
				int tempY = tp.y+ dy[i];
				
				if(tempX>=0 && tempX <R && tempY >=0 && tempY <C) {
					if(visitedG[tempX][tempY] == 0) {
						if(tddup[tempX][tempY] != 'X' && tddup[tempX][tempY] != '*') {
							visitedG[tempX][tempY] = 1;
							q.add(new Point(tempX, tempY));
							GoDepth[tempX][tempY] = GoDepth[tp.x][tp.y]+1;
						}
					}
				}
			}
		}
	}
	
}
