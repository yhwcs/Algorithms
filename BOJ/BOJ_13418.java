/*
 * 소요 시간 : 628ms
 * 메모리 사용량 : 145,916kb
 */
// 정점 수에 비해 간선 수가 많을 수 있으므로 Prim 알고리즘을 사용한다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13418 {

	static int N;
	static int[][] adjMatrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N][N];
		for(int i=0; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			// 0: 길 없음, 1: 내리막길, 2: 오르막길 되도록
			adjMatrix[A][B] = adjMatrix[B][A] = -C+2;
		}

		int good = prim();
		int bad = prim2();
		System.out.println(bad*bad - good*good);
	}
	
	public static int prim() {
		int count = 0;
		boolean[] visited = new boolean[N];
		// 타 정점에서 해당 정점까지 최소 거리
		int[] minEdge = new int[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min > minEdge[j]) {
					minVertex = j;
					min = minEdge[j];
				}
			}
			visited[minVertex] = true;
			// 오르막길인 경우
			if(min == 2) count++;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j])
					minEdge[j] = adjMatrix[minVertex][j];
			}	
		}
		
		return count;
	}
	
	public static int prim2() {
		int count = 0;
		boolean[] visited = new boolean[N];
		// 타 정점에서 해당 정점까지 최대 거리
		int[] maxEdge = new int[N];
		maxEdge[0] = 0;
		
		for(int i=0; i<N; i++) {
			int max = -1;
			int maxVertex = 0;
			for(int j=0; j<N; j++) {
				if(!visited[j] && max < maxEdge[j]) {
					maxVertex = j;
					max = maxEdge[j];
				}
			}
			visited[maxVertex] = true;
			// 오르막길인 경우
			if(max == 2) count++;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && adjMatrix[maxVertex][j] != 0 && maxEdge[j] < adjMatrix[maxVertex][j])
					maxEdge[j] = adjMatrix[maxVertex][j];
			}	
		}
		
		return count;
	}
	
}
