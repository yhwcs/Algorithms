/*
 * 소요 시간 : 668ms 
 * 메모리 사용량 : 121,668kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

	static int N, M, H, cnt;
	static int[][][] box;
	static Queue<Point> tomatoes;
	static int dh[] = {-1, 1, 0, 0, 0, 0};
	static int dr[] = {0, 0, -1, 1, 0, 0};
	static int dc[] = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		tomatoes = new LinkedList<>();
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) tomatoes.add(new Point(i, j, k));
					else if(box[i][j][k] == 0) cnt++;
				}
			}
		}
		if(cnt == 0) System.out.println(0);
		else System.out.println(bfs());
	}
	
	public static int bfs() {
		int ans = 0;
		while(!tomatoes.isEmpty()) {
			int size = tomatoes.size();
			while(size-- > 0) {
				Point tomato = tomatoes.poll();
				
				for(int d=0; d<6; d++) {
					int nh = tomato.h + dh[d];
					int nr = tomato.r + dr[d];
					int nc = tomato.c + dc[d];
					if(nh<0 || nh>=H || nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(box[nh][nr][nc] != 0) continue;
					if(--cnt == 0) return ans+1;
					box[nh][nr][nc] = 1;
					tomatoes.offer(new Point(nh, nr, nc));
				}
			}
			ans++;
		}
		return -1;
	}
	
	static class Point {
		int h, r, c;

		public Point(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

}
