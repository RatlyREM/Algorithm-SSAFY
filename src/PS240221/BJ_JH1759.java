package PS240221;

import java.io.*;
import java.util.*;

public class BJ_JH1759 {
	static ArrayList<Character> temp;
	static ArrayList<Character> mo;
	static ArrayList<String> result;
	static int L;
	static char[] t;
	static String s;
	static int ja_num = 0;
	static int mo_num = 0;
	
	public static void main(String[] args) throws IOException {
		/*
		 * 백트래킹.
		 * 1. 일단 입력받은 문자들 정렬하고
		 * 2. 백트래킹으로 L개씩 가져온다. L개가 쌓이면
		 * 3. 모음-자음 검사 실행. 모음이 1개 이상, 자음이 2개 이상이면 통과
		 * 4. 결과 arrayList에 집어넣는다.(중복 처리)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		temp = new ArrayList<Character>();
		result = new ArrayList<String>();
		
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		t = new char[L];
		Character[] amho = new Character[C];
		boolean[] visited = new boolean[C];
		
		mo = new ArrayList<Character>();
		mo.add('a');
		mo.add('e');
		mo.add('i');
		mo.add('o');
		mo.add('u');
		
		
		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < C; i++) {
			amho[i] = str[i].charAt(0);
		}
		
		Arrays.sort(amho);
		
		//arr: 어떤 집합에서 뽑는지, r: 몇 개 뽑아야 하는지, index: 현재 인덱스 , n: 배열 크기
		BackTracking(amho, visited, 0, C , L);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
	
	private static void BackTracking(Character[] amho, boolean[] visited, int index,int n, int r) {
		//기저조건, L개 완성
		if(r == 0) {
			for (int i = 0; i < t.length; i++) {
				t[i] = temp.get(i);
			}
			
			Arrays.sort(t);
			
			s = "";
			
			ja_num = 0;
			mo_num = 0;
			
			//자음, 모음 검사
			for (int i = 0; i < temp.size(); i++) {
				s += t[i];
				
				if(mo.contains(t[i])) {
					mo_num++;
				}
				else {
					ja_num++;
				}	
			}
			
			//조건
			if(ja_num >=2 && mo_num >=1) {
				if(!result.contains(s)) {
					result.add(s);
				}
			}

			return;
		}
		
		else {
			for(int i= index; i<n; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					temp.add(amho[i]);
					
					BackTracking(amho, visited, i+1, n, r-1);
					visited[i] = false;
					temp.remove(temp.size()-1);
				}
			}
		}
	}
}









