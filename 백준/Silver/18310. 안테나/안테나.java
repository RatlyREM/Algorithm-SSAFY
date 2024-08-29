import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * n^2은 불가능.
		 * 돌면서 n번만에 확인할 수 있어야 함.
		 * 
		 * 거리의 총합을 구하려면,,??
		 * 작은 순서대로 정렬하고?
		 * 최대한 중앙에 있는 집을 골라야 함
		 * 1 5 7 9
		 * 중앙에 있는 집이 두개면, 두개를 비교
		 * 두 개가 총합이 같으면, 더 작은 수를!! 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> li = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(li);
		
		
		//1 2 3 4
		if(N%2 ==1) {
			System.out.println(li.get(N/2));
		}
		else {
			int totalA = 0;
			int totalB = 0;
			
			//N/2, N/2-1 총합 계산
			for (int i = 0; i < N; i++) {
				totalA += Math.abs(li.get(N/2)- li.get(i));
			}
			
			for (int i = 0; i < N; i++) {
				totalB += Math.abs(li.get(N/2-1)- li.get(i));
			}
			
			System.out.println((totalA >= totalB) ? li.get(N/2-1) : li.get(N/2));
			
		}
	}
}