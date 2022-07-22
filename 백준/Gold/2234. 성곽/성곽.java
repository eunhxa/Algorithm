import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] color;
    static int room;
    static String[] strs = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    private static class Point {
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
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        room = 0;
        int[][] map = new int[n][m];
        color = new int[n][m];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        bfs(map, true);
        int[] roomSize = new int[room];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                roomSize[color[i][j]-1]++;
            }
        }
        int maxRoomArea = 0;
        for(int i=0; i<room; i++) {
            if(roomSize[i] > maxRoomArea) maxRoomArea = roomSize[i];
        }

        int maxRoomArea2 = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!inRange(nx, ny)) continue;
                    if(color[i][j] == color[nx][ny]) continue;
                    if(strs[map[i][j]].charAt(k) == '0') continue;
                    int tmp = roomSize[color[i][j]-1] + roomSize[color[nx][ny]-1];
                    if(tmp > maxRoomArea2) maxRoomArea2 = tmp;
                }
            }
        }
        System.out.println(room);
        System.out.println(maxRoomArea);
        System.out.println(maxRoomArea2);
    }

    public static void bfs(int[][] map, boolean drawRoom) {
        boolean[][] checked = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(checked[i][j]) continue;
                room++;

                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i, j, 1));
                checked[i][j] = true;
                while(!q.isEmpty()) {
                    Point p = q.poll();
                    int x = p.x;
                    int y = p.y;
                    int cnt = p.cnt;
                    if(drawRoom) color[x][y] = room;

                    for(int k=0; k<4; k++) {
                        int nx = x+dx[k];
                        int ny = y+dy[k];

                        if(inRange(nx, ny) && !checked[nx][ny] && strs[map[x][y]].charAt(k) == '0') {
                            q.offer(new Point(nx, ny, cnt+1));
                            checked[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < n && y < m) return true;
        else return false;
    }
}