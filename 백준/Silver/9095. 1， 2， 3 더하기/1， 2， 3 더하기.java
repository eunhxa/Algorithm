import java.util.Scanner;

public class Main {
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t=0; t<tc; t++) {
            int n = sc.nextInt();
            d = new int[n+1];
            d[1] = 1;
            if(n > 1) {
                d[2] = 2;
                if (n > 2) {
                    d[3] = 4;
                }
            }

            rec(n);
            System.out.println(d[n]);
        }
     }

    public static int rec(int n) {
        if(d[n] > 0) return d[n];
        int temp = rec(n-1) + rec(n-2) + rec(n-3);
        if(d[n] < temp) d[n] = temp;
        return d[n];
    }
}