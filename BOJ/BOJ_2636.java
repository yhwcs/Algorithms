/*
 * 소요 시간 : 112ms
 * 메모리 사용량 : 13,456kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C;
	static boolean[][] board;
	static int cheese;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				board[i][j] = st.nextToken().equals("1")? true : false;
				if(board[i][j]) cheese++;
			}
		}
		
		int time = 0, count = 0;
		while(cheese > 0) {
			time++;
			count = cheese;
			bfs();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(time).append("\n").append(count);
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		boolean[][] visited = new boolean[R][C];
		Queue<Point> queue = new LinkedList<>();
		// 공기를 탐색해서 주위에 치즈가 있는 경우 녹이기
		queue.offer(new Point(0,0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int d = 0;
			while(d < 4) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				d++;
				if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]) continue;
				if(board[nr][nc]) {	// 치즈인 경우
					cheese--;
					board[nr][nc] = false;
				} else {			// 공기인 경우
					queue.offer(new Point(nr, nc));
				}
				visited[nr][nc] = true;
			}
		}
	}

}
