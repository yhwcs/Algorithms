/*
 * 소요 시간 : 144ms
 * 메모리 사용량 : 16,140kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N+1];
		Arrays.fill(count, N);
		count[1] = 0;
		for(int i=1; i<=N; i++) {
			if(3*i <= N && count[3*i] > count[i]+1) count[3*i] = count[i]+1;
			if(2*i <= N && count[2*i] > count[i]+1) count[2*i] = count[i]+1;
			if(i+1 <= N && count[i+1] > count[i]+1) count[i+1] = count[i]+1;
		}
		System.out.println(count[N]);
	}

}
