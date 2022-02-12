import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) throws Exception {
		Stack<Character> stack = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length;
		String line;
		char result;
		char c;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		for(int t=1; t<=10; t++) {
			stack = new Stack<Character>();
			length = Integer.parseInt(br.readLine());
			line = br.readLine();
			for(int i=0; i<length; i++) {
				c = line.charAt(i);
				if(!stack.isEmpty() && map.get(c)==stack.peek()) stack.pop();
				else stack.push(c);
			}
			result = stack.isEmpty()? '1' : '0';
			System.out.println("#"+t+" "+result);
		}
	}
}
