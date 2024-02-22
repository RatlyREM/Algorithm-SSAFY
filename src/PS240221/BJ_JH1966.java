package PS240221;

import java.io.*;
import java.util.*;
import java.awt.*;

public class BJ_JH1966 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 먼저 큐에 <중요도, 번호> 순서대로 N개만큼 삽입한다.
		 * 2. 맨 앞에껄 빼내보고, 큐를 iterator로 탐색하며
		 * 3. if 가중치가 자기보다 큰 값이 있다면
		 * 		3-1. 맨 뒤에 다시 삽입.
		 * 	  else
		 * 		3-2. 출력 count를 증가시키고, M과 해당 문서 번호가 동일하다면 count 출력
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			Queue<Point> q = new LinkedList<Point>();
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < num; j++) {
				Point temp = new Point();
				temp.x = Integer.parseInt(st.nextToken());
				temp.y = j;
				
				q.add(temp);
			}
			
			int count = 0;
			
			while(true) {	
				Point p = q.poll();

				int insertFlag = 0;

				for(Point temp : q) {
					if(p.x < temp.x) {
						q.add(p);
						insertFlag = 1;
						break;
					}
				}
				
				if(insertFlag == 0) {
					count++;
					
					if(index == p.y) {
						System.out.println(count);
						break;
					}
				}
			}
			
			q.clear();
		}	
	}
}
