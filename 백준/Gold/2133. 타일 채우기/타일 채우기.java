import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        for(int i=1; i<=n; i+=2) {
            d[i] = 0;
        }
        d[0] = 1;
        if(n >= 2) {
            d[2] = 3;
            if(n >= 4) {
                d[4] = 11;
            }
        }


        for(int i=6; i<=n; i+=2) {
            d[i] = d[i-2] * d[2];
            for(int j=i-4; j>=0; j-=2) {
                d[i] += d[j] * 2;
            }
        }

        System.out.println(d[n]);
    }
}