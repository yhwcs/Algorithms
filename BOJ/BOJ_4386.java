/*
 * 소요 시간 : 92ms
 * 메모리 사용량 : 12,108kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4386 {

	static class Position {
		double x, y;

		public Position(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int n;
	static Position[] star;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		star = new Position[n];
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i] = new Position(x, y);
		}
		System.out.println(String.format("%.2f", prim()));
	}
	
	public static double prim() {
		double[] minEdge = new double[n];
		boolean[] visited = new boolean[n];
		
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[0] = 0;
		
		double result = 0;
		int cnt = 0;
		while(true) {
			int minVertex = 0;
			double min = Double.MAX_VALUE;
			for(int i=0; i<n; i++) {
				if(!visited[i] && min > minEdge[i]) {
					minVertex = i;
					min = minEdge[i];
				}
			}
			
			visited[minVertex] = true;
			result += min;
			if(++cnt == n) break;
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					double dist = Math.sqrt(Math.pow(star[minVertex].x - star[i].x, 2) + Math.pow(star[minVertex].y - star[i].y, 2));
					if(minEdge[i] > dist) minEdge[i] = dist;
				}
			}
		}
		return result;
	}

}
