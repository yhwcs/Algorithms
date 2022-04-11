/*
 * 소요 시간 : 119ms
 * 메모리 사용량 : 27,676kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607 {
	
	static final long P = 1234567891;
	static long[] fact;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		factorial();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long up, down;
			up = fact[N];							// N!
			down = (fact[N-R] * fact[R]) % P;		// (N-R)!*R!
			down = pow(down, P-2);					// 1/((N-R)!*R!)
			long ans = (up * down) % P;				// N! / ((N-R)!*R!)
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static long pow(long x, long y) {
		if(y == 0) return 1;
		else if(y == 1) return x;
		if(y%2 == 0) {
			long half  = pow(x, y/2);
			return (half * half) % P;
		}
		long half = pow(x, y-1) % P;
		return (half * x) % P;
	}
	
	public static void factorial() {
		fact = new long[1000001];
		fact[0] = 1;
		for(int i=1; i<1000001; i++) {
			fact[i] = (fact[i-1] * i) % P;
		}
	}

}
