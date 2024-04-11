package PS240402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_조합_D3_이주호_256ms {
	static long tmp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[N+1];
			fac[0] = 1;
			
			//n! 구하기
			for (int j = 1; j <= N; j++) {
				fac[j] = (fac[j-1] * j) % 1234567891;
			}
			
			long a = (fac[R] * fac[N-R]) % 1234567891;
			tmp = a;
			
			System.out.println("#"+ (i+1) + " " + ((fac[N] * zegob(a, 1234567891-2)) % 1234567891));
		}
	}
	
	static long zegob(long l, int i) {
		if(i==0) return 1;
		
		long tmp = zegob(l, i/2);
		long rst = (tmp*tmp) % 1234567891;
		
		if(i %2==0) return rst;
		else return (rst*l) %1234567891;
		
	}
}

