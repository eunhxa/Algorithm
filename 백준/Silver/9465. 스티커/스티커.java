import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n];
            int[][] d = new int[n+1][3];
            for(int i=0; i<2; i++) {
                String[] strs = br.readLine().split(" ");
                for(int j=0; j<n; j++) {
                    cost[i][j] = Integer.parseInt(strs[j]);
                }
            }

            d[1][0] = 0;
            d[1][1] = cost[0][0];
            d[1][2] = cost[1][0];

            for(int i=2; i<=n; i++) {
                for(int j=0; j<=2; j++) {
                    if(j == 0) {
                        d[i][j] = d[i-1][1] > d[i-1][2] ? d[i-1][1] : d[i-1][2];
                    } else if(j == 1) {
                        d[i][j] = Math.max(d[i-1][0], d[i-1][2]) + cost[0][i-1];
                    } else {
                        d[i][j] = Math.max(d[i-1][0], d[i-1][1]) + cost[1][i-1];
                    }
                }
            }

            int answer = 0;
            for(int i=0; i<3; i++) {
                if(answer < d[n][i]) answer = d[n][i];
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
}