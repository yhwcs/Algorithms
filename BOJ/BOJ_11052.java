/*
 * 소요 시간 : 100ms
 * 메모리 사용량 : 11,972kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N; i++) {
			for(int k=1; k<i; k++) {
				p[i] = Math.max(p[i], p[i-k] + p[k]);
			}
		}
		System.out.println(p[N]);
	}

}
