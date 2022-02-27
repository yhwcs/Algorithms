/*
 * 소요 시간 : 152ms
 * 메모리 사용량 : 18,684kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ_2635 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int cur, prev, next, count, max = 0;
		List<Integer> list = new LinkedList<>();
		for(int i=0; i<=N; i++) {
			count = 2;
			prev = N; cur = i;
			list.add(N); list.add(cur);
			while(true) {
				next = prev - cur;
				if(next < 0) {
					if(max < count) {
						max = count;
						sb.setLength(0);
						sb.append(max).append("\n");
						for(int k=0; k<list.size(); k++) {
							sb.append(list.get(k)).append(" ");
						}
					}
					list.clear();
					break;
				}
				count++;
				prev = cur; cur = next;
				list.add(next);
			}
		}
		System.out.println(sb.toString());
	}

}
