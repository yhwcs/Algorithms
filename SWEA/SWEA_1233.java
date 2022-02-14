/*
 * 소요 시간 : 123ms 
 * 메모리 사용량 : 18,624kb
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			char answer = '1';
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// index 삭제
				st.nextToken();
				// 값은 알파벳
				char value = st.nextToken().charAt(0);
				// leaf node가 아니라면 연산자여야 한다
				if(st.hasMoreTokens()) {
					if(value>='0' && value<='9') {
						answer = '0';
					}
				}
				// leaf node라면 숫자여야 한다
				else {
					if(value<'0' || value>'9') {
						answer = '0';
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
