import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] box = null;
		int num = 1;
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			box = new int[N][N];
			num = 1;
			int idx = 0;
			
			while(num <= N*N) {
				for(int i=idx; i<N-idx; i++) {
					box[idx][i] = num++;
				}
				for(int i=idx+1; i<N-idx; i++) {
					box[i][N-idx-1] = num++;
				}
				for(int i=N-idx-2; i>=idx; i--) {
					box[N-idx-1][i] = num++;
				}
				for(int i=N-idx-2; i>idx; i--) {
					box[i][idx] = num++;
				}
				idx += 1;
			}
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(box[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
