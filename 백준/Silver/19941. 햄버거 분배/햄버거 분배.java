import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 왼쪽으로 가면서 먹을 수 있는 햄버거 발견하면 픽
		 * 다 봤으면 이번엔 오른쪽으로 보면서 먹을 수 있는 햄버거 보기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		int[] visited = new int[N];
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			if(s.charAt(i) == 'P') {
				//먹을 햄버거 찾아떠나기
				for (int j = i-K; j <= i+K; j++) {
					if(j < 0 || j>=N) continue;
					
					if(s.charAt(j) == 'H' && visited[i] == 0 &&  visited[j] == 0) {
						visited[j] = 1;
						visited[i] = 2;
						total++;
					}
				}
			}
		}
		
		System.out.println(total);
		
	}
}