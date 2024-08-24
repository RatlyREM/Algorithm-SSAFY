import java.io.*;
import java.util.*;

public class Main {
	static int minValue = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//내부의 숫자들이 모두 고장난 숫자들이 아닌지.
		//모두 고장난 숫자들이 아니라면, 자릿수만큼 더한 후 확인
		//100에서 +-를 해서 더한것보다 작은지도 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
		Arrays.fill(arr, 1);
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			//고장난 버튼이면 0
			for (int i = 0; i < M; i++) {
				arr[Integer.parseInt(st.nextToken())] = 0;
			}
		}

		//N에서 0까지!!
		for (int i = N; i >= 0; i--) {
			String s = String.valueOf(i);
			
			//고장나지 않았다면?
			if(checkChannel(arr, i, N,s) == 1) {
				minValue = Math.min(minValue, (N-i)+s.length());
				break;
			}			
		}
		
		//N부터 N*2까지
		for (int i = N; i <= 2000000; i++) {
			String s = String.valueOf(i);
			
			//고장나지 않았다면?
			if(checkChannel(arr, i, N, s) == 1) {
				minValue = Math.min(minValue, (i-N)+s.length());
				break;
			}
		}
		
		//100이랑도 어떤지 살펴보기
		minValue = Math.min(minValue, Math.abs(N-100));
		System.out.println(minValue);
		
	}
	
	public static int checkChannel(int[] arr, int i, int N, String s) {
		int flag = 0;
		
		//내부 숫자가 모두 고장나지 않았는지
		for (int j = 0; j < s.length(); j++) {
			int temp = s.charAt(j) - '0';
			if(arr[temp] == 0) break;
			if(j == s.length()-1) {
				flag = 1;
			}
		}
		
		return flag;	
	}

}