package PS240408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SAM_이차원테트리스 {
	static int[][] tet;
	static int score = 0;
	static int total = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * type2는 해당 칸에서 오른쪽으로 뻗고, type3는 해당 칸에서 아래쪽으로 뻗음
		 * 
		 * 1. 만약 type 1이라면, 아래, 오른쪽으로 1을 만나거나 배열 끝날 때까지 이동
		 * 2. 만약 type 2라면, 오른쪽- 1 만날 때까지 이동, 도착한 부분에서 왼쪽으로 한칸 더 뻗음
		 * 					 아래- 해당 칸과 오른쪽 칸을 내리면서 1이 없는지 확인!
		 * 3. 만약 type 3이라면, 2와 반대로 진행
		 * 
		 * 
		 * 4. 우선 쌓는 작업을 완료했으면, 가득찬 행-열이 있는지 확인하고 이전 행-열들을 옮겨온다!
		 * 5. 점수 쌓는 작업을 완료했다면, 연한 부분에 뭔가 없는지 확인하고 차지하는 만큼 밀기!
		 * 
		 */
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		tet = new int[10][10];
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			total = 0;
			
			switch (t) {
			case 1:
				//오른쪽
				for (int j = 4; j < 10; j++) {
					if(tet[x][j] == 1) {
						tet[x][j-1] = 1;
						break;
					}
					if(j==9) tet[x][9] = 1;
				}
				
				//아래
				for (int j = 4; j < 10; j++) {
					if(tet[j][y] == 1) {
						tet[j-1][y] = 1;
						break;
					}
					
					if(j==9) tet[9][y] = 1;
				}
				
				break;
			case 2:
				//오른쪽
				for (int j = 4; j < 10; j++) {
					if(tet[x][j] == 1) {
						tet[x][j-1] = 1;
						tet[x][j-2] = 1;
						
						break;
					}
					if(j==9) {
						tet[x][8] = 1;
						tet[x][9] = 1;
					}
				}
				
				//아래
				for (int j = 4; j < 10; j++) {
					if(tet[j][y] == 1 || tet[j][y+1]== 1) {
						tet[j-1][y] = 1;
						tet[j-1][y+1] = 1;
						
						break;
					}
					
					if(j==9) {
						tet[9][y+1] = 1;
						tet[9][y] = 1;
					}
				}
				
				break;
			case 3:
				//오른쪽
				for (int j = 4; j < 10; j++) {
					if(tet[x][j] == 1 || tet[x+1][j]== 1) {
						tet[x][j-1] = 1;
						tet[x+1][j-1] = 1;
						
						break;
					}
					
					if(j==9) {
						tet[x+1][9] = 1;
						tet[x][9] = 1;
					}
				}
				
				//아래
				for (int j = 4; j < 10; j++) {
					if(tet[j][y] == 1) {
						tet[j-1][y] = 1;
						tet[j-2][y] = 1;
						
						break;
					}
					if(j==9) {
						tet[8][y] = 1;
						tet[9][y] = 1;
					}
				}
				
				break;
			}
			
			
			//각각 점수 얻는 부분 확인
			for (int j = 6; j < 10; j++) {
				int countR = 0;
				int countD = 0;
				
				for (int l = 0; l < 4; l++) {
					countR += tet[l][j];
					countD += tet[j][l];
				}

				//오른쪽
				if(countR == 4) {
					score++;
					
					for (int l = j-1; l > 2; l--) {
						for (int m = 0; m < 4; m++) {
							tet[m][l+1] = tet[m][l];
						}
					}
				}
				
				//아래
				if(countD == 4) {
					score++;

					for (int l = j-1; l > 2; l--) {
						for (int m = 0; m < 4; m++) {
							tet[l+1][m] = tet[l][m];
						}
					}
				}
			}
			
			//옅은 부분 처리
			for (int j = 4; j < 6; j++) {
				int countR = 0;
				int countD = 0;
				
				for (int m = 0; m < 4; m++) {
					countR += tet[m][j];
					countD += tet[j][m];
				}
				
				if(countR != 0) {
					for (int l = 8; l > 2; l--) {
						for (int m = 0; m < 4; m++) {
							tet[m][l+1] = tet[m][l];
						}
					}
				}
				
				if(countD != 0) {
					for (int l = 8; l > 2; l--) {
						for (int m = 0; m < 4; m++) {
							tet[l+1][m] = tet[l][m];
						}
					}
				}
			}			
		}
		
		//남아있는 총합 구하기
		for (int j = 0; j < 10; j++) {
			for (int m = 0; m < 10; m++) {
				total += tet[j][m];	
			}
		}
		
		System.out.println(score + "\n" + total);	
	}
}
