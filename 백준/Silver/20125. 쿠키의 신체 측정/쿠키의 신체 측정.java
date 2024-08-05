import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] cookie = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '*') {
					cookie[i][j+1] = 1;
				}
			}
		}
		
		
		Point head = findHead(cookie, N);
		
		//심장 찾기
		Point heart = new Point(head.x+1, head.y);
		
		int temp = heart.y;
		
		int lArm = 0;
		
		//왼쪽 팔
		for (int i = temp-1; i >0; i--) {
			if(cookie[heart.x][i] != 1) {
				
				break;
			}
			lArm++;
		}
		
		int rArm = 0;
		//오른쪽 팔
		for (int i = temp+1; i <= N; i++) {
			if(cookie[heart.x][i] != 1) {
				
				break;
			}
			rArm++;
		}
		
		
		//허리
		Point waist = new Point();
		int waistY = 0;
		
		for (int i = head.x+2; i <= N; i++) {
			if(cookie[i][head.y] != 1) {
				waist = new Point(i-1, head.y);
				break;
			}
			waistY++;
		}
		
		//왼쪽 다리
		int lLeg = 0;
		
		for (int i = waist.x+1; i <= N; i++) {
			if(cookie[i][waist.y-1] != 1) {
				break;
			}
			lLeg++;
		}
		
		//오른쪽 다리
		int rLeg = 0;
		
		for (int i = waist.x+1; i <= N; i++) {
			if(cookie[i][waist.y+1] != 1) {
				break;
			}
			rLeg++;
		}
		
		System.out.println(heart.x + " " + heart.y);
		System.out.println(lArm + " " + rArm + " " + waistY + " " + lLeg + " " + rLeg);
		
		
		
		
	}
	
	public static Point findHead(int[][] cookie, int N) {
		Point head = new Point();
		
		//머리 찾기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(cookie[i][j] == 1) {
					head = new Point(i,j);
					return head;
				}
			}
		}
		
		return head;
	}

}