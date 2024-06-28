import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		/*
		 * 홀수다? -> 없앨 기회가 있다? -> 없애기
			짝수다? -> 그냥 나아간다(짝수 수열길이 플러스)
			홀수다? -> 없앨 기회가 없다? -> 이전까지의 길이 최댓값 검사, s부터 홀수 나올때까지 더하기  
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end=0;
		int chance = 0;
		int oddLength = 0;
		int maxLength = -1;
		
		
		while(true) {
			//System.out.println(start + " " + end);
			
			if(chance > K) {
				if(arr[start] % 2 == 1) {
					chance--;
				}
				start++;
			}
			else if(end == N) {
				break;
			}
			else {
				if(arr[end] %2 == 1) {
					chance++;
				}
				
				
				end++;
			}
			
			if(chance <= K) {
				maxLength = Integer.max(maxLength, end-start-chance);
			}
			//System.out.println("chance: " + chance);
			//System.out.println("쵀대: " + (end-start-chance) + " " + maxLength);
		}
		
		System.out.println(maxLength);
		
	}
}