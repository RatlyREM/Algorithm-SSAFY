import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] LIS;
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 제대로 잘 서 있는 아이들의 사이사이에 끼워넣어야 하는 느낌.
		 * 이분탐색으로 LIS를 찾는다.
		 * 
		 * 1. 입력받고 배열에 아이들 번호를 넣는다.
		 * 2. 배열을 순회하기 시작. 초기 세팅으로 0번째 인덱스를 넣어둔다.
		 * 3. 만약 LIS배열의 마지막 요소보다 현재 인덱스가 더 크다면, 그냥 삽입
		 * 4. 마지막 요소보다 현재 인덱스가 더 작다면, 이분 탐색을 통해 들어갈 자리 찾기
		 * 5. 순회가 끝났으면, 기존 배열의 길이에서 찾은 LIS 배열의 크기를 빼면 답이다.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		LIS = new int[N];
		int cur = 0; //LIS 배열의 현재 채워진 위치
		
		//입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		LIS[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			
			
			if(LIS[cur] <= arr[i]) {
				LIS[cur+1] = arr[i];
				cur++;
			}
			else {
				//들어갈 자리 찾기
				int seki = bs(0, cur, arr[i]);
				
				//System.out.println(seki + "돌아옴");
				LIS[seki] = arr[i];	
				
			}
			
			//System.out.println(Arrays.toString(LIS));
		}
		
		System.out.println(N- (cur+1));
	}
	
	
	static int bs(int start, int end, int val) {
		
		int mid = (start+end)/2;
		
		//System.out.println(start + " " + end + " " + mid);
		
		if(start >= end) {
			if(LIS[start] < val) return start+1;
			else return start;
		}
		else {
			if(val < LIS[mid]) {
				return bs(start, mid, val);
			}
			else if(val > LIS[mid]) {
				return bs(mid+1, end, val);
			}
		}
		
		
		
		return -1;
	}
}