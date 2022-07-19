import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int row;
	static int col;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[row][col];
		int cnt = 0;
		
		for(int i=0; i<row; i++) {
			String s = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = s.charAt(j*2)-'0';
				if(map[i][j] == 1) cnt++;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		LinkedList<Point> list;
		
		int loopCnt = 0;
		int before = 0;
		
		while(true) {
			before = cnt;
			loopCnt++;
			q.add(new Point(0,0));
			list = new LinkedList<>();
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				for(int i=0; i<4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(isIn(nx,ny) && map[nx][ny] == 0) {
						q.add(new Point(nx,ny));
						list.add(new Point(nx,ny));
						map[nx][ny] = 2;
					}
				}
			}
			
			for(Point p : list) {
				map[p.x][p.y] = 0;
				for(int i=0; i<4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(isIn(nx,ny) && map[nx][ny] == 1) {
						map[nx][ny] = 0;
						cnt--;
					}
				}
			}
			
			if(cnt == 0) {
				break;
			}

		}
		
		System.out.println(loopCnt); //걸리는 시간
		System.out.println(before); //한시간 전에 남아있는 치즈조각이 놓여있는 칸의 개수
		
	}
	
	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && nx < row && ny >= 0 && ny < col;
	}

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void print2DimArray(int[][] arr) {
		for(int[] line : arr) {
			System.out.println(Arrays.toString(line));
		}
		System.out.println();
	}
}