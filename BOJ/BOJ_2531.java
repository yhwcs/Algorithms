/*
 * 소요 시간 : 148ms
 * 메모리 사용량 : 16,428kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] dishes = new int[N];
		for(int i=0; i<N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		// 한 종류당 몇번 선택했는지 저장
		int[] picked = new int[d+1];
		int count = 0;
		for(int i=0; i<k; i++) {
			int next = dishes[i];
			// 선택한 적 없는 종류라면 count 추가
			if(picked[next] == 0) count++;
			picked[next]++;
		}
		int max = count;
		for(int i=0; i<N; i++) {
			if(max <= count) {
				max = count;
				// 쿠폰 종류와 겹치지 않았다면 count 추가
				if(picked[c] == 0) max++;
			}
			
			int prev = dishes[i];
			picked[prev]--;
			if(picked[prev] == 0) count--;
			
			int next = dishes[(i+k)%N];
			if(picked[next] == 0) count++;
			picked[next]++;
		}
		
		System.out.println(max);
		
	}

}
