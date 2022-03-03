/*
 * 소요 시간 : 196ms
 * 메모리 사용량 : 17,848kb
 */

// 정점의 수에 비해 간선의 수가 적으므로 인접 리스트로 푼다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		// 정점 번호가 작은 것부터 방문
		for(int i=1; i<=N; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for(int temp : adjList[current]) {
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
		sb.append("\n");
	}
	
	public static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		sb.append(current).append(" ");
		
		for(int temp : adjList[current]) {
			if(!visited[temp]) {
				dfs(temp, visited);
			}
		}
	}

}
