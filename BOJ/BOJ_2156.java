/*
 * 소요 시간 : 104ms 
 * 메모리 사용량 : 13,092kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] amount = new int[n+1];
		int[] sum = new int[n+1];
		for(int i=1; i<=n; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		if(n>=1) sum[1] = amount[1];
		if(n>=2) sum[2] = amount[1] + amount[2];
		for(int i=3; i<=n; i++) {
			sum[i] = sum[i-1];		// 마시지 않은 경우
			sum[i] = Math.max(sum[i], sum[i-2] + amount[i]);		// 1번 연속 
			sum[i] = Math.max(sum[i], sum[i-3] + amount[i-1] + amount[i]);		// 2번 연속 
		}
		System.out.println(sum[n]);
	}

}
