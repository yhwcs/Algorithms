import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		// {idx, height}
		Stack<int[]> stack = new Stack<int[]>();

		for(int i=1; i<=N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= top) {
					sb.append(stack.peek()[0]+" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append("0 ");
			stack.push(new int[] {i, top});
		}

		System.out.println(sb.toString());
	}

}
