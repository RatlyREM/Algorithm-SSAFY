package PS240222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_JH1654 {
	/*
	 * 1. 최댓값을 기반으로 이진 탐색을 진행한다.
	 * 2. 조각이 너무 작으면(N보다 total이 크게 나오면) , 더 오른쪽에서 찾는다. 이때의 최댓값을 저장해둔다.
	 * 3. 조각이 너무 크면(N보다 total이 작게 나오면), 더 왼쪽에서 찾는다.
	 * 4. 이 과정에서 start가 end보다 커지면, 현재 mid부터 쭉 올라가면서 N보다 total이 크거나 같을 때까지
	 * 올라간다.
	 * 
	 * 
	 */
	static long[] lan;
	static long N,K;
	static long mid, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		lan = new long[K];
		
		for (int i = 0; i < K; i++) {
			long temp = Integer.parseInt(br.readLine());
			
			lan[i] = temp;
		}
		
		Arrays.sort(lan);
		
		//최댓값
		long temp = lan[K-1];
		
		long[] bs = new long[temp];
		
		for (int i = 0; i < bs.length; i++) {
			bs[i] = i+1;
		}
		
		b_search(bs, 0, temp-1);
	}
	
	//target이 딱히 존재하진 않고, 다른 것들 조각 다 더한게 
	private static void b_search(long[] arr, long start, long end) {
		if (start> end) {
			long temp = arr[mid];
			long xtotal;
			
			do {
				xtotal = 0;

				for (int i = 0; i < K; i++) {
					xtotal += (lan[i] / temp);
				}

				if(xtotal < N) {
					System.out.println(temp-1);
					break;
				}
				
				temp++;
			} while(true);
			
			return;
		}
		//System.out.println(start + " 과 "+ end);
		
		mid = (start+end)/2;
		total = 0;
		
		for (int i = 0; i < K; i++) {
			total += (lan[i] / arr[mid]);
		}
		
		if(total < N) { //덩어리가 너무 큼
			b_search(arr, start, mid-1);
		}
		else if(total == N) {
			b_search(arr, mid+1, mid);
		}
		else {
			b_search(arr, mid+1, end);
		}
	}
	
}
