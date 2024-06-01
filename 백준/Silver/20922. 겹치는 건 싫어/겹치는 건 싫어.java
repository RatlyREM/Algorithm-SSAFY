import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		//순회하면서 연속되는 수 업데이트.
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
				
		int maxSeq = 0;
		int seqLen = 0;
		
		int start = 0;
		
		
		for(int i = 0; i< N; i++) {
			if(!hm.containsKey(seq[i])) hm.put(seq[i], 1);
			else hm.put(seq[i], hm.get(seq[i])+1);
			
			
			if(hm.get(seq[i]) > K) {
			
				//maxSeq = Integer.max(maxSeq, seqLen);
				
				//이번에 나온 녀석이 처음부터 돌면서 나올 때까지 돌기
				while(true) {
					//System.out.println(seq[start] + " 없애기!!" + seq[i]);
					
					hm.put(seq[start], hm.get(seq[start])-1);
					
					if(seq[start] == seq[i]) {
						start++;
						seqLen--;
						
						
						//System.out.println(start + " " + seq[start] + " " + seqLen);
						break;
					}
					
					start++;
					seqLen--;
					
				}
				
				
			}
			
			seqLen++;
			if(maxSeq < seqLen) {
				maxSeq = seqLen;
			}
			
			//System.out.println("현재 길이는 ...."  + seqLen);
		}
		
		
		
		System.out.println(maxSeq);
	}
}