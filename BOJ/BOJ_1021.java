import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1021 {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 뽑아내려고 하는 원소들을 배열에 저장
		int[] num = new int[M];
		st =  new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 큐 초기화
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int count = 0;
		int answer = 0;
		int idx = 0;
		int m = 0;
		
		while(m < M) {
			// 첫번째 원소를 뽑아낸다
			if(list.get(0) == num[m]) {
				list.remove(0);
				m++;
				continue;
			}
			
			// 뽑아내려고 하는 원소의 인덱스 찾기
			for(int j=0; j<list.size(); j++) {
				if(list.get(j) == num[m]) {
					idx = j;
					break;
				}
			}
			
			// 인덱스가 중간 지점보다 뒤에 있는 경우, 3번 연산 (오른쪽으로 한칸 이동)
			if(list.size()/2 < idx) {
				count = list.size() - idx;
				answer += count;
				for(int j=0; j<count; j++) {
					list.add(0, list.get(list.size()-1));
					list.remove(list.size()-1);
				}
			}
			// 인덱스가 중간 지점보다 앞에 있는 경우, 2번 연산 (왼쪽으로 한칸 이동)
			else {
				count = idx;
				answer += count;
				for(int j=0; j<count; j++) {
					list.add(list.size(), list.get(0));
					list.remove(0);
				}
			}
		
		}
		// 출력
		System.out.println(answer);
	}
}
