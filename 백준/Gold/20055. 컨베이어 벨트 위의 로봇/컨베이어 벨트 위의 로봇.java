import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> con = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 2*N; i++) {
			con.add(Integer.parseInt(st.nextToken()));
		}
		
		//몇번에 어느 로봇이 들어가있는지!!
		//int[] robot = new int[con.size()];
		//int robotNum = 1;
		
		int[] robot = new int[N];
		
		//내구도가 0인 것이 K개 나올 때까지 회전
		int count = 1;
		
		while(true) {
			//System.out.println(count+"번째 실행중");
			//if(count>100) break;
			//컨베이어 벨트 회전
			//System.out.println("회전!!");
			int temp = con.get(con.size()-1);
			con.remove(con.size()-1);
			con.add(0, temp);
			
			//System.out.println(Arrays.toString(robot));
			
			for (int i = robot.length-1; i >0; i--) {
				robot[i] = robot[i-1];
				//robot[i-1] = 0;
			}
			
			robot[0] = 0;
			robot[N-1] = 0;
			
			//로봇 배열
			//System.out.println(Arrays.toString(robot));

//			System.out.println("현재 컨베이어");
//			for (int i : con) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//			
//			System.out.println("현재 로봇");
//			for (int i : robot) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
			
			//로봇 이동
			for (int i=robot.length-1; i>=0 ; i--) {
				//System.out.println(i + "번 로봇 출발, 위치는 " + robot.get(i));
				
				//로봇이 존재하고
				if(robot[i] == 1) {
					if(robot[i+1] == 0) { //다음 칸에 로봇이 없고
						if(con.get(i+1) >= 1) {
							//한칸 이동

							robot[i+1] = 1;
							robot[i] = 0;
							
							con.set(i+1, con.get(i+1)-1);
							
							robot[N-1] = 0;
							
							
//							System.out.println("현재 컨베이어");
//							for (int a : con) {
//								System.out.print(a + " ");
//							}
//							System.out.println();
						}
					}
				}
			}
			
			
//			System.out.println("현재 컨베이어");
//			for (int i : con) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
			
			//로봇 배열
			//System.out.println(Arrays.toString(robot));
			
			//로봇 놓기
			if(con.get(0) > 0) {
				robot[0] = 1; //로봇 추가. 위치는 항상 0인 상태
				
				con.set(0, con.get(0)-1); //내구도 1 줄이기
				

				//System.out.println("로봇 추가함!! 내구도는, " + con.get(0));
				
//				System.out.println("현재 로봇");
//				for (int i : robot) {
//					System.out.print(i + " ");
//				}
//				System.out.println();
				
			}
			
//			System.out.println("현재 컨베이어");
//			for (int i : con) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
			
			
			//내구도 확인
			if(Collections.frequency(con, 0) >= K) {
				System.out.println(count);
				break;
			}
			
			count++;
			
			//System.out.println("==============================");
			
			
		}
		
		
		
		
		
	}
}