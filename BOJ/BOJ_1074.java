/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,160kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {

	static int r, c, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		z((int)Math.pow(2, N), 0, 0);
		
		System.out.println(cnt);
	}
	
	public static void z(int n, int i, int j) {
		if(n == 1) return;
		
		int mid = n/2;
		if(r >= i+mid) {
			i += mid;
			cnt += n*n/2;
		}
		if(c >= j+mid) {
			j += mid;
			cnt += n*n/4;
		}
		z(mid, i, j);
	}

}
