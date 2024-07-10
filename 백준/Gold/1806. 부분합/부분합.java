import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 일단 모든 수의 누적합을 구해둔다.
		 * 2. 부분합은, 끝 인덱스 누적합 - 시작인덱스-1 누적합 하면 됨.
		 * 3. 누적합을 정렬한다.
		 * 4. 정렬한 누적합을 투 포인터로 일정 값 이상을 찾는다. 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		List<Integer> arrSum = new ArrayList<Integer>();
		
		//배열에 입력받고 누적합 저장하기
		st = new StringTokenizer(br.readLine());
		int total = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arrSum.add(total + arr[i]);
			total += arr[i];
		}
		
		int start = 0;
		int end = 1;
		int minNum = Integer.MAX_VALUE;
		
		//만약 end가 이미 범위를 넘어섰는데 부분합은 S보다 작다면,
		//end 늘리지 말고 break해야함!!
		while(true) {
			if(end >= N) {
				if(arrSum.get(N-1)- arrSum.get(start) < S) break;
				else {
					minNum = Math.min(minNum, (N-1)-start);
					start++;
				}
			}
			else {
				if(arrSum.get(end)- arrSum.get(start) < S) end++;
				else {
					minNum = Math.min(minNum, end-start);
					start++;
				}
			}
		}
		
		//맨 처음부터의 부분합 최솟값 검사
		for (int i = 0; i < N; i++) {
			if(arrSum.get(i) >= S) {
				minNum = Math.min(minNum, i+1);
			}
		}
		
		if(minNum == Integer.MAX_VALUE) minNum = 0;
		
		System.out.println(minNum);
	}
}