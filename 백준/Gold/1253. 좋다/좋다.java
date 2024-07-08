import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 두 수의 합으로 나타내기.
		 * map에다 삽입.
		 * 1. 우선 정렬 필요
		 * 2. 자기보다 낮은 수 중 합이 가능해야 함.
		 * 3. 투 포인터로 가장 작은것과 가장 큰것에서 천천히 내려옴
		 * 
		 * 4. 찾았다면 좋은 수의 개수를 하나 올리기
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> li = new ArrayList<Integer>();
		int goodNum = 0;
		
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(li);
		
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N-1;
			
			
			while(start < end) {
				if(start == i) {
					start++;
					continue;
				}
				
				if(end == i) {
					end--;
					continue;
				}
				
				int temp = li.get(start) + li.get(end);
				
				if(temp == li.get(i)) {
					//System.out.println("start: " +start + " " + end);
					//System.out.println(li.get(i) + "가능!!!!");
					goodNum++;
					break;
				}
				else if(temp > li.get(i)) {
					end--;
				}
				else if(temp < li.get(i)) {
					start++;
				}
			}
		}
		
		
		System.out.println(goodNum);
	}
}