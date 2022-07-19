import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, l;

    private static class Point {
        int x;
        int y;
        int cnt;
        int wall;

        Point(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        int[][] map = new int[n+1][m+1];
        boolean[][][] checked = new boolean[n+1][m+1][l+1];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            for(int j=1; j<=m; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j-1)+"");
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 1, 1, 0));
        checked[1][1][0] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            int wall = p.wall;

            if(x == n && y == m) {
                System.out.println(cnt);
                System.exit(0);
            }

            for(int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(inRange(nx, ny)) {
                    if(map[nx][ny] == 0) {
                        if(!checked[nx][ny][wall]) {
                            q.offer(new Point(nx, ny, cnt+1, wall));
                            checked[nx][ny][wall] = true;
                        }
                    } else {
                        if(wall >= l) {
                            continue;
                        } else {
                            if(!checked[nx][ny][wall+1]) {
                                q.offer(new Point(nx, ny, cnt+1, wall+1));
                                checked[nx][ny][wall+1] = true;
                            }
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