import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 먼저 문자열 입력받으면서 각 B와 R이 몇개인지 개수 살피기
		 * 2. 왼쪽에서 함수 호출. 맨 왼쪽이 무슨 색인지, 그 색에 따라 빨-파 확인
		 * 3. 오른쪽에서 함수 호출.
		 * 4. 가장 적은 횟수 끌어내기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		String st = br.readLine();
		
		int red = 0;
		int blue = 0;
		
		for (int i = 0; i < st.length(); i++) {
			if(st.charAt(i) == 'R') red++;
			else blue++;
		}
		
		char temp = st.charAt(0);
		int leftLength = 0;
		
		for (int i = 1; i < st.length(); i++) {
			if(st.charAt(i) != temp) {
				leftLength = i;
				break;
			}
		}
		
		
		temp = st.charAt(st.length()-1);
		int rightLength = 0;
		
		int count=1;
		for (int i = st.length()-2; i >= 0; i--) {
			if(st.charAt(i) != temp) {
				rightLength = count;
				break;
			}
			count++;
		}
		
		
		int minMove = Integer.MAX_VALUE;
		
		//빨간색 왼쪽으로 모으기
		//만약 왼쪽이 빨강이라면 ll 빼고, 파랑이면 그냥 red
		
		//System.out.println(red + " " + blue + " " + leftLength + " " + rightLength);
		//파란색 왼쪽으로 모으기
		//만약 왼쪽이 파랑이라면 ll 빼고, 빨강이면 그냥 blue
		
//		minMove = Integer.min(red, blue-leftLength);
//		minMove = Integer.min(minMove, blue);
//		minMove = Integer.min(minMove, red-leftLength);
//		minMove = Integer.min(minMove, red-rightLength);
//		minMove = Integer.min(minMove, blue-rightLength);
		
		if(st.charAt(0) == 'B') {
			minMove = Integer.min(minMove,red);
			minMove = Integer.min(minMove,blue-leftLength);
		}
		
		if(st.charAt(0) == 'R') {
			minMove = Integer.min(minMove,blue);
			minMove = Integer.min(minMove,red-leftLength);
		}
		
		if(st.charAt(st.length()-1) == 'R') {
			minMove = Integer.min(minMove,blue);
			minMove = Integer.min(minMove,red-rightLength);
		}
		
		if(st.charAt(st.length()-1) == 'B') {
			minMove = Integer.min(minMove,red);
			minMove = Integer.min(minMove,blue-rightLength);
		}
		
		//왼쪽이 파란색!!
//		red;
//		blue-leftLength;
//		
//		//왼족이 빨간색!!
//		blue;
//		red-leftLength;
//		
//		//오른쪽이 빨간색!!
//		red-rightLength;
//		
//		//오른쪽이 파란색!!
//		blue-rightLength;
//		
		
		
		System.out.println(minMove);
		
		//빨간색 오른쪽으로 모으기
		//만약 오른쪽이 빨강이라면 rl 빼고, 파랑이면 그냥 red
		
		
		//파란색 오른쪽으로 모으기
		//만약 오른쪽이 파랑이라면 rl 빼고, 빨강이면 그냥 blue
				
		
		
		
		
	}
}