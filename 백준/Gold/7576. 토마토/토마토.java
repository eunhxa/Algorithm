import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		Queue<Point> queue = new LinkedList<>();

		String s = scanner.nextLine();
		String[] splited = s.split(" "); 
		int col = Integer.parseInt(splited[0]);
		int row = Integer.parseInt(splited[1]);
		
		int[][] arr = new int[row][col];
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i=0; i<row; i++) {
			s = scanner.nextLine();
			splited = s.split(" ");
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(splited[j]);
				if(arr[i][j] == 1) queue.offer(new Point(i,j,0));
			}
		}

		int curDay = 0;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek().x;
			int curY = queue.peek().y;
			curDay = queue.peek().day;
			queue.poll();
			for(int i=0; i<4; i++) {
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				
				if(inRange(nx, ny, row, col)) {
					if(arr[nx][ny] == 0) {
						queue.offer(new Point(nx,ny, curDay+1));
						arr[nx][ny] = 1;
					}
				}
			}
		}
		
		if(isComplete(arr)) System.out.println(curDay);
		else System.out.println(-1);
	}
	
	public static boolean inRange(int x, int y, int row, int col) {
		return x >= 0 && x < row && y >=0 && y < col;
	}
	
	public static boolean isComplete(int[][] arr) {
		boolean check = true;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 0) check = false;
			}
		}
		
		return check;
	}
	
	
	public static class Point {
		int x;
		int y;
		int day;
		
		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	

}