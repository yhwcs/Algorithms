/*
 * 소요 시간 : 220ms
 * 메모리 사용량 : 37,420kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17135 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int hashCode() {
			return this.r*M + this.c;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Point) {
				Point p = (Point) obj;
				if(this.r == p.r && this.c == p.c) return true;
				return false;
			}
			return super.equals(obj);
		}
	}
	
	static int N, M, D, max, total;
	static int[] archer;
	static boolean[][] map, temp;
	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[3];
		map = new boolean[N+1][M];
		temp = new boolean[N+1][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
				if(map[i][j]) total++;
			}
		}
		combination(0, 0);
		System.out.println(max);

	}
	
	public static void combination(int start, int cnt) {
		if(cnt == 3) {
			int count = go();
			if(max < count) max = count;
			return;
		}
		
		for(int i=start; i<M; i++) {
			archer[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	public static Point find(int col) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M];
		
		queue.offer(new Point(N-1, col));
		visited[N-1][col] = true;
		
		int dist = 1;
		while(!queue.isEmpty() && dist <= D) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Point current = queue.poll();
				
				if(temp[current.r][current.c]) return current;
				
				for(int d=0; d<3; d++) {
					int nr = current.r + dr[d];
					int nc = current.c + dc[d];
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
			dist++;
		}
		return null;
	}
	
	public static int shoot() {
		Set<Point> removeSet = new HashSet<>();
		for(int col : archer) {
			Point target = find(col);
			if(target != null) removeSet.add(target);
		}
		for(Point target : removeSet) {
			temp[target.r][target.c] = false;
		}
		return removeSet.size();
	}
	
	public static int move() {
		for(int i=N; i>0 ; i--) {
			for(int j=0; j<M; j++) {
				temp[i][j] = temp[i-1][j];
			}
		}
		Arrays.fill(temp[0], false);
		int save = 0;
		for(int i=0; i<M; i++) {
			if(temp[N][i]) save++;
		}
		
		return save;
	}
	
	public static int go() {
		for(int i=0; i<N; i++) temp[i] = Arrays.copyOf(map[i], M);
		
		int shootCnt = 0, saveCnt = 0;
		while(shootCnt + saveCnt < total) {
			shootCnt += shoot();
			saveCnt += move();
		}
		return shootCnt;
		
	}

}
