/*
 * 소요 시간 : 284ms
 * 메모리 사용량 : 22,800kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] number = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			if(i<K) sum += number[i];
		}
		int max = sum;
		for(int i=K, j=0; i<N; i++, j++) {
			sum += number[i] - number[j];
			if(max < sum) max = sum;
		}
		System.out.println(max);
	}

}
