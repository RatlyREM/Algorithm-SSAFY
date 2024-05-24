package PS240417;

import java.io.*;
import java.util.*;

public class Bj_20055 {
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
		
		int[] robot = new int[N];
		
		//내구도가 0인 것이 K개 나올 때까지 회전
		int count = 1;
		
		while(true) {
			//컨베이어 회전
			int temp = con.get(con.size()-1);
			con.remove(con.size()-1);
			con.add(0, temp);

			for (int i = robot.length-1; i >0; i--) {
				robot[i] = robot[i-1];
			}
			
			robot[0] = 0;
			robot[N-1] = 0;
			
			
			//로봇 이동
			for (int i=robot.length-1; i>=0 ; i--) {
				//로봇이 존재하고
				if(robot[i] == 1) {
					if(robot[i+1] == 0) { //다음 칸에 로봇이 없고
						if(con.get(i+1) >= 1) {
							//한칸 이동

							robot[i+1] = 1;
							robot[i] = 0;
							
							con.set(i+1, con.get(i+1)-1);
							
							robot[N-1] = 0;
						}
					}
				}
			}
			
			
			//로봇 놓기
			if(con.get(0) > 0) {
				robot[0] = 1; //로봇 추가. 위치는 항상 0인 상태
				
				con.set(0, con.get(0)-1); //내구도 1 줄이기
			}
			
			
			//내구도 확인
			if(Collections.frequency(con, 0) >= K) {
				System.out.println(count);
				break;
			}
			
			count++;
		}
	}
}
