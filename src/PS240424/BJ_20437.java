package PS240424;

import java.io.*;
import java.util.*;

public class BJ_20437 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		
		ArrayList<Integer>[] alphaDir = new ArrayList[26];
		
		for (int a = 0; a < 26; a++) {
			alphaDir[a] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < T; i++) {
			Arrays.fill(alpha, 0);
			
			
			for (int a = 0; a < 26; a++) {
				alphaDir[a].clear();
			}
			
			String tempStr = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			//존재하는 알파벳 세기
			for (int j = 0; j < tempStr.length(); j++) {
				alpha[tempStr.charAt(j)- 'a']++;
				alphaDir[tempStr.charAt(j)- 'a'].add(j);
			}
			
			int min3 = -1;
			int max4 = Integer.MAX_VALUE;
			
			for (int j = 0; j < alpha.length; j++) {
				//해당 알파벳은 후보로 적용 가능
				
				//알파벳 a는 K개 이상!!
				if(alpha[j] >= K) {
					//해당 알파벳 위치 배열 돌면서 찾기
					
					//시작지점 반복문
					for (int k = 0; k < alphaDir[j].size()-K+1; k++) {
						//K개씩 돌면서 찾기. 가까운 위치를!!

						int temp = alphaDir[j].get(k+K-1) - alphaDir[j].get(k) + 1;
						
						if(temp < max4) max4 = temp;
						if(min3 < temp) min3 = temp;
						
					}
				}
			}
			
			if(max4== Integer.MAX_VALUE || min3 == -1) {
				System.out.println(-1);
			}
			else {
				System.out.println(max4 + " " + min3);
			}
		}
	}
}
