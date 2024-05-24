import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		int[] ott = new int[10001];
		int[] two = new int[10001];
		int[] three= new int[10001];
		
		ott[1] = 1;
		ott[2] = 2;
		ott[3] = 3;
		
		two[2]= 1;
		two[3] = 1;
		three[3] = 1;
		
		
		for (int j = 4; j <= 10000; j++) {
			//먼저 +1 붙이면 되는것들부터 처리
			ott[j] += ott[j-1];
			
			if(j==5) {
				two[j] = 1;
				ott[j] += 1;
			}
			else {
				//2,3으로만 이루어진 부분 처리
				two[j] = two[j-2] + three[j-2];
				ott[j] += two[j];
			}
		
			
			three[j] = three[j-3];
			ott[j] += three[j];
			
			//System.out.println(j + " : " + ott[j] + " : " + two[j] + " " + three[j]);
		}
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			
			System.out.println(ott[n]);
			
		}
	}
}