package PS240408;


import java.util.Scanner;

public class Solution_SWEA_5643_키순서_D4_이주호_2999ms {
    static int N,M, ans, tcnt, scnt;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt(); //학생 수
            M = sc.nextInt(); //비교 횟수

            map = new int[N+1][N+1];
            ans = 0;

            for(int i=0; i<M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                map[from][to] = 1;
            }

            for(int i=1; i<N+1; i++) {
                tcnt = 0;
                scnt = 0;
                taller(i, new boolean[N+1]);
                shorter(i, new boolean[N+1]);
                if(tcnt + scnt == N-1)
                    ans++;
            }

            System.out.println("#"+tc+" "+ans);
        }
    }

    static void taller(int from, boolean[] visited) {
        visited[from] = true;
        for(int i=1; i<N+1; i++) {
            if(!visited[i] && map[from][i] == 1) {
                taller(i, visited);
                tcnt++;
            }
        }
    }
    static void shorter(int to, boolean[] visited) {
        visited[to] = true;
        for(int i=1; i<N+1; i++) {
            if(!visited[i] && map[i][to] == 1) {
                shorter(i, visited);
                scnt++;
            }
        }
    }
}