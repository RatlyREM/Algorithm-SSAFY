import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Game {
		String style;
		int power;
		
		Game(String style, int power) {
			this.style = style;
			this.power = power;
		}
	}
	public static void main(String[] args) throws IOException {
		/*
		 * 결과값은 stringbuilder로.
		 * 이분탐색.
		 * sort하고 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		Game[] gameList = new Game[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			gameList[i] = new Game(st.nextToken(), Integer.parseInt(st.nextToken()));
			
		}
		
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			//temp를 gameList의 power에 대해 이분 탐색(lower bound, target 이상인 첫 번째)
			int left = 0;
			int right = N-1;
			
			while(left < right) {
				int mid = (left+right)/2;

				//System.out.println(mid);
				if(gameList[mid].power < temp) {
					left = mid+1;
				} else {
					right = mid;
				}
			}
			
			//System.out.println("left: " + left + " " + right);
			sb.append(gameList[left].style + "\n");
		}
		
		System.out.println(sb);
		
	}
}