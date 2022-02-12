import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	static int N, L;
	static int max = 0;
	static int[] t, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			t = new int[N];
			k = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				t[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			generateSubset(0, 0, 0);
			System.out.println("#"+tc+" "+max);
		}
	}
	
	public static void generateSubset(int cnt, int score, int calorie) {
		if(calorie > L) return;
		if(cnt == N) {
			max = Math.max(max, score);
			return;
		}
		
		generateSubset(cnt+1, score+t[cnt], calorie+k[cnt]);
		generateSubset(cnt+1, score, calorie);
		
	}

}
