import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 초밥들을 배열에 저장한다.
		 * 2. 슬라이딩 윈도우로 k개를 탐색. 끝에서 넘어가면 다시 처음으로(%)
		 * 3. 서로 다른 개수가 총 몇개인지?
		 * 		맵에서 맨 왼쪽 빼고 맨 오른쪽 넣고, 그리고 쿠폰 넣어두고. 총 맵 개수 
		 * 
		 * 
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N= Integer.parseInt(st.nextToken());
		int d= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		//쿠폰 삽입
		hm.put(c, 1);
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if(!hm.containsKey(sushi[i])) {
				hm.put(sushi[i], 1);
			}
			else {
				hm.put(sushi[i], hm.get(sushi[i])+1);
			}
		}
		
		
		
		int maxTotal = -1;
		
		for (int i = 0; i < N; i++) {
			//System.out.println(hm);
			if(i != 0) {
				int start = i-1;
				int end = (i+ k-1) %N;
				
				//start 빼기
				if(hm.get(sushi[start]) == 1) {
					hm.remove(sushi[start]);
				}
				else {
					hm.put(sushi[start], hm.get(sushi[start])-1);
				}
				
				
				//end 넣기
				if(!hm.containsKey(sushi[end])) {
					hm.put(sushi[end], 1);
				}
				else {
					hm.put(sushi[end], hm.get(sushi[end])+1);
				}
			}
			
			//가짓수 찾기
			maxTotal= Integer.max(maxTotal, hm.size());
		}
		
		
		System.out.println(maxTotal);
		
		
	}
}