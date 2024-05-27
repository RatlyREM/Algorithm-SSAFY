import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int total = 0;
	static int N;
	static int[][] room;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 현재 파이프가 가로,세로,대각선일 때를 각각 파라미터로 받아서,
		 * 파라미터의 값에 따라 비어있는지 체크할 부분을 달리하면 된다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				//1이면 벽
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Point pipe = new Point(0,1);
		
		goPipe(pipe, 0);
		

		System.out.println(total);
	}
	
	
	static void goPipe(Point pipe, int x) {
		if(pipe.x== (N-1) && pipe.y== (N-1)) {
			total++;
			return;
		}
		
		switch (x) {
		case 0: //가로
			if(pipe.y +1 <N) {
				if(room[pipe.x][pipe.y+1] == 0) {
					//그냥 가로로 밀기.
					goPipe(new Point(pipe.x, pipe.y+1), 0);
				}
			}
			
			if(pipe.y+1 <N && pipe.x+1 < N) {
				if(room[pipe.x][pipe.y+1] == 0 && room[pipe.x+1][pipe.y] == 0 && room[pipe.x+1][pipe.y+1] == 0) {
					goPipe(new Point(pipe.x+1, pipe.y+1), 2);
				}
			}
			break;
		case 1: //세로
			if(pipe.x +1 <N) {
				if(room[pipe.x+1][pipe.y] == 0) {
					goPipe(new Point(pipe.x+1, pipe.y), 1);
				}
			}
			if(pipe.y+1 <N && pipe.x+1 < N) {
				if(room[pipe.x][pipe.y+1] == 0 && room[pipe.x+1][pipe.y] == 0 && room[pipe.x+1][pipe.y+1] == 0) {
					goPipe(new Point(pipe.x+1, pipe.y+1), 2);
				}
			}
			break;
		case 2: //대각선
			if(pipe.x +1 <N) {
				if(room[pipe.x+1][pipe.y] == 0) {
					goPipe(new Point(pipe.x+1, pipe.y), 1);
				}
			}
			
			if(pipe.y +1 <N) {
				if(room[pipe.x][pipe.y+1] == 0) {
					goPipe(new Point(pipe.x, pipe.y+1), 0);
				}
			}
			
			if(pipe.y+1 <N && pipe.x+1 < N) {
				if(room[pipe.x][pipe.y+1] == 0 && room[pipe.x+1][pipe.y] == 0 && room[pipe.x+1][pipe.y+1] == 0) {
					goPipe(new Point(pipe.x+1, pipe.y+1), 2);
				}
			}
			
			
			break;
		}
		
		
	}

	
}