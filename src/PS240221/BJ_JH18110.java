package PS240221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_JH18110 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. n만큼 사람들의 난이도 개수 의견을 입력받는다.
		 * 		1-1. 입력받은 난이도를 sort한다.
		 * 2. n명의 15%를 구하고 반올림한다. 이 숫자만큼 위아래에서 자른다.
		 * 3. 범위에 포함되는 난이도를 순회하며 평균을 구한다.
		 * 4. 구한 평균을 반올림하여 절사평균을 결정한다.
		 * 
		 */
		
		//1. n만큼 사람들의 난이도 개수 의견을 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nanido = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			nanido[i] = temp;
		}
		
		//1-1. 입력받은 난이도를 sort한다.
		Arrays.sort(nanido);
		
		//2. n명의 15%를 구하고 반올림한다. 이 숫자만큼 위아래에서 자른다
		double nan_15 = n * 0.15;
		
		int total = 0;
		
		for (int i = (int)Math.round(nan_15); i < n-Math.round(nan_15); i++) {
			//3. 범위에 포함되는 난이도를 순회하며 평균을 구한다.
			total += nanido[i];
		}
		
		double temp = (1.0)*total / (n-2 * Math.round(nan_15));
		
		//System.out.println(total +" " + temp);
		
		System.out.println(Math.round(temp));

	}
}
