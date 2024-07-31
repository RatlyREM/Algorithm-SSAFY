import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 먼저 전체 누적합을 구해둔다.
		 * 이후 부분합을 1~2, 2~3 ... 4~5 구해야 하므로
		 * X-1부터 출발해서 N-1까지. 
		 * 시작을 X-1번째 누적합으로 잡고,
		 * 그 이후부터 i= X~ N-1까지. i- (i-X) 최대 구하기.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] nu = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		nu[0] = arr[0];
		
		
		//누적합 구하기
		for (int i = 1; i < N; i++) {
			nu[i] = nu[i-1]+ arr[i];
		}
		
		int temp = nu[X-1];
		
		hm.put(temp, 1);
		
		for (int i = X; i < N; i++) {
			int k = nu[i] - nu[i-X];
			temp = Math.max(temp, k);
			
			if(hm.containsKey(k)) {
				hm.put(k, hm.get(k)+1);
			}
			else {
				hm.put(k, 1);
			}
		}
		
		if(temp == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(temp);
			System.out.println(hm.get(temp));
			
		}
	}
}