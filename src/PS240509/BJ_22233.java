package PS240509;

import java.io.*;
import java.util.*;

public class BJ_22233 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 쉼표 기준으로 쓴 글 나누기
		 * 		키워드들 map에 삽입!!
		 * 2. 키워드들 돌면서, map에 존재하는 키워드라면? -> map에서 빼기
		 * 		map에 존재하지 않는 키워드라면? -> 그냥 넘기기
		 * 
		 * 현재 map의 크기 출력하면 됨.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			hs.add(s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			String[] tempS = s.split(",");
			
			for(String t : tempS) {
				if(hs.contains(t)) {
					hs.remove(t);
				}
			}

			bw.write(Integer.toString(hs.size()) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
