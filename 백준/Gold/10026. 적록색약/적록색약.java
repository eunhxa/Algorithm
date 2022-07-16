import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point2 {
    int x;
    int y;
    char c;
    Point2(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] checked;

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        checked = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(checked[i][j]) continue;
                Queue<Point2> q = new LinkedList<>();
                q.offer(new Point2(i, j, map[i][j]));
                checked[i][j] = true;
                while(!q.isEmpty()) {
                    Point2 p = q.poll();
                    int x = p.x;
                    int y = p.y;
                    char c = p.c;

                    for(int k=0; k<4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(inRange(nx, ny) && !checked[nx][ny] && map[nx][ny] == c) {
                            q.offer(new Point2(nx, ny, map[nx][ny]));
                            checked[nx][ny] = true;
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.print(cnt+" ");

        cnt = 0;
        checked = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(checked[i][j]) continue;
                Queue<Point2> q = new LinkedList<>();
                q.offer(new Point2(i, j, map[i][j]));
                checked[i][j] = true;
                while(!q.isEmpty()) {
                    Point2 p = q.poll();
                    int x = p.x;
                    int y = p.y;
                    char c = p.c;

                    for(int k=0; k<4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(inRange(nx, ny) && !checked[nx][ny]) {
                            if(c != 'B') {
                                if(map[nx][ny] != 'B') {
                                    q.offer(new Point2(nx, ny, map[nx][ny]));
                                    checked[nx][ny] = true;
                                }
                            }
                            else {
                                if(map[nx][ny] == c) {
                                    q.offer(new Point2(nx, ny, map[nx][ny]));
                                    checked[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < n) return true;
        else return false;
    }
}