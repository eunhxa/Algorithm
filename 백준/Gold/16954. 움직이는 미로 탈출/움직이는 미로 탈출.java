import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Point3 {
    int x;
    int y;
    int t;
    char[][] map;

    Point3(int x, int y, int t, char[][] map) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.map = map;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] original = new char[8][8];
        boolean[][][] checked = new boolean[8][8][100];
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for(int i=0; i<8; i++) {
            String str = br.readLine();
            for(int j=0; j<8; j++) {
                original[i][j] = str.charAt(j);
            }
        }

        Queue<Point3> q = new LinkedList<>();
        q.offer(new Point3(7, 0, 0, original));
        checked[7][0][0] = true;
        while(!q.isEmpty()) {
            Point3 p = q.poll();
            int x = p.x;
            int y = p.y;
            int t = p.t;
            char[][] map = p.map;

            if(map[x][y] == '#') continue;

            if(x == 0 && y == 7) {
                System.out.println(1);
                System.exit(0);
            }

            for(int k=0; k<9; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if(inRange(nx, ny) && !checked[nx][ny][t+1] && map[nx][ny] == '.') {
                    q.offer(new Point3(nx, ny, t+1, move(map)));
                    checked[nx][ny][t+1] = true;
                }
            }
        }

        System.out.println(0);
    }

    public static boolean inRange(int x, int y) {
        if(x >= 0 && y >= 0 && x < 8 && y < 8) return true;
        else return false;
    }

    public static char[][] move(char[][] map) {
        char[][] tmpMap = new char[8][8];
        for(int i=7; i>0; i--) {
            for(int j=0; j<8; j++) {
                tmpMap[i][j] = map[i-1][j];
            }
        }
        for(int i=0; i<8; i++) {
            tmpMap[0][i] = '.';
        }
        return tmpMap;
    }
}