import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point4 {
    int x;
    int y;
    Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        char[][] map = new char[r][c];
        boolean[][] checked = new boolean[r][c];
        Queue<Point4> q = new LinkedList<>();
        
        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    q.offer(new Point4(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            Point4 p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if(isRange(nx, ny)) {
                    if(map[nx][ny] == '.' && !checked[nx][ny]) {
                        q.offer(new Point4(nx, ny));
                        checked[nx][ny] = true;
                    }
                    else if(map[nx][ny] == 'W') {
                        if(map[x][y] == 'S') {
                            System.out.println(0);
                            System.exit(0);
                        } else {
                            map[x][y] = 'D';
                        }
                    }
                }
            }
        }

        System.out.println(1);
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < r && y < c) return true;
        else return false;
    }
}