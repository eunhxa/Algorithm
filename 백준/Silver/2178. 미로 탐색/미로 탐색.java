import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;
    int cnt;
    Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] checked;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n][m];
        checked = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        Queue<Pair> q = new LinkedList<>();
        checked[0][0] = true;
        q.add(new Pair(0, 0, 1));
        while(true) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;
            for(int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx == n-1 && ny == m-1) {
                    System.out.println(cnt+1);
                    System.exit(0);
                }
                if(isValid(nx, ny) && !checked[nx][ny] && arr[nx][ny] == 1) {
                    checked[nx][ny] = true;
                    q.add(new Pair(nx, ny, cnt+1));
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }
}