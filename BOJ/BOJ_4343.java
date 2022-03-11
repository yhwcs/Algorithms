/*
 * 소요 시간 : 208ms
 * 메모리 사용량 : 32,848kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4343 {

	static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
		
	}
	
	static int S, P;
	static Position[] outpost;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			outpost = new Position[P];
			parents = new int[P];
			for(int i=0; i<P; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				outpost[i] = new Position(x, y);
			}
			sb.append(String.format("%.2f\n", kruskal()));
		}
		System.out.println(sb.toString());

	}
	
	public static double kruskal() {
		makeSet();
		
		Queue<Edge> pq = new PriorityQueue<Edge>();
		for(int i=0; i<P; i++) {
			for(int j=i+1; j<P; j++) {
				double dist = Math.sqrt(Math.pow(outpost[i].x - outpost[j].x, 2) + Math.pow(outpost[i].y - outpost[j].y, 2));
				pq.add(new Edge(i, j, dist));
			}
		}
		
		double max = 0, cnt = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.from, edge.to)) {
				if(max < edge.weight) max = edge.weight;
				if(++cnt > P-1-S) return max;
			}
		}
		return max;
	}
	
	public static void makeSet() {
		for(int i=0; i<P; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
