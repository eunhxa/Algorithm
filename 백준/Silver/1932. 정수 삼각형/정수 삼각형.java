import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n+1][n+1];
        int[][] cost = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<=i; j++) {
                cost[i][j] = Integer.parseInt(strs[j]);
            }
        }


        d[1][0] = cost[0][0];
        for(int i=2; i<=n; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0) {
                    d[i][0] = d[i-1][0] + cost[i-1][0];
                }else if(j == i-1) {
                    d[i][j] = d[i-1][j-1] + cost[i-1][j];
                }else {
                    d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + cost[i-1][j]; 
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            if(answer < d[n][i]) answer = d[n][i];
        }
        System.out.println(answer);
    }
}