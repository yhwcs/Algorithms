/*
 * 소요 시간 : 292ms
 * 메모리 사용량 : 28,568kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] A = new int[4+1];
		int[] B = new int[4+1];
		int num;
		int N = Integer.parseInt(br.readLine());
		for(int t=0; t<N; t++) {
			// Initializing
			for(int i=0; i<5; i++) {
				A[i] = 0; B[i] = 0;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				num = Integer.parseInt(st.nextToken());
				A[num]++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			for(int i=0; i<b; i++) {
				num = Integer.parseInt(st.nextToken());
				B[num]++;
			}
			
			// 별 > 동그라미 > 네모 > 세모 : 4 3 2 1
			int idx;
			for(idx=4; idx>0; idx--) {
				if(A[idx] == B[idx]) continue;
				if(A[idx] > B[idx]) sb.append("A");
				else if(A[idx] < B[idx]) sb.append("B");
				break;
			}
			if(idx == 0) sb.append("D");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
