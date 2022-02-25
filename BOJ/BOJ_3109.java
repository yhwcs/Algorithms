/*
 * 소요 시간 : 400ms
 * 메모리 사용량 : 34,376kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	
	static int R, C, ans;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			
		}
		
		for(int i=0; i<R; i++) {
			dfs(i, 0);
		}
		
		System.out.println(ans);
	}
	
	public static boolean dfs(int r, int c) {

		if(c == C-1) {
			ans++;
			return true;
		}

		int d=0;
		int nc = c + 1;
		while(d<3) {
			int nr = r + dr[d];
			d++;
			if(nr<0 || nr>=R || map[nr][nc] == 'x') continue;
			
			map[nr][nc] = 'x';
			// greedy
			if(dfs(nr, nc)) return true;
		}
		
		return false;
	}

}
