import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair4 {
    long x;
    int cnt;
    String oper;
    Pair4(long x, int cnt, String oper) {
        this.x = x;
        this.cnt = cnt;
        this.oper = oper;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        boolean[] checked = new boolean[1000000001];

        if(s == t) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<Pair4> q = new LinkedList<>();
        q.offer(new Pair4(s, 0, ""));
        while(!q.isEmpty()) {
            Pair4 p = q.poll();
            long x = p.x;
            int cnt = p.cnt;
            String oper = p.oper;

            if(x == t) {
                System.out.println(oper);
                System.exit(0);
            }

            long nx = x * x;
            if(inRange(nx) && !checked[(int)nx]) {
                q.offer(new Pair4(nx, cnt+1, oper+"*"));
                checked[(int)nx] = true;
            }

            nx = x + x;
            if(inRange(nx) && !checked[(int)nx]) {
                q.offer(new Pair4(nx, cnt+1, oper+"+"));
                checked[(int)nx] = true;
            }

            nx = x - x;
            if(inRange(nx) && !checked[(int)nx]) {
                q.offer(new Pair4(nx, cnt+1, oper+"-"));
                checked[(int)nx] = true;
            }
            

            if(x != 0) {
                nx = x / x;
                if(inRange(nx) && !checked[(int)nx]) {
                    q.offer(new Pair4(nx, cnt+1, oper+"/"));
                    checked[(int)nx] = true;
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean inRange(long x) {
        if(x >= 0 && x < 1000000001) return true;
        else return false;
    }
}