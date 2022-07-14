import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class pair2 {
    int num;
    int cnt;
    pair2(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] checked = new boolean[1000001];
        int[] prev = new int[1000001];

        Queue<pair2> q = new LinkedList<>();
        q.add(new pair2(n, 0));
        checked[n] = true;
        prev[n] = -1;
        Stack<Integer> s = new Stack<>();
        
        while(!q.isEmpty()) {
            pair2 p = q.poll();
            int cur = p.num;
            int cnt = p.cnt;
            if(cur < 0 || cur > 100000) continue;
            if(cur == k) {
                System.out.println(cnt);
                s.push(cur);
                while(prev[cur] >= 0) {
                    s.push(prev[cur]);
                    cur = prev[cur];
                }
                while(!s.isEmpty()) {
                    System.out.print(s.pop()+" ");
                }
                System.exit(0);
            }
            if(cur-1 >= 0 && !checked[cur-1]) {
                q.add(new pair2(cur-1, cnt+1));
                prev[cur-1] = cur;
                checked[cur-1] = true;
            }
            if(!checked[cur+1]) {
                q.add(new pair2(cur+1, cnt+1));
                prev[cur+1] = cur;
                checked[cur+1] = true;
            }
            if(!checked[cur*2]) {
                q.add(new pair2(cur*2, cnt+1));
                prev[cur*2] = cur;
                checked[cur*2] = true;
            }
        }
    }
}