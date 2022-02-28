/*
 * 소요 시간 : 244ms
 * 메모리 사용량 : 21,708kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116 {
	
	static int N;
	static int[][] dice;
	static boolean[] isSelected;
	static int[] opposite = {5, 3, 4, 1, 2, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		isSelected = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0, sum = 0;
		int value;	// 주사위의 윗면의 값
		// 첫번째 주사위의 밑면
		for(int i=0; i<6; i++) {
			sum = findMax(0, i);
			value = dice[0][opposite[i]];
			// j번째 주사위
			for(int j=1; j<N; j++) {
				// 그 밑 주사위의 윗면의 값과 일치하는 면 찾기
				for(int k=0; k<6; k++) {
					if(dice[j][k] == value) {
						sum += findMax(j, k);
						value = dice[j][opposite[k]];
						break;
					}
				}
			}
			if(max < sum) max = sum;
		}
		System.out.println(max);
	}
	
	// 해당 주사위에서 밑면과 그 반대면(윗면)을 제외한 다른 면에서 최댓값 찾기
	public static int findMax(int diceIdx, int sideIdx) {
		int max = 0;
		for(int i=0; i<6; i++) {
			if(i == sideIdx || i == opposite[sideIdx]) continue;
			if(max < dice[diceIdx][i]) max = dice[diceIdx][i];
		}
		return max;
	}
}
