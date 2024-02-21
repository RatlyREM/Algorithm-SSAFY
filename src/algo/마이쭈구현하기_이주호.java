package algo;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쭈구현하기_이주호 {
	public static void main(String[] args) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		int N = 20; //총 보유한 마이쭈
		int person = 1;
		q.offer(new int[] {person, 1});
		
		while(N>0 && !q.isEmpty()) {
			int[] temp = q.poll();
			
			int availableCnt = (N>temp[1]) ? temp[1] : N;
			N-= availableCnt;
			
			//마지막에 가져간 사람?
			if(N==0) {
				System.out.println("마지막 마이쭈를 가져간 사원 "+temp[0]+" 가져간 개수: " + availableCnt);;
			} else {
				System.out.println(temp[0] + "번이 "+availableCnt + "개만큼 가져갑니다. 남은 수: " +N);
			
				//큐에 다시 넣기
				temp[1]++;
				q.offer(temp);
				q.offer(new int[] {++person, 1});
			}
		}
	}
}
