import java.io.*;
import java.util.*;

public class Main {
	static int[] visited;
	static int[] pyo;
	static ArrayList<Integer> result;
	static ArrayList<Integer> original;
	static int maxNum;

	static int[] totalResult;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		pyo = new int[N+1];
		maxNum = -1;
		result = new ArrayList<Integer>();
		original = new ArrayList<Integer>();
		totalResult = new int[N+1];
		
		//두 번째 줄 입력
		for (int i = 1; i <= N; i++) {
			pyo[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			visited= new int[N+1];
			visited[i] = 1;
			DFS(i);
			
			result.clear();
			original.clear();
		}

		ArrayList<Integer> r = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if(totalResult[i] == 1) {
				r.add(i);
			}
		}
		
		
		System.out.println(r.size());
		for (int i: r) {
			System.out.println(i);
		}
	}
	
	static void DFS(int start) {
		original.add(start);
		
		int temp = pyo[start];
		
		//이미 방문됐었다면
		if(visited[temp] != 0) {
			if(!result.contains(temp)) {
				result.add(temp);
			}

			//같다면
			if(result.containsAll(original)) {
				for (int i = 0; i < result.size(); i++) {
					//겹치는 사이클이라면
					totalResult[result.get(i)] = 1;
				}
			}

			return;
		}
		
		//아직 방문하지 않았다면
		if(visited[temp] == 0) {
			visited[temp] = 1;
			result.add(temp);
			
			DFS(temp);
		}
	}
}