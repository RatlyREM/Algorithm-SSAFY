import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//각 열을 스택으로 하고, 각 stack의 head들을 비교한 후 가장 큰 stack을 pop한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer>[] pyo = new Stack[N];
		
		//stack에 추가
		for (int i = 0; i < N; i++) {
			pyo[i] = new Stack<Integer>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				pyo[j].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		int result = 0;
		int temp, maxHead;
		
		for (int i = 0; i < N; i++) {
			temp = Integer.MIN_VALUE;
			maxHead = -1;
			
			//각 stack의 head들 검사하고 최댓값 찾기
			for (int j = 0; j < N; j++) {
				if(temp < pyo[j].peek()) {
					temp = pyo[j].peek();
					maxHead = j;
				}
			}
			
			result = pyo[maxHead].pop();
		}
		
		System.out.println(result);
	}
}