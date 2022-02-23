/*
 * 소요 시간 : 285ms
 * 메모리 사용량 : 20,692kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {
	
	static int N, min;
	static int[] home, result;
	static int[][] vertex;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		home = new int[2];
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			vertex = new int[N+1][2];
			visited = new boolean[N+1];
			result = new int[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			// company {x, y}
			vertex[0][0] = Integer.parseInt(st.nextToken());
			vertex[0][1] = Integer.parseInt(st.nextToken());
			// home {x, y}
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			// customer {x, y}
			for(int i=1; i<=N; i++) {
				vertex[i][0] = Integer.parseInt(st.nextToken());
				vertex[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void permutation(int cnt, int prev, int dist) {
		if(dist >= min) return;
		
		if(cnt == N) {
			int last = result[N-1];
			dist += Math.abs(home[0]-vertex[last][0]) + Math.abs(home[1]-vertex[last][1]);

			if(min > dist) min = dist;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = i;
			permutation(cnt+1, i, dist+Math.abs(vertex[prev][0]-vertex[i][0])+Math.abs(vertex[prev][1]-vertex[i][1]));
			visited[i] = false;
		}
	}

}
