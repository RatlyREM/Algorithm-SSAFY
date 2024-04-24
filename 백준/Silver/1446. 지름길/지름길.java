import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] kilo = new int[D+1];
		HashMap<Point, Integer> hm = new HashMap<Point, Integer>();
		
		//초기화
		for (int i = 0; i < kilo.length; i++) {
			kilo[i] = i;
		}
		
		//map에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			if(end > D || end-start < length) continue;
			
			if(hm.containsKey(new Point(start, end))) {
				if(hm.get(new Point(start, end)) < length) {
					continue;
				}
			}
			
			hm.put(new Point(start, end), length);
		}
		
		
		//최소 거리 구하기
		for (int i = 0; i < D+1; i++) {
			//현재 위치 최솟값 업데이트
			if(i > 0) {
				if(kilo[i-1]+1 < kilo[i]) {
					kilo[i] = kilo[i-1]+1;
				}
			}
			
			//해당 위치에서 지름길 있는지 확인
			for(Map.Entry<Point, Integer> m: hm.entrySet()) {
				if(m.getKey().x == i) {
					//해당 위치의 최솟값을 업데이트
					if(kilo[m.getKey().y] > (kilo[m.getKey().x] + m.getValue())) {
						kilo[m.getKey().y] = kilo[m.getKey().x] + m.getValue();
					}
				}
			}
		}
		
		
		System.out.println(kilo[D]);
		
		
	}
}