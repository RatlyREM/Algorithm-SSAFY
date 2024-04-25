import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] DP = new int[N+1];
		
		DP[1] = 1;
		//DP[2] = 2;
		//DP[3] = 3;
		
		int count = 1;
		//전처리
		while(count*count <= N) {
			DP[count*count] =1;
			
			count++;
		}
		
		//System.out.println(Arrays.toString(DP));
		
		//int zegob = 2;
		for (int i = 1; i <= N; i++) {
			int zegob = 1;
			int min = Integer.MAX_VALUE;
			
			//제곱수에서 빼면서 최솟값 찾기
			while(zegob*zegob <= i) {
				int temp = DP[zegob*zegob] + DP[i-zegob*zegob];
				
				if(min > temp) {
					min = temp;
				}
				
				zegob++;
			}
			
			DP[i] = min;
			
		}
		
		
		System.out.println(DP[N]);
		
		
	}
}