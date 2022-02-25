/*
 * 소요 시간 : 116ms
 * 메모리 사용량 : 14,156kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[5][5];
		int i = 0, j = 0;
		for(i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num, r=0, c=0;
		LOOP:
		for(i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(j=0; j<5; j++) {
				num = Integer.parseInt(st.nextToken());
				// 해당 숫자의 row, col 값을 찾아서
				FIND:
				for(r=0; r<5; r++) {
					for(c=0; c<5; c++) {
						if(board[r][c] == num) break FIND;
					}
				}
				// 해당 숫자를 보드에서 지운다
				board[r][c] = 0;
				if(check() >= 3) break LOOP;
			}
		}
		
		System.out.println(i*5+j+1);
	}
	
	// 현재 보드에 빙고 선이 3개 이상 그려질 수 있는지 체크하여 선 개수 반환
	public static int check() {
		int count = 0;
		int up = 5, down = 5;
		for(int i=0; i<5; i++) {
			int row = 5, col = 5;
			for(int j=0; j<5; j++) {
				if(board[i][j] != 0) col--;		// 가로 체크
				if(board[j][i] != 0) row--;		// 세로 체크
			}
			if(col == 5) count++;
			if(row == 5) count++;
			if(count >= 3) return count;
			if(board[i][i] != 0) down--;		// 우하향 대각선 체크
			if(board[5-i-1][i] != 0) up--;		// 우상향 대각선 체크
		}
		if(up == 5) count++;
		if(down == 5) count++;
		return count;
	}

}
