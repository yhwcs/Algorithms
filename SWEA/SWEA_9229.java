import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	
	static int N, M;
	static int[] weight, snack;
	static int sum, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		snack = new int[2];
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			sum = 0; max = 0;
			combination(0, 0);
			if(max == 0) max = -1;
			System.out.println("#"+t+" "+max);
		}
		
	}
	
	// 뽑는 개수가 2개밖에 안되므로 재귀문보다 2중반복문이 더 효율적
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			sum = snack[0] + snack[1];
			if(sum <= M) max = Math.max(sum, max);
			return;
		}
		
		for(int i=start; i<N; i++) {
			snack[cnt] = weight[i];
			combination(cnt+1, i+1);
		}
	}
}
