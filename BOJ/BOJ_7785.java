import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		
		for(int i=0; i<n; i++) {
			String[] in = br.readLine().split(" ");
			String name = in[0];
			String log = in[1];
			
			if(log.equals("enter")) {
				set.add(name);
			} else if(log.equals("leave")) {
				set.remove(name);
			}
		}
		
		// 출력 : 사전 순의 역순
		ArrayList<String> answer = new ArrayList<String>(set);
		Collections.sort(answer, Collections.reverseOrder());
		for(String name : answer) {
			System.out.println(name);
		}
	}

}
