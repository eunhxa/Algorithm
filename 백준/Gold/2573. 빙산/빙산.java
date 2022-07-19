import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int[][] map = new int[n][m];

        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 0) {
                    q.offer(new Point(i, j));
                }
            }
        }

        int year = 0;
        int ret;
        while((ret = countIce(map)) < 0) {
            year++;
            while(!q.isEmpty()) {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;

                for(int k=0; k<4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    
                    if(inRange(nx, ny) && map[nx][ny] > 0) {
                        map[nx][ny] -= 1;
                    }
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 0) {
                        q.offer(new Point(i, j));
                    }
                }
            }
        }
        if(ret == 0) System.out.println(0);
        else System.out.println(year);
    }
    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }

    public static int countIce(int[][] map) {
        boolean[][] checked = new boolean[n][m];
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0 && !checked[i][j]) {
                    count++;
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(i, j));
                    checked[i][j] = true;
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        int x = p.x;
                        int y = p.y;

                        for(int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];

                            if(inRange(nx, ny) && !checked[nx][ny] && map[nx][ny] > 0) {
                                q.offer(new Point(nx, ny));
                                checked[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        if(count >= 2) return 1;
        else if(count == 0) return 0;
        else return -1;
    }
}