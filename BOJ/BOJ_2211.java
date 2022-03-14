/*
 * 소요 시간 : 556ms
 * 메모리 사용량 : 91,564kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2211 {
	
	static class Vertex implements Comparable<Vertex> {
		int to, weight;

		public Vertex(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static List<Vertex>[] adjList;
	static int path[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		path = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());		
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Vertex(to, weight));
			adjList[to].add(new Vertex(from, weight));
		}
		
		dijkstra();
		
		StringBuilder sb = new StringBuilder();
		sb.append(N-1).append("\n");
		for(int i=2; i<=N; i++) {
			sb.append(i+" "+path[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dijkstra() {
		Queue<Vertex> pq = new PriorityQueue<>();
		// 시작 지점에서 해당 정점까지 거리
		int[] distance = new int[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		pq.offer(new Vertex(1, 0));
		
		while(!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			// 이미 찾은 시작 지점에서 해당 정점까지 거리가 시작지점-다른정점-해당정점 거치는 것보다 짧다면 pass
			if(minVertex.weight > distance[minVertex.to]) continue;
			
			for(Vertex adjVertex : adjList[minVertex.to]) {
				// 시작 지점에서 adjVertex까지 거리가 minVertex를 경유해서 가는 거리보다 길다면
				if(distance[adjVertex.to] > minVertex.weight + adjVertex.weight) {
					distance[adjVertex.to] = minVertex.weight + adjVertex.weight;
					path[adjVertex.to] = minVertex.to;
					pq.add(new Vertex(adjVertex.to, distance[adjVertex.to]));
				}
			}
			
		}
		
	}
}
