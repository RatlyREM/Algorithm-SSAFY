import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Point> resultStack = new Stack<Point>();
		
		for (int i = 1; i <= N; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			if(resultStack.isEmpty()) {
				sb.append("0 ");
			}
			else {
				while(true) {
					if(resultStack.peek().y > next) {
						sb.append(resultStack.peek().x).append(" ");
						break;
					}
					
					resultStack.pop();
					
					if(resultStack.isEmpty()) {
						sb.append("0 ");
						break;
					}
				}
			}

			resultStack.push(new Point(i, next));
		}
		
		System.out.println(sb);
		
	}
}