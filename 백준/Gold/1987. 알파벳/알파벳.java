import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int R, C;
	static char[][] board;
	static int maxDepth = -1;
	static HashMap<Character, Integer> hm;
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 말이 지나가는 부분의 알파벳을 hashmap으로 넣는다.
		 * 2. bfs를 돌리면서 hashmap에 존재하는 알파벳이라면 중지.
		 * 3. 범위를 벗어나기 전까지 말이 갈 수 있는 최대한의 depth를 구한다!
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		//보드 입력
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		//Char이 아니다!!
		hm = new HashMap<Character, Integer>();
		
		hm.put(board[0][0], 1);
		
		dfs(0,0, 1);
		
//		Queue<Point> q = new LinkedList<Point>();
//		q.add(new Point(0,0));
//		
//		int depth = 0;
//		
//		//(0,0)에서 bfs 실행
//		while(!q.isEmpty()) {
//			int qSize = q.size();
//			//System.out.println("큐 사이즈는" + qSize);
//			for (int i = 0; i < qSize; i++) {
//				Point tempP = q.poll();
//				
//				for (int j = 0; j < 4; j++) {
//					int tempX = tempP.x + dx[j];
//					int tempY = tempP.y + dy[j];
//					
//					if(tempX >= 0 && tempX <R && tempY >=0 && tempY <C) {
//						//해쉬맵에 포함되어 있지 않는가??
//						//System.out.println(tempX + " " + tempY + " " + board[tempX][tempY] + "검사");
//						//System.out.println(hm);
//						
//						if(!hm.containsKey(board[tempX][tempY])) {
//							//System.out.println("새로운 대문자요!!!!");
//							hm.put(board[tempX][tempY], 1);
//							q.add(new Point(tempX, tempY));
//						}
//					}
//				}
//			}
//			
//			depth++;
//		}
//		
//		
		System.out.println(maxDepth);
		
	}
	
	static void dfs(int x, int y, int depth) {
		//System.out.println(x + " " + y + " " + depth + " 최대는" + maxDepth);
		maxDepth = Math.max(maxDepth, depth);
		
		for (int j = 0; j < 4; j++) {
			int tempX = x + dx[j];
			int tempY = y + dy[j];
			
			if(tempX >= 0 && tempX <R && tempY >=0 && tempY <C) {
				//해쉬맵에 포함되어 있지 않는가??
				//System.out.println(tempX + " " + tempY + " " + board[tempX][tempY] + "검사");
				//System.out.println(hm);
				
				if(!hm.containsKey(board[tempX][tempY])) {
					//System.out.println("새로운 대문자요!!!!");
					hm.put(board[tempX][tempY], 1);
					//System.out.println("들어감!!!");
					dfs(tempX, tempY, depth+1);
					//System.out.println("돌아옴");
					hm.remove(board[tempX][tempY]);
				}
			}
		}
		
		
		
	}
}