import java.io.*;
import java.util.*;

public class Main {
	static int[] visited;
	static Queue<Integer> q;
	static int N,K;
	
	public static void main(String[] args) throws IOException {
		/*
		 * N부터 K까지 BFS.
		 * +1, -1, *2를 해보고, 아직 방문되지 않았다면 queue에 넣기.
		 * queue에서 뽑아낸 값이 K라면 그 depth를 구한다.
		 * 현재 queue에 들어있는 size만큼만 돌리면서 처리하면 그 시점의 경우의 수가 나온다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N > K) {
			System.out.println(N-K);
		}
		else {
			visited = new int[K-N+K + 3];
			q = new LinkedList<Integer>();
			q.add(N);
			visited[N] = 1;
			
			
			System.out.println(BFS());
		}	
	}
	
	static int BFS() {
		int count = 0;
		
		while(!q.isEmpty()) {
			//현재 큐 상태?
			int qs = q.size();
			for (int i = 0; i < qs; i++) {
				int temp = q.poll();
				
				if(temp == K) {
					//동생 찾음
					return count;
				}
				
				
				if(temp*2 <= (K-N+K)) {
					if(visited[temp*2]== 0) {
						visited[temp*2] = 1;
						q.add(temp*2);
					}
				}
				if(temp+1 <= K-N+K) {
					if(visited[temp+1] == 0) {
						visited[temp+1] = 1;
						q.add(temp+1);
					
					}
				}
				if((temp-1) >= 0) {
					if(visited[temp-1] == 0) {
						visited[temp-1] = 1;
						q.add(temp-1);
					
					}
				}
				
			}
			
			count++;
		}
		
		return -1;
	}
}