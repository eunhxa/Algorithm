import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    Edge (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static ArrayList<Integer>[] g;
    static int[] team;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            g = (ArrayList<Integer>[]) new ArrayList[n];
            for(int i=0; i<n; i++) {
                g[i] = new ArrayList<>();
            }
            team = new int[n+1];
            
            for(int i=0; i<m; i++) {
                stk = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(stk.nextToken()) - 1;
                int end = Integer.parseInt(stk.nextToken()) - 1;

                g[start].add(end);
                g[end].add(start);
            }

            for(int i=0; i<n; i++) {
                if(team[i] == 0) {
                    dfs(i, 1);
                }
            }

            boolean flag = true;
            for(int i=0; i<n; i++) {
                for(int j : g[i]) {
                    if(team[i] == team[j]) {
                        sb.append("NO\n");
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) sb.append("YES\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int t) {
        team[n] = t;
        for(int i=0; i<g[n].size(); i++) {
            int num = g[n].get(i);
            if(team[num] == 0) {
                dfs(num, 3-t);
            }
        }
    }
}