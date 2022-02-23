/*
 * 소요 시간 : 124ms
 * 메모리 사용량  : 14204kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int quotient = N/5;
		int remainder = N%5;
		int min;
		
		if(remainder == 0) min = quotient;
		else {
			while(true) {
				if(quotient < 0) {
					min = -1;
					break;
				}
				if(remainder % 3 == 0) {
					min = quotient + remainder/3;
					break;
				} else {
					quotient -= 1;
					remainder += 5;
				}
			}
		}

/*
 * 소요 시간 : 128ms
 * 메모리 사용량 : 14296kb
 */
//		int min = N/3+1;
//		int remainder;
//		
//		if(N%5 == 0) {
//			min = N/5;
//		} else {
//			for(int i=N/5; i>=0; i--) {
//				remainder = N - i*5;
//				if(remainder%3 == 0) min = Math.min(min, i+remainder/3);
//			}
//		}
//		if(min == N/3+1) min = -1;
		
		System.out.println(min);
	}

}
