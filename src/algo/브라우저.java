package algo;

import java.io.*;
import java.util.*;

public class 브라우저 {
	public static void main(String[] args) throws IOException {
		System.out.println("명령어 옵션");
		System.out.println("v 사이트명// 해당 사이트로 이동");
		System.out.println("b // 이전 사이트로 이동");
		System.out.println("f // 이후 사이트로 이동");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> bStack = new Stack<String>();
		Stack<String> fStack = new Stack<String>();
		
		String current = "";
		
		while(true) {
			System.out.print("입력? ");
			String line = br.readLine();
			switch(line.charAt(0)) {
			case 'v':
				
				break;
			case 'b':
				
				break;
			case 'f':
				
				break;
			default:
				System.out.println("제대로 좀 입력해");
				break;
			}
		}
		
		
	}
	
	private static void printStack() {
		System.out.println(backStack.isEmpty()? "__": "<<");
		System.out.println(current);
		System.out.println(fStack.isEmpty()? "__": "<<");
	}
}
