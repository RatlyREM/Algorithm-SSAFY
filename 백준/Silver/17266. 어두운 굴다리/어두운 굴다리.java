import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int temp = Integer.parseInt(st.nextToken());
		int maxVal = temp;
		int b = temp;
		
		for (int i = 0; i < M-1; i++) {
			b = Integer.parseInt(st.nextToken());
			double c = Math.ceil((double)(b-temp)/2);
			
			temp = b;
			
			//System.out.println("c"+ c);
			maxVal = Math.max(maxVal, (int)c);
		}
		
		maxVal = Math.max(maxVal, N-b);
		
		System.out.println(maxVal);
		
		
	}
}