/*
 * 소요 시간 : 480ms
 * 메모리 사용량 : 68,536kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {

	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for(int r : result) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			result[cnt] = i;
			permutation(cnt+1);
		}
	}

}
