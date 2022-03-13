/*
 * 소요 시간 : 960ms
 * 메모리 사용량 : 111,720kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2406 {

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
	
	static class Pair {
		int from, to;

		public Pair(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
	
	static int N;
	static int[] parents;
	static Queue<Edge> pq;
	static List<Pair> connection;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		pq = new PriorityQueue<Edge>();
		connection = new LinkedList<>();
		makeSet();
		int M = Integer.parseInt(st.nextToken());
		// 1. 직접 연결된 두 컴퓨터
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 연결되지 않은 상태라면 연결하고 weight=0 으로 추가
			if(union(from, to)) pq.add(new Edge(from, to, 0));
		}
		// 2. 직접 연결되지 않은 두 컴퓨터
		br.readLine();
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			for(int j=2; j<=N; j++) {
				int weight = Integer.parseInt(st.nextToken());
				// 연결하기 위한 비용 저장
				if(i < j) pq.add(new Edge(i, j, weight));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(kruskal()).append(" ").append(connection.size()).append("\n");
		for(Pair pair : connection) {
			sb.append(pair.from).append(" ").append(pair.to).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int kruskal() {
		int cnt = 0, result = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			// 1. 이미 직접 연결된 상태라면 pass
			if(edge.weight == 0) continue;
			// 2. 연결되지 않은 상태라면 연결
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				connection.add(new Pair(edge.from, edge.to));
				// 1번을 제외한 MST가 완성되었다면 끝낸다
				if(++cnt >= N-2) break;
			}
		}
		return result;
	}
	
	public static void makeSet() {
		for(int i=1; i<=N; i++) {
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
