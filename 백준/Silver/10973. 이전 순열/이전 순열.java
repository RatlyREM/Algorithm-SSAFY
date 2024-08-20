import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 한 자리에 N씩 들어감.
		 * 1. 뒤에서부터 보면서 오름차순 깨지는 곳 찾기
		 * 2. 찾았으면, i-1번째랑 뒤에서부터 걔보다 작아지는 곳 찾기
		 * 3. 둘이 스왑
		 * 4. 뒤에서부터 i까지 싹 바꾸기
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int t = N-1;
		
		while(true) {
			if(t == 0 || (arr[t] < arr[t-1])) {
				t = t-1;
				break;
			}
			t--;
		}
		
		if(t >= 0) {
			//i보다 작은거
			int k = 0;
			
			//t가 i-1을 담당
			for (int i = N-1; i >=0; i--) {
				if(arr[i] < arr[t]) {
					k = i;
					break;
				}
			}
			
			//k,t 스왑
			int temp = arr[k];
			arr[k] = arr[t];
			arr[t] = temp;
			
			for (int i = 0; i <= t; i++) {
				System.out.print(arr[i] + " ");
			}
			
			for (int i = N-1; i >= t+1; i--) {
				System.out.print(arr[i] + " ");
			}
			
		}
		else {
			System.out.println(-1);
		}
		
		
		
	}
}