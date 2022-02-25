/*
 * 소요 시간 : 276ms
 * 메모리 사용량 : 22,528kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num, inCnt = 1, deCnt = 1, inMax = 1, deMax = 1;
		int prev = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num >= prev) inCnt++;
			else inCnt = 1;
			if(inMax < inCnt) inMax = inCnt;
			
			if(num <= prev) deCnt++;
			else deCnt = 1;
			if(deMax < deCnt) deMax = deCnt;
			
			prev = num;
		}
		System.out.println(Math.max(inMax, deMax));
	}

}
