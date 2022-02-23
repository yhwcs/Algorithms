/*
 * 소요 시간 : 265ms
 * 메모리 사용량 : 22,452kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	
	static int N, minDiff;
	static boolean[] isSelected;
	static int[][] synergy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			isSelected = new boolean[N];
			minDiff = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);
			
			sb.append("#").append(t).append(" ").append(minDiff).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == N/2) {
			int sumA = 0, sumB = 0;

			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(isSelected[i] && isSelected[j])
						sumA += synergy[i][j] + synergy[j][i];
					else if(!isSelected[i] && !isSelected[j])
						sumB += synergy[i][j] + synergy[j][i];
				}
			}
			minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			return;
		}
		
		for(int i=start; i<N; i++) {
			isSelected[i] = true;
			combination(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
