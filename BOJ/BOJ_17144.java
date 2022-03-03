/*
 * 소요 시간 : 384ms
 * 메모리 사용량 : 131,132kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int R, C, T, purifier;
	static int[][] space;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Point> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		space = new int[R][C];
		queue = new LinkedList<>();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == -1) purifier = i;
			}
		}
		while(T-- > 0) {
			makeQueue();
			bfs();
			cleanTop();
			cleanBottom();
		}
		
		System.out.println(check());
	}
	
	public static void makeQueue() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(space[i][j] > 0) queue.offer(new Point(i, j, space[i][j]));
			}
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int give = current.dust/5;
			if(give < 1) continue;
			int count = 0;
			
			for(int d=0; d<4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(space[nr][nc] == -1) continue;
				space[nr][nc] += give;
				count++;
			}
			space[current.r][current.c] -= give*count;
		}
	}
	
	public static void cleanTop(){
        int top = purifier-1;
        for(int r=top-1; r>0; r--) space[r][0] = space[r-1][0];
        for(int c=0; c<C-1; c++) space[0][c] = space[0][c+1];
        for(int r=0; r<top; r++) space[r][C-1] = space[r+1][C-1];
        for(int c=C-1; c>1; c--) space[top][c] = space[top][c-1];
        space[top][1] = 0;
    }
	
    public static void cleanBottom(){
        int bottom = purifier;
        for(int r=bottom+1; r<R-1; r++) space[r][0] = space[r+1][0];
        for(int c=0; c<C-1; c++) space[R-1][c] = space[R-1][c+1];
        for(int r=R-1; r>bottom; r--) space[r][C-1] = space[r-1][C-1];
        for(int c=C-1; c>1; c--) space[bottom][c] = space[bottom][c-1];
        space[bottom][1] = 0;
    }
    
	
	public static int check() {
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += space[i][j];
			}
		}
		return sum+2;
	}
	
	static class Point {
		int r, c, dust;

		public Point(int r, int c, int dust) {
			super();
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
	}

}
