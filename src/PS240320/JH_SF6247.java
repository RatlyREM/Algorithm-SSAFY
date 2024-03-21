package PS240320;

import java.util.*;
import java.io.*;

public class JH_SF6247 {
	public static void main(String[] args) throws IOException {
		/*
		1. 입력받은 연비들을 오름차순으로 정렬
		2. 출력해야 할 연비가 몇 번째인지 확인
			map에 저장할 때 순서를 저장한다!!
		3. 현재 인덱스 앞뒤로 몇개씩 있는지 확인하고, 곱한다
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		Set<Integer> s = new TreeSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		int count = 0;
		for (int i: s) {
			m.put(i, count);
			count++;
		}
		
		for (int i = 0; i < q; i++) {
			int temp = Integer.parseInt(br.readLine());

			if(m.containsKey(temp)) {
				System.out.println((m.get(temp)) * (n-m.get(temp)-1));
			}
			else {
				System.out.println("0");
			}
		}
	}
}
