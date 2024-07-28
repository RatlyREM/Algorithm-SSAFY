import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 폭발 문자열 찾기.
		 * 만약 그 문자열을 빼고 생각했을 때도 폭발 문자열이 있는가?
		 * 사이에 꼈을 때 발생함.
		 * 
		 * M이 완성됐는지 확인하는 로직 필요
		 * 
		 * 1. 하나 넣었다.
		 * 2. M개만큼 빼보면서 문자열이랑 일치하는지 확인
		 * 3. 일치하면 그만큼 stack에서 뺀거임
		 * 4. 안 일치하거나 stack이 비었으면, 뺐던거 다시 stack에 삽입
		 * 5. 이걸 끝까지 반복.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		String M = br.readLine();
		
		StringBuilder sbM = new StringBuilder(M);
		//sbM = sbM.reverse();
		
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < N.length(); i++) {
//			if(i< (M.length()-1)) {
//				//st.push(N.charAt(i));
//				answer.append(N.charAt(i));
//			}
//			else {
			
			//일단 넣고
			answer.append(N.charAt(i));
			
			//그리고 sb 크기가 M 이상이면 subString으로 뽑아봐
			if(answer.length() >= M.length()) {
				String temp = answer.substring(answer.length()-M.length(), answer.length());
				
				//System.out.println(temp + " 이다!!!!!!!!!!!!");
				if(temp.equals(M)) {
					answer.delete(answer.length()-M.length(), answer.length());
				}
				
			
			}
			
			//System.out.println("sb 상태: " + answer);
			
			
				//검사 필요.
				//sb.append(N.charAt(i));
//				
//				for (int j = 0; j < M.length()-1; j++) {
//					if(st.isEmpty()) {
//						break;
//					}
//					sb.append(st.pop());
//				}
//				
//				
//				//같지 않으면 다시 스택에 원상복구 해줘야함
//				if(!sbM.toString().equals(sb.toString())) {;
//					for (int j = 0; j < sb.length(); j++) {
//						st.push(sb.charAt(sb.length()-j-1));
//					}
//				}
//				
//				sb.setLength(0);
//			}
			
		}
		
		if(answer.length() == 0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(answer.toString());
		}
		
	}
	
	
	
}