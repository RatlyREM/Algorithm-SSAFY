import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] pm;
	static char[] giho = {' ', '+', '-'};
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			pm = new char[N-1];
			
			comb(0, N);
			//System.out.println(count);
			System.out.println();
			
		}
		
		
		
		
		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++) {
//					System.out.println(giho[i] + " " + giho[j] + " " + giho[k]);
//				}
//			}
//		}
		
	}
	
	
	static void comb(int now, int end) {
		if(now == end-1) {
	//		System.out.println(Arrays.toString(pm));
//			count++;
			
			StringBuilder sb = new StringBuilder();
			
			sb.append('1');

			int next = 2;

			for(char c : pm) {
//				if(c != ' ') {
//					sb.append(c);
//				}
				
				sb.append(c);
				sb.append(next);
				next++;
			}
			
			//System.out.println(sb);
			//연산자가 등장하거나 끝났다면, 연산 진행 
			int result = 0;
			String nowArr =""; 
			char oper = '+';
			
			for (int i = 0; i < sb.length(); i++) {
				//System.out.println("nowArr: " + nowArr + " charAt: " + sb.charAt(i) + " result: " + result);
				switch (sb.charAt(i)) {
					case ' ':
						
						break;
					case '+':
					case '-':
						if(oper == '+') {
							result += Integer.parseInt(nowArr);
						}
						else if(oper == '-') {
							result -= Integer.parseInt(nowArr);
						}
						
						oper = sb.charAt(i);
						nowArr = "";
						break;
					default:
						//숫자일 때
						//System.out.println(sb.charAt(i) + "들어옴");
						nowArr += sb.charAt(i);
						
						break;
				}
			}
			
			if(oper == '+') {
				result += Integer.parseInt(nowArr);
			}
			else if(oper == '-') {
				result -= Integer.parseInt(nowArr);
			}
			
			
			//System.out.println(sb + "의 결과는: " + result);
			
			if(result == 0) System.out.println(sb);
			return;
		}
		
		
		for (int i = 0; i < 3; i++) {
			pm[now] = giho[i];
			
			comb(now+1, end);
		}
	}
}