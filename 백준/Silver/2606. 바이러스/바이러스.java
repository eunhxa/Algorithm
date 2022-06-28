import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n+1];
        int[][] network = new int[n+1][100];

        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a][cnt[a]] = b;
            network[b][cnt[b]] = a; 
            cnt[a]++;
            cnt[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<cnt[1]; i++) {
            q.add(network[1][i]);
        }

        boolean[] check = new boolean[n+1];
        while(!q.isEmpty()) {
            int tmp = q.poll();
            if(check[tmp]) continue;
            check[tmp] = true;

            for(int i=0; i<cnt[tmp]; i++) {
                q.add(network[tmp][i]);
            }
        }

        int result = 0;
        for(int i=2; i<=n; i++) {
            if(check[i]) result++; 
        }
        System.out.println(result);
    }
}