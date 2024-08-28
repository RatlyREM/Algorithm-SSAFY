import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Integer>[] city = new List[N+1];
		
		for (int i = 0; i < city.length; i++) {
			city[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			city[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		int[] minArr = new int[N+1];
		Arrays.fill(minArr, Integer.MAX_VALUE);
		
		minArr[X] = 0;
		
		//pq에서 X로부터의 최단 거리가 가장 작은 것부터 차례로 뽑아낸다.
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(minArr[o1], minArr[o2]));

		
		pq.add(X);
		
		while(!pq.isEmpty()) {
			int temp = pq.poll();	
				
			//연결되어 있는 정점이라면 기존 정점보다 작다면 업데이트
			for (int i = 0; i < city[temp].size(); i++) {
				if(minArr[city[temp].get(i)] > minArr[temp] +1) {
					minArr[city[temp].get(i)] = minArr[temp] +1;
					pq.offer(city[temp].get(i));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if(minArr[i] == K) {
				sb.append(i + "\n");
			}
		}
		
		if(sb.toString().equals("")) {
			System.out.println(-1);
		}
		else {
			System.out.println(sb);
		}
	}
}