import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int total = 0;
	static int flag = 0;
	static List<Integer>[] li;
	static int[] visited;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 서브트리에 속한 정점의 수
		 * DFS를 돌면서 정점 개수 추가
		 */
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int R = Integer.parseInt(st.nextToken());
		 int Q = Integer.parseInt(st.nextToken());
		 
		 li = new List[N+1];
		 dp = new int[N+1];
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
		 
		 visited = new int[N+1];
		 visited[R] = 1;
		 int k = DFS(R);
		 dp[R] = k;
		 
		 for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
		
			System.out.println(dp[q]);
		}
		 
	}
	
	static int DFS(int r) {
		//System.out.println("r:" + r + " q: " + q);
		//서브트리의 정점이면 더하기
		//System.out.println(r+" 은 " + li[r].size()+"개와 연결!!");
		int temp = 1;
		
		for (int i = 0; i < li[r].size(); i++) {
			//방문하지 않은 서브트리들을 더하면 됨
			//System.out.println("visited: " + Arrays.toString(visited));
			
			if(visited[li[r].get(i)] == 0) {
				visited[li[r].get(i)] = 1;
				
				if(dp[li[r].get(i)] == -1) {
					dp[li[r].get(i)] = DFS(li[r].get(i));
				}
				
				temp += dp[li[r].get(i)];
			}
			
			//dp[li[r].get(i)] = Math.min(dp[li[r].get(i)], temp);
		}
		
		
		return temp;
	}
}