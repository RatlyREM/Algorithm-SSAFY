package PS240411;

import java.io.*;
import java.util.Arrays;
import java.awt.*;


public class BJ_동물원 {
	static Point[] zoo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		zoo = new Point[N];
		
		zoo[0] = new Point(1,2);
		
		for (int i = 1; i < N; i++) {
			int x = (zoo[i-1].x + zoo[i-1].y)%9901;
			int y = ((zoo[i-1].x*2)%9901 + zoo[i-1].y)%9901;
			
			zoo[i] = new Point(x,y);
		}
		
		System.out.println((zoo[N-1].x + zoo[N-1].y)%9901);

	}
}
