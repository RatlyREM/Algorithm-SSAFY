package PS240313;

import java.util.*;
import java.io.*;

public class BJ_JH1654 {
	static long N;
	static long[] lan;
	static long mid = 1;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 이분 탐색으로 찾아가면서,
		 * 만약 나눠봤는데 N보다 개수가 작다? -> 조각이 너무 크다는 것. -> 좀더 왼쪽으로 갈 것!!
		 * 만약 나눠봤는데 N보다 개수가 크다? -> 조각이 너무 작다는 것. -> 좀더 오른쪽으로 갈 것!!
		 * 
		 * N개보다 많이 만들었다? -> N개 만들 때보다 조각이 좀 작다.(최댓값이 아닐 수 있다) 
		 * 
		 * 이분탐색으로 return되는 값은, 조각의 크기! -> 총 개수는 직접 계산해야 함
		 * 만약 이분탐색을 종료했는데, return된 값이 N보다 크다면? 조각 크기를 조금씩 키워볼 것!! -> 혹시 n을 넘어가면 종료 
		 * 이분탐색 종료했을 때 return값이 N보다 작을 순 없음! (그럴 경우는 주어지지 않으므로)
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long K = Long.parseLong(st.nextToken());
		N = Long.parseLong(st.nextToken());
		
		//랜선들 길이 집합
		lan = new long[(int)K];
		long maxLan = 0L;
		
		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			lan[i] = temp;
			if(maxLan < temp) maxLan = temp;
		}
		
		//binary search해서 얻은 조각 크기
		BS(1L, maxLan+1);
		
		System.out.println(mid);
	}
	
	/*
	 * Upper bound(상한)을 구해야 함.
	 * check로 확인했을 때 N보다 큰 최소 부분을 구해야 함.
	 * 그 부분에서 1을 빼면 거기가 최대 길이!!
	 * 
	 */
	
	private static void BS(long start, long end) {
		if(start > end) {
			mid = start-1;
			return;
		}

		mid = (start+end)/2L;
		
		long total = 0L;
		
		for (int i = 0; i < lan.length; i++) {
			total += lan[i]/mid;
		}
		
		
		if(total < N) {
			BS(start, mid-1);
		}
		else if(total >= N) {
			BS(mid+1L, end);
		}
	}
	
	//조각의 크기가 mid일 때 랜선의 개수
	private static long check(long m) {
		long total = 0L;
		
		for (int i = 0; i < lan.length; i++) {
			total += lan[i]/m;
		}
		return total;
	}
}



