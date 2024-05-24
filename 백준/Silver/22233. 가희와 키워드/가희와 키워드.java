import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			hs.add(s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			String[] tempS = s.split(",");
			
			for(String t : tempS) {
				if(hs.contains(t)) {
					hs.remove(t);
				}
			}

			bw.write(Integer.toString(hs.size()) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}