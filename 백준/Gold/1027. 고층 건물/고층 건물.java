import java.io.*;
import java.util.*;

class Main {
    public static int[] building;
    public static int N, answer;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = 0;
        building = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int Tc = 0; Tc < N; Tc++) {
            building[Tc] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            bruteForce(i);
        }
        System.out.println(answer);
    }
 
    public static void bruteForce(int idx) {
        int cnt = 0;
        double leftSlope = Integer.MAX_VALUE;
        double rightSlope = Integer.MIN_VALUE;
 
        // left
        for (int i = idx - 1; i >= 0; i--) {
            double incline = (double) (building[idx] - building[i]) / (idx - i);
            if (incline < leftSlope) {
                cnt++;
                leftSlope = incline;
            }
        }
 
        // right
        for (int i = idx + 1; i < N; i++) {
            double incline = (double) (building[idx] - building[i]) / (idx - i);
            if (incline > rightSlope) {
                cnt++;
                rightSlope = incline;
            }
        }
 
        answer = Math.max(answer, cnt);
    }
}