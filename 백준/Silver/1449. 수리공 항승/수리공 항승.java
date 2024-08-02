import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 무조건 하나 막는데 1이 든단 얘기.
		 * L 이하인 간격들이 몇개인지 찾으면 됨
		 * 
		 * 2
		 * 1 98 1
		 * 
		 * 3
		 * 1 1 1 1
		 * 
		 * 1
		 * 1 1 1
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		List<Integer> li = new ArrayList<>();
		int[] status = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		Collections.sort(li);
		
		int a = 0;
		//다 돌면서 가장 많이 덮이는 곳을 찾자!
		while(a < N) {
			for(int i= a; i< li.size(); i++) {
				if(li.get(i) > li.get(a) + L-1) {
					a = i;
					break;
				}
				
				if(i == li.size()-1) {
					a= li.size();
					break;
				}
			}
			
			//System.out.println(a);
				
			
			answer++;
		}
		
		System.out.println(answer);
		
		
		
		
	}
}