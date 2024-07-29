import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 꽉 차있고, 같은 부분에서 마무리했다? -> -1
		 * 꽉 차있고, 해보니까 이전에서 작은 부분이 나왔다? -> 등수
		 * 꽉 차있고, 큰 부분에서 마무리했다? -> -1
		 * 
		 * 다 끝났는데 꽉 안 찼고, 같은 부분에서 마무리했다? -> 같은거 등수
		 * 다 끝났는데 꽉 안 찼고, 작은 부분이 나왔다? -> -1등수
		 * 다 끝났는데 꽉 안 찼고, 큰 부분에서 마무리했다? -> +1등수
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int total = 0;
		int ans = -1;
		
		int[] arr = new int[N];
		
		if(N <= 0) {
			ans = 1;
		}
		else {
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp;
			}
			
			
			if(N >= P) {
				//꽉 차있으면
				if(arr[P-1] >= newScore) {
					ans = -1;
				}
				else {
					for (int i = 0; i < P; i++) {
						if(arr[i] == newScore) {
							ans = i+1;
							break;
						}
						if(arr[i] < newScore) {
							ans = i+1;//이거 2로?
							break;
						}
					}
				}
			}
			else {
				if(arr[N-1] > newScore) {
					ans = N+1;
				}
				else {
					for (int i = 0; i < N; i++) {
						if(arr[i] == newScore) {
							ans = i+1;
							break;
						}
						else if(arr[i] < newScore){
							ans = i+1;
							break;
						}
					}
				}
			}
		}
		
		
		System.out.println(ans);
		
		
		
	}
}