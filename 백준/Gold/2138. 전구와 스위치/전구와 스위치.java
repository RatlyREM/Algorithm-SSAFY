import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String start = br.readLine();
		String end = br.readLine();
		
		StringBuilder sb1 = new StringBuilder(start);
		//StringBuilder sb2 = new StringBuilder(end);
		
		int ans = Integer.MAX_VALUE;
		int tempNum = 0;
		
		//1번을 안 눌렀을 때!!
		for (int i = 1; i < N; i++) {
			//i번 스위치를 누르면, i-1번 전구가 확정된다.
			//목적 상태의 i-1번 전구와 start의 i-1번 전구 상태를 비교.
			//같다면 넘기고, 다르면 i-1, i, i+1을 뒤집는다.
			//System.out.println(i +"까지 옴");
			if(sb1.charAt(i-1) != end.charAt(i-1)) {
				int t = (i== N-1) ? 2 : 3;
				
				//System.out.println("t: " + t  + " i :" + i);
				for (int j = i-1; j < (i-1)+t; j++) {
					//System.out.println("j: " + j);
					if(sb1.charAt(j) == '0') sb1.setCharAt(j, '1');
					else sb1.setCharAt(j, '0');
				}
				
				tempNum++;
			}
		}
		
		if(sb1.toString().equals(end)) 	ans= Math.min(ans, tempNum);
		
		sb1 = new StringBuilder(start);
		
		tempNum = 1;
		
		//1번을 눌렀을 때
		for (int j = 0; j <= 1; j++) {
			if(sb1.charAt(j) == '0') sb1.setCharAt(j, '1');
			else sb1.setCharAt(j, '0');
		}
		
		//System.out.println(sb1);
		for (int i = 1; i < N; i++) {
			//i번 스위치를 누르면, i-1번 전구가 확정된다.
			//목적 상태의 i-1번 전구와 start의 i-1번 전구 상태를 비교.
			//같다면 넘기고, 다르면 i-1, i, i+1을 뒤집는다.
			
			if(sb1.charAt(i-1) != end.charAt(i-1)) {
				int t = (i== N-1) ? 2 : 3;
				
				for (int j = i-1; j < (i-1)+t; j++) {
					if(sb1.charAt(j) == '0') sb1.setCharAt(j, '1');
					else sb1.setCharAt(j, '0');
				}
				
				tempNum++;
			}
		}
		
		//System.out.println(sb1.toString() + " " + end);
		
		if(sb1.toString().equals(end)) {
			ans= Math.min(ans, tempNum);
		}
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
		
			
			
	}	
}