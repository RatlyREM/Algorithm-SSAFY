import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 1. 입력받은 숫자들을 배열에 삽입.
		 * 2. 누적합 배열을 생성하고 누적합 적기.
		 * 3. 투 포인터로 start와 end를 설정하고 순회한다.
		 * 4. start~end의 구간합과, end~start의 구간합 중 최솟값을 구한다.
		 * 5. 구한 값의 최댓값 검사를 진행한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] prefix = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int start = 0, end = 0;
		int maxValue = -1;
		int sum = 0;
		
		//누적합 구해놓기
		prefix[0] = arr[0];
		for (int i = 1; i < N; i++) {
			prefix[i] = prefix[i-1] + arr[i];
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				int lSum = prefix[j-1];
				if(i > 0) lSum -= prefix[i-1];
				
				int rSum= prefix[N-1] - prefix[j-1];
				if(i>0) rSum += prefix[i-1];
				
				
				sum = Integer.min(lSum, rSum);
				maxValue = Integer.max(maxValue, sum);
			}
		}
		
		
		System.out.println(maxValue);
		
	}
}