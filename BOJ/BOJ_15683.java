/*
 * 소요 시간 : 344ms
 * 메모리 사용량 : 29,256kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {

	static int N, M, wall, min = Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<int[]> cctv;
	static int[][][] direction = {
			{{}},									// 0
			{{0}, {1}, {2}, {3}},					// 1번 cctv
			{{0,1}, {2,3}},							// 2번 cctv
			{{0,2}, {0,3}, {1,2}, {1,3}},
			{{0,1,2}, {0,1,3}, {0,2,3}, {1,2,3}},
			{{0,1,2,3}}								// 5번 cctv
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] space = new char[N][M];
		cctv = new ArrayList<int[]>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				space[i][j] = st.nextToken().charAt(0);
				
				if(space[i][j] >= '1' && space[i][j] <= '5') cctv.add(new int[] {i, j, space[i][j]});
				else if(space[i][j] == '6') wall++;
			}
		}
		
		dfs(0, N*M-wall-cctv.size(), space);
		
		System.out.println(min);
	}
	
	// idx : 확인하려는 cctv의 index, cnt : 사각지대의 수
	public static void dfs(int idx, int cnt, char[][] space) {
		if(idx == cctv.size()) {
			if(min > cnt) min = cnt;
			return;
		}
		
		char[][] temp = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[i][j] = space[i][j];
			}
		}
		
		int[] cur = cctv.get(idx);
		int index = cur[2] - '0';
		// 해당 cctv가 90도 회전할 수 있는 모든 경우를 고려
		for(int i=0; i<direction[index].length; i++) {
			int sum = 0;
			// 상하좌우 중 해당 cctv가 감시할 수 있는 모든 방향을 고려 
			for(int j=0; j<direction[index][i].length; j++) {
				int d = direction[index][i][j];
				sum += see(cur[0], cur[1], d, temp);
			}
			
			dfs(idx+1, cnt-sum, temp);
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					temp[j][k] = space[j][k];
				}
			}
		}
		
	}

	// d 방향에 대해 감시할 수 있는 영역의 수를 반환
	public static int see(int r, int c, int d, char[][] temp) {
		// 감시하는 영역 수
		int count = 0;

		while(true) {
			r += dr[d];
			c += dc[d];
			
			if(r<0 || r>=N || c<0 || c>=M || temp[r][c] == '6') return count;
			if((temp[r][c] >= '1' && temp[r][c] <= '5') || temp[r][c] == '#') continue;
			temp[r][c] = '#';
			count++;
		}
	}

}
