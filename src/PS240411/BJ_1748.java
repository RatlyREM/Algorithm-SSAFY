package PS240411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1748 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int check = 9;
		int total = 0;
		int count = 1;
		
		while (true) {
			if(check > N) {
				//마지막 처리 필요
				total += N * count;
				break;
			}
			
			total += count*check;
			N -= check;

			check *=10;
			count++;	
			
		}
		
		System.out.println(total);
		
		
		
		
		
		
		
	}
}
