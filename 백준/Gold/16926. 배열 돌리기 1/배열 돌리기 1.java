import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int[] dx = {0, 1, 0,-1};
		int[] dy = {-1,0,1, 0};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		
		//배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
 			}
			
		}
		
		for(int k=0; k<R; k++) {
			int[][] newBoard = new int[N][M];
			
			//안으로 파고들어가기
			for (int i = 0; i < Math.min(N, M) /2; i++) {
				//1. 왼쪽으로
				for (int j = 0; j < M- 2*i-1; j++) {
					newBoard[i][i+j] = board[i][1+i+j];
				}
				
				//2. 위로
				for (int j = 0; j < N- 2*i-1; j++) {
					newBoard[i+j][(M-1)-i] = board[1+i+j][(M-1)-i];
				}
				
				//3. 오른쪽으로
				for (int j = 0; j < M- 2*i-1; j++) {
					newBoard[(N-1)-i][i+j+1] = board[(N-1)-i][i+j];
				}
				
				//3. 아래로
				for (int j = 0; j < N- 2*i-1; j++) {
					newBoard[i+j+1][i] = board[i+j][i];
				}

			}
			
			board = newBoard;
		
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			
			System.out.println();
		}
		
			
		
		
	}
}
