import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			//arrSum[i] = total + arr[i];
			total += arr[i];
		}
		
		Collections.sort(arrSum);
		
//		for(int i: arrSum) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		//각각 0부터 이어진거 검사, 부분합 검사, 아니면 0
		int start = 0;
		int end = 1;
		int minNum = Integer.MAX_VALUE;
		
		//만약 end가 이미 범위를 넘어섰는데 부분합은 S보다 작다면,
		//end 늘리지 말고 break해야함!!
		while(true) {
			//System.out.println("start:  " + start + " end: " + end );
			
			if(end >= N) {
				if(arrSum.get(N-1)- arrSum.get(start) < S) {
					break;
				}
				else {
					
					//System.out.println("끝부분에서 바뀌: "+ minNum + " " + (N-1-start));
					minNum = Math.min(minNum, (N-1)-start);
					
					start++;
				}
			}
			else {
				if(arrSum.get(end)- arrSum.get(start) < S) {
					end++;
				}
				else if(arrSum.get(end)- arrSum.get(start) >= S) {
					
					//System.out.println("걍 바뀌: "+ minNum + " " + (end-start));
					
					minNum = Math.min(minNum, end-start);
					start++;
				}
			}
		}
		
		//System.out.println(minNum);
		
//		int start = 0;
//		int end = N-1;
//		int minNum = Integer.MAX_VALUE;
//		
//		while(start < end) {
//			int temp = arrSum.get(end) - arrSum.get(start);
//			if(temp < S) {
//				start++;
//			}
//			else {
//				end--;
//				minNum = Math.min(minNum, end-start);
//			}
//		}
//		
//		
		for (int i = 0; i < N; i++) {
			if(arrSum.get(i) >= S) {
				minNum = Math.min(minNum, i+1);
			}
			
		}
		if(minNum == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minNum);
		
		
		
	}
}