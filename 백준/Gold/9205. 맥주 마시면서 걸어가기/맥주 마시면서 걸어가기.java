import java.util.*;
import java.io.*;
import java.awt.*;


public class Main {
	static int[][] far;
	static Point[] xy;
	static int[] visited;
	static int n;
	static String result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 각각 입력을 진행하면서, nxn 배열에 서로간의 거리를 삽입한다.
		 * 		1-1: 거리가 1000을 넘어간다면, 길이 없는 것으로 한다.
		 * 2. 그리고 root에서 BFS를 돌리면서 도착지까지 갈 수 있는 길이 있는지 확인한다!!
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			
			//거리 배열
			far = new int[n+2][n+2];
			xy = new Point[n+2];
			visited = new int[n+2];
			result = "sad";
			
			for (int j = 0; j < n+2; j++) {
				st = new StringTokenizer(br.readLine());
				
				xy[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				//앞까지의 거리 탐색
				for (int k = 0; k < j; k++) {
					int len = Math.abs(xy[j].x-xy[k].x) + Math.abs(xy[j].y-xy[k].y);
					
					if(len <= 1000) {
						far[j][k] = len;
						far[k][j] = len;
					}
				}
			}
			
//			for (int j = 0; j < n+2; j++) {
//				for (int k = 0; k < n+2; k++) {
//					System.out.print(far[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			//root부터 bfs 시작
			bfs();
			
			System.out.println(result);
		}
	}
	
	
	static void bfs() {
		Queue<Integer> q= new LinkedList<Integer>();
		
		q.add(0);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == (n+1)) result = "happy";
			
			for (int i = 0; i < n+2; i++) {
				if(visited[i] == 0) { //아직 방문 안 했고
					if(far[temp][i] != 0) { //거리가 존재한다면
						visited[i] = 1;
						q.add(i);
					}
				}
			}
		}
		
	
		
		
		
		
	}
}