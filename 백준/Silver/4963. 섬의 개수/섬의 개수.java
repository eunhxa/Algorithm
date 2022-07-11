import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1,};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n, m;
    static boolean[][] check;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            if(n == 0 && m == 0) break;

            arr = new int[m][n];
            check = new boolean[m][n];

            for(int i=0; i<m; i++) {
                stk = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            int cnt = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if((!check[i][j]) && (arr[i][j] == 1)) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
    
    public static void bfs(int x, int y) {
        if(!check[x][y]) {
            check[x][y] = true;

            for(int i=0; i<8; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if((!check[nx][ny]) && (arr[nx][ny] == 1)) {
                        bfs(nx, ny);
                    }
                }
            }
        }
    }
}