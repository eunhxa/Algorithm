import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MOD = 9901;
        long[][] d = new long[n+1][3];

        d[1][0] = 1;
        d[1][1] = 1;
        d[1][2] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<3; j++) {
                if(j == 0) {
                    d[i][j] = d[i-1][0] + d[i-1][1] + d[i-1][2];
                } else if(j == 1) {
                    d[i][j] = d[i-1][0] + d[i-1][2];
                } else {
                    d[i][j] = d[i-1][0] + d[i-1][1];
                }
                d[i][j] = d[i][j] % MOD;
            }
        }

        long answer = (d[n][0] + d[n][1] + d[n][2]) % MOD;
        System.out.println(answer);
    }
}