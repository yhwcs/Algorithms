/*
 * 소요 시간 : 428ms
 * 메모리 사용량 : 16,184kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int x) {
		if(x == 1) return false;
		for(int i=2; i<=Math.sqrt(x); i++) {
			if(x % i == 0) return false;
		}
		return true;
	}

}
