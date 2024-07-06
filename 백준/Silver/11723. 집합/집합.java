import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int M = Integer.parseInt(br.readLine());
		//List<Integer> all = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		StringTokenizer st;
		
		HashSet<Integer> ans = new HashSet<Integer>();
		HashSet<Integer> emp = new HashSet<Integer>();
		
		for (int i = 1; i <= 20; i++) {
			hs.add(i);
		}
		
		String a;
		int b = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = st.nextToken();
			if(!a.equals("all") && !a.equals("empty")) {
				b = Integer.parseInt(st.nextToken());
				
			}
			boolean flag = ans.contains(b);
			
			
			if (a.equals("add")) {
			    if (!flag) {
			        ans.add(b);
			    }
			} else if (a.equals("remove")) {
			    if (flag) {
			        ans.remove(b);
			    }
			} else if (a.equals("check")) {
			    if (flag) {
			        sb.append(1);
			    } else {
			        sb.append(0);
			    }
			    bw.flush();
			} else if (a.equals("toggle")) {
			    if (flag) {
			        ans.remove(b);
			    } else {
			        ans.add(b);
			    }
			} else if (a.equals("all")) {
			    ans = new HashSet<Integer>(hs);
			} else if (a.equals("empty")) {
			    ans = new HashSet<Integer>(emp);
			}
		};
		
		
		
		for(int i=0; i< sb.length(); i++) {
			bw.write(sb.charAt(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}