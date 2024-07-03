import java.io.*;
import java.util.*;

public class Main {
	static String temp;
	public static void main(String[] args) throws IOException {
		/*
		 1. 꽉 찼다.
			X가 O보다 1개 더 많다.
				O로 가로-세로-대각선 중 연결된 부분이 존재한다. : INVALID
				그런게 존재하지 않는다. : VALID
			X가 O보다 1개 더 많지 않다.(다른 경우이다.)
				INVALID

		2. 꽉 안 찼다.
			X가 O와 동일하다.(O로 끝났다.)
				X로 연결된 부분이 존재한다. :INVALID
				O로 연결된 부분이 존재한다. : VALID
				연결된 부분이 존재하지 않는다. :INVALID
			X가 O보다 1개 더 크다.(X로 끝났다.)
				O로 연결된 부분이 존재한다. :INVALID
				X로 연결된 부분이 존재한다.: VALID
				연결된 부분이 존재하지 않는다.: INVALID
			그 외의 경우이다.
				INVALID
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			temp = br.readLine();
			String answer = "";
			
			if(temp.equals("end")) break;
			
			int xNum = 0, oNum = 0;
			
			for (int i = 0; i < 9; i++) {
				if(temp.charAt(i)== 'X') xNum++;
				else if(temp.charAt(i)== 'O') oNum++;
			}
			
			
			if(temp.contains(".")) {
				if(xNum == oNum) {
					if(check('X')) answer = "invalid";
					else if(check('O')) answer = "valid";
					else answer = "invalid";
				}
				else if(xNum == (oNum+1)) {
					if(check('O')) answer = "invalid";
					else if(check('X')) answer = "valid";
					else answer = "invalid";
				}
				else {
					answer = "invalid";
				}
			}
			else {
				if(xNum == (oNum+1)) {
					//check는, 해당 문자로 이루어진 빙고가 있다면 true
					if(check('O')) answer = "invalid";
					else answer = "valid";
				}
				else answer = "invalid";
			}
			
			System.out.println(answer);
		}
	}
	
	
	static boolean check(char c) {
		//가로 검사
		if((temp.charAt(0)== c &&  temp.charAt(0) == temp.charAt(1) && temp.charAt(1) == temp.charAt(2)) ||
		   (temp.charAt(3)== c && temp.charAt(3) == temp.charAt(4) && temp.charAt(4) == temp.charAt(5)) ||
		   (temp.charAt(6)== c && temp.charAt(6) == temp.charAt(7) && temp.charAt(7) == temp.charAt(8))) {
			return true;
		}
		
		//세로 검사
		if((temp.charAt(0)== c &&  temp.charAt(0) == temp.charAt(3) && temp.charAt(3) == temp.charAt(6)) ||
		   (temp.charAt(1)== c && temp.charAt(1) == temp.charAt(4) && temp.charAt(4) == temp.charAt(7)) ||
		   (temp.charAt(2)== c && temp.charAt(2) == temp.charAt(5) && temp.charAt(5) == temp.charAt(8))) {
			return true;
		}
		
		
		//대각선 검사
		if((temp.charAt(0)== c &&  temp.charAt(0) == temp.charAt(4) && temp.charAt(4) == temp.charAt(8)) ||
			(temp.charAt(2)== c && temp.charAt(2) == temp.charAt(4) && temp.charAt(4) == temp.charAt(6))) {
			return true;
		}
		
		return false;
	}
}