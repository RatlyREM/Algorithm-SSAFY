import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
	static class Wo {
		String a;
		int b;
		
		public Wo(String a, int b) {
			// TODO Auto-generated constructor stub
			this.a = a;
			this.b = b;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			if(temp.length() < M) continue;
			
			if(hm.containsKey(temp)) {
				hm.put(temp, hm.get(temp)+1);
			}
			else {
				hm.put(temp, 1);
			}
		}
		
		PriorityQueue<Wo> pq = new PriorityQueue<Wo>((o1, o2) -> {
			if(o1.b == o2.b) {
				if(o1.a.length() == o2.a.length()) {
					return (o1.a).compareTo(o2.a);
				}
				else {
					return o2.a.length()- o1.a.length();
				}
			}
			else {
				return o2.b- o1.b;
			}
			
		});
		
		for(String key: hm.keySet()) {
			pq.add(new Wo(key, hm.get(key)));
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll().a + "\n");
		}
		
		System.out.println(sb);
	}
}