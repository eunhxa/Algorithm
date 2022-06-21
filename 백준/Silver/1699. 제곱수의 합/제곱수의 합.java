import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1000001];

        for(int i=0; i<=1000000; i++) {
            d[i] = -1;
        }

        d[1] = 1;
        d[2] = 2;
        d[3] = 3;

        for(int i=1; i*i<=100000; i++) {
            d[i*i] = 1;
        }

        for(int i=5; i<=n; i++) {
            for(int j=1; j*j<i; j++) {
                int tmp = d[j*j] + d[i-j*j];
                if(d[i] == -1 || d[i] > tmp) {
                    d[i] = tmp;
                }
            }
        }

        System.out.println(d[n]);
    }
}