import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//그리디?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> bank = new ArrayList<>();
		
		for (int i = 1; i < N+1; i++) {
			bank.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(bank);
		
		int[] nu = new int[N];
		
		nu[0] = bank.get(0);
		int total = nu[0];
		
		for (int i = 1; i < N; i++) {
			nu[i] = nu[i-1] + bank.get(i);
			total += nu[i];
		}
		
		//System.out.println(Arrays.toString(nu));
		
		System.out.println(total);
		
		
	}
}