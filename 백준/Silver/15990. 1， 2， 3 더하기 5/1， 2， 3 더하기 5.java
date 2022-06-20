import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int MOD = 1000000009;
        long[][] d = new long[100001][4];
        d[1][1] = 1;
        d[1][2] = 0;
        d[1][3] = 0;
        d[2][1] = 0;
        d[2][2] = 1;
        d[2][3] = 0;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        for(int i=4; i<=100000; i++) {
            for(int j=1; j<=3; j++) {
                if(j == 1) {
                    d[i][1] = (d[i-1][2] + d[i-1][3]) % MOD;
                } else if(j == 2) {
                    d[i][2] = (d[i-2][1] + d[i-2][3]) % MOD;
                } else {
                    d[i][3] = (d[i-3][1] + d[i-3][2]) % MOD;
                }
            } 
        }

        for(int t=0; t<tc; t++) {
            int n = sc.nextInt();
            long sum = 0;
            for(int i=1; i<=3; i++) {
                sum += d[n][i] % MOD;
            }
            System.out.println(sum % MOD);
        }
    }
}