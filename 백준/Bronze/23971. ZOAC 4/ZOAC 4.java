import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1칸씩 띄우면 1,3,5 ...
		 * 2칸씩 띄우면 1,4,7,10 ...
		 * 1부터 2, 2, 2... 가는거고(1칸 띄우면)
		 * 1부터 3, 3, 3... 가는거 (2칸 띄우면)
		 * 
		 * 1 + (n +1)*k <= N 인 k 찾기.
		 * 
		 *  k <= (N-1)/ (n+1) -> 2칸 -> +1
		 *  
		 *  3/2 -> 1칸 -> +1
		 */
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(((H-1)/(N+1) +1) * ((W-1)/(M+1) + 1));
		
		
		
		
		
		
		
	}
}