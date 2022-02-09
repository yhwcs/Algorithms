import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			if(checkGroup(word)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static boolean checkGroup(char[] word) {
		HashSet<Character> set = new HashSet<>();
		set.add(word[0]);
		for (int j = 1; j < word.length; j++) {
			// 이전 문자와 다른 경우
			if (word[j] != word[j - 1]) {
				// 이미 나타난 문자인 경우
				if (set.contains(word[j])) {
					return false;
				}
				set.add(word[j]);
			}
		}
		return true;
	}

}
