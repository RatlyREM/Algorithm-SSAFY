import java.io.*;
import java.util.*;

public class Main {
	static int N,K,P,X;
	static List<Integer> led;
	static String realX;
	static String resultLED;
	static List<Integer> resultList;
	
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
		resultList = new ArrayList<Integer>();
		
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
		
		
//		for(int i: resultList) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		System.out.println(resultList.size());
	}
	
	static void perm(int depth, int total) {
		if(total > P) return;
		if(depth == K && total == 0) return;
		if(depth== K && total > P) return;
		
		if(depth == K && total <= P) {
			//끝
			
//			for(int a : led) System.out.print(a + " ");
//			System.out.println();
			
			resultLED= "";
			//첫 자리에서 돌다가 만나면, 그대로 다음 자리로. 끝 자리까지 완료되면 1이상 N이하인지 확인
			makeLED(0);
			
			
//			int total2 = 0;
//			
//			String tempX = "";
//			
//			for (int i = 0; i < K; i++) {
//				int temp = realX.charAt(i)- '0';
//				int count = led.get(i);
//				int c = 0;
//				boolean flag = false;
//				
//				//다르게 바꿨는데 같은 수가 돼버릴 가능성?
//				for (int j = 0; j < 10; j++) {
//					if(change[temp][j] == count) {
//						tempX += Integer.toString(j);
//						c++;
//						flag = true;
//					}
//				}
//				
//				if(flag == false) return;
//				
//				if(total2 == 0) total2 += c;
//				else total2 *= c;
//				
//			}
//			
//			System.out.println(total2 + " 가지 나옴!!");
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
			//System.out.println("결과: " + resultLED);
			int temp = Integer.parseInt(resultLED);
			
			if(temp >=1 && temp<= N) {
				resultList.add(temp);
			}
			
			return;
		}
		
		int temp = realX.charAt(now)- '0';
		int count = led.get(now);
		boolean flag = false;
		
		for (int i = 0; i < 10; i++) {
			if(change[temp][i] == count) {
				resultLED += Integer.toString(i);
				
				//System.out.println(resultLED + " " + (now+1));
				makeLED(now+1);
				
				resultLED = resultLED.substring(0, resultLED.length()-1);
				
				flag = true;
			}
			
		}
		
		if(flag == false) return;
	}
}