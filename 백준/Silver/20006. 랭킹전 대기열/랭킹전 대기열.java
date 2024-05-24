import java.io.*;
import java.util.*;

public class Main {
	static class Room {
		int min;
		int max;
		PriorityQueue<Player> member = new PriorityQueue<>((o1, o2) -> (o1.nick).compareTo(o2.nick));
		
		public Room(int i, int j, Player tempP) {
			this.min = i;
			this.max = j;
			member.add(tempP);
		}
	}
	
	static class Player {
		int level;
		String nick;
		
		public Player(int level, String nick) {
			super();
			this.level = level;
			this.nick = nick;
		}
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * 매칭 가능한 방이 없다면 새로운 방을 생성하고 입장시킴.
		 * 		처음 입장한 플레이어의 레벨을 기준으로 +-10
		 * 
		 * 입장 가능한 방이 있다면 입장시킨 후 정원이 모두 찰 때까지 대기
		 * 		여러 개라면 먼저 생성된 방에 입장
		 * 
		 * 방의 정원이 모두 차면 게임 시작
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //방 정원
		
		
		List<Room> roomList = new ArrayList<Room>();
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			Player tempP = new Player(Integer.parseInt(st.nextToken()),st.nextToken());
			int flag = 0;
			
			for (int j = 0; j < roomList.size(); j++) {
				//roomList에서 들어갈 방 탐색
				if(roomList.get(j).min <= tempP.level && roomList.get(j).max >= tempP.level && roomList.get(j).member.size() < m) {
					//들어갈 방 찾음
					roomList.get(j).member.add(tempP);
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				//새로 방 만든 후 삽입
				roomList.add(new Room(tempP.level-10, tempP.level+10, tempP));
			}
		}
		
		
		//출력
		for(Room r : roomList) {
			if(r.member.size() == m) {
				System.out.println("Started!");
			}
			else {
				System.out.println("Waiting!");
			}
			
			while(!r.member.isEmpty()) {
				Player pp = r.member.poll();
				System.out.println(pp.level + " " + pp.nick);
			}
		}
	}
}