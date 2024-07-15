import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		List<Character> li = new ArrayList<Character>();
		
		li.add('a');
		li.add('e');
		li.add('i');
		li.add('o');
		li.add('u');
		
		while(true) {
			String temp = br.readLine();
			
			if(temp.equals("end")) {
				break;
			}
			//가능
			int flag = 0;
			StringBuilder sb = new StringBuilder();
			char cTemp = temp.charAt(0);
			
			
			for (int i = 0; i < temp.length(); i++) {
				char t = temp.charAt(i);
				
				if(t >= 'A' && t <= 'Z') {
					//System.out.println("대문자!!");
					flag = 1;
					break;
				}
				else {
					//모음이다
					if(li.contains(t)) {
						sb.append('1');
					}else {
						sb.append('0');
					}
					
					
					if(i > 0) {
						if(temp.charAt(i) == cTemp) {
							if(cTemp != 'e' && cTemp != 'o') {
								//System.out.println("같은거 연속!!");
								flag = 1;
							}
						}
					}
					
					
				}
				
				cTemp = temp.charAt(i);
			}
			
			//System.out.println(sb);
			
			//모음 3개나 자음 3개 연속 불가
			if(!sb.toString().contains("1")) {
				//System.out.println("모음 포함 안 함!!");
				flag = 1;
			}
			
			if(sb.toString().contains("000") || sb.toString().contains("111")) {
				//System.out.println("모 자음 3개!!!");
				flag = 1;
			}
			
			
			
			String tf = (flag== 1) ? " not ": " ";
			
			String s = "<" + temp + "> is" + tf + "acceptable.";
			
			System.out.println(s);
		}
		
		
		
	}
}