import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		int[] visited = new int[F+1];
		q.add(S);
		int depth = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for (int i = 0; i < qSize; i++) {
				int temp = q.poll();
				
				if(temp == G) {
					System.out.println(depth);
					System.exit(0);
				}
				
				int u = temp+ U;
				int d = temp- D;
				
				//up
				if(u > 0 && u <= F) {
					if(visited[u] == 0) {
						visited[u] = 1;
						q.add(u);
					}
				}
				
				//down
				if(d > 0 && d <= F) {
					if(visited[d] == 0) {
						visited[d] = 1;
						q.add(d);
					}
				}
			}
			
			depth++;
		}
		
		
		System.out.println("use the stairs");
	}
}