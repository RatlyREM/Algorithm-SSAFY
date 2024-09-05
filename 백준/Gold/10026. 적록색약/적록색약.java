import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        char[][] color = new char[N][N];
        char[][] rokColor = new char[N][N];
        
        for(int i=0; i<N; i++) {
            String s = br.readLine();

            for(int j=0; j<N; j++) {
                color[i][j] = s.charAt(j);
                
                if(color[i][j] == 'R') {
                    rokColor[i][j] = 'G';
                }
                else {
                	rokColor[i][j] = color[i][j];
                }
            }
        }
        
        //BFS 시작
        System.out.println(BFS(color) + " " + BFS(rokColor));


    }
    
    static int BFS(char[][] color) {
    	int[][] visited = new int[N][N];
    	Queue<Point> qu = new LinkedList<>();
    	
    	int total = 0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					//BFS 진행
					total++;
					
					visited[i][j] = 1;
					qu.add(new Point(i,j));
					
					while(!qu.isEmpty()) {
						Point temp = qu.poll();
						
						for (int k = 0; k < 4; k++) {
							int tempX = temp.x+ dx[k];
							int tempY = temp.y+ dy[k];
							
							if(tempX >=0 && tempX <N && tempY >= 0 && tempY <N) {
								if(visited[tempX][tempY] == 0 && color[tempX][tempY] == color[temp.x][temp.y]) {
									visited[tempX][tempY] = 1;
									
									qu.add(new Point(tempX, tempY));
								}
							}
						}
						
					}
				}
			}
		}
    	
    	return total;
    }
}