import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int flag = 0;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 정점의 개수만큼 배열의 수를 두고 그래프를 선언한다.
		 * 2. 이번 간선을 잇는다.
		 * 3. 이 그래프에 대해 Union-find로 사이클이 존재하는지 확인한다.
		 * 4. 존재한다면, 탈출하고 이번 횟수를 답으로 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//그래프 설정
		List<Integer>[] arr = new List[n];
		parent = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
			parent[i] = i;
		}
		
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(flag == 0) {
				int rootJ = find(start);
				int rootK = find(end);
				
				if(rootJ == rootK) {
					//cycle 발생함
					flag = i;
					break;
				}
				else {
					union(rootJ, rootK);
				}
			}
		}
		
		System.out.println(flag);
	}
	
	static int find(int a) {
		if(parent[a] != a) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
	
	static void union(int j, int k) {
		if(j < k) parent[k] = j;
		else parent[j] = k;
	}
}