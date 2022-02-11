import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class SWEA_1873 {

	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./input.txt"));
		System.setOut(new PrintStream(new FileOutputStream(new File("./output.txt"))));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			// char[H][W] 하면 toCharArray() 할 때 다시 객체 생성하므로 낭비
			map = new char[H][];
			int r = 0, c= 0;
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<W; j++) {
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
						r = i;
						c = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for(int i=0; i<N; i++) {
				if(input.charAt(i) == 'U') {
					if(r-1>=0 && map[r-1][c] == '.') {
						map[r-1][c] = '^';
						map[r][c] = '.';
						r -= 1;
					} else map[r][c] = '^';
				} else if(input.charAt(i) == 'D') {
					if(r+1<H && map[r+1][c] == '.') {
						map[r+1][c] = 'v';
						map[r][c] = '.';
						r += 1;
					} else map[r][c] = 'v';
				} else if(input.charAt(i) == 'L') {
					if(c-1>=0 && map[r][c-1] == '.') {
						map[r][c-1] = '<';
						map[r][c] = '.';
						c -= 1;
					} else map[r][c] = '<';
				} else if(input.charAt(i) == 'R') {
					if(c+1<W && map[r][c+1] == '.') {
						map[r][c+1] = '>';
						map[r][c] = '.';
						c += 1;
					} else map[r][c] = '>';
				} else if(input.charAt(i) == 'S') {
					Shoot(H, W, r, c, map[r][c]);
				} 
			}
			System.out.print("#"+t+" ");
			for(int i=0; i<H; i++) {
				System.out.println(map[i]);
			}
		}
	}
	
	public static void Shoot(int H, int W, int r, int c, char status) {
		if(status == '^') {
			if(r-1<0 || map[r-1][c]=='#') return;
			if(r-1>=0) {
				if(map[r-1][c]=='*') {
					map[r-1][c] = '.';
					return;
				}
				Shoot(H, W, r-1, c, status);
			}
		} else if(status == 'v') {
			if(r+1>=H || map[r+1][c]=='#') return;
			if(r+1<H) {
				if(map[r+1][c]=='*') {
					map[r+1][c] = '.';
					return;
				}
				Shoot(H, W, r+1, c, status);
			}
		} else if(status == '<') {
			if(c-1<0 || map[r][c-1]=='#') return;
			if(c-1>=0) {
				if(map[r][c-1]=='*') {
					map[r][c-1] = '.';
					return;
				}
				Shoot(H, W, r, c-1, status);
			}
		} else if(status == '>') {
			if(c+1>=W || map[r][c+1]=='#') return;
			if(c+1<W) {
				if(map[r][c+1]=='*') {
					map[r][c+1] = '.';
					return;
				}
				Shoot(H, W, r, c+1, status);
			}
		}
	}

}
