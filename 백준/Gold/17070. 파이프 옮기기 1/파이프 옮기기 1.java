import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int total = 0;
	static int N;
	static int[][] room;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 그 방향 그대로 밀기.
		 * (가로는 +0,+1 세로는 +1,+0 대각선은 +1,+1)
		 * 
		 * 2. 회전
		 * (가로는 
		 * 
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