/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,244kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] height = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		LOOP:
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				// 9명 중 2명을 제외한 전체 합이 100이라면 
				if(sum - height[i] - height[j] == 100) {
					for(int k=0; k<9; k++) {
						if(k!=i && k!=j) list.add(height[k]);
					}
					break LOOP;
				}
			}
		}
		
		Collections.sort(list);
		for(int i=0; i<7; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
