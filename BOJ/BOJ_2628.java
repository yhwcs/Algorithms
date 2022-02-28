/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 14,252kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int type, number;
		List<Integer> wList = new LinkedList<>();
		List<Integer> hList = new LinkedList<>();
		wList.add(0); wList.add(width); hList.add(0); hList.add(height);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			type = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			if(type == 0) hList.add(number);
			else wList.add(number);
		}
		Collections.sort(wList);
		Collections.sort(hList);
		int wMax = 0, hMax = 0, diff;
		for(int i=0; i<wList.size()-1; i++) {
			diff = wList.get(i+1) - wList.get(i);
			if(wMax < diff) wMax = diff;
		}
		for(int i=0; i<hList.size()-1; i++) {
			diff = hList.get(i+1) - hList.get(i);
			if(hMax < diff) hMax = diff;
		}
		System.out.println(wMax * hMax);
	}

}
