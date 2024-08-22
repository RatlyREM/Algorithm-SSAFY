import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Croom {
		int sTime;
		int eTime;
		int len;
		
		public Croom(int sTime, int eTime, int len) {
			super();
			this.sTime = sTime;
			this.eTime = eTime;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> hm = new TreeMap<>();
		
		//시작시간이 작은 순으로 return.
		PriorityQueue<Croom> pq = new PriorityQueue<>((o1, o2) ->  {
			if(o1.sTime != o2.sTime) {
				return o1.sTime-o2.sTime;
			}
			else {
				return o2.len- o1.len;
			}
		});
		
		//pq에 삽입
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			Croom croom = new Croom(s,t,t-s);
			pq.add(croom);
		}
		
		//pq에서 하나씩 뽑으면서 강의실에 붙이기
		
		while(!pq.isEmpty()) {
			Croom croom = pq.poll();
			int s1 = croom.sTime;
			int s2 = croom.eTime;
			//System.out.println(s1 + " 와" + s2);
			
			//System.out.println(hm);
			//시작시간을 key로 갖는 map 요소 확인
			if(hm.containsKey(s1)) {
				//하나 줄이고 끝시간을 하나 추가해야함
				int value = hm.get(s1) -1;
				
				if(value == 0) {
					hm.remove(s1);
				} else {
					hm.put(s1, value);
				}
				
				
				//끝시간 추가
				if(hm.containsKey(s2)) {
					hm.put(s2, hm.get(s2)+1);
				}
				else {
					hm.put(s2, 1);
				}
			} else {
				if(hm.isEmpty()) {
					//System.out.println("없어서 추가!!");
					hm.put(s2, 1);
				}
				else {
					if(hm.firstKey() > s1) {
						//끝시간 추가
						//System.out.println("하나 더 만든다!!");
						if(hm.containsKey(s2)) {
							hm.put(s2, hm.get(s2)+1);
						}
						else {
							hm.put(s2, 1);
						}
					}
					else {
						//firstkey를 줄이고, hm에 추가
						int value = hm.get(hm.firstKey()) -1;
						
						if(value == 0) {
							hm.remove(hm.firstKey());
						} else {
							hm.put(hm.firstKey(), value);
						}

						//끝시간 추가
						if(hm.containsKey(s2)) {
							hm.put(s2, hm.get(s2)+1);
						}
						else {
							hm.put(s2, 1);
						}
					}
				}
			}
		}
		
		int total = 0;
		//map의 value들을 다 더하기
		
		for(int i :hm.keySet()) {
			total += hm.get(i);
		}
		
		System.out.println(total);
	}
}