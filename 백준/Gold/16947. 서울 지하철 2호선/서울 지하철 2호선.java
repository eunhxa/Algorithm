import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static ArrayList<Integer>[] g;
    static boolean[] Loop;
    static int[] distance;
    static boolean isLoop;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        checked = new boolean[n+1];
        Loop = new boolean[n+1];
        distance = new int[n+1];
        g = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            g[A].add(B);
            g[B].add(A);
        }

        checked[0] = true;
        dfs(1, -1);

        for(int i=1; i<=n; i++) {
            if(!Loop[i]) continue;
            for(int num : g[i]) {
                if(!Loop[num]) {
                    calcDistance(num, 1, i);
                }
            }
        }

        for(int i=1; i<=n ;i++) {
            if(Loop[i]) System.out.print("0 ");
            else System.out.print(distance[i]+" ");
        }
    }

    public static void calcDistance(int cur, int cnt, int prev) {
        if(Loop[cur]) return;
        distance[cur] = cnt;
        for(int next : g[cur]) {
            if(next == prev) continue;
            calcDistance(next, cnt+1, cur);
        }
    }

    public static int dfs(int cur, int prev) {
        if(checked[cur]) {
            Loop[cur] = true;
            return cur;
        }
        checked[cur] = true;
        for(int num : g[cur]) {
            if(num == prev) continue;
            int ret = dfs(num, cur);
            if(ret > 0) {
                if(cur == ret) return -1;
                Loop[cur] = true;
                return ret;
            }
        }
        return -1;
    }
}