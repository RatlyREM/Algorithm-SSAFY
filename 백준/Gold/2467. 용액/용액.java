import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	//static List<Integer> solution;
	//static List<Integer> solution2;
	static Long[] solution;
	static int getMid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//solution = new ArrayList<Integer>();
		solution = new Long[N];
		//solution.add(0);
	
		for (int i = 0; i < N; i++) {
			solution[i] = Long.parseLong(st.nextToken());
			//solution.add(temp);
		}
		
		//돌면서 이분탐색으로 찾기
		//절댓값이 최대한 작아야 함!!
		long minZero = Long.MAX_VALUE;
		int mi=0, mr =0;
		//solution2 = new ArrayList<Integer>(solution);
		
		for (int i = 0; i < N-1; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left <= right) {
				int mid = (left+right)/2;
				long sum = Math.abs(solution[i] + solution[mid]);
				
				if(sum < minZero) {
					minZero = sum;
					mi = i;
					mr = mid;
				}
				
				if(solution[mid] >= -solution[i]) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
		}
		
		
		System.out.println(solution[Integer.min(mi,mr)] + " " + solution[Integer.max(mi,mr)]);
	}
	
	static int bs(int start, int end, long value) {
		int mid = (start+end)/2;
		
		if(start >= end) {
			return mid;
		}
		
		if(solution[mid] == value) {
			return mid;
		}
		else if(solution[mid] < value) {
			return bs(mid+1, end, value);
		}
		else {
			return bs(start, mid, value);
		}
	}
}