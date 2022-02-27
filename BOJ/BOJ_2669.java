/*
 * 소요 시간 : 124ms 
 * 메모리 사용량 : 14,232kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] grid = new boolean[100][100];
		int x1, y1, x2, y2;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					grid[y][x] = true;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(grid[i][j]) ans++;
			}
		}
		System.out.println(ans);
	}

}
