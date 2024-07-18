import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Medal {
		int num;
		int gold;
		int silver;
		int bronze;
		
		public Medal() {
			// TODO Auto-generated constructor stub
		}
		public Medal(int num, int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Medal> pq = new PriorityQueue<Medal>((o1, o2) -> {
			if(o1.gold != o2.gold) {
				return o2.gold- o1.gold;
			}
			else {
				if(o1.silver != o2.silver) {
					return o2.silver- o1.silver;
				}
				else {
					return o2.bronze- o1.bronze;
				}
			}
		});
		
		Medal target = new Medal();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Medal medal = new Medal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if(medal.num == K) {
				target = medal;
			}
			
			
			pq.add(medal);			
		}
		
		int ans = 1;
		while(!pq.isEmpty()) {
			Medal temp = pq.poll();
			
			if(target.gold == temp.gold && target.silver == temp.silver && target.bronze == temp.bronze) {
				break;
			}
			
			
			
			ans++;
		}
		
		
		System.out.println(ans);
		
	}
}