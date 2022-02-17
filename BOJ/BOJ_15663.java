/*
 * 소요 시간 : 224ms
 * 메모리 사용량 : 22,036kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15663 {

	static int N, M;
	static int[] result;
//	static int[] input;
	// <숫자, 입력 받은 해당 숫자의 개수>
	static Map<Integer, Integer> input;
	static List<Integer> keyList;
	static StringBuilder sb = new StringBuilder();
//	static LinkedHashSet<String> answer;
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new HashMap<Integer, Integer>();
		result = new int[M];
		st = new StringTokenizer(br.readLine()," ");
//		input = new int[N];
//		for(int i=0; i<N; i++) {
//			input[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(input);
//		answer = new LinkedHashSet<String>();
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			int value = 1;
			if(input.containsKey(key)) value += input.get(key);
			input.put(key, value);
		}
		// 오름차순 정렬
		keyList = new ArrayList<>(input.keySet());
		keyList.sort((o1, o2) -> Integer.compare(o1, o2));
		
		permutation(0);
		//permutation2(0, new boolean[N]);		
//		for(String ans : answer) {
//			sb.append(ans).append("\n");
//		}
		
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
		
		for(int i=0; i<keyList.size(); i++) {
			int key = keyList.get(i);
			int value = input.get(key);
			// 해당 숫자의 남은 개수가 0보다 크다면
			if(value > 0) {
				result[cnt] = key;
				input.replace(key, value-1);
				permutation(cnt+1);
				input.replace(key, value);
			}
		}
	}

/*
 * 소요 시간 : 304ms
 * 메모리 사용량 : 33,888kb
 */
//	public static void permutation2(int cnt, boolean[] isSelected) {
//		if(cnt == M) {
//			StringBuilder sb = new StringBuilder();
//			for(int r : result) {
//				sb.append(r).append(" ");
//			}
//			//sb.append("\n");
//			answer.add(sb.toString());
//			return;
//		}
//		
//		for(int i=0; i<N; i++) {
//			if(!isSelected[i]) {
//				result[cnt] = input[i];
//				isSelected[i] = true;
//				permutation2(cnt+1, isSelected);
//				isSelected[i] = false;
//			}
//		}
//	}

}
