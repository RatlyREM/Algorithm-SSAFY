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
		 * 종유석 10만개, 석순 10만개
		 * 
		 * 50만 * 5 + 50만 * 5 -> 500만.
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
//		List<Integer> jong = new ArrayList<>();
//		List<Integer> suk = new ArrayList<>();
//		
		int[] jongArr = new int[(N/2)+2];
		int[] sukArr = new int[(N/2)+2];
		
		
//		jong.add(0);
//		suk.add(0);
//		jong.add(500001);
//		suk.add(500001);
		
		//동굴 쭉 입력받아서 홀수는 jong, 짝수는 suk에 넣기
		for (int i = 1; i <= (N/2); i++) {
			int a= Integer.parseInt(br.readLine());
			int b= Integer.parseInt(br.readLine());
			
			sukArr[i] = a;
			jongArr[i] = b;
		}
		
		sukArr[(N/2)+1] = 500001;
		jongArr[N/2+1] = 500001;
		
		
		//리스트 정렬
//		Collections.sort(suk);
//		Collections.sort(jong);
		
		Arrays.sort(sukArr);
		Arrays.sort(jongArr);
		
//		Integer[] jongArr = jong.toArray(new Integer[0]);
//		Integer[] sukArr =  suk.toArray(new Integer[0]);
//		
		//System.out.println(Arrays.toString(jongArr));
		//System.out.println(Arrays.toString(sukArr));
		
		
		int minNum = Integer.MAX_VALUE;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 1; i <= H; i++) {
			int jj = search(H-i+1, jongArr);
			
//			if((jj+1) < (N/2)) {
//				if(jongArr[jj+1] == jongArr[jj]) {
//					for(int k= jj; k<(N/2); k++) {
//						if(jongArr[k] != jongArr[jj]) {
//							jj= k;
//							break;
//						}
//						
//						if(k == (N/2)-1) {
//							jj = (N/2);
//						}
//					}
//				}
//			}
			
			
			
			int jTemp = (N/2)-jj+1;
			
			//System.out.println((H-i+1) + "을 종유석에서 찾음: " + search(H-i+1, jongArr));
			
			int ss = search(i, sukArr);
			
//			if((ss+1) < (N/2)) {
//				if(sukArr[ss+1] == sukArr[ss]) {
//					for(int k= ss; k<(N/2); k++) {
//						if(sukArr[k] != sukArr[ss]) {
//							ss= k;
//							break;
//						}
//						
//						if(k == (N/2)-1) {
//							ss = (N/2);
//						}
//					}
//				}
//			}
			
			
			int sTemp = (N/2)-ss+1;
			//System.out.println(i + "을 석순에서 찾음: " + search(i, sukArr) + " " + sTemp);
			
			
			int total = sTemp+jTemp;
			
			//System.out.println("i: " + i + " " + jTemp + " " + sTemp);
			
			if(!hm.containsKey(total)) {
				hm.put(total, 1);
			}else {
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