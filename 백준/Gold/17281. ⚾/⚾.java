import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static ArrayList<Integer> batter;
	static int[][] inning;
	static int N;
	static int maxScore = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//우선 타순 정하기
		//8명의 타자를 8개의 타순에 넣어야 함. -> 8!
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new int[10];
		batter = new ArrayList<Integer>();
		
		inning = new int[N+1][10];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		tasun(8);
		
		System.out.println(maxScore);
	}
		
		
		
	static void tasun(int count) {
		//System.out.println(count +"에서 실행");
		
		if(count == 0) {
			//타순 배정 완료
			batter.add(3, 1);
			
//			for (int i: batter) {
//				System.out.print(i + " ");
//			}
//			System.out.println();			
			int score = 0;
			int nb = 0;
			
			//N이닝까지 진행
			for (int i = 1; i <= N; i++) {
				int outCount = 0;
				
				//주자 위치, 1루, 2루, 3루, 홈
				int[] base = new int[3]; //현재 상황?
				
				int base1=0;
				int base2=0;
				int base3=0;
				
				
				while(outCount <3) {
					int base4=0;
					
					//batter.get(nb) : 다음 타자의 번호
					//System.out.println(i + " " + nb + " " + batter.size());
					int result = inning[i][batter.get(nb)]; //해당 타자의 타격 결과
					//System.out.println("다음 타자: " + batter.get(nb) + " 타격 결과: " + result);
					
					switch (result) {
						case 0://아웃
							//System.out.println("아웃");
							outCount++;
							break;
						case 1://안타
							//System.out.println("안타");
							base2 = base[0];
							base3 = base[1];
							base4 = base[2];
							base1 = 1;
							
							break;
						case 2://2루타
							//System.out.println("2루타");
							base1 = 0;
							base3 = base[0];
							base4 = base[1] + base[2];
							base2 = 1;
							
							break;
						case 3://3루타
							//System.out.println("3루타");
							base4 = base[0] + base[1] + base[2];
							base3 = 1;
							base1= 0;
							base2 = 0;
							
							break;
						case 4://홈런
							//System.out.println("홈런");
							//주자 수만큼 점수 추가
							score += base[0]+ base[1] + base[2] + 1;
							base[0] = 0;
							base[1] = 0;
							base[2] = 0;
							
							base1 =0;
							base2 =0;
							base3 =0;
							base4 =0;
							
							
							break;
					}
					
					base[0] = base1;
					base[1] = base2;
					base[2] = base3;
					
					score += base4;
					
					//System.out.println("현재 베이스 상태: ");
					//System.out.println(Arrays.toString(base));
					
					nb = (nb+1) %9;
				}
				
				//System.out.println("이닝 끝");
				
				
			}
			
			
			//System.out.println("점수는: " + score);
			if(maxScore < score) {
				maxScore = score;
			}
			
			//System.exit(0);

			batter.remove(3);
			return;
		}
		
		for (int i = 2; i <= 9; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				batter.add(i);
				
				tasun(count-1);
				
				visited[i] = 0;
				batter.remove(batter.size()-1);
			}
		}
	}
}