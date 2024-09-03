import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 뒤부터 내림차순이 깨지는 부분(t)을 찾는다.
		 * 2. 뒤쪽부터 돌면서 해당 t보다 큰 부분(k)을 찾는다.
		 * 3. t와 k를 swap한다.
		 * 4. sb에 t까지는 쭉 넣고, 그 이후는 거꾸로 넣는다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int t = N-1;
		
		while(true) {
			if(t <= 0 || arr[t] > arr[t-1]) {
				t--;
				break;
			}
			t--;
		}
		
		int k = 0;
		
		if(t >= 0) {
			for (int i = N-1; i >= 0; i--) {
				if(arr[t] < arr[i]) {
					k = i;
					break;
				}
			}
			
			//swap
			int temp = arr[t];
			arr[t] = arr[k];
			arr[k] = temp;
			
			for (int i = 0; i <= t; i++) {
				sb.append(arr[i] + " ");
			}
			
			for (int i = N-1; i > t; i--) {
				sb.append(arr[i] + " ");
			}
			
			
			System.out.println(sb.toString());
		}
		else {
			System.out.println(t);
		}
	}
}