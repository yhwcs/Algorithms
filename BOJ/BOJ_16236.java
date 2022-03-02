/*
 * 소요 시간 : 144ms
 * 메모리 사용량 : 14,528kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, r, c, size = 2, count, ans;
	static int minDistance, minR, minC;
	static int[][] space, distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9) {
					space[i][j] = 0;
					r = i; c = j;
				}
			}
		}
		
		distance = new int[N][N];
		while(true) {
			// Initializing
			minDistance = Integer.MAX_VALUE;
			minR = Integer.MAX_VALUE;
			minC = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					distance[i][j] = -1;
				}
			}
			
			bfs();
			
			if(minDistance != Integer.MAX_VALUE) {
				ans += distance[minR][minC];
				if(++count == size) {
					size++;
					count = 0;
				}
				
				space[minR][minC] = 0;
				r = minR; c = minC;
			}
			else break;
		}
		System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		distance[r][c] = 0;
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int vr = v[0];
			int vc = v[1];
			// 현재까지 고려한 거리가 이미 찾은 최소 거리보다 더 큰 경우
			if(distance[vr][vc] > minDistance) return;
			
			for(int d=0; d<4; d++) {
				int nr = vr + dr[d];
				int nc = vc + dc[d];
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				// 이미 방문한 적 있거나 물고기의 크기가 아기상어 크기보다 큰 경우
				if(distance[nr][nc] != -1 || space[nr][nc] > size) continue;
			
				// 아기상어로부터 물고기까지 거리 갱신
				distance[nr][nc] = distance[vr][vc] +1;
				
				if(space[nr][nc] != 0 && space[nr][nc] < size) {
					// 최소 거리 갱신 물고기 선택
					if(minDistance > distance[nr][nc]) {
						minDistance = distance[nr][nc];
						minR = nr; minC = nc;
					}
					// 최소 거리에 있는 물고기가 여러 마리인 경우
					else if(minDistance == distance[nr][nc]) {
						// 가장 위에 있는 물고기 선택
						if(minR > nr) {
							minR = nr; minC = nc;
						}
						// 가장 위에 있는 물고기가 여러 마리라면 가장 왼쪽 선택
						else if(minR == nr && minC > nc) minC = nc;
					}
				}
				
				queue.add(new int[] {nr, nc});
			}		
		}
	}
	
}
