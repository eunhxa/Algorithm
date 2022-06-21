import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        long[][] d = new long[1000001][4];
        int MOD = 1000000009;
        d[1][1] = 1;
        d[1][2] = 0;
        d[1][3] = 0;
        d[2][1] = 1;
        d[2][2] = 1;
        d[2][3] = 0;
        d[3][1] = 2;
        d[3][2] = 1;
        d[3][3] = 1;

        for(int i=4; i<=1000000; i++) {
            for(int j=1; j<=3; j++) {
                d[i][j] = d[i-j][1] + d[i-j][2] + d[i-j][3];
                d[i][j] = d[i][j] % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            int n = sc.nextInt();
            long answer = d[n][1] + d[n][2] + d[n][3];
            sb.append((answer % MOD)+"\n");
        }
        System.out.println(sb);
    }
}