import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
 
public class Main {
    static int n, k;
    static int [] arr;
    static int max;
    static int count;
    static boolean [] check;
    static int first=1, second=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        check = new boolean[n+1];
        arr= new int[n+1];
        String[] s1 = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(s1[i-1]);
            arr[i]=num;
            if(num%2!=1){
                check[i]=true;
            }
        }
        solve();
        System.out.println(max);
    }
 
    public static void solve(){
        while (second<=n){
            if(count<k){ // count<k 를 만족할 때까지 계속해서 count를 증가하며 수열의 길이를 증가시킬 수 있다. 
                if(!check[second]){
                    count++;
                }
                second++;
                max = Math.max(max,second-first-count);
            }
            else if(check[second]){ // count==K를 만족하지만 뒤 숫자가 짝수여서 더 길게 가능하다.
                second++;
                max = Math.max(max,second-first-count);
            }
            else if(count==k && !check[second]){ // count==K가 됐으며 뒤의 수도 홀수일 때 first를 증가시킵니다. 
                if(!check[first]){ // first가 있던 위치의 수가 홀수일 때 count를 낮추며 아닌 경우에는 count는 냅둡니다.
                    count--;
                }
                first++;
            }
        }
    }
}