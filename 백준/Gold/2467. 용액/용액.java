import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] solution = new long[N];
		
		for (int i = 0; i < N; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		long minZero = Long.MAX_VALUE;
		int mi=0,mr = 0;

		while(left < right) {
			long sum = solution[left] + solution[right];
			
			if(Math.abs(sum) < minZero) {
				minZero = Math.abs(sum);
				mi = left; mr = right;
			}
			
			if(sum >= 0) {
				right--;
			}
			else{
				left++;
			}
		}
		
		System.out.println(solution[mi] + " " + solution[mr]);
	}
}