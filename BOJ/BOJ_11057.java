/*
 * 소요 시간 : 112ms
 * 메모리 사용량 : 12,884kb
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11057 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] count = new int[10];
		int[] next = new int[10];
		Arrays.fill(count, 1);
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=j; k<=9; k++) {
					next[k] += count[j];
					next[k] %= 10007;
				}
			}
			for(int j=0; j<=9; j++) {
				count[j] = next[j];
				next[j] = 0;
			}
		}
		int sum = 0;
		for(int i=0; i<=9; i++) {
			sum += count[i];
			sum %= 10007;
		}
		System.out.println(sum);
	}

}
