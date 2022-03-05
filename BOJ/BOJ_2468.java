/*
 * 소요 시간 : 232ms
 * 메모리 사용량 : 16,260kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {

	static int N, rain;
	static int[][] height;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		height = new int[N][N];
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				if(max < height[i][j]) max = height[i][j];
			}
		}
		
		int ans = 0;
		for(int i=0; i<=max; i++) {
			visited = new boolean[N][N];
			rain = i;
			int area = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k] && height[j][k] > i) {
						dfs(j, k);
						area++;
					}
				}
			}
			if(area > ans) ans = area;
		}
		System.out.println(ans);
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(visited[nr][nc] || height[nr][nc] <= rain) continue;
			dfs(nr, nc);
		}
	}
}
