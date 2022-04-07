/*
 * 소요 시간 : 132ms
 * 메모리 사용량 : 25,284kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, R, C, L;
	static int[][] map;
	static int[][] dr, dc;
	static final int CURRENT = 0, NEXT = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		dr = new int[2][];
		dc = new int[2][];
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ").append(bfs()).append("\n");
		}
		System.out.println(sb.toString());

	}
	
	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int count = 1;
		int time = 0;
		
		queue.offer(new Point(R, C));
		visited[R][C] = true;
		
		while(++time < L) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Point current = queue.poll();
				
				setDirection(map[current.r][current.c], CURRENT);
				
				for(int d=0; d<dr[CURRENT].length; d++) {
					int nr = current.r + dr[CURRENT][d];
					int nc = current.c + dc[CURRENT][d];
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
					
					// 다음 위치의 터널 구조물 타입에 따라 연결된 방향을 확인하고 현재 위치의 터널 구조물과 연결되지 않은 경우 continue
					setDirection(map[nr][nc], NEXT);
					boolean connected = false;
					for(int nd=0; nd<dr[NEXT].length; nd++) {
						if(dr[NEXT][nd] == -1 * dr[CURRENT][d] && dc[NEXT][nd] == -1 * dc[CURRENT][d]) {
							connected = true;
							break;
						}
					}
					if(!connected) continue;
					
					count++;
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		
		return count;
	}
	
	// 현재 위치나 다음 위치의 터널 구조물 타입에 따라 연결된 방향을 설정
	public static void setDirection(int dir, int idx) {
		switch(dir) {
		case 0:
			dr[idx] = new int[] {};
			dc[idx] = new int[] {};
			return;
		case 1:
			dr[idx] = new int[] {-1, 1, 0, 0};
			dc[idx] = new int[] {0, 0, -1, 1};
			return;
		case 2:
			dr[idx] = new int[] {-1, 1};
			dc[idx] = new int[] {0, 0};
			return;
		case 3:
			dr[idx] = new int[] {0, 0};
			dc[idx] = new int[] {-1, 1};
			return;
		case 4:
			dr[idx] = new int[] {-1, 0};
			dc[idx] = new int[] {0, 1};
			return;
		case 5:
			dr[idx] = new int[] {1, 0};
			dc[idx] = new int[] {0, 1};
			return;
		case 6:
			dr[idx] = new int[] {1, 0};
			dc[idx] = new int[] {0, -1};
			return;
		case 7:
			dr[idx] = new int[] {-1, 0};
			dc[idx] = new int[] {0, -1};
		}
	}

}
