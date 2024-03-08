package PS240308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_JH27172 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 1. 입력받은 플레이어 별 카드들을 배열에 삽입한다.
		 * 2. 각 플레이어 카드들의 100만 배열에서의 값을 1로 바꿔준다.
		 * 3. 각 카드들을 max값 이전까지의 배수들을 구하면서, 해당 배수가 100만 배열에서 1로
		 * 바뀌어 있다면 배수값으로 들어가 있다는 의미이므로 점수를 각각 업데이트 해준다.
		 * 
		 * 4. 마지막으로 각 카드 별 최종 점수를 score 배열에서 출력한다. 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] card = new int[N];
		int[] era = new int[1000001];
		int[] score = new int[1000001];
		
		int maxCard = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if(card[i] > maxCard) maxCard = card[i];
			era[card[i]] = 1;
		}
		
		for (int i = 0; i < card.length; i++) {
			int count = card[i]*2;
			
			while(count <= maxCard) {
				if(era[count] ==1) {
					score[count]--;
					score[card[i]]++;
				}
				
				count += card[i];
			}
		}
		
		for (int i = 0; i < card.length; i++) {
			System.out.print(score[card[i]] + " ");
		}
	}
}

