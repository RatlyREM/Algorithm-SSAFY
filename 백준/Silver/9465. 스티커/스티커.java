import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] sticker = new int[2][n];
			int[][] result = new int[2][n];
			
			//배열 채우기
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				
				for (int k = 0; k < n; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//초기 세팅
			result[0][0] = sticker[0][0];
			result[1][0] = sticker[1][0];
			
			if(n>1) {
				result[1][1] = sticker[0][0] + sticker[1][1];
				result[0][1] = sticker[0][1] + sticker[1][0];
			}
			
			//시작
			for (int k = 2; k < n; k++) {	
				result[0][k] = Math.max(sticker[0][k]+result[1][k-1], sticker[0][k]+result[1][k-2]);
				result[1][k] = Math.max(sticker[1][k]+result[0][k-1], sticker[1][k]+result[0][k-2]);
			}
			
			System.out.println(Math.max(result[0][n-1], result[1][n-1]));
		}
	
	}
}