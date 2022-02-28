/*
 * 소요 시간 : 136ms
 * 메모리 사용량 : 14,592kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int L, H;
		int maxL = 0, maxH = 0;
		List<Stick> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			list.add(new Stick(L, H));
			if(maxH < H) maxH = H;
		}
		
		// L 좌표 오름차순 정렬
		Collections.sort(list);
		// 가장 높은 기둥 찾기
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).H == maxH) {
				maxL = i;
				break;
			}
		}
		
		int answer = 0;
		// 가장 높은 기둥의 왼쪽 부분 (오름차순) 면적 합 구하기
		for(int i=0; i<maxL; i++) {
			for(int j=i+1; j<=maxL; j++) {
				if(list.get(i).H <= list.get(j).H) {
					answer += (list.get(j).L - list.get(i).L) * list.get(i).H;
					i = j;
				}
			}
		}
		// 가장 높은 기둥의 오른쪽 부분 (내림차순) 면적 합 구하기
		for(int i=N-1; i>maxL; i--) {
			for(int j=i-1; j>=maxL; j--) {
				if(list.get(i).H <= list.get(j).H) {
					answer += (list.get(i).L - list.get(j).L) * list.get(i).H;
					i = j;
				}
			}
		}
		// 가장 높은 기둥의 면적 더하기
		answer += maxH;
		
		System.out.println(answer);
	}

}

class Stick implements Comparable<Stick> {
	int L;
	int H;
	
	public Stick(int L, int H) {
		this.L = L;
		this.H = H;
	}
	
	@Override
	public int compareTo(Stick o) {
		return Integer.compare(this.L, o.L);
	}
	
}
