/*
 * 소요 시간 : 112ms
 * 메모리 사용량 : 12,896kb
 */

import java.util.Scanner;

public class BOJ_2193 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long zero = 1;
		long one = 0;
		for(int i=2; i<N; i++) {
			long nextZero = one;
			one = zero;
			zero += nextZero;
		}
		System.out.println(one+zero);
	}

}
