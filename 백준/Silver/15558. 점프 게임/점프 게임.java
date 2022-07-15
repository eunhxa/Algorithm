import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int r;

    Point(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[][] map = new int[2][n];
        boolean[][] checked = new boolean[2][n];
        for(int i=0; i<2; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        checked[0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int r = p.r;

            // 1. 한칸 앞으로
            int nx = x;
            int ny = y+1;
            isClear(ny, n);
            if(inRange(nx, ny, r+1) && !checked[nx][ny] && map[nx][ny] == 1) {
                q.offer(new Point(nx, ny, r+1));
                checked[nx][ny] = true;
            }

            // 2. 한칸 뒤로
            nx = x;
            ny = y-1;
            isClear(ny, n);
            if(inRange(nx, ny, r+1) && !checked[nx][ny] && map[nx][ny] == 1) {
                q.offer(new Point(nx, ny, r+1));
                checked[nx][ny] = true;
            }

            // 3. 점프
            if(x == 0) nx = 1;
            else nx = 0;
            ny = y+k;
            isClear(ny, n);
            if(inRange(nx, ny, r+1) && !checked[nx][ny] && map[nx][ny] == 1) {
                q.offer(new Point(nx, ny, r+1));
                checked[nx][ny] = true;
            }
        }
        System.out.println(0);
    }

    public static boolean inRange(int x, int y, int r) {
        if(y >= r) return true;
        else return false;
    }

    public static void isClear(int y, int n) {
        if(y >= n) {
            System.out.println(1);
            System.exit(0);
        }
    }
}