import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 *  만약 같은 수가 존재하면, 이후 숫자 개수 더하기
		 *  이후 왼쪽 포인터 하나 움직임(맵에서 뺌)
		 *  같은 수 존재하는지 확인(아까 같은 수 되게 만든)
		 *  	만약 아직도 같은 수가 존재한다면, 뒤에 수 다 더하고 왼쪽 플러스
		 *  만약 이제 같은 수가 존재하지 않는다면, 오른쪽 포인터 옮겨감
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> li = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		
		int start = 0;
		int end = 1;
		
		long t = 0L;
		for (int i = 1; i <= N; i++) {
			t += i;
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		long total = 0L;
		
		hm.put(li.get(0), 1);
		
		if(N==1) {
			total = 0;
		}
		else {
			while(true) {
				//시작
				if(start == end) {
					end++;
				}
				else if(end >= N) {
					end = N-1;
					
					while(start < end) {
						if(hm.get(li.get(end)) == 1) {
							start++;
							
							break;
						}
						else {
							total += N-(end);
							
							if(hm.get(li.get(start)) == 1) {
								hm.remove(li.get(start));
							}
							else {
								hm.put(li.get(start), hm.get(li.get(start))-1);
							}
							
							start++;
						}
					}
					
					break;
					
				}
				else if(hm.containsKey(li.get(end))) {
					int tempEnd = li.get(end);

					hm.put(tempEnd, hm.get(tempEnd)+1);
					
					while(start < end) {
						total += N-(end);
						
						if(hm.get(li.get(start)) == 1) {
							hm.remove(li.get(start));
						}
						else {
							hm.put(li.get(start), hm.get(li.get(start))-1);
						}
						
						start++;
						if(hm.get(tempEnd) == 1) {
							break;
						}
					}
					end++;
				}
				else {
					hm.put(li.get(end), 1);
					end++;
				}
			}
		}

		System.out.println(t- total);
	}
}