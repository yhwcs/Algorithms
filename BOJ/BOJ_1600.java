/*
 * 소요 시간 : 496ms
 * 메모리 사용량 : 88,676kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	
	static class Point {
		int r, c, k, count;

		public Point(int r, int c, int k, int count) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;				// 현재 말처럼 이동한 횟수
			this.count = count;		// 현재 총 이동횟수
		}
	}
	
	static int K, W, H;
	static boolean[][] board;
	static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new boolean[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				board[i][j] = st.nextToken().equals("1")? true:false;
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			if(current.r == H-1 && current.c == W-1) return current.count;
			// 1. 일반 이동하는 경우
			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=H || nc<0 || nc>=W || board[nr][nc]) continue;
				if(visited[nr][nc][current.k]) continue;
				visited[nr][nc][current.k] = true;
				queue.offer(new Point(nr, nc, current.k, current.count+1));
			}
			if(current.k >= K) continue;
			// 2. 말처럼 이동하는 경우
			for(int d=0; d<8; d++) {
				int nr = current.r + hdr[d];
				int nc = current.c + hdc[d];
				if(nr<0 || nr>=H || nc<0 || nc>=W || board[nr][nc]) continue;
				if(visited[nr][nc][current.k+1]) continue;
				visited[nr][nc][current.k+1] = true;
				queue.offer(new Point(nr, nc, current.k+1, current.count+1));
			}
				
		}
		return -1;
	}

}
