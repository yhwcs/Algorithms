/*
 * 소요 시간 : 1236ms
 * 메모리 사용량 : 15,728kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1987 {
	
	static int R, C, max = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][];
		visited = new boolean[26];
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		//bfs(0, 0, 0);
		dfs(0, 0, 0);
		System.out.println(max);
	}
	
//	public static void bfs(int r, int c, int cnt) {
//		int cur = board[r][c]-'A';
//		if(!visited[cur]) {
//			visited[cur] = true;
//			if(max < cnt+1) max = cnt+1;
//			
//			Queue<int[]> queue = new LinkedList<int[]>();
//			int d = 0;
//			while(d<4) {
//				int nr = r+dr[d];
//				int nc = c+dc[d];
//				d++;
//				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
//				queue.add(new int[]{nr, nc});
//			}
//			
//			int[] q;
//			while((q = queue.poll()) != null) {
//				bfs(q[0], q[1], cnt+1);
//			}
//			
//			visited[cur] = false;
//		}
//	}
	
	public static void dfs(int r, int c, int cnt) {
		int cur = board[r][c] - 'A';
		if(visited[cur]) {
			if(max < cnt) max = cnt;
			return;
		}
		
		visited[cur] = true;
		int d = 0;
		while(d<4) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			d++;
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
			dfs(nr, nc, cnt+1);
		}
		visited[cur] = false;
	}

}
