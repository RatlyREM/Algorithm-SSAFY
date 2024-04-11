package PS240409;

import java.io.*;
import java.util.*;

public class BJ_1182 {
	static int[] arr;
	static int N;
	static int[] visited;
	static int score = 0;
	static ArrayList<Integer> result;
	static int S;
	static int dab = 0;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 백트래킹으로 브루트 포스
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new int[N];
		result = new ArrayList<Integer>();
		
		
		st = new StringTokenizer(br.readLine());
		
		//배열에 대입
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= N; i++) {
			BT(i,0);
		}
		
		System.out.println(score);
	}
	
	static void BT(int count, int start) {
		if(count==0) {
			if(dab == S) score++;
		
			return;
		}

		for (int i = start; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				result.add(arr[i]);
				dab += arr[i];
				
				BT(count-1, i+1);

				dab -= arr[i];
				result.remove(result.size()-1);
				visited[i] = 0;
			}
		}
	}
}
