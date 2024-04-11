package PS240403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.*;

public class BJ_1019 {
	static HashMap<Long, long[]> hh;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		long temp = 1;
		long n = N;
		
		long[] result = new long[10];
		
		long[] answer= new long[10];
		
		//hh = new HashMap<Long, long[]>();
		
//		while(n >0) {
//			for (int i = 0; i < 10; i++) {
//				answer[i] += (n/10)*temp;
//			}
//			
//			for (int i = 0; i < n%10; i++) {
//				answer[i] += temp;
//			}
//			
//			answer[(int) (n%10)] += (N%temp+1);
//			
//			answer[0] -= temp;
//			temp *=10;
//			n/=10;
//		}
		
		

		
		result = F(N);
		result[0]--;
		
		for(long i: result) {
			System.out.print(i + " ");
		}
	}
	
	
	
	
	static long[] F(long n) {
		long[] temp= new long[10];
		
		System.out.println(n + "호출됨!!!");
		if(n < 10) {
			for (int i = 0; i <= n; i++) {
				temp[i] = 1;
			}
			
			hh.put(n, temp);
			
			return temp;
		}
		
		//v가 100이고 0이 101~109, 201~209... 901~909 등에 1개씩 들어가야 함.
		//v가 1000일 때, 1000~1099, 1100~ 1209
		//1~99 
		long v = V(n);
		long[] resultF, resultG;
		
		if(hh.containsKey(n-1-n%v)) {
			resultF = hh.get(n-1-n%v);
		}
		else {
			resultF = F(n-1-n%v);
		}
		
		if(hh.containsKey(n%v)) {
			resultG = hh.get(n%v);
		}
		else {
			resultG = F(n%v);
		}
		

		//long[] resultF = F(n-1-n%v); //지금까지 0~9를 몇번 해야 하는지.
		//long[] resultG = F(n%v); //현재 자릿수에서 어디까지 가야 하는지.
		
		System.out.println((n%v) + " 나타남" + v/10 + "응응");
		
		//v로 나눴을 때 나머지가 10 이하라면 0 추가해야 함.
		
		
		System.out.println("결과는: " + (n%v +1));
		
		//몇자리수인지 판단하고, for문으로 뺄 수 만들기
		long tempCount = v;
		long count = 0;
		
		while(tempCount != 0) {
			count++;
			tempCount /= 10;
		}
		
		long k = 1;
		long total = 0;
		
		for (int i = 0; i <= count; i++) {
			total +=k;
			k *= 10;
		}
		
		

		System.out.println("점검1: " + temp[0]);
		
		for (int i = 0; i < 10; i++) {	
			temp[i] += resultF[i] + resultG[i];
		}
		
		System.out.println("점검2: " + temp[0]);
		
		temp[(int) (n/v)] += (n%v+1);
		
		System.out.println(n+"의 temp 배열: " + v + " 가 v");
		System.out.println(Arrays.toString(temp));
		
		//temp[0]--;
		//long resultK = (n/v) * (n%v); //제일 왼쪽 자릿수를 몇 번 더해야 하는지.
		
		hh.put(n, temp);
		
		return temp;
	}
	
	
	static long V(long v) {
		long temp = 1;

		while(v>= 10) {
			temp *=10;
			v/=10;
		}
		
		return temp;
	}
}
