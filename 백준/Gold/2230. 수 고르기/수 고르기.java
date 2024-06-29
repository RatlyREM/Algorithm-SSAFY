import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 입력받으면서 수들을 정렬한다.
		 * 2. 처음에서부터 start와 end 포인터를 정한다.
		 * 3. 차이가 아직 M보다 작다면, 계속 end를 움직인다.
		 * 4. 차이가 M보다 큰 상태라면, start를 움직인다.
		 * 
		 * 최댓값 검사는, 차이가 M보다 클 때만.
		 * 
		 * 차이가 M보다 작다면, end를 움직인다.
		 * 차이가 M보다 크다면, start를 움직인다. 최댓값을 검사한다.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		while(start <= end) {
			
			
			int temp;
			//System.out.println(start + " " + end);
			
			
			//만약에 넘어섰다면,
			if(end >= (N-1)) {
				
				temp = list.get(N-1) - list.get(start);
				
				if(temp >= M) {
					min = Integer.min(min, temp);
					start++;
				}
				else {
					break;
				}
				
			}
			else {
				if((list.get(end) - list.get(start)) < M) {
					//.out.println("end는 진행중, 합은 다 안 채워짐");
					end++;
				}
				else {
					min = Integer.min(min, list.get(end) - list.get(start));
					
					start++;
					//System.out.println("end는 진행중, 합은 다 채워짐");
					//System.out.println(list.get(end) - list.get(start));
				}
			}
				
				
			
		}
		
		
		
		System.out.println(min);
		
		
	}
}