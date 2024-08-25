import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[201][201];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//연산 시작
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int temp = Integer.parseInt(st.nextToken());
			int[][] tempArr = new int[201][201];
			
			switch(temp) {
			case 1:
				//상하 반전, 맨 밑 행들을 시작으로 재배치
				for (int j = N-1; j >=0 ; j--) {
					for (int l = 0; l < M; l++) {
						tempArr[N-1-j][l]=  arr[j][l];
					}
				}
				
				break;
			case 2:
				//좌우 반전, 맨 오른쪽 열들을 시작으로 재배치
				for (int j = M-1; j >=0 ; j--) {
					for (int l = 0; l < N; l++) {
						tempArr[l][M-1-j]=  arr[l][j];
					}
				}
				
				break;
			case 3:
				for (int j = 0; j < M; j++) {
					for (int l = N-1; l >=0; l--) {
						tempArr[j][N-1-l]=  arr[l][j];
					}
				}
				
				
				int t = N;
				N = M;
				M = t;
				
				break;
			case 4:
				for (int j = M-1; j >= 0; j--) {
					for (int l = 0; l <N; l++) {
						tempArr[M-1-j][l]=  arr[l][j];
					}
				}
				
				int t2 = N;
				N = M;
				M = t2;
				
				break;
			case 5:
				//1-> 2
				for (int j = 0; j < M/2; j++) {
					for (int l = 0; l < N/2; l++) {
						 tempArr[l][j+M/2] = arr[l][j];
					}
				}
				
				//2->3
				for (int j = M/2; j < M; j++) {
					for (int l = 0; l < N/2; l++) {
						 tempArr[N/2+l][j] = arr[l][j];
					}
				}
				
				//3-> 4
				for (int j = M/2; j < M; j++) {
					for (int l = N/2; l < N; l++) {
						 tempArr[l][j-M/2] = arr[l][j];
					}
				}
				
				//4->1
				for (int j = 0; j < M/2; j++) {
					for (int l = N/2; l < N; l++) {
						 tempArr[l-N/2][j] = arr[l][j];
					}
				}	
				
				break;
			case 6:
				//1->4
				for (int j = 0; j < M/2; j++) {
					for (int l = 0; l < N/2; l++) {
						 tempArr[l+ N/2][j] = arr[l][j];
					}
				}
				
				//2->1
				for (int j = M/2; j < M; j++) {
					for (int l = 0; l < N/2; l++) {
						 tempArr[l][j-M/2] = arr[l][j];
					}
				}
				
				//3->2
				for (int j = M/2; j < M; j++) {
					for (int l = N/2; l < N; l++) {
						 tempArr[l-N/2][j] = arr[l][j];
					}
				}
				
				//4->3
				for (int j = 0; j < M/2; j++) {
					for (int l = N/2; l < N; l++) {
						 tempArr[l][j+M/2] = arr[l][j];
					}
				}
				
				break;
			}
			
			
			arr = Arrays.copyOf(tempArr, tempArr.length);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}