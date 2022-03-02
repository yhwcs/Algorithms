/*
 * 소요 시간 : 136ms
 * 메모리 사용량 : 14,340kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026 {
	
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 'G') arr[i][j] = 'R';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		char cur = arr[r][c];
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			
			if(!visited[nr][nc] && arr[nr][nc] == cur) 
				dfs(nr, nc);
		}
	}

}
