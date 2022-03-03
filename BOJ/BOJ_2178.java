/*
 * 소요 시간 : 92ms
 * 메모리 사용량 : 12,300kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

	static int[][] maze;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j)-'0';
			}
		}
		
		bfs(N, M);
		System.out.println(maze[N-1][M-1]);
	}
	
	public static void bfs(int N, int M) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		queue.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(maze[nr][nc] == 0 || visited[nr][nc]) continue;
				maze[nr][nc] = maze[current.r][current.c] + 1;
				if(nr==N-1 && nc==M-1) return;
				queue.offer(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
		
	}
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
