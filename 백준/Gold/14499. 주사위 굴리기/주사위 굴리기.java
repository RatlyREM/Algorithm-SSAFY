import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		/*
		 * 지도는 배열에 입력.
		 * 각 주사위. 북-남 리스트, 서-동 리스트.
		 * 이동 시 위치가 지도를 벗어나면 안 됨.
		 * 
		 * 	북쪽, 서쪽으로 굴리면 처음꺼 빼서 마지막에.
		 * 	남쪽, 동쪽으로 굴리면 마지막꺼 빼서 처음에.
		 * 	
		 *  서쪽, 동쪽은 한번 더 교환 필요
		 *  
		 * 	이동 후 공통적인 부분(1번째 인덱스)는 업데이트 필요
		 *  
		 * 이동이 끝났으면, 밑면 처리
		 * 	1. 지도가 0이면 밑면을 지도로.
		 * 	2. 지도가 0이 아니면 지도를 밑면으로, 해당 지도는 0으로
		 * 
		 * 밑면(북-남에서 마지막 인덱스) 처리가 끝났으면, 윗면을 출력.(1번 인덱스)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] jido = new int[N][M];
		List<Integer> NToS = new ArrayList<>();
		List<Integer> WToE = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			if(i<3) WToE.add(0);
			NToS.add(0);
			
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				jido[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			//x,y에서 시작
			int itr = Integer.parseInt(st.nextToken())-1;
			
			int tempX = x+dx[itr];
			int tempY = y+dy[itr];
			
			if(tempX >=0 && tempX <N && tempY >=0 && tempY <M) {
				//이동 시작
				if(itr == 0) {
					//동쪽
					int temp = WToE.remove(WToE.size()-1);
					WToE.add(0, temp);
					
					NToS.set(1, WToE.get(1));
					
					int t = WToE.get(0);
					WToE.set(0, NToS.get(3));
					NToS.set(3, t);
				}
				else if(itr==1) {
					//서쪽
					int temp = WToE.remove(0);
					WToE.add(temp);

					NToS.set(1, WToE.get(1));
					
					int t = WToE.get(2);
					WToE.set(2, NToS.get(3));
					NToS.set(3, t);
					
				}
				else if(itr==2) {
					//북쪽
					int temp = NToS.remove(0);
					NToS.add(temp);

					WToE.set(1, NToS.get(1));
				} else {
					//남쪽
					int temp = NToS.remove(NToS.size()-1);
					NToS.add(0, temp);
					
					WToE.set(1, NToS.get(1));
				}
				//밑면 처리
				if(jido[tempX][tempY] == 0) {
					jido[tempX][tempY] = NToS.get(3);
				}
				else {
					NToS.set(3, jido[tempX][tempY]);
					jido[tempX][tempY] = 0;
				}
				
				//윗면 출력
				sb.append(NToS.get(1) + "\n");
				
				x = tempX;
				y = tempY;
			}
		}
		
		System.out.println(sb);
	}
}