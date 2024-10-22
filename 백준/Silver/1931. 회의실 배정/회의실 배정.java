import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1.y == o2.y) return Integer.compare(o1.x, o2.x);
			else return Integer.compare(o1.y, o2.y);
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pq.add(new Point(start, end));
		}
		
		int tot = 0;
		int lastEnd = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(lastEnd <= p.x) {
				lastEnd = p.y;
				tot++;
			}
		}
		
		System.out.println(tot);
	}
}