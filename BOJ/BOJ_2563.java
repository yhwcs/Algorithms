/*
 * 소요 시간 : 128ms
 * 메모리 사용량 : 14,164kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		boolean[][] isSelected = new boolean[100][100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(!isSelected[j][k]) {
						isSelected[j][k] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
