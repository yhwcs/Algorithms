/*
 * 소요 시간 : 392ms
 * 메모리 사용량 : 34,688kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_15665 {

	static int N, M;
	static int[] result;
	static List<Integer> input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// TreeSet으로 중복 제거 + 오름차순 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();
		result = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		input = new ArrayList<>(set);
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for(int r : result) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<input.size(); i++) {
			result[cnt] = input.get(i);
			permutation(cnt+1);
		}
	}

}
