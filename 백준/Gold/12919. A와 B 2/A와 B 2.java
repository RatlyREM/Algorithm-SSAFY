import java.util.*;
import java.io.*;

public class Main {
	static int result = 0;
	public static void main(String[] args) throws IOException {
		/*
		 * A
		 * BABA
		 * 
		 * 만약 S의 길이보다 줄어들었다면 종료
		 * 백트래킹으로 A 떼거나 B 떼고 뒤집어 보기!!
		 * 
		 * 1. 문자열 S,T를 입력받기. T를 기준으로 시작
		 * 2. 재귀를 통해 A를 떼거나 B를 떼고 뒤집어보고, 만약 S와 동일한
		 * 문자열이 생성된다면 1을 return하고 종료.
		 * 3. 만약 S의 크기가 T의 크기를 넘어서버린다면 0을 return하고 종료!
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		transfer(T, S);
		
		System.out.println(0);
	}
	
	static void transfer(String T, String S) {
		if(T.length() == S.length()) {
			if(T.equals(S)) {
				System.out.println(1);
				System.exit(0);
			}
			
			return;
		}
		
		//맨 마지막이 A이면?
		if(T.charAt(T.length()-1) == 'A') {
			transfer(T.substring(0, T.length()-1), S);
		}
		
		if(T.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(T.substring(1));
			
			transfer(sb.reverse().toString(), S);
		}
		
		return;
	}
}