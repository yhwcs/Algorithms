import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N;
	static boolean[][] cells;
	static List<Point> cores;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int minWireCnt, maxCoreCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			cells = new boolean[N][N];
			cores = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					cells[i][j] = st.nextToken().equals("1") ? true:false;
					if(cells[i][j]) {
						// 가장 자리는 이미 전원이 연결된 것으로 간주 
						if(i==0 || i==N-1 || j==0 || j==N-1) continue;
						cores.add(new Point(i, j));
					}
				}
			}
			minWireCnt = Integer.MAX_VALUE;
			maxCoreCnt = 0;
			
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minWireCnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int idx, int wireCnt, int coreCnt) {
		// 모든 코어를 다 확인했다면 종료
		if(idx == cores.size()) {
			if(maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minWireCnt = wireCnt;
			} else if(maxCoreCnt == coreCnt && minWireCnt > wireCnt) {
				minWireCnt = wireCnt;
			}
			return;
		}
		
		int r = cores.get(idx).r;
		int c = cores.get(idx).c;
		
		for(int d=0; d<4; d++) {
			int nr = r;
			int nc = c;
			int count = 0;
			
			// 한 칸씩 이동하면서 가장자리까지 전선을 놓을 수 있는지 확인 
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) break;
				if(cells[nr][nc]) {
					count = 0;
					break;
				}
				
				count++;
			}

			// 전선을 놓을 수 없다면 다음 코어 확인
			if(count == 0) dfs(idx+1, wireCnt, coreCnt);
			// 전선을 놓을 수 있다면 전선 설치 후 다음 코어 확인
			else {
				int wireR = r;
				int wireC = c;
				for(int i=0; i<count; i++) {
					wireR += dr[d];
					wireC += dc[d];
					cells[wireR][wireC] = true;
				}
				
				dfs(idx+1, wireCnt+count, coreCnt+1);
				
				// 전선 제거 후 다음 방향 확인
				wireR = r;
				wireC = c;
				for(int i=0; i<count; i++) {
					wireR += dr[d];
					wireC += dc[d];
					cells[wireR][wireC] = false;
				}
			}
			
		}
		
		
	}
	
}
