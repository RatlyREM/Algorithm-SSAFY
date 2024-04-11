package PS240403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_5604 {
	static HashMap<Long, Long> f;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		f = new HashMap<Long, Long>();
		long sum = 0;
		
		for (long i = 0; i < 10; i++) {
			sum += i;
			f.put(i, sum);
		
		}	
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long rA = (A == 0) ? F(A) : F(A-1);
			long rB = F(B);
			
			System.out.println("#" + (i+1) + " " + (rB-rA));
		}
	}
	
	static long F(long temp) {
		if(f.containsKey(temp)) return f.get(temp);
		if(temp<10) return f.get(temp);
		
		long v = V(temp);
		long t = F(temp-1 - (temp%v)) + (temp/v)*((temp%v)+1) + F(temp%v);
		
		f.put(temp, t);
		
		return t;
	}
	
	
	static long V(long temp) {
		long v=1;
		while(temp >=10) {
			v*=10;
			temp/=10;
		}
		
		return v;
	}
}








