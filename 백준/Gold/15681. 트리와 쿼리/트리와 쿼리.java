import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<Integer>[] li;
	static int[] visited;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 서브트리에 속한 정점의 수
		 * 들어가서 순회하면서 DP 배열 업데이트
		 */
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int R = Integer.parseInt(st.nextToken());
		 int Q = Integer.parseInt(st.nextToken());
		 
		 li = new List[N+1];
		 dp = new int[N+1];
		 visited = new int[N+1];
		 
		 visited[R] = 1;
		 Arrays.fill(dp, -1);
		 
		 for (int i = 0; i < N+1; i++) {
			li[i] = new ArrayList<>();
		 }
		 
		 for (int i = 0; i < N-1; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 li[a].add(b);
			 li[b].add(a);
	     }
		 
		 int k = DFS(R);
		 dp[R] = k;
		 
		 for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
		
			System.out.println(dp[q]);
		}
		 
	}
	
	static int DFS(int r) {
		int temp = 1;
		
		for (int i = 0; i < li[r].size(); i++) {
			//방문하지 않은 서브트리들을 더하면 됨
			if(visited[li[r].get(i)] == 0) {
				visited[li[r].get(i)] = 1;
				
				if(dp[li[r].get(i)] == -1) {
					dp[li[r].get(i)] = DFS(li[r].get(i));
				}
				
				temp += dp[li[r].get(i)];
			}
		}
		
		return temp;
	}
}