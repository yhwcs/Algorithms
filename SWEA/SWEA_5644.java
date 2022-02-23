/*
 * 소요 시간 : 117ms
 * 메모리 사용량 : 23,800kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5644 {

	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	static int M, A, rA = 1, cA = 1, rB = 10, cB = 10, ans;
	static int[][] BC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] personA, personB;

		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			personA = new int[M];
			personB = new int[M];
			BC = new int[A][4];
			ans = 0; rA = 1; cA = 1; rB = 10; cB = 10;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				personB[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// x, y, c, p
				for(int j=0; j<4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			charge();
			for(int i=0; i<M; i++) {
				rA += dr[personA[i]];
				cA += dc[personA[i]];
				rB += dr[personB[i]];
				cB += dc[personB[i]];
				charge();
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void charge() {
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		
		for(int i=0 ; i<A; i++) {
			if(Math.abs(cA - BC[i][0])+Math.abs(rA - BC[i][1]) <= BC[i][2]) {
				listA.add(i);
			}
			if(Math.abs(cB - BC[i][0])+Math.abs(rB - BC[i][1]) <= BC[i][2]) {
				listB.add(i);
			}
		}

		int sizeA = listA.size();
		int sizeB = listB.size();
		
		if(sizeA == 0 && sizeB == 0) return;
		
		int max = 0, sum = 0;
		
		if(sizeA == 0) {
			for(int b : listB) {
				if(BC[b][3] > max) max = BC[b][3];
			}
		} else if(sizeB == 0) {
			for(int a : listA) {
				if(BC[a][3] > max) max = BC[a][3];
			}
		} else {
			for(int a : listA) {
				for(int b : listB) {
					if(a == b) sum = BC[a][3];
					else sum = BC[a][3] + BC[b][3];
					
					if(sum > max) max = sum;
				}
			}
		}
		ans += max;
	}
	
}
