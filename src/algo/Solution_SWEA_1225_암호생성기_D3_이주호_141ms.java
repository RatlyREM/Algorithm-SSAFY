package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_이주호_141ms {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 8개의 숫자를 각각 입력받고 queue에 넣는다.
		 * 2. 1~5까지 계속 돌아가면서 이번에 뺄 숫자를 정한다.
		 * 3. 뺄 숫자를 정하고 queue의 front에서 하나 빼서 뺀 후 뒤에다 넣는다.
		 * 4. 뺀 숫자가 0보다 작아지거나 0일 경우 0으로 넣고 프로그램을 종료시킨다.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		Queue<Integer> amho = new LinkedList<Integer>();
		
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 8; j++) {
				amho.offer(Integer.parseInt(st.nextToken()));
			}
			
			int count = 0;
			
			while(true) {
				int temp = amho.poll();
				
				temp -= (count%5 +1);
				
				if(temp <= 0) {
					temp = 0;
					
					amho.offer(temp);
					break;
				}
				amho.offer(temp);
				
				count++;
			}
			
			System.out.print("#"+num+ " ");
			
			while(!amho.isEmpty()) {
				System.out.print(amho.poll()+ " ");
			}
			System.out.println();
		}
	}
}
