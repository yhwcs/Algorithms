/*
 * 소요 시간 : 440ms
 * 메모리 사용량 : 46,432kb
 */
// Edge[] 배열 사용 시, 648ms 49,048kb

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

	static int V, E;
	static int[] parents;
	static PriorityQueue<Edge> edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		edgeList = new PriorityQueue<Edge>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(A, B, C));
		}

		makeSet();
		
		int ans = 0, cnt = 0;
		while(true) {
			Edge edge = edgeList.poll();
			if(union(edge.from, edge.to)) {
				ans += edge.weight;
				if(++cnt == V-1) break;
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void makeSet() {
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}

}
