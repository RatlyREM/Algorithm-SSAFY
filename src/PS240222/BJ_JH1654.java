package PS240222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_JH1654 {
	static long[] lan;
	static int N,K;
	static long mid, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		lan = new long[K];
		
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			lan[i] = temp;
		}
		
		Arrays.sort(lan);
		
		//최댓값
		long temp = lan[K-1];
		
		long[] bs = new long[(int) temp];
		
		for (int i = 0; i < bs.length; i++) {
			bs[i] = i+1;
		}
		
		b_search(bs, 0,temp-1);
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
