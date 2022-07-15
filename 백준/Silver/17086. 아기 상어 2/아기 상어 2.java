import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] checked;
    static int n;
    static int m;
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
        int max = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    checked = new boolean[n][m];
                    Queue<Point> q = new LinkedList<>();
                    q.offer(new Point(i, j, 0));
                    checked[i][j] = true;

                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        int cnt = p.cnt;
                        
                        if(map[x][y] == 1) {
                            max = max < cnt ? cnt : max;
                            break;
                        }

                        for(int k=0; k<8; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            
                            if(inRange(nx, ny) && !checked[nx][ny]) {
                                q.offer(new Point(nx, ny, cnt+1));
                                checked[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }
}