import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 15746;
        long[] d = new long[n+1];
        d[1] = 1;
        if(n > 1) {
            d[2] = 2;
        }

        for(int i=3; i<=n; i++) {
            d[i] = d[i-2] + d[i-1];
            d[i] %= mod;
        }
        System.out.println(d[n] % mod);
    }
}