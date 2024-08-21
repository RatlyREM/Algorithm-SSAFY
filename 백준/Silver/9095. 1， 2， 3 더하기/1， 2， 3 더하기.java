import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1 -> 1가지
		 * 2 -> 1+1, 2 -> 2가지
		 * 3 -> 1+1+1, 1+2, 2+1, 3 -> 4가지
		 * 
		 * 4-> 4+2+1
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] dp = new int[n+1];
			
			
			for (int j = 1; j <= n; j++) {
				if(j <= 3) {
					switch(j) {
					case 1:
						dp[1] = 1;break;
					case 2:
						dp[2] = 2; break;
					case 3:
						dp[3] = 4; break;
					}
				}
				else {
					dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
				}
			}
			
			System.out.println(dp[n]);
		}
		
	}
}