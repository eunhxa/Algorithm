import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] checked;
    static int n, m;

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

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();
        int year = 0;
        while(checkMap(map)) {
            year++;
            checked = new boolean[n][m];
            recure(map);
            ArrayList<Point> a = new ArrayList<>();
            q.offer(new Point(0, 0));
            checked[0][0] = true;
            while(!q.isEmpty()) {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;

                for(int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if(inRange(nx, ny) && !checked[nx][ny]) {
                        if(map[nx][ny] == 0) {
                            q.offer(new Point(nx, ny));
                            a.add(new Point(nx, ny));
                            checked[nx][ny] = true;
                        }
                    }
                }
            }

            for(int i=0; i<a.size(); i++) {
                Point p = a.get(i);
                int x = p.x;
                int y = p.y;

                for(int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if(inRange(nx, ny) && map[nx][ny] > 0) {
                        map[nx][ny] -= 1;
                    }
                }
            }
        }
        System.out.println(year);
    }

    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }

    public static void recure(int[][] map) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0) map[i][j] = 2;
            }
        }
    }

    public static boolean checkMap(int[][] map) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0) return true;
            }
        }
        return false;
    }
}