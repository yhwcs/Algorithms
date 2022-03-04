/*
 * 소요 시간 : 84ms
 * 메모리 사용량 : 11,680kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ_2667 {

	static int N, count;
	static char[][] houses;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		houses = new char[N][];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			houses[i] = br.readLine().toCharArray();
		}
		List<Integer> list = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(houses[i][j] == '0' || visited[i][j]) continue;
				count = 0;
				dfs(i, j);
				list.add(count);
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for(int cnt : list) {
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		count++;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(houses[nr][nc] == '0' || visited[nr][nc]) continue;
			dfs(nr, nc);
		}
	}
}
