import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = 9;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		
		int cnt = 0;
		boolean[][] visited = new boolean[r][c];
		
		Queue<Point> save = new LinkedList<>();

		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				
				if(map[i][j] == 9) {
					q.add(new Point(i,j));
					cnt++;
					map[i][j] = cnt;
					visited[i][j] = true;
					
					save.add(new Point(i,j));
				}
				
				//한 섬에 대해서 인덱싱
				while(!q.isEmpty()) {
					Point p = q.poll();
					for(int k=0; k<4; k++) {
						int nx = p.x+dx[k];
						int ny = p.y+dy[k];
						
						if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 9) {
							save.add(new Point(nx,ny));
							map[nx][ny] = cnt;
							q.add(new Point(nx,ny));
						}
					}
				}
				
			}
		} // 인덱싱
		
		Queue<edge> eq = new PriorityQueue<>(new Comparator<edge>() {

			@Override
			public int compare(edge o1, edge o2) {
				if(o1.length >= o2.length) return 1;
				else return -1;
			}
		}); //크루스칼 사용을 위해 우선순위 큐로 구현, 짧은 다리 순
		
		
		int len;
		
		while(!save.isEmpty()) {
			Point p = save.poll();
			
			if(isIn(p.x-2, p.y) && map[p.x-1][p.y] == 0 && map[p.x-2][p.y] == 0) { 
				len = 2; //다리 길이가 2 이상이여야함
				while(isIn(p.x-len, p.y)) { //범위를 벗어나면 break;
					if(map[p.x-len][p.y] != 0) {
						if(map[p.x-len][p.y] > map[p.x][p.y]) {
							eq.add(new edge(map[p.x][p.y], map[p.x-len][p.y], len-1));
						}
						break;
					}
					len++;
				}
			}
			
			if(isIn(p.x, p.y+2) && map[p.x][p.y+1] == 0 && map[p.x][p.y+2] == 0) { 
				len = 2;
				while(isIn(p.x, p.y+len)) { //범위를 벗어나면 break;
					if(map[p.x][p.y+len] != 0) {
						if(map[p.x][p.y+len] > map[p.x][p.y]) {
							eq.add(new edge(map[p.x][p.y], map[p.x][p.y+len], len-1));
						}
						break;
					}
					len++;
				}
			}
			
			if(isIn(p.x+2, p.y) && map[p.x+1][p.y] == 0 && map[p.x+2][p.y] == 0) { 
				len = 2; //다리 길이가 2 이상이여야함
				while(isIn(p.x+len, p.y)) { //범위를 벗어나면 break;
					if(map[p.x+len][p.y] != 0) {
						if(map[p.x+len][p.y] > map[p.x][p.y]) {
							eq.add(new edge(map[p.x][p.y], map[p.x+len][p.y], len-1));
						}
						break;
					}
					len++;
				}
			}
			
			if(isIn(p.x, p.y-2) && map[p.x][p.y-1] == 0 && map[p.x][p.y-2] == 0) { 
				len = 2;
				while(isIn(p.x, p.y-len)) { //범위를 벗어나면 break;
					if(map[p.x][p.y-len] != 0) {
						if(map[p.x][p.y-len] > map[p.x][p.y]) {
							eq.add(new edge(map[p.x][p.y], map[p.x][p.y-len], len-1));
						}
						break;
					}
					len++;
				}
			}
		} //모든 다리 만들어보기
		
		parent = new int[cnt+1];
		int result = 0;
		
		for(int i=1; i<=cnt; i++) {
			parent[i] = i;
		}
		
		int size = eq.size();
		int landcnt = 0;
		
		//print2DimArray(map);
		
		for(int i=0; i<size; i++) {
			edge e = eq.poll();
			int start = e.startP;
			int end = e.endP;
			int a = find(start);
			int b = find(end);
			if(a==b) continue;
			
			union(start, end);
			result += e.length;
			landcnt++;
		}
		
		if(landcnt == cnt-1) System.out.println(result);
		else System.out.println(-1);
		
	} //end of main
	
	static int find(int a) {
		if(a==parent[a]) return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		} else {
			return;
		}
	}
	
	public static class edge {
		int startP;
		int endP;
		int length;
		
		public edge(int startP, int endP, int length) {
			this.startP = startP;
			this.endP = endP;
			this.length = length;
		}

		@Override
		public String toString() {
			return "edge [startP=" + startP + ", endP=" + endP + ", length=" + length + "]";
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x < r && x >= 0 && y < c && y >= 0;
	}
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static void print2DimArray(int[][] arr) {
		for(int[] line : arr) {
			System.out.println(Arrays.toString(line));
		}
		System.out.println();
	}

}