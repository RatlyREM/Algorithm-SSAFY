import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] prefix = new int[N];
		
		//모든 거리를 양분한 값이 최댓값.
		int total = 0;

		for (int i = 0; i < N; i++) {
			prefix[i] = Integer.parseInt(br.readLine());
			total += prefix[i];
		}
		
		int start=0, end=1;

		int lSum = prefix[start];
		int rSum = total- lSum;
		int answer = 0;
		
		while(end < N && start < end) {
			if(lSum == rSum) {
				answer = lSum;
				break;
			}
			else if(lSum > rSum) {
				answer = Integer.max(rSum, answer);
				lSum -= prefix[start];
				rSum += prefix[start];
				start++;
			}
			else if(lSum < rSum) {
				answer = Integer.max(lSum, answer);
				lSum += prefix[end];
				rSum -= prefix[end];
				
				end++;
			}
		}
		
		System.out.println(answer);
	}
}