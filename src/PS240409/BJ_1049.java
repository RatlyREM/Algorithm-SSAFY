package PS240409;

import java.util.*;
import java.io.*;


public class BJ_1049 {
	public static void main(String[] args) throws IOException {
		/*
		 * 먼저 6xi + j 형태에서 i를 계속 늘려 나간다.
		 * 낱개일 때 제일 싼 가격과 묶음일 때 제일 싼 가격을 각각 알아둔다.
		 * 각각의 회차에서 i와 j에 가장 싼 가격을 넣어본다.
		 * 모든 회차에서의 최솟값을 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min6 = 10000;
		int min1 = 10000;
		int minTotal = 200000;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int six = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			
			if(min6 > six) min6 = six;
			if(min1 > one) min1 = one;
		}

		int count = 0;
		
		while(true) {
			int namo = N-6*count;
			int temp = count*min6;
			
			if(6*count > N) {
				if (temp < minTotal) {
					minTotal = temp;
				}
				break;
			}
			
			temp += min1*namo;
			
			if(temp < minTotal) {
				minTotal = temp;
			}
			
			count++;
		}
		
		System.out.println(minTotal);
	}
}
