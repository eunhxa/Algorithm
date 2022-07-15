import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int p1, p2;
    static ArrayList<Integer>[] g;
    static boolean[] checked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        checked = new boolean[n+1];
        g = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            g[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            g[start].add(end);
            g[end].add(start);
        }

        int answer = dfs(p1, 0);
        System.out.println(answer);
    }

    public static int dfs(int num, int cnt) {
        if(num == p2) return cnt;
        for(int i=0; i<g[num].size(); i++) {
            int cur = g[num].get(i);
            if(!checked[cur]) {
                checked[cur] = true;
                int ret = dfs(cur, cnt+1);
                if(ret > 0) return ret;
            }
        }
        return -1;
    }
}