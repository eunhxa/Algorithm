import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    static int l;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, 2, -2, 1, -1};
    static boolean[][] checked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            boolean flag = false;
            l = sc.nextInt();
            checked = new boolean[l][l];
            Pair start = new Pair(sc.nextInt(), sc.nextInt(), 0);
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            Queue<Pair> q = new LinkedList<>();
            q.add(start);
            checked[start.x][start.y] = true;

            while(!q.isEmpty()) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                int cnt = p.cnt;

                for(int k=0; k<8; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if(isValid(nx, ny) && !checked[nx][ny]) {
                        if(nx == endX && ny == endY) {
                            sb.append((cnt+1)+"\n");
                            flag = true;
                            break;
                        }
                        checked[nx][ny] = true;
                        q.add(new Pair(nx, ny, cnt+1));
                    }
                }
                if(flag) break;
            }
            if(!flag) sb.append("0\n");
        }
        System.out.println(sb);
    }

    public static boolean isValid(int x, int y) {
        if(x >= 0 && y >= 0 && x < l && y < l) return true;
        else return false;
    }
}