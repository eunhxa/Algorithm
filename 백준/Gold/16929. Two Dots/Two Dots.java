import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static int[][] dist;
    static boolean[][] checked;
    static int n, m;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new char[n][m];
        checked = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        flag = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!checked[i][j]) {
                    dist = new int[n][m];
                    checked[i][j] = true;
                    dist[i][j] = 1;
                    dfs(i, j, arr[i][j], 1);
                    if(flag) {
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");

    }

    public static void dfs(int x, int y, char c, int cnt) {
        for(int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(isValid(nx, ny) && checked[nx][ny] && arr[nx][ny] == c) {
                if(cnt - dist[nx][ny] >= 3) {
                    flag = true;
                    return;
                }
            }
            if(isValid(nx, ny) && !checked[nx][ny] && arr[nx][ny] == c) {
                dist[nx][ny] = cnt+1;
                checked[nx][ny] = true;
                dfs(nx, ny, c, cnt+1);
            }
        }
    }

    public static boolean isValid(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }
}