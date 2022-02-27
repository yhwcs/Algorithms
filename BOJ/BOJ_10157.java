/*
 * 소요 시간 : 156ms 
 * 메모리 사용량 : 14,320kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
	static int R, C, K, cnt, r, c;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		if(K > C*R) sb.append(0);
		else {
			int range = Math.max(C, R) / 2;
			for(int i=0; i<=range; i++) {
				if(rectangle(i)) {
					sb.append(c+1).append(" ").append(R-r);
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	public static boolean rectangle(int idx) {
		r = R-1-idx;
		c = idx;
		int d = 0;
		while(d<4) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<idx || nr>=R-idx || nc<idx || nc>=C-idx) {
				d++;
				continue;
			}
			cnt++;
			if(cnt == K) return true;
			
			r = nr;
			c = nc;
		}
		return false;
	}

}
