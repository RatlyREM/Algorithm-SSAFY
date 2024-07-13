import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        Arrays.sort(arr);
        
        //첫 번째는 이미 삽입된 상태
        //count를 뭘로 할지 이분탐색으로 찾아야 한다!!
        
        int left = 1;
        int right = arr[N-1]-arr[0]+1;
        
        
        while(left < right) {
        	int mid = (left+right)/2;
        	
        	//공유기가 너무 안 박혀있음!!
        	if(findNum(mid) < C) {
        		right = mid;
        	}
        	else {
        		left = mid+1;
        	}
        }
        
        System.out.println(left-1);
        
    }
    
    //공유기 몇 개 박을 수 있는가?
    static int findNum(int count) {
    	int last = arr[0];
    	int c = 1;
    	
    	for (int i = 1; i < N; i++) {
			//집 간 차이가 공유기 박을 수 있을 때
    		if(arr[i]-last >= count) {
    			last = arr[i];
    			c++;
    		}
    		
		}
    	
    	
    	return c;
    }
}