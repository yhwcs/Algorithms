/*
 * 소요 시간 : 108ms
 * 메모리 사용량 : 12,908kb
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10844 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] count = new int[10];
		int[] next = new int[10];
		for(int i=1; i<=9; i++) {
			count[i] = 1;
		}
		for(int i=1; i<N; i++) {
			for(int j=1; j<=8; j++) {
				next[j-1] += count[j];
				next[j+1] += count[j];
				next[j-1] %= 1000000000;
				next[j+1] %= 1000000000;
			}
			next[1] += count[0];
			next[8] += count[9];
			next[1] %= 1000000000;
			next[8] %= 1000000000;
			for(int j=0; j<=9; j++) {
				count[j] = next[j];
			}
			Arrays.fill(next, 0);
		}
		int sum = 0;
		for(int i=0; i<=9; i++) {
			sum += count[i];
			sum %= 1000000000;
		}
		System.out.println(sum);
	}

}
