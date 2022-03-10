/*
 * 소요 시간 : 1,632ms
 * 메모리 사용량 : 78,344kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2887 {

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
	
	static int N;
	static int[][] planet;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		// {idx, x, y, z}
		planet = new int[N][4];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			planet[i][0] = i;
			for(int j=1; j<4; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(kruskal());
	}
	
	public static int kruskal() {
		makeSet();
		
		Queue<Edge> edgeList = new PriorityQueue<>();
		// x, y, z 좌표 기준으로 정렬
		for(int i=1; i<4; i++) {
			int idx = i;
			Arrays.sort(planet, (o1, o2) -> (o1[idx] - o2[idx]));
			for(int j=0; j<N-1; j++) {
				int dist = Math.abs(planet[j][idx] - planet[j+1][idx]);
				edgeList.add(new Edge(planet[j][0], planet[j+1][0], dist));
			}
		}
		
		int result = 0;
		while(!edgeList.isEmpty()) {
			Edge edge = edgeList.poll();
			if(union(edge.from, edge.to)) {
				result += edge.weight;
			}
		}
		
		return result;
	}
	
	public static void makeSet() {
		for(int i=0; i<N; i++) {
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
