import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int cnt;
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static boolean[][] checked;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        checked = new boolean[n][n];

        Point start = new Point(sc.nextInt(), sc.nextInt(), 0);
        Point end = new Point(sc.nextInt(), sc.nextInt(), 0);

        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;

            if(x == end.x && y == end.y) {
                System.out.println(cnt);
                System.exit(0);
            }

            for(int k=0; k<6; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(inRange(nx, ny) && !checked[nx][ny]) {
                    q.add(new Point(nx, ny, cnt+1));
                    checked[nx][ny] = true;
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < n) return true;
        else return false;
    }
}