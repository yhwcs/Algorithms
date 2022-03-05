/*
 * 소요 시간 : 468ms
 * 메모리 사용량 : 128,756kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {

	static int N, M;
	static int[][] height;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		height = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int t = 0;
		while(true) {
			int count = countArea();
			if(count > 1) break;
			// 빙산이 다 녹을 때까지 분리되지 않은 경우
			else if(count == 0) {
				t = 0;
				break;
			}
			bfs();
			t++;
		}
		System.out.println(t);
	}
	
	public static void bfs() {
		Queue<Point> iceberg = new LinkedList<>();
		// 같은 해에 빙산이 녹아서 0이 되어도 옆 빙산에 영향 주지 않게 처리
		boolean[][] isIceberg = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(height[i][j] > 0) {
					iceberg.offer(new Point(i, j));
					isIceberg[i][j] = true;
				}
			}
		}
	
		while(!iceberg.isEmpty()) {
			Point current = iceberg.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(!isIceberg[nr][nc] && height[nr][nc] <= 0) height[current.r][current.c]--;
			}
		}
	}
	
	public static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			if(height[nr][nc] > 0 && !visited[nr][nc]) dfs(nr, nc, visited);
		}
	}
	
	// 빙산 덩어리 개수 세기
	public static int countArea() {
		int count = 0;
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(height[i][j] > 0 && !visited[i][j]) {
					dfs(i, j, visited);
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
