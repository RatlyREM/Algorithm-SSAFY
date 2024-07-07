import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int height = 0;
		Stack<Point> stack = new Stack<Point>();
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x  =Integer.parseInt(st.nextToken());
			int y  =Integer.parseInt(st.nextToken());
			
			while(true) {
				if(stack.isEmpty()) {
					stack.add(new Point(x,y));
					height = y;
					break;
				} else {
					if(stack.peek().y < y) {
						stack.add(new Point(x,y));
						height = y;
						break;
					}
					else if(stack.peek().y == y) {
						break;
					}
					else {
						height = x;
						stack.pop();
						count++;
					}
				}
			}
		}
		
		int x  = n;
		int y = 0;
		
		while(true) {
			if(stack.isEmpty()) {
				stack.add(new Point(x,y));
				height = y;
				break;
			} else {
				if(stack.peek().y < y) {
					stack.add(new Point(x,y));
					height = y;
					break;
				}
				else if(stack.peek().y == y) {
					break;
				}
				else {
					height = x;
					stack.pop();
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}