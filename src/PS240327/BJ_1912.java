package PS240327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * n-1번째의 max값과 현재 본인의 값을 비교.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer[] maxN = new Integer[n];
		maxN[0] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if((maxN[i-1]+ temp) > temp) {
				maxN[i] = (maxN[i-1]+ temp);
			}
			else {
				maxN[i] = temp;
			}
		}
		
		Arrays.sort(maxN,Collections.reverseOrder());
		System.out.println(maxN[0]);
	}
}
