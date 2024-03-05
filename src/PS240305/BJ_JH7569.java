package PS240305;
import java.util.*;
import java.io.*;

public class BJ_JH7569 {
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int M,N,H;
	static int[][][] tomato;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 모든 배열을 순회하며 토마토가 든 곳을 찾는다.
		 * 2. 토마토가 든 곳을 발견하면, 해당 칸에 대해 BFS를 진행
		 * 		해당 칸의 일수를 갱신 -> 더 적은 일수라면 갱신
		 * 3. 칸을 순회하며 가장 큰 일수를 출력
		 */
		
		//맨 처음에 q에 현재 위치를 삽입한다.
		//temp의 현재 위치에 현재 값을 삽입한다.
		//temp의 앞 뒤 좌 우 위 아래를 확인한다.
		//temp가 -1이면 안 넣고. 0이면 넣고, 다른 숫자라면 현재 수가 더 작으면 넣는다.
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		int maxTomato = -20000000;
		int zeroOK = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(tomato[i][j][k] == 0) {
						zeroOK = 1;
					}
				}
			}
		}
		
		
		//0이 존재하면 괜찮음
		if(zeroOK == 0) {
			maxTomato = 1;
		}
		else {
			zeroOK = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {	
					for (int k = 0; k < M; k++) {
						if(tomato[i][j][k] == 1) {
							BFS(i,j,k);
						}
					}
				}
			}
			
			
			for (int k2 = 0; k2 < H; k2++) {
				for (int l = 0; l < N; l++) {
					for (int l2 = 0; l2 < M; l2++) {
						if(tomato[k2][l][l2] == 0) {
							zeroOK = 1;
						}
						
						if(tomato[k2][l][l2] > maxTomato) {
							maxTomato = tomato[k2][l][l2];
						}
					}
				}
			}
			
			if(zeroOK == 1) {
				maxTomato = 0;
			}
		}
		
		System.out.println(maxTomato-1);
		
	}
	
	
	private static void BFS(int h,int m, int n) {
		Queue<int[]> q = new LinkedList<int[]>();

		int[] temp = {h,m,n, 2};
		q.add(temp);
		
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int tempZ = t[0]+ dz[i]; //h(높이) 
				int tempX = t[1]+ dy[i]; //행
				int tempY = t[2]+ dx[i]; //열

				int[] tt = {tempZ, tempX, tempY, t[3]+1};
				
				if(tempZ >= 0 && tempZ < H && tempY >=0 && tempY < M && tempX >=0 && tempX < N) {	
					if(tomato[tempZ][tempX][tempY] == -1) {
						continue;
					}
					else if(tomato[tempZ][tempX][tempY] == 0) {
						tomato[tempZ][tempX][tempY] = t[3];
						q.add(tt);
					}
					else if(tomato[tempZ][tempX][tempY] > t[3]) {
						tomato[tempZ][tempX][tempY] = t[3];
						q.add(tt);
					}
				}
			}
		}
	}
}