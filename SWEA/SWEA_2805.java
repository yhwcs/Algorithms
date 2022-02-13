import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String line;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] profit = new int[N][N];
			for(int i=0; i<N; i++) {
				line = br.readLine();
				for(int j=0; j<N; j++) {
					profit[i][j] = line.charAt(j) - '0';
				}
			}
			
			int sum = 0, count = 0;
			int mid = N/2;
			for(int i=0; i<N; i++) {
				int start = mid - count;
				int end = mid + count;
				for(int j=start; j<=end; j++) {
					sum += profit[i][j];
				}
				if(i < mid) count++;
				else count--;
			}
			System.out.println("#"+t+" "+sum);
		}

	}
	
}
