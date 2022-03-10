/*
 * 소요 시간 : 212ms
 * 메모리 사용량 : 20,788kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1774 {

	static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N;
	static List<Integer>[] adjList;
	static Position[] god;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		god = new Position[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			god[i] = new Position(x, y);
		}
		adjList = new List[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new LinkedList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		System.out.println(String.format("%.2f", prim()));
	}

	public static double prim() {
		double[] minEdge = new double[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[1] = 0;
		
		double result = 0;
		int cnt = 0;
		while(true) {
			int minVertex = 0;
			double min = Double.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					minVertex = i;
					min = minEdge[i];
				}
			}
			
			visited[minVertex] = true;
			result += min;
			if(++cnt == N) return result;
			
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				// 이미 연결된 상태라면 거리 값 0
				if(adjList[minVertex].contains(i)) minEdge[i] = 0;
				else {
					double dist = Math.sqrt(Math.pow(god[minVertex].x - god[i].x, 2) + Math.pow(god[minVertex].y - god[i].y, 2));
					if(minEdge[i] > dist) minEdge[i] = dist;
				}
			}
			
		}
		
	}
}
