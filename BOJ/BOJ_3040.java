/*
 * 소요 시간 : 120ms
 * 메모리 사용량 : 14,220kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3040 {

	static int[] num;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = new int[9];
		ans = new int[9];
		
		for(int i=0; i<9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
	
		combination(0, 0);

	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += ans[i];
			}
			if(sum == 100) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<7; i++) {
					sb.append(ans[i]).append("\n");
				}
				System.out.println(sb.toString());
			}
		}
		
		for(int i=start; i<9; i++) {
			ans[cnt] = num[i];
			combination(cnt+1, i+1);
		}
	}

}
