/*
 * 소요 시간 : 128ms
 * 메모리 사용량 : 14,228kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		char[] switches = new char[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			switches[i] = st.nextToken().charAt(0);
		}
		int students = Integer.parseInt(br.readLine());
		int type, number;
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			type = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			if(type == 1) {
				for(int j=number; j<=N; j+=number) {
					if(switches[j] == '1') switches[j] = '0';
					else switches[j] = '1';
				}
			} else {
				int idx = 1;
				if(switches[number] == '1') switches[number] = '0';
				else switches[number] = '1';
				while(true) {
					if(number-idx < 1 || number+idx > N) break;
					if(switches[number-idx] == switches[number+idx]) {
						if(switches[number-idx] == '1') {
							switches[number-idx] = '0';
							switches[number+idx] = '0';
						} else {
							switches[number-idx] = '1';
							switches[number+idx] = '1';
						}
					} 
					else break;
					idx++;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(switches[i]).append(" ");
			if(i%20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
