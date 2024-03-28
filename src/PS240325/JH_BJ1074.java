package PS240325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JH_BJ1074 {
	static int r,c;
	static int total = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		Z(0,0,N,0);
	}
	
	public static void Z(int a, int b, int n, int start) {
		if(n==1) {
			int count = 0;
			for (int i = a; i < a+2; i++) {
				for (int j = b; j < b+2; j++) {
					if(i==r && j==c) {
						System.out.println(start + count);
						System.exit(0);
					}
					count++;
				}
			}
			
			return;
		}
		
		int temp = (int)Math.pow(2, n-1);
		
		if(a+temp > r && b+temp > c) Z(a,b,n-1, start + (int)(Math.pow(4, n-1)*0));
		else if(a+temp > r && b+temp <= c) Z(a,(int)(b+Math.pow(2, n-1)),n-1, start + (int)(Math.pow(4, n-1)*1));
		else if(a+temp <= r && b+temp > c) Z((int)(a+ Math.pow(2, n-1)), b, n-1, start + (int)(Math.pow(4, n-1)*2));
		else if(a+temp <= r && b+temp <= c) Z((int)(a+ Math.pow(2, n-1)), (int)(b+ Math.pow(2, n-1)),n-1, start + (int)(Math.pow(4, n-1)*3));
	}
}














