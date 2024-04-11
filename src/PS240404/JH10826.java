package PS240404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JH10826 {
	static String[] PiboTable;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PiboTable = new String[10001];
		
		String r = Pibo(n);
		
		for (int i = r.length()-1; i >= 0; i--) {
			sb.append(r.charAt(i));
		}
		
		System.out.println(sb);
	}
	
	static String Pibo(int n) {
		if(n==0) return "0";
		if(n==1) return "1";
		
		StringBuilder sb = new StringBuilder();
		
		String aL= (PiboTable[n-1] != null) ? PiboTable[n-1] : Pibo(n-1);
		String bL= (PiboTable[n-2] != null) ? PiboTable[n-2] : Pibo(n-2);

		int sup = 0;
		for (int i = 0; i < Math.max(aL.length(), bL.length()); i++) {
			int temp;
			
			if(aL.length()-1 < i) {
				temp = (int)bL.charAt(i)-'0' + sup;
			}
			else if(bL.length()-1 <i) {
				temp = (int)aL.charAt(i)-'0' + sup;
			}
			else {
				temp = (int)aL.charAt(i)-'0' + (int)bL.charAt(i)-'0' + sup;
			}
			
			
			sup = temp/10;
			sb.append(temp%10);
		}
		
		
		if(sup != 0) {
			sb.append(sup);
		}
		PiboTable[n] = sb.toString();

		return PiboTable[n];
	}
}
