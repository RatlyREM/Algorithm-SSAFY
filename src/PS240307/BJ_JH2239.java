package PS240307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_JH2239 {
	static int[][] sudoku;
	static int count = 0;
	static int blank = 0;
	static int flag = 0;
	public static void main(String[] args) throws IOException {
		/*
		 * 하다 만 스도쿠를 돌다가 0을 발견하면, 1~9를 넣어 본다.
		 * 우선 가로줄, 세로줄을 검사하여 해당 숫자가 이미 존재하는지 확인한다.
		 * 		먼저 가로줄부터 돈다!! -> 같은 행을 유지하며 열을 탐색
		 * 그리고 속한 영역에서도 1~9를 검사하고 삽입한다!
		 * 만약 이미 존재하는 숫자를 발견했다면, continue하고 다음 숫자로 넘어감! 
		 * 
		 * 배열의 모든 숫자가 0이 아닌 숫자로 채워져 있는지 확인한다!
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		
		//입력
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
				if(sudoku[i][j] == 0) blank++;
			}
		}
		
		
		BT(0);
	}
	
	private static void BT(int d) {
		if(flag ==1) return;
		
		if(blank == 0) {
			print();
			System.exit(0);
		}
		
		for (int i = d; i < 81; i++) {
			int ty = i%9;
			int tx = i/9;
			
			if(sudoku[tx][ty] == 0) {
				for(int k=1; k <= 9; k++) {
					//주변에 존재하지 않는다면??
					if(!check(tx,ty,k)) {
						sudoku[tx][ty] = k;
						blank--;
						BT(d+1);
						
						blank++;
						sudoku[tx][ty]= 0;
					}
					
					if(blank == 0) {
						print();
						System.exit(0);
					}
				}
				
				break;
			}
		}
	}
	
	private static boolean check(int i, int j, int k) {
		//가로, 세로 check
		for (int l = 0; l < 9; l++) {
			if(sudoku[i][l] == k || sudoku[l][j] == k) {
				return true;
			}
		}
		
		//주위 영역 check
		
		int startX = (i/3) *3;
		int startY = (j/3) *3;
		
		for (int l = startX; l < startX+ 3; l++) {
			for (int m = startY; m < startY +3; m++) {
				if(sudoku[l][m] == k) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
}

