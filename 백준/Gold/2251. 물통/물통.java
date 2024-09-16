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
		
		HashSet<Integer> hs = new HashSet<>();
		
		visited = new int[A+1][B+1][C+1];
		q = new LinkedList<>();
		
		q.add(new Miz(0,0,C));
		visited[0][0][C] = 1;
		
		while(!q.isEmpty()) {
			Miz temp = q.poll();
			int a = temp.x;
			int b = temp.y;
			int c = temp.z;
			
			if(a==0) {
				if(!hs.contains(c)) hs.add(c);
			}
			
			//A->B
			Point p = change(a,b,B);
			goBFS(p.x, p.y, c);

			//A-> C
			p = change(a,c, C);
			goBFS(p.x, b, p.y);
			
			//B->A
			p = change(b,a,A);
			goBFS(p.y, p.x, c);
			
			//B->C
			p = change(b,c,C);
			goBFS(a, p.x, p.y);
			
			//C->A
			p = change(c,a,A);
			goBFS(p.y, b, p.x);
			
			//C->B
			p = change(c,b,B);
			goBFS(a, p.y, p.x);
		}
		
		List<Integer> li = new ArrayList<>(hs);
		Collections.sort(li);
		for(int i: li) System.out.print(i + " ");
	}
	
	static void goBFS(int r, int w, int e) {
		if(visited[r][w][e] == 0) {
			visited[r][w][e] = 1;
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