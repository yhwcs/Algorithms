/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,188kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int dir, dist;
		int[] distance = new int[6];
		int maxWidth = 0, maxHeight = 0, cnt = 0, w = 0, h = 0;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			distance[cnt] = dist;
			if(dir == 1 || dir == 2) {
				if(maxHeight < dist) {
					maxHeight = dist;
					h = cnt;
				}
			} else {
				if(maxWidth < dist) {
					maxWidth = dist;
					w = cnt;
				}
			}
			cnt++;
		}

		// 전체 사각형 넓이 - (가장 긴 세로길이의 앞뒤 길이차 * 가장 긴 가로길이의 앞뒤 길이차)
		int wDiff = Math.abs(distance[(h+5)%6] - distance[(h+1)%6]);
		int hDiff = Math.abs(distance[(w+5)%6] - distance[(w+1)%6]);
		int ans = (maxWidth*maxHeight - wDiff*hDiff) * K;
		
		System.out.println(ans);
	}

}
