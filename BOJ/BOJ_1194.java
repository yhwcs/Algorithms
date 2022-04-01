/*
 * 소요 시간 : 104ms
 * 메모리 사용량 : 13,772kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	
	static class Point {
		int r, c, count, key;

		public Point(int r, int c, int count, int key) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.key = key;
		}

	}

	static int N, M;
	static char[][] maze;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		Point start = new Point(0, 0, 0, 0);
		
		for(int i=0; i<N; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(maze[i][j] == '0') start = new Point(i, j, 0, 0);
			}
		}
		
		System.out.println(bfs(start));
		

	}
	
	public static int bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][64];
		
		queue.offer(start);
		visited[start.r][start.c][0] = true;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc][current.key]) continue;
				
				char next = maze[nr][nc];
				if(next == '1') return current.count+1;		// 출구
				if(next == '#') continue;					// 벽
				if(next >= 'A' && next <= 'F') {			// 문
					int door = 1 << (next - 'A');
					if((current.key & door) > 0) {
						visited[nr][nc][current.key] = true;
						queue.offer(new Point(nr, nc, current.count+1, current.key));
					}
				} else if(next >= 'a' && next <= 'f') {		// 열쇠
					int key = 1 << (next - 'a');
					key = key | current.key;
					// 이 key를 처음 얻어서 이 위치에 방문하는 경우
					if(!visited[nr][nc][key]) {
						visited[nr][nc][key] = true;
						visited[nr][nc][current.key] = true;
						queue.offer(new Point(nr, nc, current.count+1, key));
					}
				} else {									// 빈 칸
					visited[nr][nc][current.key] = true;
					queue.offer(new Point(nr, nc, current.count+1, current.key));
				}
			}
		}
		
		return -1;
		
	}

}
