import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	//static int[] solution;
	static List<Integer> solution;
	static List<Integer> solution2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//solution = new int[N+1];
		solution = new ArrayList<Integer>();
		solution2 = new ArrayList<Integer>();
		
		solution.add(0);
		solution2.add(0);
		
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			solution.add(temp);
			solution2.add(temp);
			
			//solution[i] = Integer.parseInt(st.nextToken());
		}
		
		//돌면서 이분탐색으로 찾기
		//절댓값이 최대한 작아야 함!!
		int minZero = Integer.MAX_VALUE;
		Point minPoint = new Point();
		
		
		for (int i = 1; i <= N ; i++) {
			//System.out.println(solution[i] + "시  작");
			//solution에서 해당 인덱스 빼기
			solution.remove(i);
			
			int temp = bs(1, N-1, (solution2.get(i)*(-1)));
			
			
			//temp랑 temp-1의 solution을 검사할거임.
			//만약 temp가 i와 동일하다면, temp-1(temp>1)과 temp-2(temp>2)를 검사.
			//만약 temp-1이 i와 동일하다면, temp와 temp-2를 검사.
			//아무것도 동일하지 않다면, temp와 temp-1을 검사.
			
			//System.out.println(solution.get(temp) + "검사!!");
			
			int a = solution2.get(i) + solution.get(temp);
			
			//System.out.println(Math.abs(a)  + "절댓값 나옴");
			
			if(Math.abs(a) < minZero) {
				minZero = Math.abs(a);
				minPoint = new Point(solution2.get(i), solution.get(temp));
			}
			
			
			
			
			if(temp>1) {
				//System.out.println(solution.get(temp-1) + "검사!!");
				
				int b = solution2.get(i) + solution.get(temp-1);
				//System.out.println(Math.abs(b)  + "절댓값 나옴");
				
				if(Math.abs(b) < minZero) {
					minZero = Math.abs(b);
					minPoint = new Point(solution2.get(i), solution.get(temp-1));
				}
			}

			
			//System.out.println(solution.get(temp));
			
			solution.add(i, solution2.get(i));
			
		}
		
		System.out.println(Integer.min(minPoint.x, minPoint.y) + " " + Integer.max(minPoint.x, minPoint.y));
		
		
		
		
		
	}
	
	static int bs(int start, int end, int value) {
		int mid = (start+end)/2;
		//System.out.println(start + " " + end + " " + mid);
		if(start >= end) {
			//solution[mid]가 무조건 더 큰게 올듯?
			return mid;
		}
		
//		if(solution.get(mid) == value) {
//			return mid;
//		}
		if(solution.get(mid) <= value) {
			//System.out.println("오른쪽~");
			return bs(mid+1, end, value);
		}
		else if(solution.get(mid) > value){
			//System.out.println("왼쪽~");
			return bs(start, mid, value);
		}
		
		return -1;
	}
}