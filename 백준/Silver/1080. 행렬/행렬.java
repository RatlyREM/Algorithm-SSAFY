import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	/*
	 * 쭉 3x3씩 바꾸면서 가면, 
	 * 
	 * 같은 행에서 진행할 때마다
	 * 3x3의 맨 왼쪽 위 부분이 확정. 마지막에는 맨 윗줄 마지막 두개도 확정.
	 * 
	 * 확정되는 부분이 안 바꿔도 똑같으면, 바꾸지 않는다!!
	 * 
	 */
	static int N, M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		//A행렬 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				A[i][j] = s.charAt(j)-'0';
			}
		}
		
		//B행렬 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				B[i][j] = s.charAt(j)-'0';
			}
		}
		
		//3x3만큼 잘라서 순회 시작
		int answer = 0;
		
		if(N < 3 || M < 3) {
			//변환될 만큼 큰 배열이 아니면, 같아야 함. 아니면 -1.
			if(!isSameArray(A,B)) System.out.println(-1);
			else System.out.println(0);
		}
		else {
			for (int i = 0; i <= N-3; i++) {
				for (int j = 0; j <= M-3; j++) {
					//하나 검사
					if(A[i][j] != B[i][j]) {
						//A를 뒤집기
						for (int k = i; k < i+3; k++) {
							for (int k2 = j; k2 < j+3; k2++) {
								A[k][k2] = (A[k][k2] == 0) ? 1 : 0;
							}
						}
						
						answer++;
						
						if(isSameArray(A,B)) {
							System.out.println(answer);
							System.exit(0);
						}
					}
				}
			}
			
			System.out.println(-1);
		}
		
		

	}
	
	static boolean isSameArray(int[][] A, int[][] B) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A[i][j] != B[i][j]) return false;
			}
		}
		
		return true;
	}
	
	
}