/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.io.*;
import java.awt.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		//트럭 무게 x, 현재 위치 y
		Point[] truck = new Point[n];
		
		for(int i=0; i<n; i++) {
		    truck[i] = new Point();
		    truck[i].x = Integer.parseInt(st.nextToken());
 		}
		
		int start = 0;
		int bridgeWeight = 0;
		
		/*
		 현재 다리의 무게를 모니터링하다가,
		 초마다 다음 트럭을 얹어봤을 때 하중이 넘친다면 안 올린다.
		 다리 위의 트럭의 위치는 계속 증가시킴.
		 모든 트럭이 건너간다면 종료
		*/
		int time = 0;
		int end = 0;
		
		while(true) {
		    time++;
		    //System.out.println("시간: " + time);
		    
		     //다리 위 트럭 위치 업데이트		    
		    for(int i=end; i< start; i++) {
		        truck[i].y += 1;
		        
		        //끝난 트럭은 무게 빼기
		        if(truck[i].y > w) {
		            //System.out.println(end + "번 트럭 빠짐!!!!!");
		            bridgeWeight -= truck[end].x;
		            end++;
		        }
		        
		        //System.out.println(end +"번 트럭 빠질 차례, 무게는 " + bridgeWeight);
		    }
		    
		    //다리에 트럭 올리기
		    if(start < n) {
		        if(bridgeWeight + truck[start].x <= L) {
		            //System.out.println(start + "번 트럭 올림!!!");
		            truck[start].y += 1;
		            bridgeWeight += truck[start].x;
		            start++;
		        }    
		    }
		    
		    //System.out.println(start + " 무게는 " + bridgeWeight);
		    
           
		    
		   // System.out.println(Arrays.toString(truck));
		    
		    if(end >= n) break;
		}
		
		
		System.out.println(time);
		
		
	}
}
