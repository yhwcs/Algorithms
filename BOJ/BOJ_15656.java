/*
 * 소요 시간 : 660ms
 * 메모리 사용량 : 123,664kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {

	static int N, M;
	static int[] result;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		result = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
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
		
		for(int i=0; i<N; i++) {
			result[cnt] = input[i];
			permutation(cnt+1);
		}
	}
	
}
