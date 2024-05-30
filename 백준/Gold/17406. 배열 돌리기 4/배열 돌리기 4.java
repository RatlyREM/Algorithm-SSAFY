import java.io.*;
import java.util.*;

public class Main {
	static int[] visited;
	static int[] output;
	static List<Rotate> rotateList;
	static int[][] startArr;
	static int N,M;
	static int minTotal = Integer.MAX_VALUE;
	
	static public class Rotate {
		int rx;
		int ry;
		int count;
		
		public Rotate(int rx, int ry, int count) {
			this.rx = rx;
			this.ry = ry;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		startArr = new int[N+1][M+1];
		visited = new int[K];
		output = new int[K];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= M; j++) {
				startArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//회전 방법 입력
		rotateList = new ArrayList<Rotate>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			Rotate r = new Rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			rotateList.add(r);
		}
		
		//순서 정하기(K P K 진행)
		perm(K, 0);
		
		System.out.println(minTotal);
	}

	
	static void perm(int K, int depth) {
		if(depth == K) {
			//고르기 성공!!
		
			int[][] arr = new int[N+1][M+1];
			
			//초기 배열 복사.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i][j] = startArr[i][j];
				}
			}
			//이번에 출발할 때 배열 상태는 초기 상태로 시작해야 함!!
			
			for (int i = 0; i < K; i++) {
				//이번에 회전할 방법!!
				Rotate tempR = rotateList.get(output[i]);
				
				for (int j = 1; j <= tempR.count; j++) {
					int start = arr[tempR.rx-j][tempR.ry-j];

					//왼쪽 아래
					for (int l = tempR.rx-j + 1; l < tempR.rx-j + 1 + j*2; l++) {
						arr[l-1][tempR.ry-j] = arr[l][tempR.ry-j]; 
					}
					
					//오른쪽 아래
					for (int l = tempR.ry-j + 1; l < tempR.ry-j + 1 + j*2; l++) {
						arr[tempR.rx+j][l-1] = arr[tempR.rx+j][l]; 
					}
					
					//오른쪽 위
					for (int l = tempR.rx+j - 1; l > tempR.rx+j - 1 - j*2; l--) {
						arr[l+1][tempR.ry+j] = arr[l][tempR.ry+j]; 
					}
					
					//왼쪽 위
					for (int l = tempR.ry+j - 1; l > tempR.ry+j - 1 - j*2; l--) {
						arr[tempR.rx-j][l+1] = arr[tempR.rx-j][l]; 
					}
					
					
					arr[tempR.rx-j][tempR.ry-j+1] = start;
					
				}	
			}
		
			//행 최소합 계산
			for (int l = 1; l <= N; l++) {
				int total = 0;
				
				for (int l2 = 1; l2 <= M; l2++) {
					total += arr[l][l2];
				}
				
				if(total< minTotal) minTotal = total;
			}
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				output[depth] = i; 
				
				perm(K, depth+1);
				
				visited[i] = 0;
			}
		}
	}
}