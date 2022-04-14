/*
 * 소요 시간 : 108ms
 * 메모리 사용량 : 12,900kb
 */

import java.util.Scanner;

public class BOJ_11726 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		num[0] = 1; 
		num[1] = 1;
		for(int i=2; i<=n; i++) {
			num[i] = num[i-1] + num[i-2];
			num[i] %= 10007;
		}
		System.out.println(num[n]);
	}

}
