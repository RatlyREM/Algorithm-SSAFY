package PS240228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JH_SWEA_1767 {
	static int[][] mac;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 전선이 전원과 연결되려면, 가장자리까지 가는 길에 core가 있어선 안 됨.
		 * core 자리는 1, 전선 자리는 2, 비어있으면 0
		 * 
		 * 안쪽 부분을 탐색하면서, 코어를 발견하면 차례대로 전선 꽂아보기
		 * 만약 끝까지 돌았다면, 연결된 코어 개수를 센다.
		 * 
		 * 백트래킹으로,4군데로
		 * 먼저 전선 연결하고 
		 * 		가는 길에 코어가 존재하거나 범위를 벗어나면 멈추고 전선 회수
		 * 돌아오면 다시 원상복구
		 * 
		 * 
		 * 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			mac = new int[N][N];
			
			//입력
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < N; k++) {
					mac[j][k] = Integer.parseInt(st.nextToken());
				}	
			}
			
			
			for(int k=1; k< N-1; k++) {
				for (int l = 1; l < N-1; l++) {
					if(mac[k][l] == 1) {
						BT(k,l);
					}
				}
			}
		}
		
		
	}
	
	private static void BT(int a, int b) {
		//
		if(mac[a][b] == 1) {
			for (int i = 0; i < 4; i++) {
				//쭉 갔을 때 뭐가 없으면 [a][b]에서 쭉 나아가기
				
				int x= a;
				int y = b;
				
				while(true) {
					//뭔가에 부딪힐 때까지
					x += dx[i];
					y += dy[i];
					
					//끝에 도달하면
					if(x < 0 || x > N || y < 0 || y > N) {
						break;
					}
						
					
					//방해물에 부딪히면
					if(mac[x][y] == 1 || mac[x][y] ==2) {
						break;
					}
					
					
					
				}
				
				
				
				//전선 잇고
				
				//다음껄로 넘어가고
				
				//전선 복구시키고
			}
		}
		
	}
}

