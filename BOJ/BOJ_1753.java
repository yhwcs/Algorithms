/*
 * 소요 시간 : 796ms
 * 메모리 사용량 : 107,760kb
 */

// 정점의 개수에 비해 간선의 개수가 적으므로 인접리스트 + PQ로 푼다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	
	static class Vertex implements Comparable<Vertex>{
		int no, dist;

		public Vertex(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.dist - o.dist;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<Vertex>[] adjList = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adjList[from].add(new Vertex(to, dist));
		}
		
		int[] distance = new int[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new Vertex(start, distance[start]));
		
		// dijkstra는 이미 방문한 정점도 갱신될 수 있으므로 pq가 빌 때까지 반복
		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
			if(current.dist > distance[current.no]) continue;
			
			for(Vertex to : adjList[current.no]) {
				if(distance[to.no] > distance[current.no] + to.dist) {
					distance[to.no] = distance[current.no] + to.dist;
					pq.offer(new Vertex(to.no, distance[to.no]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(distance[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
