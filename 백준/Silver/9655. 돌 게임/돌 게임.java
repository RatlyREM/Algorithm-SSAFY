import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 상근이부터 돌을 가져감.
		 * 
		 * 돌이 3개보다 적을 때, 1개씩만 가져감.
		 * 
		 * 1개 -> S
		 * 2개 -> S C
		 * 이후는 짝수면 CY, 홀수면 SK
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String ans = "";
		
		if(N == 1) ans = "SK";
		else if(N==2) ans = "CY";
		else {
			if(N%2 == 0) ans = "CY";
			else ans = "SK";
		}
		
		System.out.println(ans);
		
	}
}