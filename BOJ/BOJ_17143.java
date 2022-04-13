import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_17143 {
	
	static class Shark {
		int r, c;
		int s, d, z;	// 속력, 이동방향, 크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R, C, M, king, ans;
	static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static Shark[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				map[i][j] = new Shark(i, j, 0, 0, 0);
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(d == UP || d == DOWN) s %= 2*(R-1);
			else s %= 2*(C-1);
			map[r][c] = new Shark(r, c, s, d, z);
		}
		go();
		System.out.println(ans);

	}
	
	public static void fishing() {
		for(int i=1; i<=R; i++) {
			if(map[i][king].z != 0) {
				ans += map[i][king].z;
				map[i][king] = new Shark(i, king, 0, 0, 0);
				return;
			}
		}
	}
	
	public static void move(Shark[][] temp, Shark sh) {
		int nr = sh.r;
		int nc = sh.c;
		int count = 0;
		while(count < sh.s) {
			nr += dr[sh.d];
			nc += dc[sh.d];
			if(nr<=0 || nr>R || nc<=0 || nc>C) {
				nr -= dr[sh.d];
				nc -= dc[sh.d];
				turn(sh);
				continue;
			}
			count++;
		}
		sh.r = nr;
		sh.c = nc;
		
		if(temp[nr][nc].z == 0) temp[nr][nc] = sh;
		else if(temp[nr][nc].z < sh.z) temp[nr][nc] = sh;
	}
	
	public static void turn(Shark sh) {
		switch(sh.d) {
		case UP:
			sh.d = DOWN;
			break;
		case DOWN:
			sh.d = UP;
			break;
		case RIGHT:
			sh.d = LEFT;
			break;
		case LEFT:
			sh.d = RIGHT;
		}
	}
	
	public static void go() {
		while(king < C) {
			king += 1;
			fishing();
			
			Shark[][] temp = new Shark[R+1][C+1];
			for(int i=1; i<=R; i++) {
				for(int j=1; j<=C; j++) {
					temp[i][j] = new Shark(i, j, 0, 0, 0);
				}
			}
			
			for(int i=1; i<=R; i++) {
				for(int j=1; j<=C; j++) {
					if(map[i][j].z != 0) {
						move(temp, map[i][j]);
					}
				}
			}
			
			map = temp;
		}
	}

}
