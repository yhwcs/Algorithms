/*
 * 소요 시간 : 364ms
 * 메모리 사용량 : 29668kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

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
		permutation(0, new boolean[N]);
		
		System.out.println(sb.toString());
	}
	
	public static void permutation(int cnt, boolean[] isSelected) {
		if(cnt == M) {
			for(int r : result) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) {
				result[cnt] = input[i];
				isSelected[i] = true;
				permutation(cnt+1, isSelected);
				isSelected[i] = false;
			}
		}
	}

}
