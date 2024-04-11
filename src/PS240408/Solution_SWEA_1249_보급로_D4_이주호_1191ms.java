package PS240408;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1249_보급로_D4_이주호_1191ms {

static int N,ans;
static int dir[][] = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};

static boolean[][] visited;
static int[][] sum;
static int [][] arr;
static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
static StringBuilder sb=new StringBuilder();

public static void main(String[] args) throws  IOException {
    // TODO Auto-generated method stub
         long start=System.currentTimeMillis();
        int T = Integer.parseInt(br.readLine());
        for (int o = 1; o <= T; o++) {
            ans=Integer.MAX_VALUE;
            N=Integer.parseInt(br.readLine());
            arr=new int[N][N];
            visited= new boolean[N][N];
            sum=new int[N][N];
            for(int i=0;i<N;i++) {
                Arrays.fill(sum[i], Integer.MAX_VALUE);
            }
            
            
            for(int i=0;i<N;i++) {
                char[] str=br.readLine().toCharArray();
                for(int j=0;j<N;j++) {
                    arr[i][j]=str[j]-'0';
                }
            }
            sum[0][0]=0;
            visited[0][0]=true;
            dfs(0,0);
            
            sb.append("#" + o + " " + ans+"\n");

            
            
        }
        System.out.println(sb);
        System.out.println(System.currentTimeMillis()-start);
}
public static void dfs(int x, int y) {
    if(x==N-1&&y==N-1) {
        ans=Math.min(ans,sum[x][y]);
        return;
    }
    if(ans<=sum[x][y]) return;
    for(int a=0;a<4;a++) {
        int nx=x+dir[a][0];
        int ny=y+dir[a][1];
        if(nx>=0&&ny>=0&&nx<N&&ny<N) {
            int tmp=sum[x][y]+arr[nx][ny];
            if(!visited[nx][ny]||tmp<sum[nx][ny]) {        
                visited[x][y]=true;
                sum[nx][ny]=tmp;
                dfs(nx,ny);

           }
        }
    }
    
   
}
}