import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 5 4 5 5
		 * 7 안됨!! -> 제일 가까운 안 고장난 수 찾기
		 * 
		 * 1. 100에서 +버튼 쭉 눌러서 이동
		 * 2. 100에서 -버튼 쭉 눌러서 이동
		 * 3. 
		 * 
		 * 우선 +-버튼을 최소한으로 눌러 갈 수 있게 근처까지 가야 함
		 * 1 -> 양쪽으로 각각 
		 * 1->2 2->3 ... 8-> 9
		 * 2-> 1 3->2 ... 9-> 8
		 * 
		 * 5467
		 * 5450
		 * 5470
		 * 
		 * 재귀로.
		 * 자릿수만큼 들어가다가, 만약 고장난 버튼이 있다면
		 * depth만큼 파고 들어간다.
		 * 파고 들어가다가 가능한 depth가 있다면,
		 * 2개 중 뭐가 최소인지도 판단해야 한다.
		 * 
		 */
		
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

		//5457이면, 10914까지 확인한다.
		//내부의 숫자들이 모두 고장난 숫자들이 아닌지.
		//모두 고장난 숫자들이 아니라면, 자릿수만큼 더한 후 확인
		//100에서 +-를 해서 더한것보다 작은지도 확인
		
		int minValue = Integer.MAX_VALUE;
		
		//N에서 0까지!!
		for (int i = N; i >= 0; i--) {
			String s = String.valueOf(i);
			int flag = 0;
			
			//내부 숫자가 모두 고장나지 않았는지
			for (int j = 0; j < s.length(); j++) {
				int temp = s.charAt(j) - '0';
				if(arr[temp] == 0) break;
				if(j == s.length()-1) {
					flag = 1;
				}
			}
			
			//고장나지 않았다면?
			if(flag == 1) {
				minValue = Math.min(minValue, (N-i)+s.length());
				break;
			}			
		}
		
		//N부터 N*2까지
		for (int i = N; i <= 2000000; i++) {
			String s = String.valueOf(i);
			int flag = 0;
			
			//내부 숫자가 모두 고장나지 않았는지
			for (int j = 0; j < s.length(); j++) {
				int temp = s.charAt(j) - '0';
				if(arr[temp] == 0) break;
				if(j == s.length()-1) {
					flag = 1;
				}
			}
			
			//고장나지 않았다면?
			if(flag == 1) {
				minValue = Math.min(minValue, (i-N)+s.length());
				break;
			}	
		}
		
		//100이랑도 어떤지 살펴보기
		minValue = Math.min(minValue, Math.abs(N-100));
		
		
		
		System.out.println(minValue);
		
	}

}