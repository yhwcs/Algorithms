/*
 * 소요 시간 : 80ms
 * 메모리 사용량 : 11,844kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	
	static int N, M, count;
	static int[][] space;
	static final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		space = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, d);
		System.out.println(count);
	}
	
	public static void clean(int r, int c, int d) {
		// 현재 위치를 청소
		if(space[r][c] == 0) {
			space[r][c] = 2;
			count++;
		}
		
		int i;
		int original = d;
		// 네 방향 탐색
		for(i=0; i<4; i++) {
			int nd = (d+3)%4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(nr>0 || nr<N || nc>0 || nc<M) {
				// 왼쪽 방향에 청소할 공간이 존재한다면
				if(space[nr][nc] == 0) {
					clean(nr, nc, nd);
					break;
				}
			}
			d = nd;
		}
		// 네 방향 모두 청소가 이미 되어있거나 벽인 경우
		if(i == 4) {
			int back = (d+2)%4;
			int nr = r + dr[back];
			int nc = c + dc[back];
			if(nr>0 || nr<N || nc>0 || nc<M) {
				// 뒤쪽 방향이 벽이 아니라 후진이 가능한 경우
				if(space[nr][nc] != 1)
					clean(nr, nc, original);
			}
			
		}
	}
}
