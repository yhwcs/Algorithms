import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5656 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, W, H, min;
	static int[][] bricks;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			bricks = new int[H][W];
			result = new int[N];
			min = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					bricks[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");	
		}
		System.out.println(sb.toString());

	}
	
	// 구슬을 쏠 벽돌 위치를 중복 순열으로 고르기
	public static void combination(int cnt) {
		if(cnt == N) {
			int[][] temp = new int[H][];
			for(int i=0; i<H; i++) {
				temp[i] = Arrays.copyOf(bricks[i], W);
			}
			int res = 0;
			for(int w : result) {
				int h = find(w, temp);
				// 해당 column에 벽돌이 없는 경우, 잘못된 순열이므로 종료 
				if(h == H) return;
				temp = remove(new Point(h, w), temp);
				temp = move(temp);
				res = getRest(temp);
				// 최소인 경우 더 탐색할 필요 없음 
				if(res == 0) {
					min = res;
					return;
				}
			}
			if(min > res) min = res;
			return;
		}
		
		for(int i=0; i<W; i++) {
			if(min == 0) return;
			result[cnt] = i;
			combination(cnt+1);
		}
	}
	
	// idx번째 column에서 맨 위의 벽돌 height 찾기
	public static int find(int idx, int[][] temp) {
		int h = 0;
		for(h=0; h<H; h++) {
			if(temp[h][idx] != 0) break;
		}
		return h;
	}
	
	// range만큼 4방의 벽돌 제거하기
	public static int[][] remove(Point start, int[][] temp) {
		int range = temp[start.r][start.c];
		temp[start.r][start.c] = 0;
		
		for(int d=0; d<4; d++) {
			int nr = start.r;
			int nc = start.c;
			
			for(int i=1; i<range; i++) {
				nr += dr[d];
				nc += dc[d];
				if(nr<0 || nr>=H || nc<0 || nc>=W) break;
				if(temp[nr][nc] != 0) remove(new Point(nr, nc), temp);
			}
		}
		return temp;
	}
	
	// 빈 공간이 있는 경우 벽돌 밑으로 떨어뜨리기 
	public static int[][] move(int[][] temp) {
		for(int w=0; w<W; w++) {
			for(int h=0; h<H-1; h++) {
				if(temp[h][w] != 0 && temp[h+1][w] == 0) {
					for(int i=h+1; i>0; i--) {
						temp[i][w] = temp[i-1][w];
					}
					temp[0][w] = 0;
				}
			}
		}
		return temp;
	}
	
	// 남은 벽돌의 개수 세기
	public static int getRest(int[][] temp) {
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(temp[i][j] != 0) count++;
			}
		}
		return count;
	}

}
