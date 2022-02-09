import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 현재 스택에 넣으려는 숫자 인덱스
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			// 뽑으려는 숫자까지 스택에 넣는다
			for(int j=idx; j<=num; j++) {
				stack.push(j);
				sb.append("+\n");
				idx++;
			}
			// 뽑은 숫자가 해당 숫자가 아니라면 수열을 만들 수 없다
			if(stack.pop() != num) {
				System.out.println("NO");
				return;
			}
			sb.append("-\n");
		}
		System.out.print(sb);
	}

}
