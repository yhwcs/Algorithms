/*
 * 소요 시간 : 476ms
 * 메모리 사용량 : 45,876kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10423 {
	
	static class Edge implements Comparable<Edge> {
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
	static int[] parents;
	static Queue<Edge> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		makeSet();
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine(), " ");
		// 발전소는 부모를 0으로 저장
		for(int i=0; i<K; i++) {
			int station = Integer.parseInt(st.nextToken());
			parents[station] = 0;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Edge(u, v, w));
		}
		System.out.println(kruskal());
	}
	
	public static int kruskal() {
		int result = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(check()) break;
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
		if(parents[x] == 0) return 0;
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		// a의 root가 발전소일 때
		if(aRoot == 0) {
			// b의 root가 발전소라면 이을 필요 없음
			if(bRoot == 0) return false;
			// b가 발전소와 연결되어 있지 않다면 연결
			parents[bRoot] = 0;
		}
		// b의 root가 발전소일 때 a가 발전소와 연결되어 있지 않다면 연결
		else if(bRoot == 0) parents[aRoot] = 0;
		// a와 b 모두 발전소와 연결되어 있지 않다면 연결
		else parents[bRoot] = aRoot;
		return true;
	}
	
	public static boolean check() {
		for(int i=1; i<=N; i++) {
			// 발전소와 연결되지 않은 도시가 존재한다면 false
			if(parents[i] != 0) return false;
		}
		return true;
	}

}
