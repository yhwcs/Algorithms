/*
 * 소요 시간 : 100ms
 * 메모리 사용량 : 12,532kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	
	static int n, sx, sy, ex, ey;
	static Point[] store;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			store = new Point[n];
			st = new StringTokenizer(br.readLine(), " ");
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store[i] = new Point(x, y);
			}
			st = new StringTokenizer(br.readLine(), " ");
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			if(bfs()) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		
		queue.offer(new Point(sx, sy));
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			if(Math.abs(current.x-ex) + Math.abs(current.y-ey) <= 1000) return true;
			
			for(int i=0; i<n; i++) {
				if(visited[i]) continue;
				int nx = store[i].x;
				int ny = store[i].y;
				if(Math.abs(current.x-nx) + Math.abs(current.y-ny) <= 1000) {
					visited[i] = true;
					queue.offer(new Point(nx, ny));
				}
			}
		}
		return false;
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}