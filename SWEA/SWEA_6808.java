/*
 * 소요 시간 : 1576ms
 * 메모리 사용량 : 25,016kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808 {
	
	static int[] other;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] input = new int[9];
		other = new int[9];
		boolean[] isSelected = new boolean[18+1];
		int[] score = new int[2];
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=18; i++) {
				isSelected[i] = false;
			}
			for(int i=0; i<9; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				isSelected[input[i]] = true;
			}
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				if(!isSelected[i]) {
					other[cnt++] = i;
				}
			}
			
			Arrays.sort(other);
			
			int win = 0, loss = 0, sum = 0;
			do {
				score[0] = 0; score[1] = 0;
				for(int i=0; i<9; i++) {
					sum = input[i] + other[i];
					if(input[i] > other[i]) score[0] += sum;
					else if(input[i] < other[i]) score[1] += sum;
				}
				if(score[0] > score[1]) win++;
				else if(score[0] < score[1]) loss++;
			} while(np());
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(loss).append("\n");	
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean np() {
		int i = 8;
		while(i>0 && other[i-1] >= other[i]) --i;
		if(i==0) return false;

		int j = 8;
		while(other[i-1] >= other[j]) --j;

		swap(i-1, j);
		
		int k = 8;
		while(i<k) {
			swap(i++, k--);
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = other[i];
		other[i] = other[j];
		other[j] = temp;
	}

}
