import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		/*
		 * nCr = n! / (n-r)! r!
		 * a^p = a (mod p)
		 * a^p-2 = a^-1 (mod p)
		 * 
		 * a = (n-r)! r! 이라 가정.
		 * => n! ((n-r)! r!) ^ p-2
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] fac = new long[N+1];
		fac[0] = 1;
		
		//n! 구하기
		for (int i = 1; i <= N; i++) {
			fac[i] = (fac[i-1] * i) % MOD;
		}
		
		long a = (fac[N-K] * fac[K]) % MOD;
		
		//분할 정복을 통한 n제곱 계산
		System.out.println((fac[N] * zegop(a, MOD-2)) %MOD);
	}
	
	static long zegop(long a, int p) {
		if(p==0) return 1;
		
		long tmp = zegop(a, p/2);
		long rst = (tmp*tmp) % MOD;
		
		if(p%2 == 0) return rst;
		else return (rst*a) % MOD;
	}
}