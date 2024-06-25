import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 1.리스트에 겹치지 않게 아이디들 삽입
		 * 2. 리스트의 총 개수를 각 플레이 횟수로 나눈 값이 정답
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		String game = st.nextToken();
		
		HashMap<String, Integer> idList = new HashMap<String, Integer>();
		
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			if(!idList.containsKey(temp)) idList.put(temp, 1);
			else idList.put(temp, idList.get(temp)+1);
		}
		
		int total = 0;

		if(game.equals("Y")) total = idList.size();
		if(game.equals("F")) total = idList.size()/2;
		if(game.equals("O")) total = idList.size()/3;
		
		
		System.out.println(total);
		
		
		
	}
}