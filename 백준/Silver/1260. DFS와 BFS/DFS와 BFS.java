import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int n;
    static ArrayList<Integer>[] g;
    static Stack<Integer> s;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken()) - 1;

        check = new boolean[n];
        g = (ArrayList<Integer>[])new ArrayList[n];
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

        for(int i=0; i<n; i++) {
            g[i].sort(Comparator.naturalOrder());
        }

        sb = new StringBuilder();
        s = new Stack<>();
        dfs(v);
        sb.append("\n");

        for(int i=0; i<n; i++) {
            check[i] = false;
        }
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.add(v);
        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append((num+1)+" ");
            for(int i=0; i<g[num].size(); i++) {
                int next = g[num].get(i);
                if(!check[next]) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int v) {
        s.push(v);
        sb.append((v+1)+" ");
        check[v] = true;
        for(int i=0; i<g[v].size(); i++) {
            int num = g[v].get(i);
            if(!check[num]) {
                dfs(num);
            }
        }
    }
}