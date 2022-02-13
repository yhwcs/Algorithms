import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		LinkedList<String> list;
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			list = new LinkedList<String>();
			for(int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			int commands = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<commands; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				for(int j=0; j<s; j++) {
					list.add(idx+j, st.nextToken());
				}
			}
			
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
