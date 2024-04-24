import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	static int[][] visited;
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 다익스트라로 풀기!
		 * 1. 먼저 모든 배열의 수를 무한으로 설정하고, 첫 root 부분의 값을 설정한다.
		 * 2. 모든 배열 중 가장 최소의 값을 가진 곳을 visited하고, 거기서 이어지는(방문되지 않은) 곳을
		 * 현재 장소에서 해당 자리의 도둑루피 값만큼 더해봐서 더 작은지 확인한다.
		 * 3. 더 작으면 갱신하고, 작지 않으면 그대로 둔다.
		 * 4. 모든 정점이 visited 될 때까지 반복한다.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			//방문 여부
			visited = new int[N][N];
			//기본 값 저장
			int[][] zelda= new int[N][N];
			//최단 거리 저장
			int[][] minArr = new int[N][N];
			
			//입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					zelda[i][j] = Integer.parseInt(st.nextToken());
					minArr[i][j] = 2147483647;
				}
			}
			
			
			minArr[0][0] = zelda[0][0];
			
			//int temp = 0;
			
			while(true) {
				//temp++;
				if(!check()) break;

				int minValue = 2147483647;
				int minI=0;
				int minJ=0;
				
				//최솟값 찾기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(visited[i][j] == 0 && minArr[i][j] < minValue) {
							minValue = minArr[i][j];
							minI = i;
							minJ = j;
						}
					}
				}
				
				//System.out.println(minI + " " + minJ);
				
				
//				if(temp ==6) break;
				visited[minI][minJ] = 1;
				
				//상하좌우 확인
				for (int i = 0; i < 4; i++) {
					int tempX = minI + dx[i];
					int tempY = minJ + dy[i];
					
					if(tempX >=0 && tempX <N && tempY >=0 && tempY <N) {
						if(visited[tempX][tempY] == 0) {
							if((minArr[minI][minJ] + zelda[tempX][tempY]) < minArr[tempX][tempY]) {
								minArr[tempX][tempY] = (minArr[minI][minJ] + zelda[tempX][tempY]);
							}
						}
					}
				}
				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(minArr[i][j] + " ");
//					}
//					System.out.println();
//				}
//				
//				System.out.println("visited는? ");
//				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(visited[i][j] + " ");
//					}
//					System.out.println();
//				}
			}
			
			
			System.out.println("Problem " + (count++) + ": " + minArr[N-1][N-1]);
		}
		
	}
	
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}
