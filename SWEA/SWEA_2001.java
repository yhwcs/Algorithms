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
			int[][] grid = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			// O((N-M+1)^2 * M^2)
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int sum = 0;
					for(int k=0; k<M; k++){
						for(int l=0; l<M; l++) {
							sum += grid[i+k][j+l];
						}
					}
					if(sum > max) max = sum;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}


}
