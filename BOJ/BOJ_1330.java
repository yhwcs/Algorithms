/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,296kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1330 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(A > B) System.out.println('>');
		else if(A < B) System.out.println('<');
		else System.out.println("==");
	}

}
