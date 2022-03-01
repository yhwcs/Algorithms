/*
 * 소요 시간 : 312ms
 * 메모리 사용량 : 24,468kb 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		int[] count = new int[N+1];
		int r, c, width, height;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			for(int j=r; j<r+height; j++) {
				for(int k=c; k<c+width; k++) {
					board[j][k] = i;
				}
			}
		}
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				count[board[i][j]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
