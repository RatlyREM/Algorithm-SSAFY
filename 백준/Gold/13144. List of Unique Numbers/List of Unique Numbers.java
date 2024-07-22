import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 *  만약 어떤 구간에서 연속한 수가 등장한다면, 그 구간을
		 *  포함하는 모든 구간이 불가능한 것.
		 *  일단 투 포인터로 같은게 나오는 부분 찾기?
		 *  찾았다면, 그 부분을 포함하는 모든 구간의 경우의 수를 찾기
		 *  
		 *  일단, 전체 경우의 수는
		 *  해당 개수까지 1부터 전부 더한 것.
		 *  
		 *  찾았다면 그 덩어리를 반드시 포함하는 경우의 수 개수 찾기
		 *  (1 2 3 1) 2 -> 덩어리 제외 1개
		 *  
		 *  1 (2 3 1 2) -> 덩어리 제외 1개
		 *  
		 *  (1 1) 1 1 1 -> 덩어리 제외
		 *  
		 *  만약 같은 수가 존재하면, 이후 숫자 개수 더하기
		 *  이후 왼쪽 포인터 하나 움직임(맵에서 뺌)
		 *  같은 수 존재하는지 확인(아까 같은 수 되게 만든)
		 *  	만약 아직도 같은 수가 존재한다면, 뒤에 수 다 더하고 왼쪽 플러스
		 *  만약 이제 같은 수가 존재하지 않는다면, 오른쪽 포인터 옮겨감
		 *  
		 *  
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
			//end가 N에 도달했을 때, start 올려가면서 비교해야 함
			
			//end < N && start < end
			while(true) {
				//System.out.println("start:" + start + " end: " + end);
				//end가 이미 존재하면?
				
				//System.out.println("처음 해쉬맵 상태: " + hm);
				
				//시작
				if(start == end) {
					//System.out.println("둘다 똑같음!!!!!!!!!!!!");
					end++;
				}
				else if(end >= N) {
					//System.out.println("사후작업 들어감");
					//end는 그대로 두고 start만 확인
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
					
					//System.out.println("겹치는 수 발견!!!!");
					int tempEnd = li.get(end);
					
					//겹치는게 있으면?
					//겹치는 수를 세줘야 함.
					
					hm.put(tempEnd, hm.get(tempEnd)+1);
					
					while(start < end) {
						//System.out.println((N-end) + " 추가!!! 이전은 "+ total);
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
					//겹치는게 없으면, 그냥 오른쪽 하나 늘리고 hm에 추가
					hm.put(li.get(end), 1);
					end++;
				}
				
				//System.out.println("나중 해쉬맵 상태: " + hm);

				//System.out.println();
				//System.out.println();
			}
		}
		
		
		
		
		System.out.println(t- total);
		
		
		
	}
}