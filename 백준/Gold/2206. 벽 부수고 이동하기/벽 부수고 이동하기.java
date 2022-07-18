import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
    int x;
    int y;
    int cnt;
    boolean wall;

    Point2(int x, int y, int cnt, boolean wall) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.wall = wall;
    }
}

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int[][] map = new int[n+1][m+1];
        boolean[][][] checked = new boolean[n+1][m+1][2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            for(int j=1; j<=m; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
            }
        }

        Queue<Point2> q = new LinkedList<>();
        q.offer(new Point2(1, 1, 1, false));
        checked[1][1][0] = true;
        while(!q.isEmpty()) {
            Point2 p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            boolean wall = p.wall;
            int iwall;
            if(wall) iwall = 1;
            else iwall = 0;

            if(x == n && y == m) {
                System.out.println(cnt);
                System.exit(0);
            }

            for(int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(inRange(nx, ny) && !checked[nx][ny][iwall]) {
                    if(map[nx][ny] == 0) {
                        q.offer(new Point2(nx, ny, cnt+1, wall));
                        checked[nx][ny][iwall] = true;
                    } else {
                        if(wall) {
                            continue;
                        } else {
                            q.offer(new Point2(nx, ny, cnt+1, true));
                            checked[nx][ny][iwall] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean inRange(int x, int y) {
        if(x >= 1 && y >= 1 && x <= n && y <= m) return true;
        else return false;
    }
}