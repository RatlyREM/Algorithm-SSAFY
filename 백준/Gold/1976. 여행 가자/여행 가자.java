import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 1. 그래프를 인접 행렬 식으로 저장한다.
		 * 2. 1 -> 2-> 3이 여행 경로라면..
		 * 	1-> 2가 가능한지 확인해야 한다!!(BFS로 확인)
		 * 	2-> 3 확인. 이렇게 모든 경로가 가능하면 YES!!
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] edge = new int[N+1][N+1];
		int[] visited = new int[N+1];
		
		int[] route = new int[M];
		
		//그래프의 간선 삽입
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				edge[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			route[i]= Integer.parseInt(st.nextToken());
		}
		
		int count = 1;
		String ans = "YES";
		
		//경로가 존재하는지 확인!!
		while(count < M) {
			int start = route[count-1];
			int end = route[count];
			
			if(start == end) {
				count++;
				
				continue;
			}
			//start~end로의 경로가 존재하는지 BFS로
			
			//System.out.println(start+ "와 " + end + "사이의 BFS 시작!!");
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			visited[start] = 1;
			
			int flag = 0;
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				
				//System.out.println(temp + "에 대해 조사");
				
				for (int i = 1; i <= N; i++) {
					if(edge[temp][i] == 1) {
						if(visited[i] == 0) {
							//System.out.println(i + "가 근처에 존재, visited 완료!!");
							
							
							visited[i] = 1;
							q.add(i);
							
							//경로 존재함
							if(i == end) {
								//System.out.println("경로 존재하므로 탈출");
								flag = 1;
								break;
							}
						}
					}
					
				}
				
				
				if(flag == 1) {
					//System.out.println("진짜 탈출");
					q.clear();
					break;
				}
			}
			
			Arrays.fill(visited, 0);
			
			if(flag == 0) {
				ans = "NO";
				break;
			}
			
//			if((count+1) == M) {
//				if(flag == 1) {
//					ans = "YES";
//					break;
//				}
//			}
			
			count++;
		}
		
		
		System.out.println(ans);
	}
}