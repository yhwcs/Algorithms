/*
 * 소요 시간 : 220ms
 * 메모리 사용량 : 22,748kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] number = new int[N+1];
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());		
		}
		int count = N+1;
		int start =0, end = 0, sum = 0;
		while(start <= N && end <= N) {
			if(sum >= S) {
				if(count > (end - start)) count = end - start;
			}
			if(sum < S) sum += number[end++];
			else sum -= number[start++];
		}
		System.out.println(count == N+1 ? 0 : count);
	}

}
