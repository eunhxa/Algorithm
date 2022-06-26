import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][3];
        int[][] d = new int[n+1][3];

        for(int i=1; i<=n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                cost[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int answer = -1;
        for(int m=0; m<3; m++) {
            d[1][0] = 1000001;
            d[1][1] = 1000001;
            d[1][2] = 1000001;
            d[1][m] = cost[1][m];

            for(int i=2; i<=n; i++) {
                for(int j=0; j<3; j++) {
                    if(j == 0) {
                        d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][0];
                    }else if(j == 1) {
                        d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + cost[i][1];
                    }else {
                        d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + cost[i][2];
                    }
                }
            }
            
            for(int i=0; i<3; i++) {
                if(i == m) continue;
                if(answer == -1 || answer > d[n][i]) {
                    answer = d[n][i];
                }
            }
        }

        System.out.println(answer);
    }
}