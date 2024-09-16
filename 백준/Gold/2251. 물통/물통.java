import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static Queue<Miz> q;
	static int[][][] visited;
	
	static class Miz {
		int x;
		int y;
		int z;
		
		public Miz(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*
		 * 물통의 각 무게를 노드로 생각.
		 * 물을 이동시킬 수 있는 경우의 수를 간선으로.
		 */
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		List<Integer> li = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		
		visited = new int[A+1][B+1][C+1];
		q = new LinkedList<>();
		
		q.add(new Miz(0,0,C));
		visited[0][0][C] = 1;
		
		while(!q.isEmpty()) {

			//System.out.println(q);
			
			Miz temp = q.poll();
			//System.out.println("temp: " + temp.x + " " + temp.y + " " + temp.z);
			int a = temp.x;
			int b = temp.y;
			int c = temp.z;
			
			
			if(a== 0) {
//				if(!hs.contains(c)) {
//					hs.add(c);
//				}
				
				if(!li.contains(c)) li.add(c);
				
			}
			
			//A->B
			Point p = change(a,b,B);
			//System.out.println(p.x + " " + p.y + " "+ c);
			goBFS(p.x, p.y, c);

			//A-> C
			p = change(a,c, C);
			//System.out.println(p.x + " " +b + " "+ p.y);
			
			goBFS(p.x, b, p.y);
			
			//B->A
			p = change(b,a,A);
			//System.out.println(p.y + " " + p.x + " "+ c);
			
			goBFS(p.y, p.x, c);
			
			//B->C
			p = change(b,c,C);
			//System.out.println(a + " " + p.x + " "+ p.y);
			
			goBFS(a, p.x, p.y);
			
			//C->A
			p = change(c,a,A);
			//System.out.println(p.y + " " +b + " "+ p.x);
			
			goBFS(p.y, b, p.x);
			
			//C->B
			p = change(c,b,B);
			//System.out.println(a + " " + p.y + " "+ p.x);
			
			goBFS(a, p.y, p.x);
			
			//다 붓되, 용량 초과 시 남은 건 출발지에 남김
			//(출발지 상태, 도착지 상태, 도착지 최대)
		}
		
		Collections.sort(li);
		for(int i: li) System.out.print(i + " ");
	}
	
	static void goBFS(int r, int w, int e) {
		if(visited[r][w][e] == 0) {
			visited[r][w][e] = 1;
			//System.out.println(r + " " + w + " " + e + "추가!!");
			q.add(new Miz(r,w,e));
		}
	}
	
	
	static Point change(int x, int y, int Z) {
		if(x+y <= Z) {
			y = x+y;
			x=0;
		}
		else {
			x= x- (Z-y);
			y= Z;
		}
		
		return new Point(x,y);
	}
}