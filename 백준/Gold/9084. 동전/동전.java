import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coin = new int[N+1];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				coin[j] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int total = 0;
			
			//행이 1000개, 열이 
			int[][] makeCoin = new int[M+1][N+1];
			int[] answer = new int[M+1];
			
			//N= 3, M = 1000
			//j가 행, k가 열
			for (int k = 1; k <= N; k++) {
			
				for (int j = 1; j <= M; j++) {
					
					//System.out.println("j: " + j + " k: " + k + "  coin[k]: " + coin[k]);
					
					if(j == coin[k]) {
						answer[j] += 1;
					}
					else if(j > coin[k]) {
						answer[j] += answer[j-coin[k]];
					}
				}
			}
			
			System.out.println(answer[M]);
		}
		
		
		
	}
}