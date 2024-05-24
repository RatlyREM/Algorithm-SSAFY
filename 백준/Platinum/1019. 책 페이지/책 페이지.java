import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Long, long[]> hh;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		long temp = 1;
		long n = N;	
		long[] answer= new long[10];
		while(n >0) {
			for (int i = 0; i < 10; i++) {
				answer[i] += (n/10)*temp;
			}
			
			for (int i = 0; i < n%10; i++) {
				answer[i] += temp;
			}
			
			answer[(int) (n%10)] += (N%temp+1);
			
			answer[0] -= temp;
			temp *=10;
			n/=10;
		}

		for(long i: answer) {
			System.out.print(i+" ");
		}
	}
	
}