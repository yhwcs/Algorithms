/*
 * 소요 시간 : 120ms
 * 메모리 사용량 : 14,052kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			list.add(list.size()-idx, i);
		}
		for(int i=0; i<N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
