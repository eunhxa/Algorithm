import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int min;

    static private class Point {
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        min = -1;
        Point[] pArr;

        int cnt = 0;
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2) cnt++;
            }
        }
        pArr = new Point[cnt];
        cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 2) {
                    pArr[cnt++] = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        combination(pArr, new boolean[cnt], 0, cnt, n, m);
        System.out.println(min);
    }

    static void combination(Point[] pArr, boolean[] visited, int start, int cnt, int n, int r) {
        if(r == 0) {
            int ret = bfs(visited, pArr, cnt, n);
            if(ret >= 0) {
                if(min == -1) min = ret;
                else min = min > ret ? ret : min;
            }
            return;
        } 
    
        for(int i=start; i<cnt; i++) {
            visited[i] = true;
            combination(pArr, visited, i+1, cnt, n, r - 1);
            visited[i] = false;
        }
    }    

    public static int bfs(boolean[] visited, Point[] pArr, int cnt, int n) {
        boolean[][] checked = new boolean[n][n];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<cnt; i++) {
            if(visited[i]) {
                Point p = pArr[i];
                q.offer(new Point(p.x, p.y, 0));
                checked[p.x][p.y] = true;
            }
        }
        if(checkMap(n, checked)) return 0;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int curCnt = p.cnt;

            for(int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if(inRange(nx, ny, n) && !checked[nx][ny] && map[nx][ny] == 0) {
                    q.offer(new Point(nx, ny, curCnt+1));
                    checked[nx][ny] = true;
                }
            }
            if(checkMap(n, checked)) return curCnt+1;
        }
        return -1;
    }

    public static boolean checkMap(int n, boolean[][] checked) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0 && !checked[i][j]) return false;
            }
        }
        return true;
    }

    public static boolean inRange(int x, int y, int n) {
        if(x >= 0 && y >= 0 && x < n && y < n) return true;
        else return false;
    }
}