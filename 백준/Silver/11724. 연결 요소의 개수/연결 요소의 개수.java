import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static ArrayList<Integer>[] g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        checked = new boolean[n];
        g = (ArrayList<Integer>[]) new ArrayList[n];
        for(int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken()) - 1;
            int end = Integer.parseInt(stk.nextToken()) - 1;

            g[start].add(end);
            g[end].add(start);
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                dfs(i); 
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int v) {
        checked[v] = true;
        for(int i=0; i<g[v].size(); i++) {
            int n = g[v].get(i);
            if(!checked[n]) {
                dfs(n);
            }
        }
    }
}