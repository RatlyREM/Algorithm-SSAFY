import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 110 120 140 150

더 큰건 이걸로 고정.

150 
110 120 140 150

110 120 140 140 -> 140까지의 누적합에, 140 * 1= 510

110 120 120 120 -> 120까지의 누적합, 120 * 2 = 470

485 - (120까지 누적합) 한 다음에, 255 >=  N* 2이면서 N이 최댓값이어야 한다!
		 */
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer> li = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(li);
		
		int[] nu = new int[N];
		
		int total = 0;
		
		//누적합 구해놓기
		for (int i = 0; i < N; i++) {
			total += li.get(i);
			nu[i] = total;
		}
		
		for (int i = N-1; i >= 0; i--) {
			int l = nu[i] + li.get(i) * ((N-1)- i);
			if(l <= M) {
				if(i == N-1) {
					System.out.println(li.get(i));
				}
				else {
					int temp = M- nu[i];
					System.out.println(temp/((N-1)-i));
				}
				
				break;
			}
			
			if(i== 0) {
				System.out.println(M/N);
			}
		}
		
		
		
	}
}