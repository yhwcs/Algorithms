/*
 * 소요 시간 : 297ms
 * 메모리 사용량 : 48,160kb
 */

// 정점에 비해 간선이 많은 문제이기 때문에 kruskal보다 prim 알고리즘을 사용하는 게 더 나은듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1251_Prim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] vertex;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			vertex = new int[N][2];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				vertex[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				vertex[i][1] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			double[][] adjMatrix = new double[N][N];
			// 다른 섬에서 해당 섬까지 최소 거리
			double[] minEdge = new double[N];
			boolean[] visited = new boolean[N];

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adjMatrix[i][j] = Math.pow(vertex[i][0]-vertex[j][0], 2) + Math.pow(vertex[i][1]-vertex[j][1], 2);
				}
				minEdge[i] = Double.MAX_VALUE;
			}
			
			double result = 0;
			minEdge[0] = 0;
			
			for(int i=0; i<N; i++) {
				double min = Double.MAX_VALUE;
				int minVertex = 0;

				for(int j=0; j<N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}

				visited[minVertex] = true;
				result += min;

				for(int j=0; j<N; j++) {
					if (!visited[j] && minEdge[j] > adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(result * E)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
