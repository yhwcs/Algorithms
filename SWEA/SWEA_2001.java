import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
// 			int[][] grid = new int[N][N];
// 			for(int i=0; i<N; i++) {
// 				st = new StringTokenizer(br.readLine(), " ");
// 				for(int j=0; j<N; j++) {
// 					grid[i][j] = Integer.parseInt(st.nextToken());
// 				}
// 			}
// 			int max = 0;
// 			// O((N-M+1)^2 * M^2)
// 			for(int i=0; i<=N-M; i++) {
// 				for(int j=0; j<=N-M; j++) {
// 					int sum = 0;
// 					for(int k=0; k<M; k++){
// 						for(int l=0; l<M; l++) {
// 							sum += grid[i+k][j+l];
// 						}
// 					}
// 					if(sum > max) max = sum;
// 				}
// 			}
			
			// Sliding Window Algorithm
			// 1열부터 사용하기 위해 [N+1]
			int[][] map = new int[N][N+1]; 
			for (int i = 0; i <N; ++i) {
				st = new StringTokenizer(in.readLine().trim(), " ");
				// 행 단위로 열 누적합
				for (int j = 1; j <=N; ++j) {
					map[i][j] = map[i][j-1]+ Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int i = 0; i <=N-M; ++i) {
				for (int c = M; c <=N; ++c) {
					int sum = 0;
					for (int r = i; r < i+M; ++r) { 
						sum += map[r][c] - map[r][c-M];
					}
					max = Math.max(sum, max);
				}
			}

			System.out.println("#"+t+" "+max);
		}
	}


}
