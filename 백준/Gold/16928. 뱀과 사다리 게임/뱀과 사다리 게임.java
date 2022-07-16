import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P {
    int to;
    int cnt;

    P(int to, int cnt) {
        this.to = to;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[2][101]; //0: type, 1: to
        boolean[] checked = new boolean[101];

        // type 0: 일반, 1: 사다리, 2: 뱀
        for(int i=0; i<n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[0][from] = 1;
            map[1][from] = to;
        }
        for(int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[0][from] = 2;
            map[1][from] = to;
        }

        Queue<P> q = new LinkedList<>();
        q.offer(new P(1, 0));
        checked[1] = true;
        while(!q.isEmpty()) {
            P p = q.poll();
            int to = p.to;
            int cnt = p.cnt;
            
            if(to == 100) {
                System.out.println(cnt);
                System.exit(0);
            }

            for(int i=1; i<=6; i++) {
                int next = to + i;
                if(inRange(next) && !checked[next]) {
                    checked[next] = true;
                    if(map[0][next] == 1) { // 사다리
                        next = map[1][next];
                        if(checked[next]) continue;
                        checked[next] = true;
                        q.offer(new P(next, cnt+1));
                    } else if(map[0][next] == 2) { // 뱀
                        next = map[1][next];
                        if(checked[next]) continue;
                        checked[next] = true;
                        q.offer(new P(next, cnt+1));
                    } else {
                        checked[next] = true;
                        q.offer(new P(next, cnt+1));
                    }
                }
            }
        }
    }

    public static boolean inRange(int x) {
        if(x >= 1 && x <= 100) return true;
        else return false;
    }
}