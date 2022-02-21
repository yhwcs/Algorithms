/*
 * 소요 시간 : 120ms
 * 메모리 사용량 : 14,084kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	
	static int N;
	static int[] sour, bitter;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(generateSubset());

	}
	
	public static int generateSubset() {
		int mul, sum;
		int min = Integer.MAX_VALUE;
		int diff;
		for(int flag=1, caseCount=1<<N; flag<caseCount; flag++) {
			mul = 1; sum = 0;
			for(int i=0; i<N; i++) {
				if((flag & 1<<i) != 0) {
					mul *= sour[i];
					sum += bitter[i];
				}
			}
			diff = Math.abs(mul - sum);
			if(diff < min) min = diff;
		}
		return min;
	}

}
