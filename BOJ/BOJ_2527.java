/*
 * 소요 시간 : 128ms
 * 메모리 사용량 : 14,172kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		char ans;
		for(int t=0; t<4; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			// 공통부분 없음
			if(x1 > p2 || p1 < x2 || y1 > q2 || q1 < y2) ans = 'd';
			// 점
			else if((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2)) ans = 'c';
			// 선분
			else if((x1 == p2 && y1 != q2) || (p1 != x2 && y1 == q2) || (x1 != p2 && q1 == y2) || (p1 == x2 && q1 != y2)) ans = 'b';
			// 직사각형
			else ans = 'a';
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
