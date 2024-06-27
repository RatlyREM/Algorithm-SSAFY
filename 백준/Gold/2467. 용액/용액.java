import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> solution;
	static List<Integer> solution2;
	static int getMid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		solution = new ArrayList<Integer>();
		
		solution.add(0);
	
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			solution.add(temp);
		}
		
		//돌면서 이분탐색으로 찾기
		//절댓값이 최대한 작아야 함!!
		int minZero = Integer.MAX_VALUE;
		Point minPoint = new Point();
		
		solution2 = new ArrayList<Integer>(solution);
		
		for (int i = 1; i <= N ; i++) {
			//solution에서 해당 인덱스 빼기
			solution.remove(i);
			int solutionI = solution2.get(i);
			
			
			int temp = bs(1, N-1, (solutionI*(-1)));
			int a = Math.abs(solutionI + solution.get(temp));
			
			if(a < minZero) {
				minZero = a;
				minPoint = new Point(solutionI, solution.get(temp));
			}

			if(temp>1) {
				int b = Math.abs(solutionI + solution.get(temp-1));

				if(b < minZero) {
					minZero = b;
					minPoint = new Point(solutionI, solution.get(temp-1));
				}
			}
			solution.add(i, solutionI);
			
		}
		
		System.out.println(Integer.min(minPoint.x, minPoint.y) + " " + Integer.max(minPoint.x, minPoint.y));
	}
	
	static int bs(int start, int end, int value) {
		int mid = (start+end)/2;
		
		if(start >= end) {
			return mid;
		}
		
		if(solution.get(mid) == value) {
			return mid;
		}
		else if(solution.get(mid) < value) {
			return bs(mid+1, end, value);
		}
		else {
			return bs(start, mid, value);
		}
	}
}