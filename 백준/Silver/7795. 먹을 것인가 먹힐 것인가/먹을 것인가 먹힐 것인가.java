import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			
			int total = 0;
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			for (int j = 0; j < A.length; j++) {
				//A[j]마다 B에서 이진탐색
				//System.out.println(A[j] + "찾기");
				
				int left = 0;
				int right = B.length-1;
				
				while(left < right) {
					int mid = (left+right)/2;
					
					if(A[j] > B[mid]) {
						left = mid+1;
					}
					else {
						right = mid;
					}
				}
				
				if(right == M-1 && B[right] < A[j]) {
					total += right+1;
				}
				else {
					total += right;
				}
			}
			
			
			//System.out.println(Arrays.toString(A));
			//System.out.println(Arrays.toString(B));
			System.out.println(total);
			
			
			
			
		}
		
		
		
	}
}