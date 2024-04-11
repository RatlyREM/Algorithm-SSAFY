package PS240402;

import java.util.*;
import java.io.*;
import java.awt.*;

public class BJ_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//각 물건들의 배열
		Point[] mono = new Point[N];
		int[][] bag = new int[N][K+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			mono[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <= K; i++) {		
			if(i >= mono[0].x) {
				bag[0][i] = mono[0].y;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j < mono[i].x) { //정해진 크기보다 더 무거움
					bag[i][j] = bag[i-1][j];
				}
				else {
					bag[i][j] = Math.max(bag[i-1][j], mono[i].y +bag[i-1][j-mono[i].x]);
				}
						
			}
		}
		
		System.out.println(bag[N-1][K]);
		
	}
}
