import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pair {
    int x;
    int cnt;
    int clipboard;
    pair(int x, int cnt, int clipboard) {
        this.x = x;
        this.cnt = cnt;
        this.clipboard = clipboard;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] checked = new boolean[2001][2001];

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(1, 0, 0));
        checked[1][0] = true;
        while(!q.isEmpty()) {
            pair p = q.poll();
            
            int x = p.x;
            int cnt = p.cnt;
            int clipboard = p.clipboard;

            if(x == n) {
                System.out.println(cnt);
                System.exit(0);
            }

            int next;
            
            if(x != clipboard) q.add(new pair(x, cnt+1, x)); // 복사

            if(clipboard > 0) { // 붙여넣기
                next = x+clipboard;
                if(isValid(next) && !checked[next][clipboard]) {
                    q.add(new pair(next, cnt+1, clipboard));
                    checked[next][clipboard] = true;
                }
            }

            next = x-1; // 지우기
            if(isValid(next) && !checked[next][clipboard]) {
                q.add(new pair(next, cnt+1, clipboard));
                checked[next][clipboard] = true;
            }
        }
    }

    public static boolean isValid(int x) {
        if(x >= 0 && x <= 2000) return true;
        else return false;
    }
}