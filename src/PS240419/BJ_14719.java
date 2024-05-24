package PS240419;

import java.io.*;
import java.util.*;

public class BJ_14719 {
	static int startIndex, start, water;
	static int[] height, height2;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 왼쪽에서 오른쪽, 오른쪽에서 왼쪽 의 총 2회 반복을 수행한다.
		 * 2. 스타트 높이에서 시작해서, 점점 가다가 같거나 높은 높이를 만나면 멈춘다.
		 * 		2-1. 멈췄으면, 가능한 빈 칸의 개수를 세고 더한다.
		 * 3. 빈 칸 처리가 끝났다면, 부딪힌 칸의 높이부터 다시 출발한다.
		 * 4. 만약에 범위가 끝났는데 아직 부딪히지 않았다면, 종료한다.
		 * 		4-1. 이를 반복한다.
		 */
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		//높이 입력
		st = new StringTokenizer(br.readLine());
		
		height = new int[W];
		height2 = new int[W];
		
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			height2[W-i-1] = height[i];
		}
		
		start = height[0];
		startIndex = 0;
		
		int count = 1;
		water = 0;
		
		//왼쪽부터 출발
		while(count < W) {
			//스타트 높이에서 시작
			if(start <= height[count]) {
				//가능한 빈 칸의 수 세기
				check(height, count);
			}
			
			count++;
		}
		
		start = height2[0];
		startIndex = 0;
		count = 1;
		
		//오른쪽으로 출발
		while(count < W) {
			if(start < height2[count]) {
				check(height2, count);
			}
			count++;
		}
		
		System.out.println(water);
	}
	
	
	static void check(int[] height, int count) {
		for (int i = startIndex+1; i < count; i++) {
			water += start - height[i];
		}
		start = height[count];
		startIndex = count;
	}
}
