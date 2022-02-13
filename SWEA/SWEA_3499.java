import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_3499 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] cards;
		LinkedList<String> result;
		StringTokenizer st;
		StringBuilder sb;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			cards = new String[N];
			result = new LinkedList<String>();
			st = new StringTokenizer(br.readLine(), " ");
			
			int mid = N/2;
			for(int i=0; i<N; i++) {
				cards[i] = st.nextToken();
			}
			int idx = N%2==0? mid : mid+1;
			for(int i=0; i<mid; i++) {
				result.add(cards[i]);
				result.add(cards[idx+i]);
			}
			if(N%2!=0) result.add(cards[mid]);
			
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<N; i++) {
				sb.append(result.get(i)).append(" ");
			}
			System.out.println(sb.toString());
		}
		
	}

}
