/*
 * 소요 시간 : 664ms
 * 메모리 사용량 : 120,532kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	
	static int M, N, cnt;
	static int[][] box;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Point> tomatoes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		tomatoes = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) cnt++;
				else if(box[i][j] == 1) tomatoes.add(new Point(i, j, 0));
			}
		}
		
		if(cnt == 0) System.out.println(0);
		else System.out.println(bfs());

	}
	
	public static int bfs() {

		while(!tomatoes.isEmpty()) {
			Point current = tomatoes.poll();

			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(box[nr][nc] != 0) continue;
				if(--cnt == 0) return current.time+1;
				box[nr][nc] = 1;
				tomatoes.offer(new Point(nr, nc, current.time+1));
			}
		}
		return -1;
	}
	
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
