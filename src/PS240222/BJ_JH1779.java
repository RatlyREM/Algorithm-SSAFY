package PS240222;

import java.util.*;
import java.io.*;

public class BJ_JH1779 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 배열 입력
		 * 2. 각 배열 내부 인덱스를 순회하면서, (x,y)를 설정하고, <d1,d2>가 (N,N) 이하에서 돈다
		 * 3. 먼저 각 사각형의 꼭짓점이 범위 내부에 있는지 확인한다.
		 * 4. 배열 순회하며 x범위가 1,4번 꼭짓점의 범위이고, y범위가 2,3번 꼭짓점의 범위라면 5번 선거구로!!
		 * 5. x범위가 1 ≤ r < x+d1, y범위가 1 ≤ c ≤ y라면 1번 선거구
		 * 6. x범위가 1 ≤ r ≤ x+d2, y범위가 y < c ≤ N라면 2번 선거구
		 * 7. x범위가  x+d1 ≤ r ≤ N, y범위가 1 ≤ c < y-d1+d2라면 3번 선거구
		 * 8. x범위가 x+d2 < r ≤ N, y범위가 y-d1+d2 ≤ c ≤ N라면 4번 선거구
		 * 
		 * 9. 구역을 모두 할당했다면, 각 인구수를 계산하고 최대-최소 차이 확인
		 * 10. 인구수 차이의 최솟값을 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		int[][] peopleNum = new int[N+1][N+1];
		int[][] vote = new int[N+1][N+1];
		int x,y,d1,d2;
		int minimum = 2147483647;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				peopleNum[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				x = i;
				y = j;
				
				//N/2+1까지 순회하며 d1, d2를 설정
				for (int k = 1; k <= N/2+1; k++) {
					for (int l = 1; l <= N/2+1; l++) {
						d1 = k;
						d2 = l;
		
						if(x+d1 >=1 && x+d1 <=N && y-d1>=1 && y-d1 <=N &&
							x+d2 >=1 && x+d2 <=N && y+d2 >=1 && y+d2 <=N &&
							x+d1+d2 >=1 && x+d1+d2 <=N && y-d1+d2 >=1 && y-d1+d2 <=N) {

							//5번 선거구 설정
							
							int left = 0;
							int right = 0;
							
							for(int a=x; a<= x+d1+d2; a++) {	
								for(int b= y-left; b<=y+right; b++) {
									vote[a][b] = 5;
								}
								
								if(a< x+d1) left++;
								else left--;
								
								if(a< x+d2) right++;
								else right--;
							}
							
							
							for (int a = 1; a <= N; a++) {
								for (int b = 1; b <= N; b++) {
									//1선거구
									if(a < x+d1 && b <= y && vote[a][b] != 5) {
										vote[a][b] = 1;
									}
									
									//2선거구
									if(a <= x+d2 && b>y && vote[a][b] != 5) {
										vote[a][b] = 2;
									}
									
									//3선거구
									if(a >= x+d1 && b < y-d1+d2 && vote[a][b] != 5) {
										vote[a][b] = 3;
									}
									
									//4선거구
									if(a > x+d2 && b >= y-d1+d2 && vote[a][b] != 5) {
										vote[a][b] = 4;
									}									
								}
							}

							int[] countPeople = new int[6];
							
							for (int a = 1; a <= N; a++) {
								for (int b = 1; b <= N; b++) {
									
									countPeople[vote[a][b]] += peopleNum[a][b];
								}
							}
							
							Arrays.sort(countPeople);
							
							if(minimum > countPeople[5] - countPeople[1]) {
								minimum = countPeople[5] - countPeople[1];
							}
							
							
							//초기화
							for (int a = 1; a <= N; a++) {
								for (int b = 1; b <= N; b++) {
									vote[a][b] = 0;
								}
							}
						}
						
						
					}
				}
			}
		}

		System.out.println(minimum);
		
	}
}
