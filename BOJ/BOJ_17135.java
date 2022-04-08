import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17135_1 {
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int hashCode() {
			return this.r*M + this.c;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Point) {
				Point p = (Point) obj;
				if(this.r == p.r && this.c == p.c) return true;
				return false;
			}
			return super.equals(obj);
		}
		
	}
	
	static int N, M, D, max;
	static int[] archer;
	static List<Point> enemy, targets;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[3];
		enemy = new LinkedList<>();
		targets = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				if(st.nextToken().equals("1")) enemy.add(new Point(i, j));
			}
		}
		combination(0, 0);
		System.out.println(max);

	}
	
	public static void combination(int start, int cnt) {
		if(cnt == 3) {
			int count = go();
			if(max < count) max = count;
			return;
		}
		
		for(int i=start; i<M; i++) {
			archer[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	public static int go() {
		for(Point e : enemy) targets.add(e);
		
		int count = 0;
		while(!targets.isEmpty()) {
			count += shoot();
			move();
		}
		return count;
	}
	
	public static Point find(int col) {
		int dist, minDist = D+1, minIdx = -1;
		for(int i=0; i<targets.size(); i++) {
			Point target = targets.get(i);
			dist = (N - target.r) + Math.abs(col - target.c);
			if(dist > D) continue;
			if(minDist > dist) {
				minDist = dist;
				minIdx = i;
			} else if(minDist == dist) {
				if(targets.get(minIdx).c > target.c) minIdx = i;
			}
		}
		if(minIdx >=0 )return targets.get(minIdx);
		else return null;
	}
	
	
	public static int shoot() {
		int count = 0;
		Set<Point> removeSet = new HashSet<>();
		
		for(int col : archer) {
			Point target = find(col);
			if(target != null) removeSet.add(target);
		}
		for(Point target : removeSet) {
			targets.remove(target);
			count++;
		}
		return count;
	}
	
	public static void move() {
		for(int i=targets.size()-1; i>=0; i--) {
			Point target = targets.get(i);
			if(target.r == N-1) targets.remove(i);
			else targets.set(i, new Point(target.r+1, target.c));
		}
	}

}
