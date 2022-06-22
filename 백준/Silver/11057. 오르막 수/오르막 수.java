import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = 10007;
        int n = sc.nextInt();
        int[][] d = new int[n+1][10];

        for(int i=0; i<=9; i++) {
            d[1][i] = 1;
        }
        for(int i=0; i<=n; i++) {
            d[i][0] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=9; j++) {
                int tmp = 0;
                for(int m=j; m>=0; m--) {
                    tmp += d[i-1][m]; 
                    tmp = tmp % MOD;
                }
                d[i][j] = tmp;
            }
        }

        long answer = 0;
        for(int i=0; i<=9; i++) {
            answer += d[n][i];
            answer = answer % MOD;
        }
        System.out.println(answer);
    }
}