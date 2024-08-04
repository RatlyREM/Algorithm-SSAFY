import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 이분탐색이 필요할지도?
		 * 1 3 5면 1부터 시작한다고 가정하면,
		 * 3개 통과함. 이분탐색으로 찾은거 포함해서 3개
		 * 2면, 3,5. 못찾으면 그 뒷부분 포함해서 2개
		 * 
		 * 이런 식으로 종유석-석순 각각 이분탐색 하면?
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] jongArr = new int[(N/2)+2];
		int[] sukArr = new int[(N/2)+2];

		//동굴 쭉 입력받아서 홀수는 jong, 짝수는 suk에 넣기
		for (int i = 1; i <= (N/2); i++) {
			int a= Integer.parseInt(br.readLine());
			int b= Integer.parseInt(br.readLine());
			
			sukArr[i] = a;
			jongArr[i] = b;
		}
		
		sukArr[(N/2)+1] = 500001;
		jongArr[N/2+1] = 500001;
	
		Arrays.sort(sukArr);
		Arrays.sort(jongArr);

		int minNum = Integer.MAX_VALUE;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 1; i <= H; i++) {
			int jTemp = (N/2)- search(H-i+1, jongArr)+1;
			int sTemp = (N/2)-search(i, sukArr)+1;
			
			int total = sTemp+jTemp;
			
			if(!hm.containsKey(total)) {
				hm.put(total, 1);
			} else {
				hm.put(total, hm.get(total)+1);
			}
			
			minNum = Math.min(minNum, sTemp+jTemp);
		}
		
		System.out.println(minNum + " " + hm.get(minNum));
	}
	
	public static int search(int js, int[] cave) {
		//cave에서 js를 찾는 것.
		int left = 0;
		int right = cave.length-1;
		
		while(left < right) {
			int mid = (left+right)/2;
			if(cave[mid] < js) {
				left = mid +1;
			}
			else {
				right = mid;
			}
		}
		
		return right;
	}
}