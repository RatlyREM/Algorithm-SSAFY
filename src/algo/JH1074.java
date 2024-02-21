package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JH1074 {
	static int[][] zz;
	
	private static void zet(int r, int c, int size) {
		
		
		zet(r,c, size/2);
		zet(r+ size/2,c, size/2);
		zet(r,c+ size/2, size/2);
		zet(r+size/2,c+ size/2, size/2);
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		/*
		 * 분할 정복, 재귀로 해결 필요
		 * 
		 * 1. 일단 입력받고 재귀함수 호출
		 * 2. size가 2x2가 되면 재귀 return하기
		 * 3. 2x2에 도착했으면, z만큼 
		 * 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		zz = new int[N][N];
		
		zet(0,0,N);
	}
}
