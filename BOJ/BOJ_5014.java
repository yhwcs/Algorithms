/*
 * 소요 시간 : 168ms
 * 메모리 사용량 : 55,236kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	
	static int F, G;
	static int[] dr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		dr = new int[]{U, -D};
		int ans = bfs(S);
		if(ans == -1) System.out.println("use the stairs");
		else System.out.println(ans);
	}
	
	public static int bfs(int start) {
		if(start == G) return 0;
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[F+1];
		
		queue.add(start);
		visited[start] = 1;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int d=0; d<2; d++) {
				int next = current + dr[d];
				if(next<1 || next>F || visited[next] != 0) continue;
				if(next == G) return visited[current];
				visited[next] = visited[current] + 1;
				queue.offer(next);
			}
		}
		return -1;
	}

}
