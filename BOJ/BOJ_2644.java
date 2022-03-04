/*
 * 소요 시간 : 84ms
 * 메모리 사용량 : 11,560kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644 {
	
	static int n, b, ans = -1;
	static boolean[][] adjMatrix;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMatrix[x][y] = adjMatrix[y][x] = true;
		}
		dfs(a, 0);
		System.out.println(ans);

	}
	
	public static void dfs(int x, int cnt) {
		if(x == b) {
			ans = cnt;
			return;
		}
		visited[x] = true;
		
		for(int i=1; i<=n; i++) {
			if(!visited[i] && adjMatrix[x][i])
				dfs(i, cnt+1);
		}
	}

}
