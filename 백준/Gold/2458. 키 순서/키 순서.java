import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * 기존 그래프랑 방향 뒤집힌 그래프 두개 만들고,
		 * 각각 BFS로 탐색했을 때 visited를 처리.
		 * 두 그래프의 방문 경우의 수를 합쳤을 때 전체가 되면 키가 몇 번째인지 알 수 있는 학생이다,
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int total = 0;
		
		List<Integer>[] stu= new List[N+1];
		List<Integer>[] rev_stu= new List[N+1];
		
		for (int i = 1; i < N+1; i++) {
			stu[i] = new ArrayList<>();
			rev_stu[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			stu[a].add(b);
			rev_stu[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			//각 그래프별로 BFS
			int[] visited = new int[N+1];
			int[] visited2 = new int[N+1];
			
			visited = BFS(stu, i);
			visited2 = BFS(rev_stu, i);
			
			for (int j = 1; j < N+1; j++) {
				if(visited[j] + visited2[j] == 0) {
					break;
				}
				
				if(j == N) total++;
			}
			
		}
		
		System.out.println(total);
		
		
		
	}
	
	public static int[] BFS(List<Integer>[] stu, int i) {
		
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[N+1];
		//System.out.println("N: " + N);
		q.add(i);
		visited[i] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for (int j = 0; j < stu[temp].size(); j++) {
				//System.out.println(temp + "  " + j);
				//System.out.println(stu[temp].get(j));
				
				if(visited[stu[temp].get(j)] == 0) {
					visited[stu[temp].get(j)] = 1;
					
					q.add(stu[temp].get(j));
				}
				
			}
		}
		
		return visited;
		
	}
}