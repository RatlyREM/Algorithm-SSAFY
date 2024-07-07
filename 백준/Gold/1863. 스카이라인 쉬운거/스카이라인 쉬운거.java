import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	static Stack<Point> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		stack = new Stack<Point>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x  =Integer.parseInt(st.nextToken());
			int y  =Integer.parseInt(st.nextToken());
			
			check(x,y);
		}
		
		int x  = n;
		int y = 0;
		
		check(x,y);
		
		System.out.println(count);
	}
	
	static void check(int x, int y) {
		while(true) {
			if(stack.isEmpty()) {
				stack.add(new Point(x,y));
				break;
			} else {
				if(stack.peek().y < y) {
					stack.add(new Point(x,y));
					break;
				}
				else if(stack.peek().y == y) {
					break;
				}
				else {
					stack.pop();
					count++;
				}
			}
		}
	}
}