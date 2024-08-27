import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 각 톱니바퀴를 리스트로 둔다.
		 * 
		 * 톱니바퀴를 회전시킬 때,
		 * 이전 톱니바퀴가 돌았다면 -> 마주본 면이 다르다면 -> 회전
		 * 						 마주본 면이 같다면 -> 회전 x
		 * 
		 * 안 돌았다면 -> 회전 x
		 * 
		 * 회전-> 반시계방향이면 앞에꺼 빼서 뒤에 넣기
		 * 		 시계방향이면 뒤에꺼 빼서 앞에 넣기
		 * 
		 * 오른쪽 맞닿는건 인덱스 2번. 왼쪽 맞닿는건 인덱스 6번.
		 * 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		List<List<Integer>> li = new ArrayList<>();
		
		//문자열 입력받고 리스트에 삽입
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			
			List<Integer> tempList = new ArrayList<>();
			
			for (int j = 0; j < str.length(); j++) {
				tempList.add(str.charAt(j)- '0');
			}
			
			li.add(tempList);
		}
		
		int K = Integer.parseInt(br.readLine());
				
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num= Integer.parseInt(st.nextToken());
			int ddir= Integer.parseInt(st.nextToken()); //1이 시계방향
			
			//num번 톱니바퀴에서 출발
			
			int dir = ddir*(-1);
			
			List<Point> turnList = new ArrayList<>();
			turnList.add(new Point(num-1, ddir));
			
			//왼쪽으로
			for (int j = num-1; j > 0; j--) {
				//j+1과 비교
				//나의 6번과, j-1의 2번을 비교 -> 다르면 j-1을 돌린다
				int flag = 0;
				
				if(li.get(j).get(6) != li.get(j-1).get(2)) {
					//왼쪽 회전 리스트에 추가
					turnList.add(new Point(j-1, dir));
					dir *= -1;
					flag = 1;
				}
				
				if(flag == 0) break;
			}
			
			
			dir = ddir*(-1);
			//오른쪽으로
			for (int j = num-1; j < li.size()-1; j++) {
				//j+1과 비교
				//나의 2번과, j+1의 6번을 비교 -> 다르면 j+1을 돌린다
				int flag = 0;
				
				if(li.get(j).get(2) != li.get(j+1).get(6)) {
					turnList.add(new Point(j+1, dir));
					dir *= -1;
					flag = 1;
				}
				
				if(flag == 0) break;
			}
			
			//있는거 회전시키기
			for (Point p: turnList) {
				if(p.y == -1) {
					//반시계 회전
					int temp = li.get(p.x).get(0);
					li.get(p.x).remove(0);
					li.get(p.x).add(temp);
				}
				else {
					//시계 회전
					int temp = li.get(p.x).get(7);
					li.get(p.x).remove(7);
					li.get(p.x).add(0, temp);
				}
			}
			
			turnList.clear();
		}

		int total = 0;
		
		for (List<Integer> l : li) {
			if(l.get(0) == 1) {
				total++;
			}
		}
		
		System.out.println(total);
	}
}