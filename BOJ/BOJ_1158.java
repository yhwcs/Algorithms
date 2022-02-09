import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {

	public static void main(String[] args) {
		// 입력
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// 큐에 전원 추가
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			// 큐에서 K-1번만큼 사람을 제거하고 뒤에 다시 추가
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			// K번째 사람을 큐에서 제거
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		System.out.println(sb);
		
//		// 제거된 사람 체크
//		boolean[] isRemoved = new boolean[N];
//		// 출력을 위한 제거 순서 배열
//		int[] answer = new int[N];
//
//		int i = 0;
//		// K번 반복문 돌기 위한 카운트
//		int k = 0;
//		// 제거된 사람 수
//		int count = 0;
//		
//		while(true) {
//			if(isRemoved[i] == false) {
//				k++;
//			}
//			// K번째 사람 제거
//			if(k == K) {
//				answer[count++] = (i+1);
//				// 전원 제거되었다면 stop
//				if(count == N) break;
//				isRemoved[i] = true;
//				k = 0;
//			}
//			i = (i+1) % N;
//		}
//		
//		// 출력
//		System.out.print("<");
//		for(i=0; i<N-1; i++) {
//			System.out.print(answer[i]+", ");
//		}
//		System.out.println(answer[N-1]+">");
	}

}
