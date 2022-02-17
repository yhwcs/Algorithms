/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,260kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15664 {
	static int N, M;
	static int[] result;
	// <숫자, 입력 받은 해당 숫자의 개수>
	static Map<Integer, Integer> input;
	static List<Integer> keyList;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new HashMap<Integer, Integer>();
		result = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			int value = 1;
			if(input.containsKey(key)) value += input.get(key);
			input.put(key, value);
		}
		// 오름차순 정렬
		keyList = new ArrayList<>(input.keySet());
		keyList.sort((o1, o2) -> Integer.compare(o1, o2));
		
		combination(0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int r : result) {
				sb.append(r).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<keyList.size(); i++) {
			int key = keyList.get(i);
			int value = input.get(key);
			// 해당 숫자의 남은 개수가 0보다 크다면
			if(value > 0) {
				result[cnt] = key;
				input.replace(key, value-1);
				combination(cnt+1, i);
				input.replace(key, value);
			}
		}
	}
}