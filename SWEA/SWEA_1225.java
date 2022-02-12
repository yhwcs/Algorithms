import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = null;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int num;
		for(int tc=1; tc<=10; tc++){
			queue = new LinkedList<Integer>();
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			LOOP: 
			while(true) {
				for(int i=1; i<=5; i++) {
					num = queue.poll() - i;
					if(num <= 0) {
						queue.offer(0);
						break LOOP;
					}
					queue.offer(num);
				}
			}
			sb.setLength(0);
			sb.append("#").append(t).append(" ");
			for(int data : queue) {
				sb.append(data).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
