/*
 * 소요 시간 : 128ms
 * 메모리 사용량 : 14,164kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		// {row, col}
		int[][] position = new int[N+1][2];
		int dir, dist;
		for(int i=0; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			if(dir==1) {
				position[i][0] = 0;
				position[i][1] = dist;
			} else if(dir==2) {
				position[i][0] = height;
				position[i][1] = dist;
			} else if(dir==3) {
				position[i][0] = dist;
				position[i][1] = 0;
			} else if(dir==4) {
				position[i][0] = dist;
				position[i][1] = width;
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			// 북쪽-남쪽
			if(Math.abs(position[N][0]-position[i][0]) == height)
				dist = height + Math.min(width-position[N][1]+width-position[i][1], position[N][1]+position[i][1]);
			// 서쪽-동쪽
			else if(Math.abs(position[N][1]-position[i][1]) == width)
				dist = width + Math.min(height-position[N][0]+height-position[i][0], position[N][0]+position[i][0]);
			else 
				dist = Math.abs(position[N][0]-position[i][0])+Math.abs(position[N][1]-position[i][1]);
			ans += dist;
		}
		
		System.out.println(ans);
		
	}

}
