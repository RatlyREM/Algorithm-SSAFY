import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
				
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//한 depth씩 파고들어가기
		int t = Math.min(N, M)/2;
		int nM = M;
		int nN = N;
		
		for (int i = 0; i < t; i++) {
			//i,i가 현재 시작지점
			int r = R % (2*nM + 2*nN -4);
			nM -= 2;
			nN -= 2;
			
			for (int a = 0; a < r; a++) {
				int temp = arr[i][i];
				
				//윗줄
				for (int j = i; j < M-i-1; j++) {
					arr[i][j] = arr[i][j+1];
				}
				
				//오른쪽 줄
				for (int j = i; j < N-i-1; j++) {
					arr[j][M-i-1] = arr[j+1][M-i-1];
				}
				
				//밑 줄
				for (int j = M-i-1; j >i; j--) {
					arr[N-i-1][j] = arr[N-i-1][j-1];
				}
				
				//왼쪽 줄
				for (int j = N-i-1; j >i ; j--) {
					if(j == i+1) {
						arr[j][i] = temp;
					}
					else {
						arr[j][i] = arr[j-1][i];
					}
					
				}
				
				
//				//배열 출력
//				for (int q = 0; q < N; q++) {
//					for (int w = 0; w < M; w++) {
//						System.out.print(arr[q][w] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			
			}
			
		}
		
		
		
		//배열 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}