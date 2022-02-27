/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,276kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		// 2w, 2h마다 순환
		int x = (p+t)%(2*w);
		int y = (q+t)%(2*h);
		
		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb.toString());
	}

}
