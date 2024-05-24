package PS240412;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class SAM_메이즈러너 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Point exit;
    static int[][] miro;
    static int N;
    static int total = 0;
    
    public static void main(String[] args) throws IOException {
        /*

     * 1. 참가자 이동
     *         1-1. 상하 -> 좌우 살펴보고, 배열 범위 내부이면서 벽이 없고, 출구까지의 최단거리가 
     *              줄어든다면 그걸 우선으로 이동한다.(이동횟수는 저장해두어야 함.)
     *         1-2. 도달한 곳이 출구라면, 참가자를 탈출시킨다.
     *        1-3. 모든 참가자가 탈출했다면, 게임을 종료시킨다. 
     *
     * 2. 정사각형 설정
     *         2-1. 모든 참가자가 이동했다면, 좌상단부터 크기가 2,3 ... n인 정사각형을
     *              살펴보며 참가자와 출구가 최소 하나씩 포함되어있는지 확인하고 찾는다.
     * 3. 회전
     *         3-1. 정사각형의 크기를 살펴보고, 그에 맞춰 행의 끝에서부터 돌며 각 열에 
     *              삽입한다.(시계 방향 회전)
     * 
     * 4. 참가자가 존재하지 않고 게임이 끝났다면, 현재 출구 좌표와 이동거리 합을 출력한다. 
     * 
     */
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    miro = new int[N+1][N+1];
    Point[] perDir= new Point[M+1];
    int[] perOut = new int[M+1]; //탈출했으면 1
    
    
    //벽 삽입
    for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine());
        
        for (int j = 1; j <= N; j++) {
            miro[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    //참가자 삽입
    for (int i = 1; i <= M; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        miro[x][y] += -1;
        perDir[i] = new Point(x,y);
    }
    
    //출구 입력
    st = new StringTokenizer(br.readLine());
    exit = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
    
    miro[exit.x][exit.y] = -100; //출구는 -100
    
    //모든 참가자가 탈출하거나 K초가 지날 때까지
    for (int i = 1; i <= K; i++) {
        //참가자 탈출 검사
        int outTotal = 0;
        
        for (int j = 1; j <= M; j++) {
            outTotal += perOut[j];
        }
        
        if(outTotal == M) break;
   
        //참가자 이동
        for (int j = 1; j <= M; j++) {
            if(perOut[j] == 1) continue;
            
            int x = perDir[j].x;
            int y = perDir[j].y;
            
            //갈 좌표 선택. 만약 갈 곳이 없다면 -1,-1 return
            Point go = goPerson(x, y);
            
            if(go.x == -1) continue;
            
            //도달한 곳이 출구라면
            if(go.x == exit.x && go.y==exit.y) {
                perOut[j] = 1;
            } //갈 곳이 있다면
            else {
                miro[go.x][go.y] += -1;
            }
            
            total++;
            miro[x][y] -= -1;
            perDir[j] = new Point(go.x, go.y);
        }
        
        //정사각형 선택    
        int[] p = selectJung();
        
        //회전 개시
        int[][] tempArr = new int[N+1][N+1];
        
        if(p != null) {
        	ArrayList<int[]> temp = new ArrayList<int[]>();
     		
        	 for (int j = p[1]; j < p[1] + p[0]; j++) {
                 for (int k = p[2]; k < p[2] + p[0]; k++) {
                     //각 행을 돌며 tempArr의 각 열에 삽입
                	
                 	if(miro[j][k] > 0) {
                 		tempArr[p[1]+(k-p[2])][p[0]+p[2]-1 -(j-p[1])] = miro[j][k]-1;
                 	}
                 	else {
                 		//참가자. 위치 업데이트 해줘야 함
                 		//이 위치인 참가자 찾기
                 		
                 		if(miro[j][k] < 0) {
                 			if(miro[j][k] != -100) {
                     	
                     			for(int a=1; a< M+1; a++) {
                         			if(perDir[a].x == j && perDir[a].y==k) {
                         				int[] array = {a, p[1]+(k-p[2]), p[0]+p[2]-1 -(j-p[1])};
                         				temp.add(array);
                         			}
                         		}    	
                     		}
                     		else if(miro[j][k] == -100) {
                     			exit = new Point(p[1]+(k-p[2]), p[0]+p[2]-1 -(j-p[1]));
                     		}
                 		}

                 		tempArr[p[1]+(k-p[2])][p[0]+p[2]-1 -(j-p[1])] = miro[j][k]; 
                 	}
                 }
             }
        	 
        	 for (int[] l : temp) {
      			perDir[l[0]] = new Point(l[1], l[2]);
  			 }
  			
  			temp.clear();
  			
        	 
        	 for (int a = p[1]; a < p[1]+ p[0]; a++) {
                 for (int b = p[2]; b < p[2] + p[0]; b++) {
                     miro[a][b] = tempArr[a][b];
                 }
             }
        }
    }
    
    System.out.println(total + "\n" + exit.x + " " + exit.y);
}

static boolean checkJung(int j, int k, int m) {
    boolean isExit = false;
    boolean isPerson = false;
    
    for (int l = 0; l < j; l++) {
        for (int l2 = 0; l2 < j; l2++) {
            //4칸 돌기
            if(miro[k+l][m+l2] == -100) {
                isExit = true;
            }
            else if(miro[k+l][m+l2] < 0) {
                isPerson = true;
            }
            
            if(isExit== true && isPerson== true) {
                return true;
            }
        }
    }
    
    return false;
}

static int[] selectJung() {
    for (int j = 2; j <= N; j++) {
        
        for (int k = 1; k <= N-j+1; k++) {
            for (int m = 1; m <= N-j+1; m++) {
                //(k,m) 설정!
                
                if(checkJung(j, k,m)) {
                    //정사각형 찾기 성공
                    int[] t = {j,k,m};
                    return t;
                }
            }
        }
    }
    
    
    return null;
}

static Point goPerson(int x, int y) {
    //현 x,y에서 최단거리
    int curMinDir = Math.abs(exit.x-x) + Math.abs(exit.y-y);
    
    //상하좌우 확인
    for (int l = 0; l < 4; l++) {
        int tempX = x+ dx[l];
        int tempY = y+ dy[l];
        
        //범위 내에 존재한다면
        if(tempX > 0 && tempX <= N && tempY > 0 && tempY <= N) {
            //벽이 아니라면
            if(miro[tempX][tempY] <= 0) {
                int tempMinDir = Math.abs(exit.x-tempX) + Math.abs(exit.y-tempY);
                
                if(tempMinDir < curMinDir) {
                    //tempX, tempY가 가야될 부분
                    return new Point(tempX, tempY);
                }
            }
        }
    }

    return new Point(-1,-1);
}
}