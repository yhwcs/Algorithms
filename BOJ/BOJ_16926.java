/*
 * 소요 시간 : 1072ms 
 * 메모리 사용량 : 37,000kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	
	static int N, M, R, idx;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int range = Math.min(N, M) / 2;
		for(int i=0; i<R; i++) {
			idx = 0;
			for(int j=0; j<range; j++) {
				rotate(idx, idx, arr[idx][idx+1], 0);
				idx++;
			}
		}
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void rotate(int r, int c, int prev, int d) {
		if(r == idx && c == idx && d != 0) return;
		
		int temp = arr[r][c];
		arr[r][c] = prev;
		int nr = r + dr[d];
		int nc = c + dc[d];
		if(nr<idx || nr>=N-idx || nc<idx || nc>=M-idx) {
			d++;
			nr = r + dr[d];
			nc = c + dc[d];
		}
		rotate(nr, nc, temp, d);
	}

}
