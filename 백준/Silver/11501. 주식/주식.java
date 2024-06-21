import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * pq와 queue를 이용.
		 * 1. 먼저 pq와 일반 queue에 집어넣는다.(순서, 날 수)
		 * 2. 일반 queue에서 하나 빼고, pq에서도 뺀다.
		 * 3. pq에서 우선순위를 통해 제일 날 수가 높은걸 뺀다.
		 * 4. 뺀 수가 일반 큐에서 뺀 수보다 작다면, 판다.(팔 게 있으면)
		 * 5. 뺀 수가 일반 큐에서 뺀 수보다 크거나 같다면, 산다.
		 * 
		 * 6. 다 끝나면 이익을 계산한다.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			Queue<Point> q = new LinkedList<Point>();
			//PriorityQueue<Point> pq = new PriorityQueue<Point>((o1, o2) -> o2.y-o1.y);
			List<Integer> li = new ArrayList<Integer>();
			
			
			int N = Integer.parseInt(br.readLine());
			long total = 0L;
			int buy = 0;
			
			st = new StringTokenizer(br.readLine());
			
			
			
			for (int j = 0; j < N; j++) {
				Point temp = new Point(j,Integer.parseInt(st.nextToken())); 
				
				q.add(temp); 
				li.add(temp.y);
			}
			
			int[] behindMax = new int[N];
			
			int count = 0;
			
//			while(!pq.isEmpty()) {
//				Point temp = pq.poll();
//				
//				behindMax[count] = temp.y;
//				
//				count++;
//			}
			
			int max = li.get(N-1);
			
			for (int j = N-1; j >=0 ; j--) {
				if(max < li.get(j)) max = li.get(j);
				
				behindMax[j] = max;
				
			}
			
			
			count = 0;
			while(!q.isEmpty()) {
				Point a = q.poll();
				
				//System.out.println(q.size() + " " + pq.size());
				
				//if(q.isEmpty() ) break;
				int b = (count>= N) ? a.y : behindMax[count];
				
				//System.out.println("a:" +a.x + " " + a.y + " b: " + b);
				
				if(a.y >= b) {
					//팔기
					//System.out.println("팔기!");
					total += buy * a.y;
					buy = 0;
				}
				else {
					//사기
					//System.out.println("사기!");
					total -= a.y;
					buy++;
				}
				
				//System.out.println("현재 이득: " + total);
				count++;
			}
			
			
			
			System.out.println(total);
			//System.out.println();
		}
		
		
	}
}