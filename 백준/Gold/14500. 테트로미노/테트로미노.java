import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] serodxy = {{0,0}, {1,0}, {2,0}, {0,1},{1,1},{2,1}};
	static int[][] sero = {{2,3},{0,5},{0,2},{3,5},{3,4},{0,1},{4,5}, {1,2}};
	
	static int[][] garodxy = {{0,0}, {1,0}, {0,1},{1,1},{0,2}, {1,2}};
	static int[][] garo = {{1,4}, {2,4}, {0,5}, {0,2},{0,4},{1,5},{3,5},{1,3}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] paper = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로 채우기
		
		
		
		int maxTotal = -1;
		
		//1. 4칸인 케이스부터 돌기
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < M-1; j++) {
				int total = 0;
				
				//여기서 내부 4칸
				for (int j2 = 0; j2 < 2; j2++) {
					for (int k = 0; k < 2; k++) {
						total += paper[i+j2][j+k];
					}
				}
				//System.out.println(total);
				
				maxTotal = Math.max(maxTotal, total);
			}
		}
		
		//System.out.println("끝");
		
		//1-2. 가로 일자인 케이스
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M-3; j++) {
				int total = 0;
				
				//여기서 내부 4칸
				for (int k = 0; k < 4; k++) {
					total += paper[i][j+k];
				}
				//System.out.println(total);
				
				maxTotal = Math.max(maxTotal, total);
			}
		}
		//System.out.println("끝");
		
		//1-2. 세로 일자인 케이스
		for (int i = 0; i < N-3; i++) {
			for (int j = 0; j < M; j++) {
				int total = 0;
				
				//여기서 내부 4칸
				for (int k = 0; k < 4; k++) {
					total += paper[i+k][j];
				}
				//System.out.println("i,j: " + i + " " + j + "total: " + total);
				
				
				maxTotal = Math.max(maxTotal, total);
			}
		}
		//System.out.println("끝");
		
		
		//2. 세로 6칸인 케이스 확인
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-1; j++) {
				int total = 0;
				
				//여기서 내부 6칸
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 2; k++) {
						total += paper[i+j2][j+k];
					}
				}
				
				//여기서 뭐 뺄지 결정
				//현재 위치는, (i,j)임
				for (int k = 0; k < sero.length; k++) {
					//2,3번째꺼 빼보기
					//paper[(serodxy[sero[k][0]][0])][(serodxy[sero[k][0]][1])[1]];
					
					//sero[k]의 x와 y에는 각각 point가 들었고, 
					
					int temp = total-paper[i + serodxy[sero[k][0]][0]][j + serodxy[sero[k][0]][1]]-paper[i + serodxy[sero[k][1]][0]][j + serodxy[sero[k][1]][1]];
					//System.out.println("temp: " + temp);
					
					maxTotal = Math.max(maxTotal, temp);
							
					//(serodxy[sero[k][0]][1])
				}
				
			}
		}
		//System.out.println("끝");
		
		//3. 가로 6칸인 케이스 확인
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < M-2; j++) {
				int total = 0;
				
				//여기서 내부 6칸
				for (int j2 = 0; j2 < 2; j2++) {
					for (int k = 0; k < 3; k++) {
						total += paper[i+j2][j+k];
					}
				}
				
				//여기서 뭐 뺄지 결정
				for (int k = 0; k < garo.length; k++) {
					//2,3번째꺼 빼보기
					//sero[k]의 x와 y에는 각각 point가 들었고, 
					
					int temp = total-paper[i + garodxy[garo[k][0]][0]][j + garodxy[garo[k][0]][1]]-paper[i + garodxy[garo[k][1]][0]][j + garodxy[garo[k][1]][1]];
					//System.out.println("temp: " + temp);
					
					maxTotal = Math.max(maxTotal, temp);
				}
				
			}
		}
		//System.out.println("끝");
		
		System.out.println(maxTotal);
		
	}
}