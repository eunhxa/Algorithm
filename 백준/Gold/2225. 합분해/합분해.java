import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] d = new int[k+1][n+1];
        int MOD = 1000000000;
        
        for(int i=0; i<=n; i++) {
            d[1][i] = 1;
        }
        for(int i=0; i<=k; i++) {
            d[i][0] = 1;
        }

        for(int i=1; i<=k; i++) {
            for(int j=0; j<=n; j++) {
                int sum = 0;
                for(int m=0; j-m>=0; m++) {
                    sum += d[i-1][j-m];
                    sum = sum % MOD;
                }
                d[i][j] = sum;
            }
        }
        
        System.out.println(d[k][n] % MOD);
    }
}