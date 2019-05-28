package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJO_15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //¼±¾ð
		BufferedWriter wf = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		int a,b;
		String s;
		for(int t =0; t<T; ++t) {
			s=bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			a= Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			wf.write(a+b+"\n");
		}
		wf.flush();
		bf.close();
		wf.close();
	}
}
