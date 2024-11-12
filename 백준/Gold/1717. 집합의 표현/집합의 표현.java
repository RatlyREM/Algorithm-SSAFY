import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        /*
        union-find.
        연산 1. -> union.

        연산 2. -> find.

        parent 배열. 처음에 자기 자신으로 초기화.
        자기 자신이면, 본인이 root라는 것으 ㄹ의미.

        union 연산은, 번호가 더 작은 정점을 부모로 만든다.
        find 연산은, 해당 정점의 root를 찾는다.
        만약 root가 똑같다면 같은 집합에 포함되어 있다는 것.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(t == 0) union(a,b);
            else if(t==1) {
                sb.append((find(a) == find(b)) ? "YES\n" : "NO\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int p) {
        if(parent[p] == p) return p;
        else return parent[p] = find(parent[p]);
//        if(parent[p] != p) p = find(parent[p]);
//        return p;
    }

    static void union(int p, int q) {
        int a = find(p);
        int b = find(q);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }


}