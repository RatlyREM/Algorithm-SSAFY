import java.io.*;
import java.util.*;

public class Main {
	static int N,K,P,X;
	static List<Integer> led;
	static String realX;
	//static String resultLED;
	//static List<Integer> resultList;
	static StringBuilder sb;
	static int totalCount = 0;
	
	static int[][] change = {{0, 4, 3, 3, 4, 3, 2, 3, 1, 2,},
			{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
			{3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
			{3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
			{4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
			{3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
			{2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
			{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
			{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
			{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		led = new ArrayList<Integer>();
		//resultList = new ArrayList<Integer>();
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		//자릿수 앞에 0 붙이기
		realX = Integer.toString(X);
		int zeroSize = K-realX.length();
	
		for (int i = 0; i < zeroSize; i++) {
			realX = "0" + realX;
		}
		
		perm(0, 0);
		
		//System.out.println(resultList.size());
		System.out.println(totalCount);
	}
	
	static void perm(int depth, int total) {
		if(total > P) return;
		if(depth == K && total == 0) return;
		if(depth== K && total > P) return;
		
		if(depth == K && total <= P) {
			//resultLED= "";
			//첫 자리에서 돌다가 만나면, 그대로 다음 자리로. 끝 자리까지 완료되면 1이상 N이하인지 확인
			makeLED(0);

			return;
		}
		
		for (int i = 0; i <= 7; i++) {
			led.add(i);
			
			perm(depth+1, total+i);
			
			led.remove(led.size()-1);
		}
	}
	
	static void makeLED(int now) {
		if(now == K) {
			//숫자 완성
			//int temp = Integer.parseInt(resultLED);
			
			int temp = Integer.parseInt(String.valueOf(sb));
			
			if(temp >=1 && temp<= N) {
				//resultList.add(temp);
				totalCount++;
			}
			
			return;
		}
		
		int temp = realX.charAt(now)- '0';
		int count = led.get(now);
		
		for (int i = 0; i < 10; i++) {
			if(change[temp][i] == count) {
				//resultLED += Integer.toString(i);
				sb.append(i);
				
				makeLED(now+1);
			
				sb.deleteCharAt(sb.length()-1);
				
				//resultLED = resultLED.substring(0, resultLED.length()-1);
			}
			
		}
	}
}