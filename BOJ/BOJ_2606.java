/*
 * 소요 시간 : 80ms
 * 메모리 사용량 : 11,604kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

	static int N, cnt;
	static boolean[][] adjMatrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		dfs(1, new boolean[N+1]);
		System.out.println(cnt-1);

	}
	
	public static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		cnt++;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
			}
		}
	}

}
