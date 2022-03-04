/*
 * 소요 시간 : 124ms
 * 메모리 사용량 : 17,004kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	
	static Queue<Integer> queue;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(bfs(n, k));
	}
	
	public static int bfs(int n, int k) {
		queue = new LinkedList<>();	
		visited = new boolean[100001];
		
		queue.add(n);
		visited[n] = true;
		
		int t = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int temp = queue.poll();
				if(temp == k) return t;
				offer(temp-1);
				offer(temp+1);
				offer(temp*2);
			}
			t++;
		}
		return t;
	}
	
	public static void offer(int temp) {
		if(temp < 0 || temp > 100000 || visited[temp]) return;
		visited[temp] = true;
		queue.offer(temp);
	}

}
